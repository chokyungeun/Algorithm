package solution;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_1209_Sum_서울9반_조경은  {

	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1209.txt"));
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			int T = sc.nextInt();
			
			int[][] arr = new int[100][100];
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			int row[] = new int[100];
			int col[] = new int[100];
			
			int[] res = new int[4];
			for(int j=0; j<100; j++) {
				for(int k=0; k<100; k++) {
					row[j] += arr[j][k];
					col[j] += arr[k][j];
				}
				res[2] += arr[j][j];
				res[3] += arr[j][99-j];
			}
			
			res[0] = Arrays.stream(row).max().getAsInt();
			res[1] = Arrays.stream(col).max().getAsInt();
			int result = Arrays.stream(res).max().getAsInt();
			
			System.out.println("#" + (i+1) + " " + result);
		
		}

	}

}
