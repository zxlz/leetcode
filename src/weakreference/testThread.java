package weakreference;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class testThread {
	private static int i=0;
	public static void main(String[] args) {
		class testRunnable implements  Runnable {
			@Override
			public void run() {
				try {
					long start = System.currentTimeMillis();
					i++;
					System.out.println(Thread.currentThread().getName());
					Thread.sleep((long) (Math.random()*1000));
					long end = System.currentTimeMillis();
					System.out.println(Thread.currentThread().getName() + "=====end"+"TIME = " + (end - start));

				
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
//		ExecutorService e= Executors.newCachedThreadPool();
		ExecutorService e= Executors.newFixedThreadPool(3);
//		Executors.newSingleThreadExecutor();
		for (int i = 0; i < 100; i++) {
//			e.execute(new testRunnable());
			Future a= e.submit(new testRunnable());
			
//			while(a.isDone()) {
//				System.out.println(a.isDone());
//				continue;
//			}
		}
		
		e.shutdown();
//		e.shutdownNow();
		while(e.isShutdown()||e.isTerminated()) {
			System.err.println(e.isShutdown()+"=================="+e.isTerminated());
			break;
		}
		
		System.out.println(i);
//		ThreadPoolExecutor pool = new ThreadPoolExecutor();
	}
}
