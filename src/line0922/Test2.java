package line0922;

import java.io.*;
import java.util.*;

public class Test2 {
	public static int[] arr, arr2, a;
	public static int[] v;
	public static int cnt, num;
	
	public static void permComb(int start, int count) {
		if(count == arr.length) {
			cnt++;
			if(cnt == num) {
				for(int i=0; i<a.length; i++)
					System.out.print(a[i]);
			}
			return;
		}
		for(int i=0; i<arr.length; i++) { //i=start로 시작하면 조합, 0으로 시작하면 순열
			if(v[i]==0) { //!!
				v[i] = 1; //visit 배열에 방문처리 //!!
				a[count] = arr[i];
				permComb(i,count+1);
				v[i] = 0; //방문 해제. //!!
			} //!!
		}
		//!!주석처리 하면 중복허용, 주석처리 안하면 중복제거
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		arr = new int[s.length];
		for(int i=0; i<s.length; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		num = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		v = new int[arr.length];
		a = new int[arr.length];
		permComb(0,0);
		
		

	}

}
