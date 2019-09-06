package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_정올_1863_종교_박지홍 {
	
	static int[] p;
	static int[] rank;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		p = new int[N+1];
		rank = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}	// 집합 만들기
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		for (int i = 1; i < p.length; i++) {
			p[i] = findSet(p[i]);
			set.add(p[i]);
		}
		System.out.println(set.size());
	}
	
	public static void makeSet(int x) {
		p[x] = x;
		rank[x] = 0;
	}
	
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		
		if(px != py) {
			link(px, py);
		}
	}
	
	public static int findSet(int x) {
		if(p[x] == x) {
			return x;
		} else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}

	public static void link(int px, int py) {
		if(rank[px] > rank[py]) {
			p[py] = px;
		} else {
			p[px] = py;
			if(rank[px] == rank[py])
				rank[py]++;
		}
	}

	
}
