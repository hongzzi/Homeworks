package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1494_사랑의카운슬러_박지홍 {
	
	    private static int[] selected;
	    private static int[][] worms;
	    private static long sumX;
	    private static long sumY;
	    private static long min;
	    
	    public static void main(String[] args) throws Exception {
	    	
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine());
	        StringBuilder sb = new StringBuilder();
	        
	        for (int tc = 1; tc <= T; tc++) {
	            int N = Integer.parseInt(br.readLine());
	            worms = new int[N][2];
	            selected = new int[N/2];
	            
	            sumX = 0;
	            sumY = 0;
	            
	            for (int i = 0; i < worms.length; i++) {
	                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	                
	                worms[i][0] = Integer.parseInt(st.nextToken());
	                worms[i][1] = Integer.parseInt(st.nextToken());
	                
	                sumX += worms[i][0];
	                sumY += worms[i][1];
	            }
	            
	            min = Long.MAX_VALUE;
	            comb(N, N/2);
	            
	            sb.append('#').append(tc).append(' ').append(min).append('\n');
	        }    // end of Test case
	        System.out.print(sb);
	    }    // end of main
	    
	    public static void comb(int n, int r) {
	        if(r == 0) {
	            long selSumX = 0;
	            long selSumY = 0;
	            
	            for (int i = 0; i < selected.length; i++) {
	                selSumX += worms[selected[i]][0];
	                selSumY += worms[selected[i]][1];
	            }
	            
	            long vectorX = selSumX - (sumX - selSumX);
	            long vectorY = selSumY - (sumY - selSumY);
	            
	            long vector = vectorX * vectorX + vectorY * vectorY;
	            
	            if(min > vector) min  = vector;
	            
	        } else if(n < r) {    // 오류
	            return;
	        } else {
	            selected[r-1] = n-1;
	            comb(n-1, r-1);
	            comb(n-1, r);
	        }
	    }
}// end of class
