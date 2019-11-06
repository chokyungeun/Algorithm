package a1106;
import java.io.*;
import java.util.*;

public class Solution_D4_4050_재관이의대량할인_서울9반_조경은 {
	public static int N,total;
	public static int[] arr,div;
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_4050.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			total=0;
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				total+=arr[i];
			}
			
			Arrays.sort(arr);
			div = new int[3];
			for(int i=N-3; i>=0; i-=3) {
				total-=arr[i];
			}
			
			System.out.println("#" + t + " " + total);
			
		}
		
	}
}