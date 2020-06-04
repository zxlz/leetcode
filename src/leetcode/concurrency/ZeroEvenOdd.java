package leetcode.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
	
	
	private int n;
	private int i=1;
	Thread cacheThreadZero;
	 Thread cacheThreadOdd;
	 Thread cacheThreadEven;
	 AtomicInteger atomic = new AtomicInteger();
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    	cacheThreadZero=Thread.currentThread();
    	while(cacheThreadOdd==null || cacheThreadEven==null){System.out.println("NULL");};
    	while(i<=n) {
    		if(atomic.compareAndSet(0,1)){//成功拿到0锁
        		printNumber.accept(0);
        		if(i%2==0) {
//        			System.out.println("even");
        			atomic.compareAndSet(1,2);//执行完毕，开偶数锁
        			LockSupport.unpark(cacheThreadEven);//放偶数阻塞
        		}else {
//        			System.out.println("odd");
        			atomic.compareAndSet(1,3);//执行完毕，开奇数锁
        			LockSupport.unpark(cacheThreadOdd);
        		}
        	}else {
        		LockSupport.park(this);
        	}
    	}
    	
    	
    }
    public void odd(IntConsumer printNumber) throws InterruptedException {
    	cacheThreadOdd=Thread.currentThread();
    	LockSupport.park(this);
    	while(i<=n) {
    		
    		if(atomic.compareAndSet(3,1)){//成功拿到0锁
        		printNumber.accept(i++);
//        		LockSupport.unpark(cacheThreadZero);
        		if(i>n) {
        			atomic.compareAndSet(1,-1);
        			LockSupport.unpark(cacheThreadZero);
        			LockSupport.unpark(cacheThreadEven);
        		}else {
        			atomic.compareAndSet(1,0);
        			LockSupport.unpark(cacheThreadZero);
        		}
//        		if(i>n) {
//        			LockSupport.unpark(cacheThreadEven);
//        			break;
//        		}
        	}else {
        		LockSupport.park(this);
        	}
    	}
    }
    public void even(IntConsumer printNumber) throws InterruptedException {
    	cacheThreadEven=Thread.currentThread();
    	LockSupport.park(this);
    	while(i<=n) {
    		
    		if(atomic.compareAndSet(2,1)){//成功拿到0锁
        		printNumber.accept(i++);
        		if(i>n) {
        			atomic.compareAndSet(1,-1);
        			LockSupport.unpark(cacheThreadZero);
        			LockSupport.unpark(cacheThreadOdd);
        		}else {
        			
        			atomic.compareAndSet(1,0);
        			LockSupport.unpark(cacheThreadZero);
        			
        		}
        		//执行完毕，放0锁
//        		LockSupport.unpark(cacheThreadZero);
//        		if(i>n) {
//        			LockSupport.unpark(cacheThreadOdd);
//        			break;
//        		}
        	}else {
        		LockSupport.park(this);
        	}
    	}
    	
    }

   
}
