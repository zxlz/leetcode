package leetcode.dynamicProgramming;

/**
 * 1227. 飞机座位分配概率
 * 有 n 位乘客即将登机，飞机正好有 n 个座位。第一位乘客的票丢了，他随便选了一个座位坐下。
 *
 * 剩下的乘客将会：
 *
 * 如果他们自己的座位还空着，就坐到自己的座位上，
 *
 * 当他们自己的座位被占用时，随机选择其他座位
 * 第 n 位乘客坐在自己的座位上的概率是多少？
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出：1.00000
 * 解释：第一个人只会坐在自己的位置上。
 * 示例 2：
 *
 * 输入: n = 2
 * 输出: 0.50000
 * 解释：在第一个人选好座位坐下后，第二个人坐在自己的座位上的概率是 0.5。
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 */
public class NthPersonGetsNthSeat {

    /**
     *      坐自己位置   坐n位置    坐其他
     * 1    1/n 1      1/n  0     n-2/n * f(n-1)
     *
     * @param n
     * @return
     */

    //迭代
    public double nthPersonGetsNthSeat1(int n) {
        double pre=1;
        double cur=0;
        for (int i = 2; i <= n; i++) {
            cur=1.0/i + (i-2)/i * pre;
            pre=cur;
        }
        return pre;
    }
    //递归
    public double nthPersonGetsNthSeat(int n) {
        if(n==1)return 1;
        return 1.0/n + ((n-2)*1.0/n )*nthPersonGetsNthSeat(n-1);
    }
}
