package solution;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D2_1959_두개의숫자열_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d2_1959.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		//입력받기
		for(int tc=1; tc<T+1; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			int[] sum;
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			for(int i=0; i<M; i++) {
				B[i] = sc.nextInt();
			}
			//A가 B보다 길 경우
			if(N>M) {
				sum = new int[N-M+1];
				for(int i=0; i<(N-M+1); i++) {
					for(int j=0; j<M; j++) {
						sum[i] += A[i+j]*B[j];
					}
				}
			}
			else { //B가 A보다 길 경우
				sum = new int[M-N+1];
				for(int i=0; i<(M-N+1); i++) {
					for(int j=0; j<N; j++) {
						sum[i] += B[i+j]*A[j];
					}
				}
			}
			//최대값 찾기
			int max = sum[0];
			for(int i=1; i<sum.length; i++) {
				if(sum[i] > max)
					max = sum[i];
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}