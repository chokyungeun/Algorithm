package a1113;
import java.io.*;
import java.util.*;

public class Main_정올_2097_지하철_서울_9반_조경은_dijkstra {
	public static int N,M,res,INF=987654321;
	public static int[][] g;
	public static ArrayList<Integer> rlist;
	public static boolean[] v;
	public static int[] d,p;
	
	public static int getSmallIndex() {
		int min=987654321;
		int index=0;
		for(int i=0; i<N; i++) {
			if(d[i]<min && !v[i]) {
				min=d[i];
				index=i;
			}
		}
		return index;
	}
	public static void dijkstra1(int start) {
		d[start]=0;
		for(int i=0; i<N; i++) {
			int minNode=INF;
			int minVal=INF;
			for(int j=0; j<N; j++) {
				if(!v[j] && minVal>d[j]) {
					minNode=j;
					minVal=d[j];
				}
			}
			v[minNode]=true;
			for(int j=0; j<N;j ++) {
				if(d[j]>minVal+g[minNode][j]){
					d[j]=minVal+g[minNode][j];
					p[j]=minNode;
				}
			}
		}
	}
	
	public static void dijkstra(int start) {
		d[start]=0;
		for(int i=0; i<N-2; i++) {
			int curr=getSmallIndex();
			v[curr]=true;
			for(int j=0; j<N; j++) {
				if(!v[j]) {
					if(d[j]>d[curr]+g[curr][j]) {
						d[j]=d[curr]+g[curr][j];
						p[j]=curr;
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken())-1;
		g = new int[N][N];
		d=new int[N];
		p=new int[N];
		v=new boolean[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				g[i][j] = Integer.parseInt(st.nextToken());
			}
			d[i]=987654321;
			p[i]=-1;
		}
		dijkstra(0);
		
		System.out.println(d[M]);
		Stack<Integer> path = new Stack<>();
		for(int l=M; l!=-1; l=p[l]) {
			path.push(l+1);
		}
		
	}

}
