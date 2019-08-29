package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1251_하나로_박지홍  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            int V = Integer.parseInt(br.readLine());
             
            int[][] ads = new int[V][2];
             
            st = new StringTokenizer(br.readLine());
             
            int idx = 0;
             
            while(st.hasMoreTokens()) {
                ads[idx++][1] = Integer.parseInt(st.nextToken());
            }
             
            st = new StringTokenizer(br.readLine());
             
            idx = 0;
            while (st.hasMoreTokens()) {
                ads[idx++][0] = Integer.parseInt(st.nextToken());
            }
         
            long[][] G = new long[V][V];
             
            double e = Double.parseDouble(br.readLine());
 
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < ads.length; j++) {
                    long val = (long)(ads[i][1] - ads[j][1]) * (ads[i][1] - ads[j][1])
                            + (long)(ads[i][0] - ads[j][0]) * (ads[i][0] - ads[j][0]); 
                    G[i][j] = val;
                    G[j][i] = val; 
                }
            }
             
            int[] p = new int[G.length];
            long[] val = new long[G.length];
             
             
            boolean[] selected = new boolean[V];
             
            int r = 0; 
             
            for (int i = 0; i < selected.length; i++) {
                if(G[r][i] > 0) {
                    val[i]=G[r][i];
                    p[i] = r;
                }else {
                    val[i] = Long.MAX_VALUE;
                }
            }
            val[r] = 0; 
            p[r]=r; 
            selected[r] = true;
             
            for (int i = 1; i < V; i++) {
                int minIndex = -1;  
                long min = Long.MAX_VALUE; 
                 
                for (int j = 0; j < val.length; j++) {
                    if(!selected[j] && min > val[j]) {
                        min = val[j];
                        minIndex = j;
                    }
                }
                 
                r = minIndex;
                selected[r] = true;
                 
                for (int j = 0; j < G[r].length; j++) {
                    if(!selected[j] && G[r][j]!=0 && val[j] > G[r][j]) {
                        val[j]=G[r][j];
                        p[j] = r;
                    }
                }
            }
             
            double MST = 0;
            for (int i = 0; i < val.length; i++) {
                MST += val[i];
            }
             
            MST *= e;
            System.out.println("#"+t+" "+ Math.round(MST));
        }
    }
}
