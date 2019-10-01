package line0922;

import java.io.*;
import java.util.*;

public class Test3 {
public static int res;
public static int res1;
	
	public static void Toilet(ArrayList<int[]> list) {
		int min = list.get(0)[1];
		int index = 0;
		for(int i=1; i<list.size(); i++) {
			if(list.get(i)[1] < min) {
				min = list.get(i)[1];
				index = i;
			}
		}
		
		ArrayList<int[]> nlist = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0] >= min) {
				nlist.add(list.get(i));
			}
			else {
				if(index != i) {
					res1++;
				}
				
			}
			
		}
		
		
		list = new ArrayList<>();
		for(int i=0; i<nlist.size(); i++) {
			list.add(nlist.get(i));
		}
		if(res < res1)
			res = res1;
		if(nlist.size() > res) {
			res1 = 1;
			Toilet(list);
		}
			
		else {
			return;
		}
		
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new int[] {sc.nextInt(), sc.nextInt()});
		}
		res = 1;
		res1 = 1;
		Toilet(list);
		System.out.println(res);
	}

}
