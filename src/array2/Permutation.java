package array2;

import java.util.Arrays;
import java.util.Scanner;

//순열 nPr=n*(n-1)*...(n-r) 5P3=5*4*3=60
//중복을 허용하지 않는 순열
public class Permutation {
	public static int n,r,cnt,a[];
	
	public static void permutation(int count) {
		if(count == r) {
			for(int i=0; i<r; i++) {
				for(int j=i+1; j<r; j++) {
					if(a[i] == a[j]) return;
				}
			}
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		
		for(int i=1; i<=n; i++) {
			a[count] = i;
			permutation(count+1);
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5;//sc.nextInt();
		r = 3;//sc.nextInt();
		a = new int[r];
		permutation(0);
		System.out.println(cnt);
		sc.close();
	}
}
