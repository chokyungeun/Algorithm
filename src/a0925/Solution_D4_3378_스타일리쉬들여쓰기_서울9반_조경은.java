package a0925;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution_D4_3378_스타일리쉬들여쓰기_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_3378.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			int p = Integer.parseInt(s[0]);
			int q = Integer.parseInt(s[1]);
			String[] pcode = new String[p];
			String[] qcode = new String[q];
			
			for(int i=0; i<p; i++) {
				pcode[i] = br.readLine();
			}
			for(int i=0; i<q; i++) {
				qcode[i] = br.readLine();
			}
			
			int R=0;
			int C=0; 
			int S=0;
			int a=0;
			int b=0;
			int c=0;
			int d=0;
			int e=0;
			int f=0;
			
			for(int i=0; i<p; i++) {
				char[] ch = pcode[i].toCharArray();
				int dot=0;
				int tf = 0;
				for(int j=0; j<ch.length; j++) {
					if(ch[j] == ')') {
						a++;
						tf = 2;
					}
					else if(ch[j] == ')') {
						b++;
						tf = 2;
					}
					else if(ch[j] == '{') {
						c++;
						tf = 2;
					}
					else if(ch[j] == '}') {
						d++;
						tf = 2;
					}
					else if(ch[j] == '[') {
						e++;
						tf = 2;
					}
					else if(ch[j] == ']') {
						f++;
						tf = 2;
					}
					else if(ch[j] == '.' && tf==0) {
						dot++;
					}
					else {
						tf = 2;
					}
				}
				
				if(dot != 0) {
					if(c-d == 0 && e-f==0) {
						R = dot/(a-b);
					}
					else if(a-b == 0 && c-d == 0) {
						S = dot/(e-f);
					}
					else if(a-b == 0 && e-f == 0) {
						C = dot/(c-d);
					}
					if(a-b == 0) {
						if(C!=0) {
							if(e-f !=0)
								S = (dot-(C*(c-d)))/(e-f);
						}
						else if(S!=0) {
							if(c-d !=0)
								C = (dot-(S*(e-f)))/(c-d);
						}
					}
					if(c-d == 0) {
						if(R!=0) {
							if(e-f !=0)
								S = (dot-(R*(a-b)))/(e-f);
						}
						else if(S!=0) {
							if(c-d !=0)
								C = (dot-(S*(e-f)))/(c-d);
						}
					}
					if(e-f == 0) {
						if(R!=0) {
							if(c-d !=0)
								C = (dot-(R*(a-b)))/(c-d);
						}
						else if(C!=0) {
							if(a-b !=0)
								R = (dot-(C*(c-d)))/(a-b);
						}
					}
					
					if(R!=0 && C!=0) {
						S = (dot-((R*(a-b)) + (C*(c-d))))/(e-f);
					}
					else if(R!=0 && S!=0) {
						C = (dot-((R*(a-b)) + (S*(e-f))))/(c-d);
					}
					else if(C!=0 && S!=0) {
						R = (dot-((S*(e-f)) + (C*(c-d))))/(a-b);
					}
					
				}
				
			}
			
			System.out.println(R + " " + C +  " " + S);
			for(int i=0; i<q; i++) {
				char[] ch = qcode[i].toCharArray();
				for(int j=0; j<ch.length; j++) {
					
				}
			}
			
			
			
			
			
			
			
			
			
			
			
		}

	}

}
