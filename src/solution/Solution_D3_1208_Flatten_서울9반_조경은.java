package solution;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_D3_1208_Flatten_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[100];
		for(int tc=1; tc<11; tc++) {
			int dump = sc.nextInt();
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i=0; i<dump; i++) {
				if((arr[0] == arr[99]) || arr[0] == (arr[99]-1)){
					break;
				}
				else {
					++arr[0];
					--arr[99];
					Arrays.sort(arr);
				}
			}
			int result = arr[99] - arr[0];
			System.out.println("#" + tc + " " + result);
		}
	}
}
