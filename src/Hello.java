import java.math.BigInteger;

public class Hello {
	
	public static double nCr(int n, int r) {
		if(n<r) return 0.0;
		if(r==0) return 1.0;
		return nCr(n-1, r-1) + nCr(n-1, r);
	}
	
	/*public static double nCr(int n, int r) {
		if(r==0) return 1.0;
		return 1.0*n/r*nCr(n-1, r-1);
	}*/
	public static void main(String[] args) {
		System.out.println(nCr(5,3));
		double d = 1.123456789;
		int tc = 1;
		System.out.println(d);
		System.out.printf("%f\n",d);
		System.out.printf("%.6f\n",d);
		System.out.printf("%.4f\n",d);
		System.out.printf("%.3f\n",d);
		System.out.printf("#%d %.3f\n", tc, d);
		/*//long l = 111111111111111111111111111L;
		String s = "111111111111111111111111111";
		BigInteger i1 = new BigInteger(s);
		BigInteger i2 = i1.add(BigInteger.valueOf(3));
		BigInteger i3 = i1.subtract(BigInteger.ONE);
		BigInteger i4 = i1.multiply(BigInteger.TEN);
		BigInteger i5 = i1.divide(BigInteger.valueOf(2));
		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);
		System.out.println(i4);
		System.out.println(i5);*/
		
		
		
		/*String s = "11";
		System.out.println(Integer.parseInt(s));
		System.out.println(Integer.parseInt(s, 2));
		System.out.println(Integer.parseInt(s, 8));
		System.out.println(Integer.parseInt(s, 10));
		System.out.println(Integer.parseInt(s, 16));
		

		int i=17;
		System.out.println("0b" + Integer.toBinaryString(i));
		System.out.println("0" + Integer.toOctalString(i));
		System.out.println("0x" + Integer.toHexString(i));
		System.out.println(Integer.toString(i, 7));*/
	}

}
