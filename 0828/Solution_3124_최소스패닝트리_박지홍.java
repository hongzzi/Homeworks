package algo_지홍;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1251_하나로_박지홍{
    public static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int val;

		public Edge(int a, int b, int val) {
			this.a = a - 1;
			this.b = b - 1;
			this.val = val;
		}

		public String toString() {
			return "[" + a + "," + b + "," + val + "]";
		}

		@Override
		public int compareTo(Edge o) { 
			return this.val - o.val;
		}

	}

	static int[] p; 
	static int[] rank;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			  int V = sc.nextInt();
		      int E = sc.nextInt(); 
		      
		      Edge[] G = new Edge[E];
		      for (int i = 0; i < E; i++) {
		         G[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
		      }
		      Arrays.sort(G); 
		      p = new int[V];  
              rank = new int[V]; 
		      for (int i = 0; i < V; i++) {
		         makeSet(i);
              }
		      long MST = 0; 
		      int cnt = 0;
		      for (int i = 0; i < E; i++) {
		         Edge e = G[i]; 
		         int px = findSet(e.a); 
		         int py = findSet(e.b);
		         if(px!=py) { 
		            union(px,py);
		            MST += e.val;
		            cnt++;
		            if(cnt==V-1) {
		               break;
		            }
		         }
		      }
		      System.out.println("#"+testCase+" "+MST);
		
		}	      
	}
	public static int findSet(int x) {
		if (p[x] == x) { 
			return x;
		} else {
			p[x] = findSet(p[x]);
			return p[x];
		}
	}
	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (px != py) {
			link(px, py);
		}
	}

	public static void link(int px, int py) {
		if (rank[px] > rank[py]) {
			p[py] = px; 
		} else {
			p[px] = p[py];
			if (rank[px] == rank[py])
				rank[py]++;
		}
	}

	public static void makeSet(int x) {
		p[x] = x;
		rank[x] = 0;
	}

} 