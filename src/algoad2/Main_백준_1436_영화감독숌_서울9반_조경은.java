package algoad2;

import java.io.*;

public class Main_백준_1436_영화감독숌_서울9반_조경은 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int index=-1;
		int i=666;
		while(true) {
			int temp = i;
			boolean b = false;
			
			while(temp>0) {
				if (temp % 1000 == 666) {
					b = true;
					break;
				}
				temp /= 10;
			}
			if (b) {
				index++;
				if (index == N-1)
					break;
			}
			i++;
		}
		System.out.println(i);
	}

}
