package line0405;

import java.io.*;
import java.util.*;

public class Main4 {

	public static void main(String[] args) throws Exception {
		String[][] snapshots = { { "ACCOUNT1", "100" }, { "ACCOUNT2", "150" } };
		String[][] transactions = { { "1", "SAVE", "ACCOUNT2", "100" }, { "2", "WITHDRAW", "ACCOUNT1", "50" },
				{ "1", "SAVE", "ACCOUNT2", "100" }, { "4", "SAVE", "ACCOUNT3", "500" },
				{ "3", "WITHDRAW", "ACCOUNT2", "30" } };

		
		ArrayList<String[]> list = new ArrayList<>();
		ArrayList<String[]> ss = new ArrayList<>();
		
		for(int i=0; i<snapshots.length; i++) {
			ss.add(snapshots[i]);
		}
		for (int i = 0; i < transactions.length; i++) {
			for (int j = i + 1; j < transactions.length; j++) {
				if (transactions[i][0].equals(transactions[j][0])) {
					transactions[j][0]="X";
				}
			}
		}
		
		for (int i = 0; i < transactions.length; i++) {
			if(!transactions[i][0].equals("X")) {
				list.add(transactions[i]);
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			String account = list.get(i)[2];
			boolean flag = false;
			for(int j=0; j<ss.size(); j++) {
				if(account.equals(ss.get(j)[0])) {
					if(list.get(i)[1].equals("SAVE")) {
						ss.get(j)[1] = (Integer.parseInt(ss.get(j)[1])+Integer.parseInt(list.get(i)[3]))+"";
					}
					else {
						ss.get(j)[1] = (Integer.parseInt(ss.get(j)[1])-Integer.parseInt(list.get(i)[3]))+"";
					}
					flag = true;
					break;
				}
			}
			if(!flag) {
				ss.add(new String[] {account, list.get(i)[3]});
			}
		}
		PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return o1[0].compareTo(o2[0]);
			}
		});
		for(int i=0; i<ss.size(); i++) {
			pq.add(ss.get(i));
		}
		
		String[][] answer = new String[pq.size()][2];
		int index=0;
		while(!pq.isEmpty()) {
			String[] s = pq.poll();
			for(int j=0; j<s.length; j++) {
				answer[index][j] = s[j];
			}
			index++;
		}
		
		System.out.println(Arrays.deepToString(answer));
	}

}
