package a0829;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main_정올_1828_냉장고_서울9반_조경은 {
	public static int res;
	
	public static void Refri(ArrayList<int[]> list) {
		int min = list.get(0)[1];
		
		for(int i=1; i<list.size(); i++) {
			if(list.get(i)[1] < min) {
				min = list.get(i)[1];
			}
		}
		
		ArrayList<int[]> nlist = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0] > min) {
				nlist.add(list.get(i));
			}
		}
		
		if(nlist.size() > 0) 
			res++;
		else 
			return;
		
		list = new ArrayList<>();
		for(int i=0; i<nlist.size(); i++) {
			list.add(nlist.get(i));
		}
		
		Refri(list);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1828.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			list.add(new int[] {Integer.parseInt(s[0]),Integer.parseInt(s[1])});
		}
		
		res = 1;
		Refri(list);
		
		System.out.println(res);
	}

}
