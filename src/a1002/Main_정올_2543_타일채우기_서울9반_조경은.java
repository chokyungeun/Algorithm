package a1002;

import java.io.*;
import java.util.*;

public class Main_정올_2543_타일채우기_서울9반_조경은 {
	public static int[][] arr;
	
	public static void tile(int sx, int sy, int ex, int ey, int hx, int hy, int hc)
	{
	    int mx=(sx+ex)/2,my=(sy+ey)/2;
	    if(sx==ex)
	    {
	        arr[sx][sy]=hc;
	        return;
	    }
	    if(hx>=sx&&hx<=mx&&hy>=sy&&hy<=my)
	    {
	    	arr[mx+1][my]=1;
	    	arr[mx][my+1]=1;
	    	arr[mx+1][my+1]=1;
	        tile(sx,sy,mx,my,hx,hy,hc);
	        tile(mx+1,sy,ex,my,mx+1,my,1);
	        tile(sx,my+1,mx,ey,mx,my+1,1);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,1);
	    }
	    else if(hx>=mx+1&&hx<=ex&&hy>=sy&&hy<=my)
	    {
	    	arr[mx][my]=2;
	    	arr[mx+1][my]=2;
	    	arr[mx+1][my+1]=2;
	        tile(sx,sy,mx,my,mx,my,3);
	        tile(mx+1,sy,ex,my,hx,hy,hc);
	        tile(sx,my+1,mx,ey,mx,my+1,3);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,3);
	    }
	    else if(hx>=sx&&hx<=mx&&hy>=my+1&&hy<=ey)
	    {
	    	arr[mx][my]=3;
	    	arr[mx][my+1]=3;
	    	arr[mx+1][my+1]=3;
	        tile(sx,sy,mx,my,mx,my,2);
	        tile(mx+1,sy,ex,my,mx+1,my,2);
	        tile(sx,my+1,mx,ey,hx,hy,hc);
	        tile(mx+1,my+1,ex,ey,mx+1,my+1,2);
	    }
	    else if(hx>=mx+1&&hx<=ex&&hy>=my+1&&hy<=ey)
	    {
	    	arr[mx][my]=4;
	    	arr[mx+1][my]=4;
	        arr[mx][my+1]=4;
	        tile(sx,sy,mx,my,mx,my,4);
	        tile(mx+1,sy,ex,my,mx+1,my,4);
	        tile(sx,my+1,mx,ey,mx,my+1,4);
	        tile(mx+1,my+1,ex,ey,hx,hy,hc);
	    }
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int X = Integer.parseInt(s[0]);
		int Y = Integer.parseInt(s[1]);

		arr = new int[513][513];
		
		tile(1,1,N,N,X+1,Y+1,0);
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
