package a1220;
import java.io.*;
import java.util.*;

public class Solution3_반복문 {
	public static String N,res;
	public static char x, y;
	public static boolean flag;
	
	public static void func2() {
		for(int i=0; i<N.length(); i++) {
			if(flag) {
				if(N.charAt(i)==x) {
					for(int j=0; j<i; j++) {
						System.out.print(N.charAt(j));
					}
					System.out.print(y);
					for(int j=i+1; j<N.length(); j++) {
						System.out.print(x);
					}
					return;
				}
				else if(N.charAt(i)==y) { 
					flag = true;
					if(i-2>=0) {
						i-=2;
						continue;
					}
					else {
						System.out.print(-1);
						return;
					}
					
				}
			}
			
			if(N.charAt(i)!=x && N.charAt(i) !=y) {
				if(N.charAt(i)>x) {
					for(int j=0; j<i; j++) {
						System.out.print(N.charAt(j));
					}
					for(int j=i; j<N.length(); j++) {
						System.out.print(x);
					}
					return;
				}
				else if(N.charAt(i)>y) {
					
					if(i!=0) {
						for(int j=0; j<i; j++) {
							System.out.print(N.charAt(j));
						}
						System.out.print(y);
						for(int j=i+1; j<N.length(); j++) {
							System.out.print(x);
						}
					}
					else {
						System.out.print("-1");
					}
					return;
				}
				else {
					flag = true;
					if(i-2>=0) {
						i-=2;
						continue;
					}
					else {
						System.out.print(-1);
					}
				}
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			N = s[0];
			x = s[1].charAt(0);
			y = s[2].charAt(0);
			char te;
			if (x < y) {
				te = x;
				x = y;
				y = te;
			}
			flag = false;
			System.out.print("#" + t + " " );
			func2();
			System.out.println();
		}

	}

}
