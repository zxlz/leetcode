package leetcode.concurrency;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.IntConsumer;

import javax.swing.plaf.SliderUI;

import org.junit.Test;

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

//	@Test
//	public  void test() throws Exception {
//		int i=100;
//		while(i-->0) {
//			main();
//		}
//	}
	public  static void main(String[] args) throws Exception {
	
		
//		Foo foo = new Foo();
//		Thread t1 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					foo.first(() -> {
//						try {
//							Thread.sleep((long) (Math.random()*1000));
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						System.out.println("one");	
//					});
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		});
//		Thread t2 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					foo.second(() -> {
//						try {
//							Thread.sleep((long) (Math.random()*1000));
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						System.out.println("two");	
//					});
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		});
//		Thread t3 = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					foo.third(() -> {
//						try {
//							Thread.sleep((long) (Math.random()*1000));
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						System.out.println("three");	
//					});
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		});
//		t1.start();
//		t2.start();
//		t3.start();
//		FooBar fooBar=new FooBar(10);
//		Thread t1=new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					fooBar.foo(() -> System.out.print("foo"));
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		Thread t2=new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					fooBar.bar(() -> System.out.print("bar"));
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		t2.start();
//		t1.start();
//		ZeroEvenOdd2 z = new ZeroEvenOdd2(100);
//		Thread t1=new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					z.zero((value)->System.out.print(value));
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		Thread t2=new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					z.odd((value)->System.out.print(value));
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		Thread t3=new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					z.even((value)->System.out.print(value));
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		
//		t3.start();
//		
////		Thread.sleep(1000);
//		t1.start();
////		Thread.sleep(1000);
//		t2.start();
		
//		H2O h = new H2O();
//		Thread t1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					h.hydrogen(() -> System.out.println("h"));
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//			}
//		});
//		Thread t2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				try {
//					h.oxygen(() -> System.out.println("o"));
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//			}
//		});
//		
//		t1.start();
//		t2.start();
		
		FizzBuzz f = new FizzBuzz(105);
		Thread t1 = new Thread(()->{
			try {
				f.fizz(()->System.out.println("fizz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(()->{
			try {
				f.buzz(()->System.out.println("buzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t3 = new Thread(()->{
			try {
				f.fizzbuzz(()->System.out.println("fizzbuzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t4 = new Thread(()->{
			try {
				f.number((num)->System.out.println(num));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
	
}
