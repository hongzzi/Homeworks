package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드_박지홍 {

	static class Car {
		int x;
		int y;
		int dir;

		public Car() {
		}
	}

	static String[][] map;
	static Car car = null;
	static int[]dirx = { -1, 0, 1, 0};
	static int[]diry = { 0, 1, 0, -1};
	static String[] crr = {"^",">","v","<"};
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			map = new String[H][W];
			car = new Car();
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < str.length(); j++) {
					String s = String.valueOf(str.charAt(j));
					map[i][j] = s;
					if (s.equals("<")) {
						car.x = i;
						car.y = j;
						car.dir = 3;
					} else if (s.equals(">")) {
						car.x = i;
						car.y = j;
						car.dir = 1;
					} else if (s.equals("^")) {
						car.x = i;
						car.y = j;
						car.dir = 0;
					} else if (s.equals("v")) {
						car.x = i;
						car.y = j;
						car.dir = 2;
					}
				}
			}

			int N = Integer.parseInt(br.readLine().trim());
			String command = br.readLine();

			for (int i = 0; i < command.length(); i++) {
				char c = command.charAt(i);
				move(c);

			}
			
			System.out.print("#"+testCase+" ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void move(char c) {
		switch (c) {
		case 'U' : {
			take(0);
			break;
		}
		case 'D' : {
			take(2);
			break;
		}
		case 'L' : {
			take(3);
			break;
		}
		case 'R' : {
			take(1);
			break;
		}
		case 'S' : {
			broken();
			break;
		}
		}
	}

	static void broken() {
		int x = car.x;
		int y = car.y;
		int dir = car.dir;
		if (dir == 0) {
			for (int i = x-1; i >= 0; i--) {
				if(map[i][y].equals("#")) {
					break;
				} else if(map[i][y].equals("*")) {
					map[i][y] = ".";
					break;
				}
			}
		} else if(dir == 1) {
			for (int i = y+1; i < map[x].length; i++) {
				if(map[x][i].equals("#")) {
					break;
				} else if(map[x][i].equals("*")) {
					map[x][i] = ".";
					break;
				} 
			}
		} else if(dir == 2) {
			for (int i = x+1; i < map.length; i++) {
				if(map[i][y].equals("#")) {
					break;
				} else if(map[i][y].equals("*")) {
					map[i][y] = ".";
					break;
				}
			}
		} else {
			for (int i = y-1; i >= 0; i--) {
				if(map[x][i].equals("#")) {
					break;
				} else if(map[x][i].equals("*")) {
					map[x][i] = ".";
					break;
				}
			}
		}
	}

	static void take(int dir) {
		car.dir = dir;
		int nx = car.x+dirx[dir];
		int ny = car.y+diry[dir];
		map[car.x][car.y] = crr[dir];
		if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[nx].length) {
			if(map[nx][ny].equals(".")) {
				map[car.x][car.y] = ".";
				car.x = nx;
				car.y = ny;
				map[nx][ny] = crr[dir];
			}
		}
	}
}
