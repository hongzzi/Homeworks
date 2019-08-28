import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_프로세서연결{

	public static class Core {

		int x;
		int y;
		int cnt;
		boolean 상;
		boolean 하;
		boolean 좌;
		boolean 우;

		public Core(int x, int y, boolean 상, boolean 하, boolean 좌, boolean 우,int cnt) {
			this.x = x;
			this.y = y;
			this.상 = 상;
			this.하 = 하;
			this.좌 = 좌;
			this.우 = 우;
			this.cnt = cnt;
		}
	}

	static List<Core> list = null;
	static int[][] map;
	static int maxCore, minLine;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {

			int N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			maxCore = 0;
			list = new ArrayList<>();

			// 입력
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			// 코어 있는곳 받아오기
			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map.length; k++) {
					if (map[j][k] == 1) {
						if (j == 0 || k == 0 || j == map.length - 1 || k == map.length - 1) {
							maxCore++; // 가장자리에 있는건 자동으로 붙는다고 본다
							continue;
						} else {
							checkDir(j, k); // 코어에서 전선 뻗어나갈수있는 경우 저장
						}
					}
				}
			}

			int[][] copy = copyMap(map);

			minLine = Integer.MAX_VALUE;
			Collections.sort(list, new Comparator<Core>() {
				@Override
				public int compare(Core o1, Core o2) {
					return o1.cnt-o2.cnt;
				}
			});
			checkMax(copy, 0, maxCore, 0);

			System.out.println("#" + i + " " + minLine);
		}
	}

	public static int[][] copyMap(int[][] arr) {
		int[][] result = new int[arr.length][arr.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = arr[i][j];
			}
		}
		return result;
	}

	public static void checkMax(int[][] copy, int index, int tmpMax, int line) {
		
		if (index == list.size()) {
			
			if (maxCore == tmpMax) {
				if (line <= minLine) {
					minLine = line;
				}
				maxCore = tmpMax;
			} else if (maxCore < tmpMax) {
				maxCore = tmpMax;
				minLine = line;
			}
			
		} else {
			
			Core core = list.get(index);
			
			int[][] arr;
			int max;
			int l;
			
			if (core.상) {
				boolean flag = true;
				for (int i = 0; i < core.x; i++) {
					if (copy[i][core.y] == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					arr = copyMap(copy);
					max = tmpMax;
					l = line;
					for (int i = 0; i < core.x; i++) {
						arr[i][core.y] = 1;
					}
					l = l + core.x;
					max++;
					checkMax(arr, index + 1, max, l);
				}
			}

			if (core.하) {
				boolean flag = true;
				for (int i = core.x + 1; i < copy.length; i++) {
					if (copy[i][core.y] == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					arr = copyMap(copy);
					max = tmpMax;
					l = line;

					for (int i = core.x + 1; i < arr.length; i++) {
						arr[i][core.y] = 1;
					}
					l = l + arr.length - (core.x + 1);
					max++;
					checkMax(arr, index + 1, max, l);
				}
			}

			if (core.좌) {
				boolean flag = true;
				for (int i = 0; i < core.y; i++) {
					if (copy[core.x][i] == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					arr = copyMap(copy);
					max = tmpMax;
					l = line;
					for (int i = 0; i < core.y; i++) {
						arr[core.x][i] = 1;
					}
					l = l + core.y;
					max++;
					checkMax(arr, index + 1, max, l);
				}
			}

			if (core.우) {
				boolean flag = true;
				for (int i = core.y + 1; i < copy.length; i++) {
					if (copy[core.x][i] == 1) {
						flag = false;
						break;
					}
				}
				if (flag) {
					arr = copyMap(copy);
					max = tmpMax;
					l = line;
					for (int i = core.y + 1; i < arr.length; i++) {
						arr[core.x][i] = 1;
					}
					l = l + arr.length - (core.y + 1);
					max++;
					checkMax(arr, index + 1, max, l);
				}
			}
			
			checkMax(copy, index + 1, tmpMax, line);
		}

	}

	public static void checkDir(int j, int k) {

		boolean 상 = true;
		boolean 하 = true;
		boolean 좌 = true;
		boolean 우 = true;
		int cnt = 4;
		
		for (int i = 0; i < j; i++) {
			if (map[i][k] == 1) {
				상 = false;
				cnt--;
				break;
			}
		}
		for (int i = j + 1; i < map.length; i++) {
			if (map[i][k] == 1) {
				하 = false;
				cnt--;
				break;
			}
		}
		for (int i = 0; i < k; i++) {
			if (map[j][i] == 1) {
				좌 = false;
				cnt--;
				break;
			}
		}
		for (int i = k + 1; i < map.length; i++) {
			if (map[j][i] == 1) {
				우 = false;
				cnt--;
				break;
			}
		}

		if (상 || 하 || 좌 || 우) {
			list.add(new Core(j, k, 상, 하, 좌, 우, cnt));
		}
	}
}
