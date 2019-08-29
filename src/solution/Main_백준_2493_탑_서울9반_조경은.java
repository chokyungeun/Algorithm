package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_백준_2493_탑_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] sa = line.split(" ");
		int N = Integer.parseInt(sa[0]);
		
		int[] arr = new int[N];
		int[] res = new int[N];
		
		line = br.readLine();
		sa = line.split(" ");
		//StringTokenizer st = new StringTokenizer(line);
		
		for(int i=0;i <N; i++) {
			arr[i] = Integer.parseInt(sa[i]);
		}
		
		for(int i=1; i<N; i++) {
			for(int j=i-1; j>=0; j--) {
				if(arr[i] < arr[j]) {
					res[i] = j+1;
					break;
				}
			}
			
		}
		for(int v:res)
			System.out.print(v + " ");
		
	}

}
