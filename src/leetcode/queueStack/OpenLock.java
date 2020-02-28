package leetcode.queueStack;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * 打开转盘锁
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

 

示例 1:

输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
 * @author zxl
 *
 */
public class OpenLock {
	@Test
	public void main() throws UnsupportedEncodingException {
		openLock(new String[]{"0201","0101","0102","1212","2002"},"0202");
	}
	/**
	 * 0000->1000 0000/排除重
	 * 			  2000
	 * 			  1100
	 * 			  1900
	 * 			  。。。
	 * 
	 * 		 9000  8000
	 * 			   0000/排重
	 * 			   9100
	 * 			   9900
	 * 			   9010
	 * 			   9090
	 * 			   。。。
	 *            
	 * 		 0100
	 * 		 0900
	 * 		 。。。
	 * 遇到锁定中断
	 * 
	 * @param deadends
	 * @param target
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	boolean[][][][] check;
	int count=0;
	//改为双向bfs，用hash替换队列，初始值向目标和目标到初始值交替用少的层内节点少的一方遍历，最后一层直接
	//用hash判断，可节省中间最多一层的遍历消耗
    public int openLock(String[] deadends, String target) {
    	check=new boolean[10][10][10][10];
    	for (String s : deadends) {
			check[s.charAt(0)-'0'][s.charAt(1)-'0'][s.charAt(2)-'0'][s.charAt(3)-'0']=true;
		}
    	  Queue<byte[]> queue = new LinkedList<>();
    	  queue.offer(new byte[]{0,0,0,0});//从0000开始
    	  
    	
    	while(!queue.isEmpty()) {
    		int layerSize=queue.size();
    		for (int i = 0; i < layerSize; i++) {//遍历一层所有可能
    			byte[] cur=queue.poll();//当前位置
        		if(target.equals(cur[0]+""+cur[1]+cur[2]+cur[3]))return count;
        			bfs(queue,cur);
			}
    		count++;
    	}
		return -1  ;
    }
   
    public Queue<byte[]> bfs(Queue<byte[]> queue,byte[] cur){
    	if(!check[cur[0]][cur[1]][cur[2]][cur[3]]) {//不是死锁，遍历它的下层
			
			check[cur[0]][cur[1]][cur[2]][cur[3]]=true;
			//第一位+1或-1
			if(!check[(cur[0]+9)%10][cur[1]][cur[2]][cur[3]]) //没有检查过或非死锁就加入
				queue.offer(new byte[] {(byte) ((cur[0]+9)%10),cur[1],cur[2],cur[3]});
			//byte[] next= new byte[] {(byte) (cur[0]-1),cur[1],cur[2],cur[3]};
			if(!check[(cur[0]+11)%10][cur[1]][cur[2]][cur[3]])//没有检查过或非死锁就加入
				queue.offer(new byte[] {(byte) ((cur[0]+11)%10),cur[1],cur[2],cur[3]});
			//第二位+1或-1
			if(!check[cur[0]][(cur[1]+9)%10][cur[2]][cur[3]])//没有检查过就加入
				queue.offer(new byte[] {cur[0],(byte) ((cur[1]+9)%10),cur[2],cur[3]});
			if(!check[cur[0]][(cur[1]+11)%10][cur[2]][cur[3]])//没有检查过就加入
				queue.offer(new byte[] {cur[0],(byte) ((cur[1]+11)%10),cur[2],cur[3]});
				
			
			if(!check[cur[0]][cur[1]][(cur[2]+9)%10][cur[3]])//没有检查过就加入
				queue.offer(new byte[] {cur[0],cur[1],(byte) ((cur[2]+9)%10),cur[3]});
			if(!check[cur[0]][cur[1]][(cur[2]+11)%10][cur[3]])//没有检查过就加入
				queue.offer(new byte[] {cur[0],cur[1],(byte) ((cur[2]+11)%10),cur[3]});
			
			if(!check[cur[0]][cur[1]][cur[2]][(cur[3]+9)%10])//没有检查过就加入
				queue.offer(new byte[] {cur[0],cur[1],cur[2],(byte) ((cur[3]+9)%10)});
			if(!check[cur[0]][cur[1]][cur[2]][(cur[3]+11)%10])//没有检查过就加入
				queue.offer(new byte[] {cur[0],cur[1],cur[2],(byte) ((cur[3]+11)%10)});
		}
		return queue;
    	
    }
}
