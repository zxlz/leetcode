package weakreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Random;
import java.util.WeakHashMap;

public class TestWeakReference {

	public static void main(String[] args) throws InterruptedException {

		
		HashMap<String,String> map = new HashMap<String, String>();
		ReferenceQueue<HashMap> re = new ReferenceQueue<HashMap>();
//		WeakReference<HashMap> weakMap = new WeakReference<HashMap>(map,re);
		
		PhantomReference<HashMap> weakMap = new PhantomReference<HashMap>(map,re );
//		WeakHashMap
		int i=10;
		while(i-->0) {
			map.put(""+i,""+i);
		}
		long start = System.currentTimeMillis();

		while (true) {
//			System.gc(); 
			//没有这个强引用，map过段时间就会被gc，  而且map越大回收的越快
			//			System.out.println("here is the strong reference 'map' "+map.get(1));
			if (weakMap.get() != null) {
				i++;
//				Thread.currentThread().sleep(1);
				System.out.println("Object is alive for " + i + " loops - " + weakMap);
			} else {
				System.out.println("Object has been collected.");
				break;
			}
		} 
//		map.put(""+i,""+i);
		long end = System.currentTimeMillis();
		System.out.println("TIME = " + (end - start));
		System.out.println(re.poll());
	}

}
