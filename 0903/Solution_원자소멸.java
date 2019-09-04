import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_원자소멸 {

	static class Atom {
		int y;
		int x;
		int dir;
		int e;
		int sec = 0;
		boolean explo = false;
	}
	static Queue<Atom> que = new LinkedList<>();
	static int energy;
	static Atom[][][] map = new Atom[2002][2002][2];
	static int[] diry = {1,-1,0,0};
	static int[] dirx = {0,0,-1,1};
 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int energy = 0;
			int N =Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				Atom atom = new Atom();
				atom.y = Integer.parseInt(st.nextToken()) + 1000;
				atom.x = Integer.parseInt(st.nextToken()) + 1000;
				atom.dir = Integer.parseInt(st.nextToken());
				atom.e = Integer.parseInt(st.nextToken());
				map[atom.y][atom.x][0] = atom;
				que.add(atom);
			}	// input 끝
			
			while(que.size() > 0) {	// 부딪히는건 두개이상이어야하니까는
				Atom a1 = que.poll();
				int b = a1.sec%2;
				map[a1.y][a1.x][b] = null;
				if(a1.explo) {
					energy += a1.e;
					continue;
				}
				int ny = a1.y+dirx[a1.dir];
				int nx = a1.x+diry[a1.dir];
				if(ny < 0 || nx < 0 || ny >= map.length || nx >= map.length ) {
					continue;
				}
				// n.5초에 만날경우 처리를 위해 sec+ 안해주고 계산하는거
				if(map[ny][nx][b] != null && map[ny][nx][b].sec == a1.sec && !map[ny][nx][b].explo) {
					int d = a1.dir;
					switch(d) {
					case 0 :
						if (map[ny][nx][b].dir == 1) {
							energy += a1.e;
							map[ny][nx][b].explo = true;
							continue;
						}
						break;
					case 1 :
						if (map[ny][nx][b].dir == 0) {
							energy += a1.e;
							map[ny][nx][b].explo = true;
							continue;
						}
						break;
					case 2 :
						if (map[ny][nx][b].dir == 3) {
							energy += a1.e;
							map[ny][nx][b].explo = true;
							continue;
						}
						break;
					case 3 :
						if (map[ny][nx][b].dir == 2) {
							energy += a1.e;
							map[ny][nx][b].explo = true;
							continue;
						}
						break;
					}
				}
				
				a1.y = ny;
				a1.x = nx;
				a1.sec += 1;
				b = a1.sec%2;
				if(map[ny][nx][b] == null) {
					map[ny][nx][b] = a1;
					que.add(a1);
				} else {	// +1초 한상태로 만났을 때
					if(map[ny][nx][b].sec == a1.sec) {
						energy += a1.e;
						map[ny][nx][b].explo = true;
					} else {
						map[ny][nx][b] = a1;
						que.add(a1);
					}
				}
			}	// end of while
			
			System.out.println("#"+testCase+" "+energy);
		}	// end of testCase
		
	}	// end of main

}	// end of class
