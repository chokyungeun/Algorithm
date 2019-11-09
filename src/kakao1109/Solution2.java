package kakao1109;
import java.io.*;
import java.util.*;

public class Solution2 {
	
	public static int[] solution(String s) {
		int[] answer= {};
		char[] c= s.toCharArray();
		int index=0;
		int[][] arr = new int[4][];
		int[] temp = new int[4];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<c.length; i++) {
			if(c[i] != '{') {
				if(c[i]=='}' && index!=0) {
					arr[index-1] = new int[index];
					for(int j=0; j<index; j++) {
						if(temp[j]==0) break;
						arr[index-1][j] = temp[j];
					}
					temp = new int[4];
					index=0;
				}
				else if(c[i]>=0 && c[i]!=',') {
					temp[index] = (c[i]-'0');
					index++;
				}
			}
		}
		answer[0] = arr[0][0];
		
			
		return answer;
	}
	public static void main(String args[]) throws Exception {
			
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		
		solution(s);
	}
}