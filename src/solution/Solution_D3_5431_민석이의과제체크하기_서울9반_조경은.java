package solution;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_5431_민석이의과제체크하기_서울9반_조경은 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_d3_5431.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			boolean[] arr = new boolean[N];
	
			for(int i=0; i<K; i++) {
				arr[(sc.nextInt()-1)] = true;
			}
			System.out.print("#" + (tc+1) + " " );
			for(int i=0; i<N; i++) {
				if(arr[i] == false) {
					System.out.print((i+1) + " ");
				}
			}
			System.out.println();
			
		}
	}
}
