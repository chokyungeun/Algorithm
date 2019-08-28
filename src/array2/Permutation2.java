package array2;

import java.util.Arrays;
import java.util.Scanner;
//비트연산을 이용한 중복체크
//순열 nPr=n*(n-1)*...(n-r) 5P3=5*4*3=60
//중복을 허용하지 않는 순열
public class Permutation2 {
	public static int n,r,cnt,a[];
	
	public static void permutation(int start, int flag, int count) {
		if(count == r) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=1; i<=n; i++) {
			if((flag & (1<<i))==0) {
				a[count] = i;
				permutation(i, (flag|(1<<i)), count+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 5;//sc.nextInt();
		r = 3;//sc.nextInt();
		a = new int[r];
		permutation(1, 0, 0);
		System.out.println(cnt);
		sc.close();
	}
}
