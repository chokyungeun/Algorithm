package brutegreedy;

import java.util.Arrays;
import java.util.Scanner;

//순열 nPr=n*(n-1)*...(n-r) 5P3=5*4*3=60
public class Perm {
	public static int n,cnt,d[]={1,2,3,4};
	public static void swap(int i, int j) {
		if(i==j)
			return;
		int T = d[i];
		d[i] = d[j];
		d[j] = T;
	}
	public static void perm(int count) {
		if(count == n) {
			cnt++;
			System.out.println(Arrays.toString(d));
			return;
		}
		for(int i=count; i<n; i++) { //i=start로 시작하면 조합, 0으로 시작하면 순열
			swap(count, i);
			perm(count+1);
			swap(count, i);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = d.length;//sc.nextInt();
		perm(0);
		System.out.println(cnt);
		sc.close();
	}
}
