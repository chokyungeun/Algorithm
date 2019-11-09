package kakao1109;
import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int j=0; j<moves.length; j++) {
        	for(int i=0; i<board.length; i++) {
        		if(board[i][moves[j]-1]!=0) {
        			list.add(board[i][moves[j]-1]);
        			board[i][moves[j]-1]=0;
        			break;
        		}
        	}
        	if(list.size()>=2 && list.get(list.size()-1)==list.get(list.size()-2)) {
        		list.remove(list.size()-1);
        		list.remove(list.size()-1);
        		answer+=2;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) throws Exception {
		
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(solution(board, moves));
	}

}
