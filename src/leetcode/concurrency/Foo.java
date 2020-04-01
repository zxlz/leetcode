package leetcode.concurrency;

import static sun.misc.Unsafe.getUnsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * 顺序执行 first，second，third
 * @author zxl
 *
 */
public class Foo {
	AtomicInteger a;
	 Thread cacheThread1;
	 Thread cacheThread2;
	 Thread cacheThread3;
    public Foo() {
    	 a = new AtomicInteger();
    }

    public void first(Runnable printFirst) throws InterruptedException {
    	while(!a.compareAndSet(0, 1)) {//失败，park线程，加入缓存等3来unpark
    		cacheThread1=Thread.currentThread();
            LockSupport.park(this);
    	}
    	cacheThread1=null;
    	printFirst.run();
    	//成功，如果2被锁解锁2
    	LockSupport.unpark(cacheThread2);
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	while(!a.compareAndSet(1, 2)) {
    		cacheThread2=Thread.currentThread();
            LockSupport.park(this);
    	}
    	cacheThread2=null;
        printSecond.run();
        LockSupport.unpark(cacheThread3);
    }

    public void third(Runnable printThird) throws InterruptedException {
    	while(!a.compareAndSet(2, 3)) {
    		cacheThread3=Thread.currentThread();
            LockSupport.park(this);
    	}
       cacheThread3=null;
        printThird.run();
        LockSupport.unpark(cacheThread3);
    }
}
