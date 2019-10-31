package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_백준_1717_집합의표현_박지홍 {
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (op == 0) { // 합집합
				union(a, b);
			} else { // 같은 집합 여부
				int x = find(a);
				int y = find(b);
				if(x==y) {
					System.out.println("YES");
				} else  {
					System.out.println("NO");
				}
			}
		}
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		} else {
			return parent[x] = find(parent[x]);
		}
	}
	
	public static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		
		if(a != b) {
			parent[b] = parent[a];
		}
	}
}
