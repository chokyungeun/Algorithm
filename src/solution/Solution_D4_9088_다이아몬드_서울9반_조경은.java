package solution;
import java.io.*;
import java.util.*;

public class Solution_D4_9088_다이아몬드_서울9반_조경은 {
	public static int N,K,result;
	public static int[] size;
	
	public static void diamond(int num) {
		int index=0;
		for(int i=num; i<N; i++) {
			if(size[i]-size[num]<=K) {
				index++;
			}
		}
		result = Math.max(result, index);
	}
	
	public static void permComb(int start, int count, int num) {
		if(count==num) {
			
		}
	}
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_9088.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			K = Integer.parseInt(s[1]);
			size = new int[N];
			for(int i=0; i<N; i++) {
				size[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(size);
			result = 0;
			for(int i=0; i<N; i++) {
				diamond(i);
			}
			System.out.println("#" + t + " " + result);
		}
		
	}
}