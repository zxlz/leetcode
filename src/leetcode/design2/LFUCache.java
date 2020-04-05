package leetcode.design2;

import org.junit.Test;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Random;

public class LFUCache {


    private Element head;
    private Element tail;
    private int size;
    private int capacity;
    class Element{
        Element pre;
        Element next;
        int val;
        int key;
        int hits;
        Element() {}
        Element(int key, int val) {
            this.key=key;
            this.val=val;
        }
    }
    HashMap<Integer,Element> map;
    public LFUCache(int capacity) {
        map=new HashMap<>(capacity);
        this.capacity=capacity;
        head=new Element();
        head.hits=Integer.MAX_VALUE;
        tail=new Element();
        tail.hits=Integer.MIN_VALUE;
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        Element e =map.get(key);
        if(e!=null){
            e.hits++;
            moveUp(e);
            return e.val;
        }
        return -1;
    }

    /**
     * 增加hits后前移e
     * @param e
     */
    private void moveUp(Element e) {
        Element tar = e.pre;
        while(tar.hits<e.hits){
            tar=tar.pre;
        }

        if((tar=tar.next)!=e){
            moveTo(e,tar);
        }
    }

    /**
     * 吧e移动到tar前一个,tar不为head，
     * @param e
     * @param tar
     */
    private void moveTo(Element e, Element tar) {
        e.pre.next= e.next;
        e.next.pre=e.pre;
        tar.pre.next=e;
        e.pre=tar.pre;
        e.next=tar;
        tar.pre=e;
    }

    public void put(int key, int value) {

        Element oldE = map.get(key);
//        Element oldE = map.get(key,e);
        if(oldE==null){//新加元素
            Element e =new Element(key,value);
            map.put(key,e);
            if(++size>capacity) {//执行删除
                Element del=tail.pre;
                while(del.pre.hits==del.hits){
                    del=del.pre;
                }
                unlinkE(del);
                map.remove(del.key);
                size--;
            }
            linkE(e);
        }else{
            oldE.val=value;
            oldE.hits++;
            moveUp(oldE);
        }
    }

    private void linkE(Element e) {
        e.pre=tail.pre;
        e.next=tail;
        tail.pre.next=e;
        tail.pre=e;
    }

    private void unlinkE(Element del) {
        del.pre.next=del.next;
        del.next.pre=del.pre;
    }
}
