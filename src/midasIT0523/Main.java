package midasIT0523;
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		String[] strs = {"abcdefkjkjkjnj","ab","afefg"};
		
		String answer = "";
		String s = "";
		int index = 0;
		Loop: for(int j=1; j<=strs[0].length(); j++) {
			index = j;
			s=strs[0].substring(0,j);
			for(int i=1; i<strs.length; i++) {
				if(strs[i].length()<j) {
					index = j-1;
					break Loop;
				}
				String st = strs[i].substring(0, j);
				if(!s.equals(st)) {
					index = j-1;
					break Loop;
				}
			}
		}
		answer = strs[0].substring(0,index);
		System.out.println(answer);
	}

}
