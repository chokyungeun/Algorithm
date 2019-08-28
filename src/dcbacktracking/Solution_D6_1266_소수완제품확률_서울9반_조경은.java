package dcbacktracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_D6_1266_소수완제품확률_서울9반_조경은 {
	public static double nCr(int n, int r) {
		if(n<r) return 0.0;
		if(r==0) return 1.0;
		return nCr(n-1, r-1) + nCr(n-1, r);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_D6_1266.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<T+1; t++) {
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			double dA = A*0.01;
			double dB = B*0.01;
			//2 3 5 7 11 13 17
			
			double[] a = new double[12];
			double[] b = new double[12];
			for(int i=0; i<12; i++)
				a[i] = 1;
			for(int i=0; i<12; i++)
				b[i] = 1;
			double ra = 0;
			double rb = 0;
			int num = 0;
			for(int i=0; i<19; i++) {
				if(i==0 ||i==1 || i==4 || i==6 || i==8 || i==9 || i==10 || i==12 || i==14 ||i==15 || i==16 || i==18) {
					for(int j=0; j<i; j++) {
						a[num]*=dA;
					}
					for(int j=0; j<18-i; j++) {
						a[num]*=(1-dA);
					}
					ra += nCr(18,i)*a[num];
					num++;
				}
			}
			num = 0;
			for(int i=0; i<19; i++) {
				if(i==0 ||i==1 || i==4 || i==6 || i==8 || i==9 || i==10 || i==12 || i==14 ||i==15 || i==16 || i==18) {
					for(int j=0; j<i; j++) {
						b[num]*=dB;
					}
					for(int j=0; j<18-i; j++) {
						b[num]*=(1-dB);
					}
					rb += nCr(18,i)*b[num];
					num++;
				}
			}
			
			System.out.printf("#%d %.6f\n", t, 1-(ra*rb));
		}
		
	}

}
