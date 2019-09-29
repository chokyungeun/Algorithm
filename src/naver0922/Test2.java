package naver0922;

import java.util.*;
import java.io.*;

public class Test2 {

	public static void main(String[] args) {
		int n = 2;
		long answer = 0;
		
		ArrayList<Long> list = new ArrayList<>();
		
		for(int i=2; i<100; i++) {
			for(int j=1; j<100000; j++) {
				long num = 1;
				for(int k=j; k<j+i; k++) {
					num *= k;
				}
				if(num > 0)
					list.add(num);
			}
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size()-1;) {
			if(list.get(i) == list.get(i+1)) {
				list.remove(i);
			}
			else {
				i++;
			}
		}
		
		
		System.out.println(list);
		System.out.println(list.size());
		
		
		//System.out.println(answer);

	}

}
