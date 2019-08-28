package Solution;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Solution_D4_1218_괄호짝짓기_서울9반_조경은 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1218.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		for(int T=1; T<11; T++) {
			int res = 0;
			int num = sc.nextInt();
			char[] ca = new char[num];
			String s = sc.next();
			ca = s.toCharArray();
			Stack<Character> stack = new Stack<>();
			
			for(int i=0; i<num; i++) {
				if(ca[i] == '(' || ca[i] == '{' || ca[i] == '[' || ca[i] == '<') {
					stack.push(ca[i]);
				}
				else {
					if(ca[i] == ')' && stack.peek() == '(')
						stack.pop();
					else if(ca[i] == '}' && stack.peek() == '{') 
						stack.pop();
					else if(ca[i] == ']' && stack.peek() == '[')
						stack.pop();
					else if(ca[i] == '>' && stack.peek() == '<')
						stack.pop();
					else {
						res = 0;
						break;
					}
				}
			}
			if(stack.empty()) {
				res = 1;
			}
			System.out.println("#" + T + " " + res);
		}

	}

}
