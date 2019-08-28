package Solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_2817_부분수열의합_서울9반_조경은 {

	//이렇게 재귀함수로 만들어서 풀 수도 있음!
	/*public static void solve(int sum, int pos) {
	 * 
		if(sum>hap) 
			return;
			
		if(sum==hap) {
			cnt++;
			return;
		}
		
		if(pos==N) 
			return;
		
		solve(sum, pos+1);
		solve(sum+a[pos], pos+1);
			
	}*/
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_2817.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<T+1; tc++) {
			int num=0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int x = 1;
			for(int i=0; i<N; i++) {
				x = x*2;
			}
			int[] sum = new int[x];
			
			for(int i=0; i<(1 << arr.length); i++) {
				for(int j=0; j<arr.length; j++) {
					if((i & (1<<j)) > 0) {
						sum[i] = sum[i] + arr[j];
					}
				}
			}
			for(int i=0; i<sum.length; i++) {
				if(K == sum[i])
					++num;
			}
			System.out.println("#" + tc + " " + num);
		}
	}
}
