import java.io.*;
import java.util.*;

public class Main_로봇청소기 {

	static int n, m, r, c, dir;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int count = 0;

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 초기값 입력
		st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		map = new int[n][m];

		st = new StringTokenizer(br.readLine());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		dir = stoi(st.nextToken());

		// 맵 초기값 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}

		solution();
	}

	static void solution() {

		// 청소기 가동
		while (true) {

			// 네방향 확인 끝냈을 때
			if (count == 4) {
				int backX = r - dx[dir];
				int backY = c - dy[dir];

				// 벽이면 종료
				if (map[backX][backY] == 1) {
					System.out.println(getCleanArea());
					return;
				}
				// 아니면 후진
				else
					setRobot(backX, backY, dir, 0);

			}

			// 현재 위치 청소
			if (map[r][c] == 0)
				map[r][c] = 2;

			int ld = (dir+3)%4;
			int nx = r + dx[ld];
			int ny = c + dy[ld];

			if (map[nx][ny] == 0)
				setRobot(nx, ny, ld, 0);
			else
				setRobot(r, c, ld, count + 1);

		}
	}

	static void setRobot(int nextX, int nextY, int nextD, int nextCount) {

		r = nextX;
		c = nextY;
		dir = nextD;
		count = nextCount;

	}

	static int getCleanArea() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					result++;
				}
			}
		}
		return result;
	}
}
