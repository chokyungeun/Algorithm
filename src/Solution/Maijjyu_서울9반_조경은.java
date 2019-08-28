package Solution;

import java.util.LinkedList;
import java.util.Queue;

public class Maijjyu_서울9반_조경은 {

	public static void main(String[] args) {
		/*Queue<Integer> q = new LinkedList<>();
		int num = 1;
		int cnt = 20;
		int tot = 0;
		int tnum = -1;
		q.offer(num);
		q.offer(1);
		while(cnt > 0) {
			tnum = q.poll();
			int tsu = q.poll();
			int su=(tsu>cnt)? cnt:tsu;
			cnt -= su;
			tot += su;
			System.out.println(tnum +"번 " + su + " 개 남은 수 : " + cnt);
			
			q.offer(tnum);
			q.offer(++tsu);
			q.offer(++num);
			q.offer(1);
		}
		System.out.println("마지막 받은 사람 = " + tnum);
		System.out.println(tot);*/
		
		Queue<int[]> q = new LinkedList<int[]>();
		int num = 1;
		int cnt = 20;
		int tot = 0;
		int[] recv = null;
		q.offer(new int[] {num, 1});
		while(cnt > 0) {
			recv = q.poll();
			int su = (recv[1]>cnt) ? cnt : recv[1];
			cnt -= su;
			tot += su;
			System.out.println(recv[0]+"번 " + su + " 개 남은 수 : " + cnt);
			recv[1]++;
			q.offer(recv);
			q.offer(new int[] {++num, 1});
		}
		System.out.println("마지막 받은 사람 = " + recv[0]);
	
		
		
		
		/*Queue<Integer> q = new LinkedList<>();
		int[] num = new int[20];
		int m = 100;
		Loop: for(int i=1; i<20; i++) {
			for(int j=1; j<=i; j++) {
				if(!q.contains(j))
					q.offer(j);
			}
			int n = q.poll();
			num[n]++;
			m = m-num[n];
			if(m<=0) {
				System.out.println(n + "번째가 가져갔어요!");
				break Loop;
			}
		}*/
	}
}
