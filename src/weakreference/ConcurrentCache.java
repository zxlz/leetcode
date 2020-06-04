package weakreference;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * tomcat在这里是使用ConcurrentHashMap和WeakHashMap做了分代的缓存。
 * 在put方法里，在插入一个k-v时，先检查eden缓存的容量是不是超了。
 * 没有超就直接放入eden缓存，如果超了则锁定longterm将eden中所有的k-v都放入longterm。
 * 再将eden清空并插入k-v。在get方法中，也是优先从eden中找对应的v，如果没有则进入longterm缓存中查找，
 * 找到后就加入eden缓存并返回。 

经过这样的设计，相对常用的对象都能在eden缓存中找到，不常用（有可能被销毁的对象）的则进入longterm缓存。
而longterm的key的实际对象没有其他引用指向它时，gc就会自动回收heap中该弱引用指向的实际对象，弱引用进入引用队列。
longterm调用expungeStaleEntries()方法，遍历引用队列中的弱引用，并清除对应的Entry，不会造成内存空间的浪费。
 */
public final class ConcurrentCache<K,V> {
	 
    private final int size;
 
    private final Map<K,V> eden;
 
    private final Map<K,V> longterm;
 
    public ConcurrentCache(int size) {
        this.size = size;
        this.eden = new ConcurrentHashMap<>(size);
        this.longterm = new WeakHashMap<>(size);
    }
 
    public V get(K k) {
        V v = this.eden.get(k);
        if (v == null) {
            synchronized (longterm) {
                v = this.longterm.get(k);
            }
            if (v != null) {
                this.eden.put(k, v);
            }
        }
        return v;
    }
 
    public void put(K k, V v) {
        if (this.eden.size() >= size) {
            synchronized (longterm) {
                this.longterm.putAll(this.eden);
            }
            this.eden.clear();
        }
        this.eden.put(k, v);
    }
}