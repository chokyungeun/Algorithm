package graph;
import java.util.Arrays;

public class PrimTest {
	/*
	..........[6]
	.....13.....73..12
	[3].28.............[0]
	..24............67.17
	....[1].62.........[4]
	...................20
	...............45....
	..........[5]..37..[2]      
	*/
			
	public static int N=7;
	public static int INF=Integer.MAX_VALUE/2;
	public static int[][] a={
		{  0, 67,INF, 28, 17,INF, 12},
		{ 67,  0,INF, 24, 62,INF,INF},
		{INF,INF,  0,INF, 20, 37,INF},
		{ 28, 24,INF,  0,INF,INF, 13},
		{ 17, 62, 20,INF,  0, 45, 73},
		{INF,INF, 37,INF, 45,  0,INF},
		{ 12,INF,INF, 13, 73,INF,  0},
	};
	public static int[] w;
	
	public static int prim(){
		/*for(int i=0; i<N; i++)
			w[i] = -1;*/
		Arrays.fill(w, -1); //위와 같은 표현
		w[0] = 0;
		for(int k=1; k<N; k++) {
			int minWeight = INF;
			int minVertax=0;
			for(int i=0; i<N; i++) {
				if(w[i]<0)
					continue;
				for(int j=0; j<N; j++) {
					if(w[j]>=0)
						continue;
					if(minWeight>a[i][j]) {
						minWeight=a[i][j];
						minVertax = j;
					}
				}
			}
			w[minVertax] = minWeight;
			System.out.println(Arrays.toString(w));
		}
		
		int sum=0;
		for(int i=0; i<N; i++)
			sum += w[i];
		return sum;
	}
	
	public static void main(String[] args) {
		w=new int[N];
		System.out.println(prim());
	}

}
