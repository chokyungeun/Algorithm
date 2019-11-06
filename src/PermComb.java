import java.util.ArrayList;

public class PermComb {
	public static int N;
	public static int[][] temp;
	public static ArrayList<int[]> egg;
	public static boolean[] v;
	
	public static void permComb(int start, int count) {
		if(count == N) {
			func();
			return;
		}
		for(int i=0; i<N; i++) { 
			if(!v[i]) { 
				v[i] = true; 
				temp[count] = egg.get(i);
				permComb(i,count+1);
				v[i] = false; 
			} 
		}
	}

	private static void func() {
		
	}
}
