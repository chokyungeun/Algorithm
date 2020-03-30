package solution;
import java.io.*;
import java.util.*;

public class Main_백준_1764_듣보잡_서울9반_조경은 {
	public static int N,M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> hm = new HashMap<>();
		int index = 0;
		for(int i=0; i<N; i++) {
			hm.put(br.readLine(),index++);
		}
		PriorityQueue<String> pq = new PriorityQueue<>();
		for(int j=0; j<M; j++) {
			String s = br.readLine();
			int num = hm.size();
			hm.put(s, index++);
			if(num == hm.size()) {
				pq.offer(s);
			}
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
