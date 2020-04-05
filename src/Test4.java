import java.io.*;
import java.util.*;

public class Test4 {
	public static int[] p;
	
	public static void main(String[] args) throws Exception {
		String[] s = {"doc1","1"};
		String[] s2 = {"doc4","1"};
		
		PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1])) {
					return o1[0].compareTo(o2[0]);
				}
				return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
			}
		});
		pq.add(s);
		pq.add(s2);
		System.out.println(s[0].compareTo(s2[0]));
		while(!pq.isEmpty()) {
			String[] x = pq.poll();
			System.out.println(Arrays.toString(x));
		}
	}

}
