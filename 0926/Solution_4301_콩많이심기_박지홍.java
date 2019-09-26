package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4301_콩많이심기_박지홍 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt = 0;
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(((i/2)%2==0 && (j/2)%2==0) || ((i/2)%2==1 && (j/2)%2==1)) {
						cnt++;
					}
				}
			}
			System.out.println("#"+testCase+" "+cnt);
		}
	}
}
