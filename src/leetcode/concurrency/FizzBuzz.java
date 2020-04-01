package leetcode.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.function.IntConsumer;

public class FizzBuzz {
	private int n;
	private volatile int i = 1;
	private Thread cacheThreadFizz;
	private Thread cacheThreadBuzz;
	private Thread cacheThreadFB;
	private Thread cacheThreadNumb;
//	boolean[] tableFizz;
//	boolean[] tableBuzz;
    public FizzBuzz(int n) {
        this.n = n;
//        tableFizz=new boolean[n];
//    	tableBuzz=new boolean[n];
//    	for(int i=2;i<n;i +=3) {
//    		tableFizz[i]=true;
//    	}
//    	for(int i=4;i<n;i +=5) {
//    		tableBuzz[i]=true;
//    	}
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
    	cacheThreadFizz = Thread.currentThread();
    	LockSupport.park();
    	while(i<=n) {//拿到锁
    		printFizz.run();
    		LockSupport.unpark(cacheThreadNumb);
        	LockSupport.park(this);
        }
    	
    	
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
    	cacheThreadBuzz = Thread.currentThread();
    	LockSupport.park();
    	while(i<=n) {//拿到锁
    		printBuzz.run();
    		LockSupport.unpark(cacheThreadNumb);
        	LockSupport.park(this);
        }
    	
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
    	cacheThreadFB = Thread.currentThread();
    	LockSupport.park();
    	while(i<=n) {//拿到锁
        	printFizzBuzz.run();
        	LockSupport.unpark(cacheThreadNumb);
        	LockSupport.park(this);
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
    	cacheThreadNumb = Thread.currentThread();
    	boolean Buzz =false;
    	boolean Fizz =false;
        for (; i <= n; i++) {
        	
        	if(!Buzz && !Fizz) {
        		printNumber.accept(i);
        		Buzz=(i+1)%5==0;
            	Fizz=(i+1)%3==0;
        		continue;
        	}else if(Buzz&&Fizz) {
        		LockSupport.unpark(cacheThreadFB);
        	}else if(Buzz){
        		LockSupport.unpark(cacheThreadBuzz);
        	}else {
        		LockSupport.unpark(cacheThreadFizz);
        	}
        	Buzz=(i+1)%5==0;
        	Fizz=(i+1)%3==0;
        	LockSupport.park(this);
        	
		}
        LockSupport.unpark(cacheThreadFB);	
        LockSupport.unpark(cacheThreadBuzz);	
        LockSupport.unpark(cacheThreadFizz);		
        
    }
}
