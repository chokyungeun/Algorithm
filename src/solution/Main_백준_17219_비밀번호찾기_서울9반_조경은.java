package solution;
import java.io.*;
import java.util.*;

public class Main_백준_17219_비밀번호찾기_서울9반_조경은 {
	public static int N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		ArrayList<String[]> site = new ArrayList<>();
		for(int i=0; i<N; i++) {
			s = br.readLine().split(" ");
			site.add(new String[] {s[0],s[1]});
		}
		
		for(int i=0; i<M; i++) {
			s[0] = br.readLine();
			for(int j=0; j<site.size(); j++) {
				if(site.get(j)[0].equals(s[0])) {
					System.out.println(site.get(j)[1]);
					site.remove(j);
					break;
				}
			}
		}
	}

}
