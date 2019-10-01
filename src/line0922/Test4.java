package line0922;
import java.util.*;
import java.io.*;

public class Test4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == 1) {
				list.add(i);
			}
		}

		int[] d = new int[list.size()-1];
		for(int i=0; i<d.length; i++) {
			d[i] = list.get(i+1)-list.get(i);
		}
		int max = d[0];
		for(int i=1; i<d.length; i++) {
			if(max < d[i])
				max = d[i];
		}
		
		System.out.println(max/2);
	}

}
