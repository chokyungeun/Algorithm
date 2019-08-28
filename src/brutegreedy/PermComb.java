package brutegreedy;

import java.util.Arrays;
import java.util.Scanner;

//중복순열 nPIr=n^r 5PI3=5*5*5=125
//순열 nPr=n*(n-1)*...(n-r) 5P3=5*4*3=60
//중복조합 nHr=(n+r-1)Cr 5H3=(5+3-1)C3=7C3=7P3/3!=7*6*5/3*2*1=35
//조합 nCr=nPr/r! 5C3=5P3/3!=5*4*3/3*2*1=10
public class PermComb {
	public static int n, r, cnt, a[], v[], d[] = { 0, 1 };
	public static char[] c = { 'A', 'B', 'C', 'D' };

	public static void permcomb(int count) {
		if (count == r) {
			cnt++;
			System.out.print(Arrays.toString(a));
			for (int i = 0; i < r; i++) {
				if (a[i] == 1)
					System.out.print(c[i] + " ");
			}
			System.out.println();
			return;
		}
		a[count] = d[0];
		permcomb(count+1);
		a[count] = d[1];
		permcomb(count+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 2;// sc.nextInt();
		r = 4;// sc.nextInt();
		v = new int[n]; // 사용 여부 체크
		a = new int[r];
		permcomb(0);
		System.out.println(cnt);
		sc.close();
	}
}
