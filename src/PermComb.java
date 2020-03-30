import java.util.ArrayList;
import java.util.Arrays;

public class PermComb {
	public static int N;
	public static int[] temp;
	public static ArrayList<int[]> egg;
	public static boolean[] v;
	
	public static void permComb(int start, int count) {
		if(count == 4) {
			func();
			return;
		}
		for(int i=start; i<N; i++) { 
			if(!v[i]) { 
				v[i] = true; 
				temp[count] = i;
				permComb(i,count+1);
				v[i] = false; 
			} 
		}
	}

	private static void func() {
		System.out.println(Arrays.toString(temp));
	}
	
	public static void main(String args[]) throws Exception {
		N = 4;
		temp = new int[N];
		v = new boolean[N];
		permComb(0, 0);
	}
	
}
