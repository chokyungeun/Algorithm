package a0829;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Solution_D4_4408_자기방으로돌아가기_서울9반_조경은 {
    static class Room implements Comparable<Room>{
        int start, end;
        public Room(int start, int end) {
            if(start > end) {
                this.start = end;
                this.end = start;
            }else {
                this.start = start;
                this.end = end;
            }
        }
        @Override
        public int compareTo(Room o) {
            return this.start - o.start;
        }
    }
    public static void main(String[] args) throws Exception{
    	System.setIn(new FileInputStream("res/input_d4_4409_2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine().trim());
        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            int res = 0;
            ArrayList<Room> list = new ArrayList<>();
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                if(start%2 == 0) start -= 1;
                if(end%2 == 0) end -= 1;
                list.add(new Room(start,end));
            }
             
            Collections.sort(list);
             
            while(!list.isEmpty()) {
                Room temp = list.get(0);
                list.remove(temp);
                for(int i=0; i<list.size(); i++) {
                    Room temp2 = list.get(i);
                    if(temp2.start <= temp.end) 
                    	continue;
                    temp = temp2;
                    list.remove(temp2);
                    i--;
                }
                res++;
            }
            System.out.println("#"+t+" "+ res);
        }
    }
}