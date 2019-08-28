package imtest_0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution_AD_0001_서울9반_김동주
{	
	static int Ans,T,N;
	static int[] ccards, oans, nans,cards;
	static int[] LL,RR,L,R;
	static boolean bo,bn,notsameo, notsamen;
	static int co,min;
	static int xx;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new java.io.FileInputStream("res/input_ad_0001.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++)
		{
			N = Integer.parseInt(br.readLine());
			LL = new int[N/2];
			RR = new int[N/2];
			L = new int[N/2];
			R = new int[N/2];
			ccards = new int[N];
			cards = new int[N];
			oans = new int[N];
			nans = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int n=0; n<N;n++) {
				ccards[n]=Integer.parseInt(st.nextToken());
			}
			for(int n=0; n<N/2;n++) {
				LL[n]=ccards[n];
			}
			for(int n=0; n<N/2;n++) {
				RR[n]=ccards[n+N/2];
			}
			for(int n=0; n<N; n++) {
				oans[n]= ccards[n];
			}
			Arrays.sort(oans);
			for(int n=0; n<N; n++) {
				nans[n]= oans[N-1-n];
			}
			bo=false;
			bn=false;
			min=Integer.MAX_VALUE;
			co=0;
			orum(ccards, LL,RR);

			Ans=0;
			if(!bo && !bn) {Ans = -1;} 
			else Ans=min;
			sb.append("#" + test_case+" "+Ans+"\n"); 
		}
		System.out.println(sb);
		br.close(); 
	}
	private static void orum(int[] cards,int[] L,int[] R) {
		if(co == 6) return;
		notsameo=false;
		notsamen=false;
		for(int n=0; n<N; n++) { 
			if(cards[n]!= oans[n]) notsameo=true;
			if(cards[n]!= nans[n]) notsamen=true;
		}
		if(!notsameo) {
			if(co<min) min=co;
			bo = true;
			return;
		}else if(!notsamen) {
			if(co<min) min=co;
			bn = true;
			return;
		}
		for(int x=0; x<N; x++) {
			if(x<N/2) {
				for(int n=0;n<N/2-x; n++) { 
					cards[n]=L[n];
				}
				for(int n=N/2-x; n<N/2+x; n++) { 
					if((n-(N/2-x))%2==0) cards[n]=R[(n-(N/2-x))/2];
					else cards[n]=L[(n-(N/2-x))/2+(N/2-x)];
				}
				for(int n=N/2+x;n<N; n++) { 
					cards[n]=R[n-N/2];
				}
			}else {
				xx = N-x-1;
				for(int n=0;n<N/2-xx; n++) { 
					cards[n]=R[n];
				}
				for(int n=N/2-xx; n<N/2+xx; n++) {
					if((n-(N/2-xx))%2==0) cards[n]=L[(n-(N/2-xx))/2];
					else cards[n]=R[(n-(N/2-xx))/2+(N/2-xx)]; 
				}
				for(int n=N/2+xx;n<N; n++) { 
					cards[n]=L[n-N/2]; 
				}
			}
			for(int n=0; n<N/2;n++) {
				L[n]=cards[n];
			}
			for(int n=0; n<N/2;n++) {
				R[n]=cards[n+N/2];
			}
			co++;
			orum(cards,L,R);
			co--;
		}
	}
}
