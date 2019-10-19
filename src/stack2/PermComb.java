package stack2;

import java.util.Arrays;
import java.util.Scanner;

//중복순열 nPIr=n^r 5PI3=5*5*5=125
//순열 nPr=n*(n-1)*...(n-r) 5P3=5*4*3=60
//중복조합 nHr=(n+r-1)Cr 5H3=(5+3-1)C3=7C3=7P3/3!=7*6*5/3*2*1=35
//조합 nCr=nPr/r! 5C3=5P3/3!=5*4*3/3*2*1=10
public class PermComb {
	public static int n,r,cnt,a[],v[],d[]={1,2,3,4,5,6};
	
	public static void permComb(int start, int count) {
		if(count == r) {
			cnt++;
			System.out.println(Arrays.toString(a));
			return;
		}
		for(int i=start; i<n; i++) { //i=start로 시작하면 조합, 0으로 시작하면 순열
			if(v[i]==0) { //!!
				v[i] = 1; //visit 배열에 방문처리 //!!
				a[count] = d[i];
				permComb(i,count+1);
				v[i] = 0; //방문 해제. //!!
			} //!!
		}
		//!!주석처리 하면 중복허용, 주석처리 안하면 중복제거
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = 6;//sc.nextInt();
		r = 4;//sc.nextInt();
		v = new int[n]; //사용 여부 체크
		a = new int[r];
		permComb(0,0);
		System.out.println(cnt);
		sc.close();
	}
}
