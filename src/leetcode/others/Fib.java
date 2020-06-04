package leetcode.others;

/**
 * 
 * 递归中的重复计算
 * 记忆化
为了消除上述情况中的重复计算，正如许多人已经指出的那样，
其中一个想法是将中间结果存储在缓存中，以便我们以后可以重用它们，而不需要重新计算。
 * 
 * 斐波那契数
斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
给定 N，计算 F(N)。
 * @author zxl
 *
 */
public class Fib {
	Integer[] cache ;
    public int fib(int N) {
    	cache = new Integer[N];
    	cache[0]=0;
    	cache[1]=1;
    	cache[2]=1;
    	cache[3]=2;
		return N;
    }
    public int run(int n) {
    	if(cache[n]!=null)return cache[n];
    	int a=run(n-1);
    	if(cache[n-1]==null)cache[n-1]=a;
    	int b=run(n-2);
    	if(cache[n-2]==null)cache[n-2]=b;
    	return run(n-1)+run(n-2);
    }
    
}
