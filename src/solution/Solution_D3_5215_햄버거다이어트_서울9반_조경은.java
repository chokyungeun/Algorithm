package solution;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_5215_햄버거다이어트_서울9반_조경은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i=0; i < tc; i++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int[] sort_T = new int[N];
			int[] sort_K = new int[N];
			
			int result = 0;
			
			for(int j = 0; j < N; j++) {
				sort_T[j] = sc.nextInt();
				sort_K[j] = sc.nextInt();
			}
			int[][] arr = new int[N][N];
			/*for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					arr[j][k] = 
				}
			}*/
			
			
			/*int[] T = sort_T;
			int[] K = sort_K;
			Arrays.sort(T);
			Arrays.sort(K);
			int k_sum = 0;
			int x = 0;
			for(int j=0; j<K.length; j++) {
				k_sum += sort_K[j];
				if(k_sum > 1000) {
					x = j;
					break;
				}
			}
			for(int j=0; j<x; j++) {
				result += sort_T[j];
			}
			//가장 적은 칼로리부터 차례로 더해서 1000이 넘으면 멈추고 맛접수를 칼로리 개수만큼 더함
			//but 칼로리 크기와 맛 점수가 비례하지 않음!
			 * 
			 */
			System.out.println("#" + tc + " " + result);
		}
	}
}
