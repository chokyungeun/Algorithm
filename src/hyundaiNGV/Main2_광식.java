package hyundaiNGV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main2_광식 {
   static int n, m;
   static ArrayList<Integer>[] child;

   static void dfs(int i) {
      if (child[i].size() == 0)
         return;
      for (int j = 0; j < child[i].size(); j++) {
         int childNum = child[i].get(j);
         child[i].addAll(child[childNum]);
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      n = Integer.parseInt(st.nextToken());
      m = Integer.parseInt(st.nextToken());

      child = new ArrayList[n + 1];
      for (int i = 1; i < child.length; i++) {
         child[i] = new ArrayList<>();
      }
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= n; i++) {
         int parent = Integer.parseInt(st.nextToken());
         if (parent == 0)
            continue;
         child[parent].add(i);
      }

      for (int i = 1; i <= n; i++) {
         if (child[i].size() > 0) {
            dfs(i);
         }
      }
      int sum = 0;
      TreeSet<Integer> setA;
      TreeSet<Integer> setB;
      for (int i = 0; i < m; i++) {
         st = new StringTokenizer(br.readLine());
         int a = Integer.parseInt(st.nextToken());
         int b = Integer.parseInt(st.nextToken());
         setA = new TreeSet<>(child[a]);
         setB = new TreeSet<>(child[b]);
         sum += setA.size() - setB.size();
      }
      System.out.println(sum);
      br.close();
      System.exit(0);
   }

}