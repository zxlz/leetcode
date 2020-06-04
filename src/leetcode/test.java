package leetcode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.swing.plaf.SliderUI;

import leetcode.arg.ArgRotate;
import leetcode.arg.ArgRotate2;
import leetcode.arg.ContainsDuplicate;
import leetcode.arg.IsValidSudoku;
import leetcode.concurrency.Foo;
import leetcode.design.MinStack;
import leetcode.design.MinStack2;
import leetcode.design2.LRUCache;
import leetcode.design2.MedianFinder;
import leetcode.hashTable.RandomizedSet;
import leetcode.tree.KthLargest;

public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		ArgRotate a = new ArgRotate();
		//a.main();
//		ArgRotate2 a2 = new ArgRotate2();
//		a2.main();
//		ContainsDuplicate a3=new ContainsDuplicate();
//		a3.main();
//		IsValidSudoku a4=new IsValidSudoku();
//		a4.main();
//		MinStack2 s=new MinStack2();
//		s.push(2);
//		s.push(0);
//		s.push(3);
//		s.push(0);
//		s.pop();
//		s.pop();
//		System.out.println(s.getMin());
//		s.pop();
//		System.out.println(s.getMin());
//		RandomizedSet set= new RandomizedSet();
//		set.insert(1);
//		set.insert(10);
//		set.insert(20);
//		set.insert(30);
//		int count=1000;
//		while(count-->0) {
//			System.out.println(set.getRandom());
//		}
//		KthLargest a = new KthLargest(3,new int[] {4,5,8,2});
//		a.add(3);
//		a.add(5);
//		a.add(10);
//		a.add(9);
//		a.add(4);
		
//		LRUCache lru=new LRUCache(2);
//		lru.put(1,1);
//		lru.put(2,2);
//		System.out.println(lru.get(1));
//		lru.put(3, 3);
//		System.out.println(lru.get(2));
//		lru.put(4,4);
//		System.out.println(lru.get(1));
//		System.out.println(lru.get(3));
//		System.out.println(lru.get(4));
//		ThreadLocal a=new ThreadLocal<String>();
//		a.equals("");
//		MedianFinder m=new MedianFinder();
//		m.addNum(1);
//		m.addNum(2);
//		System.out.println(m.findMedian());
//		m.addNum(3);
//		System.out.println(m.findMedian());
		
		Foo foo = new Foo();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					foo.first(() -> {
						try {
							Thread.sleep((long) (Math.random()*1000));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("one");	
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					foo.second(() -> {
						try {
							Thread.sleep((long) (Math.random()*1000));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("two");	
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					foo.third(() -> {
						try {
							Thread.sleep((long) (Math.random()*1000));
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("three");	
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		t1.start();
		t2.start();
		t3.start();
		System.out.println("o1ne");
		
		
		
		
	}
	
	
}
