package solution;

import java.io.*;
import java.util.*;

public class Main_백준_14501_퇴사_서울9반_조경은 {
	public static int N,res;
	public static ArrayList<int[]> list;
	
	public static void func(int count, int temp, int p) {
		if(count >= N) {
			if(count == N) {
				p += temp;
			}
			res = Math.max(res, p);
			return;
		}
		func(count+list.get(count)[0],list.get(count)[1],p+temp);
		func(count+1,0,p+temp);
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(s[0]), Integer.parseInt(s[1])});
		}
		res=0;
		func(0,0,0);
		System.out.println(res);
	}

}
