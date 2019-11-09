package kakao1109;
import java.io.*;
import java.util.*;

public class Solution4 {
	
	public static long[] solution(long k, long[] room_number) {
		long[] answer= new long[room_number.length];
		boolean[] v = new boolean[2000];
		
		for(int i=0; i<room_number.length; i++) {
			if(!v[(int) room_number[i]]) {
				v[(int) room_number[i]]=true;
				answer[i]=(int) room_number[i];
			}
			else {
				for(int j=(int) room_number[i]; j<v.length; j++) {
					if(!v[j]) {
						v[j]=true;
						answer[i] = j;
						break;
					}
				}
			}
		}
		
			
		
		
		return answer;
	}
	public static void main(String args[]) throws Exception {
		long[] answer = solution(10, new long[]{1,3,4,1,3,1});
			
		System.out.println(Arrays.toString(answer));
		
	}
}