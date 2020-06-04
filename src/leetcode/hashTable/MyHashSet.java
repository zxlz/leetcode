package leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 设计哈希集合
不使用任何内建的哈希表库设计一个哈希集合

具体地说，你的设计应该包含以下的功能

add(value)：向哈希集合中插入一个值。
contains(value) ：返回哈希集合中是否存在这个值。
remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * @author zxl
 *
 */
public class MyHashSet {
	static class Node  {
        final int hash;
        final int key;
        Node next;

        Node(int hash, int key, Node next) {
            this.hash = hash;
            this.key = key;
            this.next = next;
        }

        public final int getKey()        { return key; }

//        public final int hashCode() {
//            return Objects.hashCode(key);
//        }

        
    }
	Node[] table;
    int threshold;
    transient int size;
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
    final Node[] resize() {
        Node[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * DEFAULT_LOAD_FACTOR;//loadFactor
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
        Node[] newTab = (Node[])new Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof TreeNode)
//                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node loHead = null, loTail = null;
                        Node hiHead = null, hiTail = null;
                        Node next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
    Node newNode(int hash, int key, Node next) {
        return new Node(hash, key, next);
    }
	 /** Initialize your data structure here. */
    public MyHashSet() {
    	this.threshold=DEFAULT_INITIAL_CAPACITY;
    }
    
    public void add(int key) {
    	int hash=hash(key);
    	Node[] tab; Node p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;//扩容或初始化
        if ((p = tab[i = (n - 1) & hash]) == null)//&运算取索引i，取出元素p
            tab[i] = newNode(hash, key, null);//空位置，建node
        else {
            Node e; int k;
            if (p.hash == hash &&
                //((k = p.key) == key || (key != null && key.equals(k))))
            	((k = p.key) == key )) {
            	e = p;
            }
                
//            else if (p instanceof TreeNode)
//                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
            	/**
            	 * 循环p的next，如果和新key相等，e=oldNode，
            	 * 			   如果到尾部null还没有找到这个key， 就新new一个，e=null
            	 */
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, null);
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // >=7 node转为树结构
//                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                         ((k = e.key) == key ))//|| (key != null && key.equals(k))
                        break;
                    p = e;
                }
            }
//            if (e != null) { // existing mapping for key
//                int oldValue = e.value;
//                boolean onlyIfAbsent=false;//是否不覆盖
//                if (!onlyIfAbsent )//oldValue == null
//                    e.value = value;
//                //afterNodeAccess(e);
//                //return oldValue;
//            }
        }
        //++modCount;控制迭代异常的判断数，
        if (++size > threshold)
            resize();
       // afterNodeInsertion(evict);
        //return null;
    }
    
    public void remove(int key) {
    	int hash=hash(key);
    	//boolean matchValue=false;
    	
    	Node[] tab; Node p; int n, index;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (p = tab[index = (n - 1) & hash]) != null) {//p的位置不为空， 选出该key的node，
            Node node = null, e; int k; int v;
            if (p.hash == hash &&
                ((k = p.key) == key))
                node = p;
            else if ((e = p.next) != null) {
//                if (p instanceof TreeNode)
//                    node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
//                else {
                    do {
                        if (e.hash == hash &&
                            ((k = e.key) == key )) {
                            node = e;
                            break;
                        }
                        p = e;
                    } while ((e = e.next) != null);
//                }
            }
            if (node != null ) {//||(value != null && value.equals(v)))) 

//                if (node instanceof TreeNode)
//                    ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
//                else
            	if (node == p)
                    tab[index] = node.next;
                else
                    p.next = node.next;
//                ++modCount;
                --size;
//                afterNodeRemoval(node);
//                return node;
            }
        }
//        return null;
    }
    final Node getNode(int hash, int key) {
        Node[] tab; Node first, e; int n;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                (first.key == key ))
                return first;
            if ((e = first.next) != null) {
//                if (first instanceof TreeNode)
//                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                         e.key == key )
                        {
                    	return e;
                        }
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	return getNode(hash(key), key)!=null;
    }
}
