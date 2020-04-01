package leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.function.IntConsumer;

public class ZeroEvenOdd2 {
	
	
	private int n;
	private int i=1;
	Semaphore spZero = new Semaphore(1);
	Semaphore spOdd = new Semaphore(0);
	Semaphore spEven = new Semaphore(0);
    public ZeroEvenOdd2(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
    	while(i<=n) {
    			spZero.acquire();
    			if(i>n) {
    				
    				spEven.release();
    				spOdd.release();
    				break;
    			}
        		printNumber.accept(0);
        		
        		if(i%2==0) {
        			spEven.release();
        		}else {
        			spOdd.release();
        		}
        		
        	
    	}
    	
    	
    }
    public void odd(IntConsumer printNumber) throws InterruptedException {
    	
    	while(i<=n) {
    		
    		spOdd.acquire();
    		if(i>n)break;
        		printNumber.accept(i++);
        	spZero.release();

    	}
    }
    public void even(IntConsumer printNumber) throws InterruptedException {
    	while(i<=n) {
    		
    			spEven.acquire();
    			if(i>n)break;
        		printNumber.accept(i++);
        		spZero.release();
        		

    	}
    	
    }

   
}
