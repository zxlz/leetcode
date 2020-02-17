package leetcode.arg;

import java.util.HashSet;
import java.util.Set;

public class IsValidSudoku {
	
	public void main(){
		char[][] a= {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(a));
	}
	/**
	 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

		数字 1-9 在每一行只能出现一次。
		数字 1-9 在每一列只能出现一次。
		数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
	 * @param board
	 * @return
	 * 输入:
		[
		   0        2   3       5   6        8
		 0["8","3",".",".","7",".",".",".","."],
		  ["6",".",".","1","9","5",".",".","."],
		 2[".","9","8",".",".",".",".","6","."],
		 3["8",".",".",".","6",".",".",".","3"],
		  ["4",".",".","8",".","3",".",".","1"],
		 5["7",".",".",".","2",".",".",".","6"],
		 6[".","6",".",".",".",".","2","8","."],
		  [".",".",".","4","1","9",".",".","5"],
		 8[".",".",".",".","8",".",".","7","9"]
		]
		输出: false
		解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
		     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
		     0
		     1
		    10
		    
		    11
		   100
		   101
		   
		   110
		   111
		  1000   
		  [
		  ["5","3",".",".","7",".",".",".","."],
		  ["6",".",".","1","9","5",".",".","."],
		  [".","9","8",".",".",".",".","6","."],
		  ["8",".",".",".","6",".",".",".","3"],
		  ["4",".",".","8",".","3",".",".","1"],
		  ["7",".",".",".","2",".",".",".","6"],
		  [".","6",".",".",".",".","2","8","."],
		  [".",".",".","4","1","9",".",".","5"],
		  [".",".",".",".","8",".",".","7","9"]]
	 */
	public boolean isValidSudoku(char[][] board) {
		Set<String> checkhash = new  HashSet<String>();
		for(int i=0;i<board.length;i++) {
			String a=i>2?i>5?"2":"1":"0";
			for(int j=0;j<board.length;j++) {
				String b=j>2?j>5?"2":"1":"0";
				if(! (board[i][j]=='.')) {
					if(!( checkhash.add(j+"j"+board[i][j])
							&& checkhash.add(i+"i"+board[i][j])
							&& checkhash.add(a+b+board[i][j]) )) {
						
						return false;
					}
				}
			}
		}
		return true;
        
    }
	 public boolean isValidSudoku2(char[][] board){
	        short[] rows = new short[9];
	        short[] cols = new short[9];
	        short[] boxes = new short[9];
	        for (int row = 0; row < 9; row++) {
	            for (int col = 0; col < 9; col++) {
	                char c = board[row][col];
	                //把1 逻辑左移，右边补0
	                short num = (short) (1 << (c - '1'));
	                if (c == '.') continue;
	                if ((rows[row] & num) != 0) return false;
	                if ((cols[col] & num) != 0) return false;

	                int boxIndex = row / 3 * 3 + col / 3;
	                if ((boxes[boxIndex] & num) != 0) return false;

	                rows[row] |= num;
	                cols[col] |= num;
	                boxes[boxIndex] |= num;
	            }
	        }
	        return true;
	    }
	 public boolean isValidSudoku3(char[][] board) {
         int[] numArray = new int[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int chart = board[i][j] - '1';
                    //把行 列 区合为一个二进制值比较
                    int value = (1 << i) | (1 << (j + 9)) | (1 << (i / 3 * 3 + j / 3 + 18));
                    int preValue = numArray[chart];
                    if ((preValue & value) == 0) {
                        numArray[chart] = preValue | value;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
