package com.ssafy;
import java.io.*;
import java.util.*;

public class Main_백준_4195_친구네트워크_서울9반_조경은 {
	public static int F;
	public static ArrayList<String[]> list,name;
	
	public static int getParent(int[] p, int x) {
		if(p[x]==x)
			return x;
		else {
			return p[x] = getParent(p,p[x]);
		}
	}
	
	public static void unionParent(int[] p, int a, int b) {
		a = getParent(p, a);
		b = getParent(p, b);
		if(a<b) 
			p[b] = a;
		else
			p[a] = b;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			F = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			name = new ArrayList<>();
			int index=0;
			for(int i=0; i<F; i++) {
				String[] s = br.readLine().split(" ");
				list.add(new String[] {s[0],s[1]});
				boolean one = false;
				boolean two = false;
				for(int j=0; j<name.size(); j++) {
					if(!one && name.get(j)[0].equals(s[0])) {
						one = true;
					}
					if(!two && name.get(j)[0].equals(s[1])) {
						two = true;
					}
				}
				if(!one) name.add(new String[] {s[0],Integer.toString(++index)});
				if(!two) name.add(new String[] {s[1],Integer.toString(++index)});
			}
			int[] p = new int[name.size()+1];
			for(int i=1; i<=name.size(); i++)
				p[i] = i;
			
			for(int i=0; i<list.size(); i++) {
				int num1=0;
				int num2=0;
				for(int k=0; k<name.size(); k++) {
					if(num1==0 && name.get(k)[0].equals(list.get(i)[0])) {
						num1 = Integer.parseInt(name.get(k)[1]);
					}
					if(num2==0 && name.get(k)[0].equals(list.get(i)[1])) {
						num2 = Integer.parseInt(name.get(k)[1]);
					}
					if(num1!=0 && num2!=0) break;
				}
				unionParent(p,num1, num2);
				 
				int res=0;
				for(int x=1; x<p.length; x++) {
					if(getParent(p, x)==getParent(p, num1)) {
						res++;
					}
				}
				System.out.println(res);
				
			}
		}
	}

}
