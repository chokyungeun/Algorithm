package com.ssafy;

import java.util.Arrays;

public class NextCombinationTest {

	static int[] numbers = {1,2,3,4,5};
	static int[] p ;
	static int  N = 5, R=2, cnt=0;
	public static void main(String[] args) {

		p = new int[N]; // N크기의 int 배열 생성 : 0으로 초기화
		p[N-1] = p[N-2] = 1;
		Arrays.sort(p); // 오름차순
		
		do {
			System.out.println(Arrays.toString(p));
			for (int i = 0; i < N; i++) {
				if(p[i]==1) System.out.print("\t"+numbers[i]);
			}
			System.out.println();
		}while(np());
		System.out.println(cnt);
	}
	
	private static boolean np() {
		cnt++;
		//1. 교환이 필요한 위치 찾기(i-1) : 교환이 필요한 다음으로 가중치가 큰 자리
		int i = N-1;
		while(i>0 && p[i-1] >= p[i]) --i;
		if(i==0) return false; // 이미 가장 큰 순열이므로 다음 순열 없음.
		
		//2. i-1위치값이랑 교환할 j값 찾기(i-1 위치 뒤쪽에서)
		// i-1위치값보다 크면서 이 자리에 올수 있는 i-1 위치 뒤쪽에서의 가장 작은 값
		int j=N-1;
		while(p[i-1]>=p[j]) --j;
		
		//3. i-1위치값하고 j위치값 교환
		int t = p[i-1];
		p[i-1] = p[j];
		p[j] = t;
		
		//4. i-1위치 뒤쪽으로 가장 작은 순열로 정렬
		j=N-1;
		while(i<j) {
			t = p[i];
			p[i] = p[j];
			p[j] = t;
			++i;
			--j;
		}
		return true;
	}

}






