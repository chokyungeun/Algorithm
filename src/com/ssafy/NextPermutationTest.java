package com.ssafy;

import java.util.Arrays;

public class NextPermutationTest {

	static int[] numbers = {1,2,3,4,5};
	static int  N = 5,cnt=0;
	public static void main(String[] args) {

		Arrays.sort(numbers); // 오름차순
		do {
			System.out.println(Arrays.toString(numbers));
		}while(np());
		System.out.println(cnt);
	}
	
	private static boolean np() {
		cnt++;
		//1. 교환이 필요한 위치 찾기(i-1) : 교환이 필요한 다음으로 가중치가 큰 자리
		int i = N-1;
		while(i>0 && numbers[i-1] >= numbers[i]) --i;
		if(i==0) return false; // 이미 가장 큰 순열이므로 다음 순열 없음.
		
		//2. i-1위치값이랑 교환할 j값 찾기(i-1 위치 뒤쪽에서)
		// i-1위치값보다 크면서 이 자리에 올수 있는 i-1 위치 뒤쪽에서의 가장 작은 값
		int j=N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		
		//3. i-1위치값하고 j위치값 교환
		int t = numbers[i-1];
		numbers[i-1] = numbers[j];
		numbers[j] = t;
		
		//4. i-1위치 뒤쪽으로 가장 작은 순열로 정렬
		j=N-1;
		while(i<j) {
			t = numbers[i];
			numbers[i] = numbers[j];
			numbers[j] = t;
			++i;
			--j;
		}
		return true;
	}

}
