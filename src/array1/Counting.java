package array1;

import java.util.Arrays;

public class Counting { //배열안의 수의 개수를 카운팅하고 그 개수를 인덱스로 사용해 정렬

	public static void main(String[] args) {
		int[] a = {0, 4, 1, 3, 1, 2, 4, 1};
		int k = Arrays.stream(a).max().getAsInt();
		int[] c = new int[k+1]; //배열의 최대값 + 1
		int[] s = new int[a.length]; //정렬된 배열을 저장할 배열
		System.out.println(a.length);
		
		
		for(int i=0; i<a.length; i++) c[a[i]]++;
		for(int i=1; i<c.length; i++) c[i] += c[i-1];
		for(int i=0; i<a.length; i++) {
			c[a[i]]--;
			s[c[a[i]]] = a[i];
		}
		System.out.println(Arrays.toString(s));
		
		
	}

}
