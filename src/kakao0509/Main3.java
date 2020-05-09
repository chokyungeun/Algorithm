package kakao0509;
import java.io.*;
import java.util.*;

public class Main3 {
	public static String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
	public static int[] answer;
	
	public static void main(String[] args) throws Exception {
		answer = new int[2];
		HashMap<String, Integer> g = new HashMap<>();
		int index = 0;
		for(int i=0; i<gems.length; i++) {
			g.put(gems[i],index++);
		}
		if(g.size()==1) {
			answer[0]=1;
			answer[1] = 1;
		}
		else {
			Loop: for(int j=g.size(); j<=gems.length; j++) {
				for(int i=0; i<=gems.length-j; i++) {
					HashMap<String, Integer> temp = new HashMap<>();
					int idx = 0;
					for(int k=i; k<j+i; k++) {
						temp.put(gems[k],idx++);
					}
					System.out.println(j + " " + temp);
					if(temp.size()==g.size()) {
						answer[0] = i+1;
						answer[1] = i+j;
						break Loop;
					}
				}
			}
			
		}
		System.out.println(g.size());
		System.out.println(Arrays.toString(answer));
	}

}
