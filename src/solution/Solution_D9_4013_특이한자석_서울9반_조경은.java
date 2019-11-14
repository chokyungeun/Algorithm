package solution;
import java.io.*;
import java.util.*;

public class Solution_D9_4013_특이한자석_서울9반_조경은 {
	public static int K;
	public static ArrayList<int[]> mag;
	public static ArrayList<int[]> rot;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			K = Integer.parseInt(br.readLine());
			mag = new ArrayList<>();
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					mag.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
				}
			}
			rot=new ArrayList<>();
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				rot.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			}
			
			
			
		}
		
	}
}