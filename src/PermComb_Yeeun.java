import java.io.*;
import java.util.*;

public class PermComb_Yeeun {
	public static int[] arr = {1,2,3,4,5,6};
	public static int[] d;
	public static boolean[] v;
	
	//{1,2,3,4,5,6}
	public static void permComb(int start, int count) {
		if(count == 4) {
			System.out.println(Arrays.toString(d));
			return;
		}
		
		for(int i = start; i<6; i++) {
			if(!v[i]) {
				v[i] = true;
				d[count] = arr[i];
				permComb(i, count+1);
				v[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		d = new int[4];
		v = new boolean[6];
		permComb(0,0);
	}

}
