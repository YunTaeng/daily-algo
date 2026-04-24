import java.util.*;
import java.io.*;

class Solution {
	static int [] topIdxList;
	static Stack<Integer> stack = new Stack<>();
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int N = board.length;
        
        topIdxList = new int[N];
        
        for (int i=0;i<N;i++) {
        	for (int j=0;j<N;j++) {
        		if(board[i][j]>0 && topIdxList[j]==0) {
        			topIdxList[j]=i;
        		}
        	}
        	
        }
        for (int k : moves) {
            int col = k - 1;
            
            for (int row = 0; row < board.length; row++) {
                if (board[row][col] != 0) {//인형발견
                    int doll = board[row][col];
                    board[row][col] = 0; // 인형 뽑고 빈칸
                    
                    // 2. 스택 로직
                    if (!stack.isEmpty() && stack.peek() == doll) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(doll);
                    }
                    break;//더 내려갈것없이 탈출
                }
            }
        }
        
        
        
        return answer;
    }
}