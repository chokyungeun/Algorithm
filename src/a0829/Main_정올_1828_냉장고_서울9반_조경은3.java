package a0829;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class Main_정올_1828_냉장고_서울9반_조경은3 {
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
		if(nlist.size() > 0) {
			res++;
		}
		else {
			return;
		}
		list = new ArrayList<>();
		for(int i=0; i<nlist.size(); i++) {
			list.add(nlist.get(i));
		}
		Refri(list);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1828.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new int[] {sc.nextInt(), sc.nextInt()});
		}
		res = 1;
		Refri(list);
		
		System.out.println(res);
	}

}
