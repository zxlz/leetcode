package leetcode.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class FooBar {
	private int n;
	AtomicInteger flag = new AtomicInteger();
	Thread cacheThread1;
	 Thread cacheThread2;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
    	cacheThread1=Thread.currentThread();
        for (int i = 0; i < n; ) {
        	if(flag.compareAndSet(0,1)){//成功拿到foo锁
        		printFoo.run();
        		flag.compareAndSet(1,2);//执行完毕，开bar锁
        		LockSupport.unpark(cacheThread2);
        		i++;
        	}else {
        		LockSupport.park(this);//避免循环太多，park减少cpu消耗
        	}
        	
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
    	cacheThread2=Thread.currentThread();
    	
        for (int i = 0; i < n; ) {
        	if(flag.compareAndSet(2, 1)){//成功拿到bar锁
        		printBar.run();
        		flag.compareAndSet(1,0);//执行完毕，开foo锁
        		LockSupport.unpark(cacheThread1);
        		i++;
        	}else {
        		LockSupport.park(this);
        	}
        }
    }
}
