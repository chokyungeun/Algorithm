package solution;
import java.io.*;
import java.util.*;

public class Main_백준_17211_좋은날싫은날_서울9반_조경은 {
	public static int N,M,gres,bres;
	public static double[] mood;
	public static double tgood, tbad;
	
	public static void good(int count, double res) {
		if(count==N+1) {
			tgood += res;
			return;
		}
		good(count+1,res*mood[0]);
		bad(count+1, res*mood[1]);
	}
	
	public static void bad(int count, double res) {
		if(count==N+1) {
			tbad += res;
			return;
		}
		good(count+1,res*mood[2]);
		bad(count+1, res*mood[3]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		mood = new double[4];
		s = br.readLine().split(" ");
		for(int i=0; i<4; i++) {
			mood[i] = Double.parseDouble(s[i]);
		}
		
		if(M==0) good(1,1);
		else bad(1,1);
		
		gres = (int) Math.round(1000*tgood);
		bres = (int) Math.round(1000*tbad);
		System.out.println(gres);
		System.out.println(bres);
	}

}
