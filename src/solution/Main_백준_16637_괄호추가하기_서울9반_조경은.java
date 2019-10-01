package solution;

import java.io.*;
import java.util.*;

public class Main_백준_16637_괄호추가하기_서울9반_조경은 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] c = br.readLine().toCharArray();
		int[] num = new int[(N+1)/2];
		char[] op = new char[N/2];
		for(int i=0; i<(N+1)/2; i++) {
			num[i] = c[(i*2)]-'0';
			if(i==(N/2))
				break;
			op[i] = c[(i*2)+1];
		}
		
		
		
	}

}
