package com.ssafy;
import java.io.*;
import java.util.*;

public class Main_백준_4195_친구네트워크_서울9반_조경은_ArrayList {
	public static int F;
	public static ArrayList<String[]> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			F = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for(int i=0; i<F; i++) {
				String[] s = br.readLine().split(" ");
				boolean one = false;
				boolean two = false;
				int num1=0;
				int num2=0;
				
				Loop:for(int j=0; j<list.size(); j++) {
					for(int k=0; k<list.get(j).length; k++) {
						if(!one && list.get(j)[k].equals(s[0])) {
							one = true;
							num1 = j;
						}
						if(!two && list.get(j)[k].equals(s[1])) {
							two = true;
							num2=j;
						}
						if(one && two) {
							break Loop;
						}
					}
				}
				if(one && !two) {
					String[] temp = new String[list.get(num1).length+1];
					for(int x=0; x<list.get(num1).length; x++) {
						temp[x] = list.get(num1)[x];
					}
					temp[list.get(num1).length] = s[1];
					list.remove(num1);
					list.add(temp);
					System.out.println(list.get(list.size()-1).length);
				}
				else if(!one && two) {
					String[] temp = new String[list.get(num2).length+1];
					for(int x=0; x<list.get(num2).length; x++) {
						temp[x] = list.get(num2)[x];
					}
					temp[list.get(num2).length] = s[0];
					list.remove(num2);
					list.add(temp);
					System.out.println(list.get(list.size()-1).length);
				}
				else if(one && two) {
					if(num1==num2) {
						System.out.println(list.get(num1).length);
					}
					else {
						String[] temp1 = list.get(num1);
						String[] temp2 = list.get(num2);
						String[] temp = new String[temp1.length+temp2.length];
						
						for(int x=0; x<temp1.length; x++) {
							temp[x] = temp1[x];
						}
						for(int x=0; x<temp2.length; x++) {
							temp[x+temp1.length] = temp2[x];
						}
						if(num1>num2) {
							list.remove(num1);
							list.remove(num2);
						}
						else {
							list.remove(num2);
							list.remove(num1);
						}
						list.add(temp);
						System.out.println(list.get(list.size()-1).length);
					}
				}
				else {
					list.add(new String[] {s[0],s[1]});
					System.out.println(list.get(list.size()-1).length);
				}
			}
		}
	}

}
