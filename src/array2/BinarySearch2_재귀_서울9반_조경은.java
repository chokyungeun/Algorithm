package array2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch2_재귀_서울9반_조경은 {
	public static int[] a = {2, 4, 7, 11, 19, 23};
	private static boolean binarySearch(int low, int high, int key) {
		if(low>high)
			return false;
		else {
			int middle = (low+high)/2;
			if(a[middle] == key)
				return true;
			else if(a[middle]>key)
				return binarySearch(low, middle-1, key);
			else
				return binarySearch(middle+1, high, key);
		}
	}
	/*public static void binarySearch(int[] a, int low, int high, int key) {
		int middle;
		if(a[low] > a[high])
			System.out.println("false");
		else {
			middle = (low + high)/2;
			
			if(key == a[middle])
				System.out.println("true");
			else if(key < a[middle])
				binarySearch(a, low, middle-1, key);
			else if(key > a[middle])
				binarySearch(a, middle+1, high, key);
		}
	}*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int key = sc.nextInt();
		
		System.out.println(binarySearch(0, a.length-1, key)); //인덱스 값 출력
		
		/*int[] a = {2, 4, 7, 9, 11, 19, 23};
		
		binarySearch(a, 0, a.length-1, 7);
		binarySearch(a, 0, a.length-1, 6);*/
	}

}
