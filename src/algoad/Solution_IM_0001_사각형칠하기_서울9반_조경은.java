package algoad;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_IM_0001_사각형칠하기_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_im_0001.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] si = new int[K];
			int[] sj = new int[K];
			int[] ei = new int[K];
			int[] ej = new int[K];
			int[] c = new int[K];
			for(int i=0; i<K; i++) {
				si[i] = sc.nextInt();
				sj[i] = sc.nextInt();
				ei[i] = sc.nextInt();
				ej[i] = sc.nextInt();
				c[i] = sc.nextInt();
			}
			int[][] arr = new int[N][M];
			for(int k=0; k<K; k++) {
				int num=0;
				for(int i=si[k]; i<=ei[k]; i++) {
					for(int j=sj[k]; j<=ej[k]; j++) {
						if(arr[i][j] > c[k])
							num++;
					}
				}
				if(num==0) {
					for(int i=si[k]; i<=ei[k]; i++) {
						for(int j=sj[k]; j<=ej[k]; j++) {
							arr[i][j] = c[k];
						}
					}
				}
			}
			int[] col = new int[21];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					col[arr[i][j]]++;
				}
			}
			Arrays.sort(col);
			
			System.out.println("#" + t + " " + col[col.length-1]);
		}
	}

}
