package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1258_행렬찾기_박지홍 {

	static class Matrix {
		int rowSize;
		int colSize;
		int size;
	}

	static int N;
	static boolean[][] map;
	static List<Matrix> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {

			N = Integer.parseInt(br.readLine());
			map = new boolean[N][N];
			
			// 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int a = Integer.parseInt(st.nextToken());
					map[i][j] = a > 0 ? true : false;
				}
			}
			
			list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j]) {
						research(i, j);
					}
				}
			}
			
			Collections.sort(list, new Comparator<Matrix>() {
				@Override
				public int compare(Matrix o1, Matrix o2) {
					if(o1.size == o2.size) {
						return o1.rowSize - o2.rowSize;
					}
					return o1.size - o2.size;
				}
			});
			
			System.out.print("#"+testCase+" "+list.size()+" ");
			for (Matrix mat : list) {
				System.out.print(mat.rowSize+" ");
				System.out.print(mat.colSize+" ");
			}
			System.out.println();
		}
	}

	private static void research(int r, int c) {
		int rei = r, cei = c;
		// 가로 찾기
		for (int i = c; i < map.length; i++) {
			if (!map[r][i]) {
				break;
			} else {
				map[r][i] = false;
			}
			cei = i;
		}

		boolean flag = false;
		// 세로 찾기
		for (int i = r+1; i < map.length; i++) {
			for (int j = c; j <= cei; j++) {
				if(!map[i][j]) {
					flag = true;
					break;
				}
			}
			if(flag) {
				break;
			}
			for (int j = c; j <= cei; j++) {
				map[i][j] = false;
			}
			rei = i;
		}
		Matrix mt = new Matrix();
		mt.rowSize = rei - r + 1;
		mt.colSize = cei - c + 1;
		mt.size = mt.rowSize * mt.colSize;
		list.add(mt);
	}

}
