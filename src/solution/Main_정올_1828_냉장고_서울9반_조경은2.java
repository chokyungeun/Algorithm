package solution;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;



public class Main_정올_1828_냉장고_서울9반_조경은2 {
	public static int res;
	
	public static void Refri(int[] low, int[] high) {
		int min = high[0];
		for(int i=1; i<high.length; i++) {
			if(high[i] < min) {
				min = high[i];
			}
		}
		ArrayList<int[]> nlist = new ArrayList<>();
		for(int i=0; i<low.length; i++) {
			if(low[i] > min) {
				nlist.add(new int[] {low[i], high[i]});
			}
		}
		if(nlist.size() > 0) {
			res++;
		}
		else {
			return;
		}
		int[] l = new int[nlist.size()];
		int[] h = new int[nlist.size()];
		for(int i=0; i<nlist.size(); i++) {
			l[i] = nlist.get(i)[0];
			h[i] = nlist.get(i)[1];
		}
		
		Refri(l, h);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] low = new int[N];
		int[] high = new int[N];
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			low[i] = Integer.parseInt(s[0]);
			high[i] = Integer.parseInt(s[1]);
		}
		res = 1;
		Refri(low, high);
		
		System.out.println(res);
	}

}
