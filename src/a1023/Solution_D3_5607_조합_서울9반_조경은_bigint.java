package a1023;

import java.io.*;
import java.math.BigInteger;

//Fermat Little Theorem
//a^p=a(mod p)
//a^(p-1)=1
//a^(p-2)=1/a

//5C2%7 -> 5!/(3!*2!)%7
//		-> 5!*6^5*2^5%7
//		-> (5!%7)*(6^5%7)*(2^5%7)
//		-> (5*4*3*2*1%7)*(6^5%7)*(2^5%7)
//		-> (5*2*1%7)*(3*2)(6^5%7)*2(2^5%7)
//		-> (10%7)*(6^6%7)*(2^5%7)
//		-> 3%7*1%7*1%7
//		-> 3%7


public class Solution_D3_5607_조합_서울9반_조경은_bigint {
	public static int P=1234567891;
	
	public static long power(long x, long y, long p) {
		long r=1L;
		x=x%p;
		// ^7 7승이면 7번 곱해야하는데 연산횟수 줄이는 방법
		//=> 3^7 > 7 3 1	3^7 --> 3^1*3^2*3^4
		while(y>0) {
			if(y%2==1) r=(r*x)%p;
			y=y>>1; //y=y/2;
			x=(x*x)%p;
		}
		return r;
		
	}
	
	public static BigInteger nCr(int n, int r, int p) {
		long[] fac=new long[n+1];
		fac[0]=1;
		for(int i=1; i<=n; i++)
			fac[i]=fac[i-1]*i%p;
		//remainder : 모듈연산
		BigInteger P=BigInteger.valueOf(p);
		BigInteger A=BigInteger.valueOf(fac[n]);
		BigInteger B=BigInteger.valueOf(fac[r]).modInverse(P).remainder(P);
		BigInteger C=BigInteger.valueOf(fac[n-r]).modInverse(P).remainder(P);
		return A.multiply(B).multiply(C).remainder(P);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int R = Integer.parseInt(s[1]);
			
			System.out.println("#" + t + " " +nCr(N,R,P));
		}
		
	}
	
}
