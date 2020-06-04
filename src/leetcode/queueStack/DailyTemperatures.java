package leetcode.queueStack;

import java.util.Stack;

import org.junit.Test;

/**
 * 每日温度
根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * @author zxl
 *  
 */
public class DailyTemperatures {
	@Test
	public void main() {
		//dailyTemperatures(new int[] {73,74,75,71,69,72,76,73});
		dailyTemperatures(new int[] {34,80,80,34,34,80,80,80,80,34});
		
	}
    public int[] dailyTemperatures(int[] T) {
//    	Stack<Integer> stack=new Stack<Integer>();
    	int[] res=new int[T.length];
    	res[T.length-1]=0;
//		stack.push(T[T.length-1]);
		
//    	for (int i = T.length-2; i >=0; i--) {
//			
//				int count=res[i+1];
//			
//				if(T[i]<T[i+1]) {
//					count=1;
//				}
//				
//				while(!stack.isEmpty() && T[i]>=stack.peek()) {//stack只保留大的
//					count++;
//					stack.pop();
//					
//				}
//				if(stack.isEmpty()) {
//					res[i]=0;
//				}else {
//					res[i]=count;
//				}
//				stack.push(T[i]);
//				
//		}
    	
    	for (int  i= T.length-2; i >=0; i--) {
			
			int count=0;
			int m=i+1;
			if(T[i]<T[m]) {
				count=1;
			}else if(T[i]==T[m]) {
				count=res[m]+1;
				if(res[m]==0) {
					count=0;
				}
			}else {
				while(T[i]>T[m] && res[m]>0) {//stack只保留大的
					m=m+res[m];
				}
				 if(T[i]<T[m]){//如果找到了
					count=m-i;
				}else  if(T[i]==T[m]){
					count=m-i+res[m];
					if(res[m]==0) {
						count=0;
					}
				}else  {
					count=0;
				}
			}
			
			res[i]=count;
			
	}
    	

		return res;

    }
}
