package leetcode.concurrency;

import java.util.concurrent.Semaphore;

public class H2O {
	Semaphore spH=new Semaphore(2);
	Semaphore spO=new Semaphore(1);
	
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    	while(true) {
    		spH.acquire();
    		// releaseHydrogen.run() outputs "H". Do not change or remove this line.
    		releaseHydrogen.run();
    		if(spH.availablePermits()==0){
    			spO.release();
    		}
    		
    	}
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        while(true) {
        	spO.acquire();
        	releaseOxygen.run();
        	while(spH.availablePermits()==0){
        		spH.release(2);
        	}
        	
        }
    }
}
