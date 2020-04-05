package line0405;
import java.io.*;
import java.util.*;

public class Main5 {

	public static void main(String[] args) throws Exception {
		String[][] dataSource = {
				{"doc1", "t1", "t2", "t3"},
				{"doc2", "t0", "t2", "t3"},
			    {"doc3", "t1", "t6", "t7"},
			    {"doc4", "t1", "t2", "t4"},
			    {"doc5", "t6", "t100", "t8"}
		};
		String[] tags = {"t1", "t2", "t3"};
		
		
		PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].equals(o2[1])) {
					return o1[0].compareTo(o2[0]);
				}
				return -(Integer.parseInt(o1[1])-Integer.parseInt(o2[1]));
			}
		});
		for(int i=0; i<dataSource.length; i++) {
			int num = 0;
			for(int j=0; j<tags.length; j++) {
				for(int k=1; k<dataSource[i].length; k++) {
					if(dataSource[i][k].equals(tags[j])) {
						num++;
						break;
					}
				}
			}
			if(num>0)
				pq.add(new String[] {dataSource[i][0], num+""});
		}
		
		String[] answer = new String[pq.size()];
		int index=0;
		while(!pq.isEmpty()) {
			String[] s = pq.poll();
			answer[index++] = s[0];
		}
		
        System.out.println(Arrays.toString(answer));
		
	}

}
