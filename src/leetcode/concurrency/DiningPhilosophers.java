package leetcode.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 哲学家从 0 到 4 按 顺时针 编号。请实现函数 void wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork)：

philosopher 哲学家的编号。
pickLeftFork 和 pickRightFork 表示拿起左边或右边的叉子。
eat 表示吃面。
putLeftFork 和 putRightFork 表示放下左边或右边的叉子。
由于哲学家不是在吃面就是在想着啥时候吃面，所以思考这个方法没有对应的回调。
给你 5 个线程，每个都代表一个哲学家，请你使用类的同一个对象来模拟这个过程。在最后一次调用结束之前，可能会为同一个哲学家多次调用该函数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/the-dining-philosophers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author zxl
 *
 */
public class DiningPhilosophers {
	Semaphore[] chopsticks;//5个筷子
	public DiningPhilosophers() {
		chopsticks = new Semaphore[] {
					new Semaphore(1),
					new Semaphore(1),
					new Semaphore(1),
					new Semaphore(1),
					new Semaphore(1)
			};
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        //拿筷子位置
    	int RightForkIndex=philosopher;
    	int LeftForkIndex=(philosopher+1)%5;
    	if((philosopher^1)==1) {
    		chopsticks[LeftForkIndex].acquire();
    		pickLeftFork.run();
        	chopsticks[RightForkIndex].acquire();
        	pickRightFork.run();
    	}else {
    		chopsticks[RightForkIndex].acquire();
    		pickRightFork.run();
        	chopsticks[LeftForkIndex].acquire();
        	pickLeftFork.run();
    	}
    	eat.run();
    	putLeftFork.run();
    	chopsticks[LeftForkIndex].release();
    	putRightFork.run();
    	chopsticks[RightForkIndex].release();
    }
}
