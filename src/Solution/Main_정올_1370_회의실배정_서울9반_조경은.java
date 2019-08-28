package Solution;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_정올_1370_회의실배정_서울9반_조경은 {
	public static class Meeting implements Comparable<Meeting>{
		int num; int start; int end;
		Meeting(int num, int start, int end){ 
			this.num = num; this.start = start; this.end = end;
		}
		@Override
		public int compareTo(Meeting o) { 
			return Integer.compare(end, o.end);
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1370.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Meeting[] m = new Meeting[N];
		
		for (int i = 0; i < N; i++) {
			m[i] = new Meeting(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
			
		Arrays.sort(m);
		//System.out.println(Arrays.toString(m).replace("[", "").replace("]", "").replace(", ", "\n"));
		
		List<Meeting> li = new ArrayList<>();
		li.add(m[0]);
		for(int i=1; i<m.length; i++) {
			if(li.get(li.size()-1).end <= m[i].start) 
				li.add(m[i]);
		}
		System.out.println(li.size());
		for(Meeting meet : li)
			System.out.print(meet.num + " ");
		sc.close();

	}

}
