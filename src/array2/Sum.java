package array2;

public class Sum {

	private static int sum(int n) { //재귀호출은 무조건 if~else 구문
		if(n==1) return 1;
		return n+sum(n-1);
	}
	
	private static int fac(int n) { //재귀호출은 무조건 if~else 구문
		if(n==1) return 1;
		return n*fac(n-1);
	}
	
	private static int fibo(int n) { //재귀호출은 무조건 if~else 구문
		if(n<2) return n;
		return fibo(n-1) + fibo(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(sum(10));
		System.out.println(fac(10));
		System.out.println(fibo(10));
	}


}
