package array2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch1_반복_서울9반_조경은 {
	public static int[] a = {2, 4, 7, 11, 19, 23};
	
	public static boolean binarySearch(int key) {
		int start = 0;
		int end = a.length-1;
		while(start<=end) {
			int middle = (start + end)/2;
			if(a[middle] == key) {
				return true;
			}
			else if(a[middle] > key) {
				end = middle - 1;
			}
			else {
				start = middle + 1;
			}
		}
		return false;
	}
	
	/*public static void binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length-1;
		int middle = 0;
		while(start <= end) {
			middle = (start+end)/2;
			if(a[middle] == key) {
				System.out.println("true");
				break;
			}
			else if(a[middle] > key) {
				end = middle - 1;
			}
			else {
				start = middle + 1;
			}
		}
		if(a[middle] != key)
			System.out.println("false");
	}
	*/
	public static void main(String[] args) {
		//int[] a = {2, 4, 7, 9, 11, 19, 23};
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		System.out.println(binarySearch(key));
		
		System.out.println(Arrays.binarySearch(a, key)); //인덱스 값 출력
		//binarySearch(a, 7);
		//binarySearch(a, 6);
	}

}
