package line0405;
import java.io.*;
import java.util.*;

public class Main1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = br.readLine();
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int res = 0;
		for(int i=0; i<inputString.length(); i++) {
			if(inputString.charAt(i)=='(') {
				one++;
			}
			else if(inputString.charAt(i)=='{') {
				two++;
			}
			else if(inputString.charAt(i)=='[') {
				three++;
			}
			else if(inputString.charAt(i)=='<') {
				four++;
			}
			else if(inputString.charAt(i)==')') {
				if(one==0) {
					res = -1;
					break;
				}
				else {
					one--;
					res++;
				}
			}
			else if(inputString.charAt(i)=='}') {
				if(two==0) {
					res = -1;
					break;
				}
				else {
					two--;
					res++;
				}
			}
			else if(inputString.charAt(i)==']') {
				if(three==0) {
					res = -1;
					break;
				}
				else {
					three--;
					res++;
				}
			}
			else if(inputString.charAt(i)=='>') {
				if(four==0) {
					res = -1;
					break;
				}
				else {
					four--;
					res++;
				}
			}
		}
		System.out.println(res);
	}

}
