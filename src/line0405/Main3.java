package line0405;
import java.io.*;
import java.util.*;

public class Main3 {
	public static int[] d;
	public static ArrayList<Integer> list;
	public static boolean[] v;
	public static int max;
	
	public static void permComb(int start, int count, int n, char[] road) {
		if(count == n) {
			char[] temp = new char[road.length];
			for(int i=0; i<road.length; i++) {
				temp[i] = road[i];
			}
			for(int i=0; i<d.length; i++){
				temp[d[i]] = '1';
			}
			
			int num = 0;
			for(int i=0; i<temp.length; i++) {
				if(temp[i]=='1') {
					num++;
				}
				else {
					max = Math.max(max,num);
					num=0;
				}
			}
			max = Math.max(max,num);
			return;
		}
		
		for(int i=start; i<list.size(); i++) {
			if(!v[i]) {
				v[i] = true;
				d[count] = list.get(i);
				permComb(i, count+1, n, road);
				v[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		String road = "001100";
		int n = 5;
		
		int answer = -1;
		char[] r = road.toCharArray();
		list = new ArrayList<>();
		for(int i=0; i<road.length(); i++) {
			if(road.charAt(i)=='0') {
				list.add(i);
			}
		}
		
		v = new boolean[list.size()];
		max = 0;
		if(n>list.size()) {
			d = new int[list.size()];
			permComb(0,0,list.size(),r);
		}
		else {
			d = new int[n];
		}
			permComb(0,0,n,r);
		
		answer = max;
		
		System.out.println(answer);
	}

}
