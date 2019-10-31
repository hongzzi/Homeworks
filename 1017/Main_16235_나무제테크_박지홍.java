package com.acm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16235_나무제테크_박지홍 {
	static class Tree {
		int x;
		int y;
		int age;
		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	// 밭 크기
		int M = Integer.parseInt(st.nextToken());	// 나무 수
		int K = Integer.parseInt(st.nextToken());	// K년 후

		int[] dirx = {1, -1, 0, 0, 1, 1, -1, -1};
		int[] diry = {0, 0, 1, -1, 1, -1, 1, -1 };
		
		int[][] map = new int[N][N];	// 밭
		int[][] A = new int[N][N];		// 겨울에 더해줄 양분 정보
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 5;
			}
		}	// 초기 양분값
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}	// 겨울에 뿌릴 양분 정보
		
		List<Tree> trees = new ArrayList<>();
		List<Integer> die = new ArrayList<>();
		List<Integer> seed = new ArrayList<>();
		List<Tree> alive =new ArrayList<>();
		List<Tree> newtree = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			trees.add(new Tree(a-1, b-1, age));
		}
		
		for (int years = 0; years < K; years++) {	// K년 만큼 제태크를 한다.
			//봄			
			for (int j = 0; j < trees.size(); j++) { // 나이 적은 나무가 나이순으로 양분을 먹고 나이 1 증가
				Tree t = trees.get(j);
				if(t.age <= map[t.x][t.y]) {// 양분 먹음
					map[t.x][t.y] -= t.age;
					t.age += 1;
					if (t.age > 4 && t.age%5 == 0) {
						seed.add(j);
					}
					alive.add(t);
				}
			} // end of increase
			// end of spring
			
			//여름
			for (int i = 0; i < die.size(); i++) {
				int index = die.get(i);	// 나무의 리스트중 죽을 나무의 리스트 인덱스
				Tree dtree = trees.get(index);
				map[dtree.x][dtree.y] += dtree.age / 2;
			}	// end of summer

			
			//가을
			for (int i = 0; i < seed.size(); i++) {
				Tree stree = trees.get(seed.get(i));
				for (int j = 0; j < 8; j++) {
					int nx = stree.x + dirx[j];
					int ny = stree.y + diry[j];
					if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length ) {
						newtree.add(new Tree(nx, ny, 1));
					}
				}
			}	// end of autumn
			
			//겨울
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					map[i][j] += A[i][j];
				}
			}
			
			for (int i = 0; i < alive.size(); i++) {
				newtree.add(alive.get(i));
			}
			
			trees.clear();
			trees.addAll(newtree);
			seed.clear();
			die.clear();
			alive.clear();
			newtree.clear();
		}
		
		System.out.println(trees.size());
	}
}
