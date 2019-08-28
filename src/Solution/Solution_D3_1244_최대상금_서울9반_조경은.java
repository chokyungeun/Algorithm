package Solution;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution_D3_1244_최대상금_서울9반_조경은 {
	public static int n, max;
	public static char[] num;
	
	public static void swap(int i, int j) {
		char T = num[i];
		num[i] = num[j];
		num[j] = T;
	}
	public static void dfs(int count, int cnt) {
		if(cnt==n) {
			max = Math.max(max, Integer.parseInt(String.valueOf(num)));
			return;
		}
		for(int i=count; i<num.length; i++) {
			for(int j=i+1; j<num.length; j++) {
				if(num[i]<=num[j]) { //안들어가도 되지만 들어가면 시간이 훨씬 줄어듬!
					swap(i, j);
					dfs(i, cnt+1);
					swap(i, j);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_1244.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t < T + 1; t++) {
			num = sc.next().toCharArray();
			n = sc.nextInt();
			
			max = 0;
			dfs(0, 0);
			System.out.println("#" + t + " " + max);
		}
		sc.close();
	}
	
	
	
	
	
	
	
	/*public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D3_1244.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t < T + 1; t++) {
			int num = sc.nextInt();
			int n = sc.nextInt();

			String s = Integer.toString(num);
			char[] arr1 = s.toCharArray();
			ArrayList<Character> list = new ArrayList<>();
			for (int i = 0; i < arr1.length; i++) {
				list.add(arr1[i]);
			}
			ArrayList<Character> test = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				test.add(list.get(i));
			}
			Collections.sort(test);
			ArrayList<Character> l = new ArrayList<>();
			if (test.get(test.size() - 1) == test.get(test.size() - 2)) {

				if (list.size() >= n) {
					for (int i = 0; i < n; i++) {
						l.add(list.get(i));
					}
					Collections.sort(l);
					for (int i = n; i < list.size(); i++) {
						l.add(list.get(i));
					}
				} else {
					for (int i = 0; i < list.size(); i++) {
						l.add(list.get(i));
					}
					Collections.sort(l);
				}
			} else {
				for(int i=0; i<list.size(); i++) {
					l.add(list.get(i));
				}
			}

			for (int i = 0; i < n; i++) {
				int x = i;
				if(x>=l.size()) {
					for(int j=0; j<n-l.size(); j++) {
						Collections.swap(l, l.size()-2, l.size()-1);
					}
					break;
				}
				int max = x;
				for (int j = x + 1; j < l.size(); j++) {
					if (l.get(j) >= l.get(max))
						max = j;
				}
				if (x != max) {
					Collections.swap(l, x, max);
				} else {
					if(l.get(x) == l.get(x-1)) {
						break;
					}
					n++;
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < l.size(); i++) {
				System.out.print(l.get(i));
			}
			System.out.println();
		}
	}*/

}
