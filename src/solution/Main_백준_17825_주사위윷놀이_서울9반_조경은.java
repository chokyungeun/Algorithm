package solution;
import java.io.*;
import java.util.*;

public class Main_백준_17825_주사위윷놀이_서울9반_조경은 {
	public static int[] dice;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		for(int i=0; i<10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
	}

}
