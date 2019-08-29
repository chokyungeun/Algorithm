package solution;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_D3_1230_암호문3_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_1230.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int T=1; T<11; T++) {
			String x = sc.nextLine();
			int N = Integer.parseInt(x);
			ArrayList<String> list = new ArrayList<>(); 
			String s = sc.nextLine();
			String[] s1 = s.split(" ");
			
			for(int i=0; i<s1.length; i++) {
				list.add(s1[i]);
			}
			String y = sc.nextLine();
			//int M = Integer.parseInt(y);
			String s2 = sc.nextLine();
			
			String[] cmd = s2.split(" ");
			for(int i=0; i<cmd.length; i++) {
				
				if(cmd[i].equals("I")) {
					int xi = Integer.parseInt(cmd[++i]);
					int yi = Integer.parseInt(cmd[++i]);
					
					for(int j=0; j<yi; j++) {
						list.add(++xi, cmd[++i]);
						
					}
				}
				else if(cmd[i].equals("D")) {
					int xi = Integer.parseInt(cmd[++i]);
					int yi = Integer.parseInt(cmd[++i]);
					
					for(int j=0; j<yi; j++) {
						list.remove(xi+1);
					}
					
				}
				else if(cmd[i].equals("A")) {
					int xi = Integer.parseInt(cmd[++i]);
					for(int j=0; j<xi; j++) {
						list.add(cmd[++i]);
					}
				}
			}
			ArrayList<String> list2 = new ArrayList<>();
			for(int i=1; i<11; i++) {
				list2.add(list.get(i));
			}
			System.out.print("#" + T + " ");
			for(int i=0; i<10; i++) {
				System.out.print(list2.get(i) + " ");
			}
			System.out.println();
		}
	}

}
