package a1031;

import java.io.*;
import java.util.*;

public class Solution_D9_5658_보물상자비밀번호_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_5658.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int K = Integer.parseInt(s[1]);
			char[] arr = br.readLine().toCharArray();
			
			ArrayList<String> list = new ArrayList<>();
			
			for(int k=0; k<N/4; k++) {
				for(int i=0; i<=N-(N/4); i+=N/4) {
					String sixteen = "";
					for(int j=i; j<N/4+i; j++) {
						sixteen += arr[j];
					}
					if(!list.contains(sixteen))
						list.add(sixteen);
				}
				char temp = arr[N-1];
				for(int x=N-1; x>0; x--) {
					arr[x] = arr[x-1];
				}
				arr[0] = temp;
			}
			
			long[] ten = new long[list.size()];
			for(int i=0; i<list.size(); i++) {
				ten[i] = Long.parseLong(list.get(i), 16);  
			}
			Arrays.sort(ten);
			System.out.println("#"  + t + " " + ten[list.size()-K]);
			
		}

	}

}
