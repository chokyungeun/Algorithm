package solution;

import java.io.*;
import java.util.*;

public class Solution_D3_8658_Summation_서울9반_조경은 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			String[] arr = new String[10];
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i=0; i<10; i++) {
				arr[i] = st.nextToken();
				char[] c = arr[i].toCharArray();
				int sum = 0;
				for(int j=0; j<c.length; j++) {
					sum += c[j]-'0';
				}
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			System.out.println("#" + t + " " + max + " " + min);
		}

	}

}
