package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2_박지홍 {
	
	static int M = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] network = new int[N][N];

			for (int i = 0; i < network.length; i++) {
				for (int j = 0; j < network.length; j++) {
					network[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && network[i][j]==0) {
						network[i][j] = M;
					}
				}
			}
			
			for (int k = 0; k < network.length; k++) {
				for (int i = 0; i < network.length; i++) {
					if(i == k) continue;
					for (int j = 0; j < network.length; j++) {
						if(i == j || k == j) continue;
						
						if(network[i][k] != M && network[k][j] != M
								&& network[i][j] > network[i][k] + network[k][j]) {
							network[i][j] = network[i][k] + network[k][j];
						}
					}
				}
			}
			
			int temp = Integer.MAX_VALUE;
			for (int i = 0; i < network.length; i++) {
				int sum = 0;
				for (int j = 0; j < network[i].length; j++) {
					sum += network[i][j];
				}
				if(temp > sum) temp = sum;
			}
			
			System.out.println("#"+testCase+" "+temp);
		}
	}

}
