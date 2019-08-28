package brutegreedy;

import java.util.Arrays;
import java.util.Scanner;

public class PowerSet {
	public static int n, cnt, v[], d[] = {1,2,3,4};

	public static void powerset(int count) {
		if (count == n) {
			cnt++;
			System.out.print(Arrays.toString(v) + " ");
			for(int i=0; i<n; i++) {
				if(v[i]==1)
					System.out.print(d[i] + " ");
			}
			System.out.println();
			return;
		}
		v[count] = 0;
		powerset(count+1);
		v[count] = 1;
		powerset(count+1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 4;// sc.nextInt();
		v = new int[n]; // 사용 여부 체크
		powerset(0);
		System.out.println(cnt);
		sc.close();
	}
}
