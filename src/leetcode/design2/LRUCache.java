package leetcode.design2;

import java.util.HashMap;

import leetcode.design2.LRUCache.Element;

public class LRUCache {
	private Element head;
	private Element tail;
	private int size;
	class Element{
		Element pre;
		Element	next;
		int val;
		int key;
		Element() {}
		Element(int key, int val) {
			this.key=key;
			this.val=val;
		}
	}
	private int capacity;
	private HashMap<Integer,Element> map = new HashMap<Integer, Element>();
  	public LRUCache(int capacity) {
		this.capacity=capacity;
		head=new Element();
		tail=new Element();
		head.next=tail;
		tail.pre=head;
	}

	public int get(int key) {
		Element e=map.get(key);
		if(e==null)return -1;
		afterNodeGet(e);
		return e.val;
	}


	public void put(int key, int value) {
		Element old;
		if((old=map.get(key))==null) {
			old.val=value;
			afterNodeGet(old);
		}else {
			freeMemoryIfNeeded();
//			System.out.println("put:"+value);
			Element e=new Element(key,value);
			map.put(key, e);
			linkToHead(e);
		}
		
	}
	private void freeMemoryIfNeeded() {
		if(++size>capacity) {//执行删除
			Element e=tail.pre;
//			System.out.println("free:"+e.val);
			unlinkE(e);
			map.remove(e.key);
			size--;
		}
	}

	private void afterNodeGet(Element e) {
//		System.out.println("head:"+e.val);
		unlinkE(e);
		linkToHead(e);
	}
	private void unlinkE(Element e) {
		// 断开
		e.pre.next = e.next;
		e.next.pre = e.pre;
	}



	private void linkToHead(Element e) {
		//加入head
		e.next = head.next;
		head.next.pre = e;
		e.pre = head;
		head.next = e;
	}
}
