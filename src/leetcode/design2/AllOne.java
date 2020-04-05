package leetcode.design2;

import org.junit.Test;

import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 432. 全 O(1) 的数据结构
 * 实现一个数据结构支持以下操作：
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 */
public class AllOne {
    @Test
    public void main() {
//        ["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
//[[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]
//        AllOne allOne = new AllOne();
//        allOne.inc("hello");
//        allOne.inc("goodbye");
//        allOne.inc("hello");
//        allOne.inc("hello");
//        System.out.println(allOne.getMaxKey());
//        allOne.inc("leet");
//        allOne.inc("code");
//        allOne.inc("leet");
//        allOne.dec("hello");
//        allOne.inc("leet");
//        allOne.inc("code");
//        allOne.inc("code");
//        ["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
//[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
//        allOne.inc("a");
//        allOne.inc("b");
//        allOne.inc("b");
//        allOne.inc("c");
//        allOne.inc("c");
//        allOne.inc("c");
//        allOne.dec("b");
//        allOne.dec("b");
//        System.out.println(allOne.getMinKey());
//        allOne.dec("a");
//        System.out.println(allOne.getMaxKey());
//        System.out.println(allOne.getMinKey());
//        ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","getMinKey"]
//[[],["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"],[]]
//        allOne.inc("a");
//        allOne.inc("b");
//        allOne.inc("c");
//        allOne.inc("d");
//        allOne.inc("a");
//        allOne.inc("b");
//        allOne.inc("c");
//        allOne.inc("d");
//        allOne.inc("c");
//        allOne.inc("d");
//        allOne.inc("d");
//        allOne.inc("a");
//        System.out.println(allOne.getMinKey());
//        allOne.inc("a");
//        allOne.inc("b");
//        allOne.inc("b");
//        allOne.inc("b");
//        allOne.inc("b");
//        allOne.dec("b");
//        allOne.dec("b");
//
//        System.out.println(allOne.getMaxKey());
//        System.out.println(allOne.getMinKey());
//        ["AllOne","inc","inc","inc","inc","inc","inc","getMaxKey","inc","dec","getMaxKey","dec","inc","getMaxKey","inc","inc","dec","dec","dec","dec","getMaxKey","inc","inc","inc","inc","inc","inc","getMaxKey","getMinKey"]
//[[],["hello"],["world"],["leet"],["code"],["DS"],["leet"],[],["DS"],["leet"],[],["DS"],["hello"],[],["hello"],["hello"],["world"],["leet"],["code"],["DS"],[],["new"],["new"],["new"],["new"],["new"],["new"],[],[]]

    }
    HashMap<String,Element> map ;
    //双向链表，类似lru做法
    class Element{
        Element pre;
        Element next;
        String key;
        int v;
        Element(){}
        Element(String key){
            this.key=key;
            this.v=1;
        }
    }
    Element head;
    Element tail;

    /** Initialize your data structure here. */
    public AllOne() {
        map= new HashMap();
        head=new Element();
        tail=new Element();
        head.next=tail;
        head.key="";
        head.v=Integer.MAX_VALUE;
        tail.pre=head;
        tail.key="";
        tail.v=Integer.MIN_VALUE;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Element e = map.get(key);
        if(e==null){
            e=new Element(key);
            linkToTail(e);
            map.put(key,e);
        }else{
            e.v++;
            moveUp(e);
        };
    }

    private void moveUp(Element e) {
        Element tar=e.pre;
        while (e.v>tar.v){//大于前一个，目标前移
            tar=tar.pre;
        }

        tar=tar.next;
        //   tp   t  tn     ep  e  en
//        if(tar==e.pre){//和前一个换
//
//            e.pre=tar.pre;
//            tar.pre.next=e;
//            tar.pre=e;
//            tar.next=e.next;
//            e.next.pre=tar;
//            e.next=tar;
//        }else  if(tar!=e){
        //移动到tar前一个
        if(tar!=e){
            moveTo(e,tar);
        }


//        }
    }

    /**
     * e移动到tar前一个，tar不为head
     * @param e
     * @param tar
     */
    private void moveTo(Element e, Element tar) {
        e.pre.next=e.next;
        e.next.pre=e.pre;
        e.next=tar;
        e.pre=tar.pre;
        tar.pre=e;
        e.pre.next=e;
    }

    private void moveDown(Element e) {
        Element tar=e.next;
        while (e.v<tar.v){//小于后一个，目标后移
            tar=tar.next;
        }
        //移动到tar前一个
        //   tp   t  tn     ep  e  en
        if(tar!=e.next){
            moveTo(e,tar);
        }

    }
    /**
     * link一个新节点e到head
     * @param e
     */
    private void linkToTail(Element e) {
//        e.next=head.next;
//        e.pre=head;
//        head.next.pre=e;
//        head.next=e;
        e.next=tail;
        e.pre=tail.pre;
        tail.pre.next=e;
        tail.pre=e;
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Element e = map.get(key);
        if(e!=null){
            if(e.v==1){
                map.remove(key);
                unlink(e);
            }else{
                e.v--;
                moveDown(e);
            }
        }

    }



    private void unlink(Element e) {
        e.pre.next=e.next;
        e.next.pre=e.pre;
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return head.next.key;

    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return tail.pre.key;

    }


}
