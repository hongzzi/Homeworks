import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_1210_SW문제해결기본2일차_ladder1_박지홍 {

	static int [][] ladder = new int[100][102];
	static int [] line;
	static int T = 10;
	static int answer;
	static int lineIdx;	// line index 번호
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 0; t < T; t++) {
			
			int testCase = Integer.parseInt(br.readLine());	// 몇번째 테스트 케이스인지 받기
			int [] temp = new int[100];
			int idx = 0;
			int end = 0;	// 도착점 인덱스 번호
			
			
			// 사다리 정보 불러오기
			for (int i = 0; i < ladder.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < ladder[i].length-1; j++) {	// 사다리맵 양끝 0 초기화, 100*102
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			// 시작 포인트 받아오기(사다리 직선 라인들)
			for (int i = 1; i < ladder[0].length-1; i++) {
				if (ladder[ladder.length-1][i] == 2) {
					end = i;
					lineIdx = idx;
					temp[idx++] = i;
				}
				else if(ladder[ladder.length-1][i] == 1) {
					temp[idx++] = i;
				}
			}
			
			line = Arrays.copyOf(temp,idx);			// 복사
		
			// 도착점 찾기
			for (int i = 0; i < ladder[ladder.length-1].length; i++) {
				if(ladder[ladder.length-1][i] == 2) {
					end = i;
				}
			}
			
			// 도착점으로부터 올라가기 
			a(end, ladder.length-1);
			
			System.out.println("#"+testCase+" "+(answer-1));
		}
	}
	
	public static void a(int index, int y) {
		if (y == 0) {	// 맨 윗줄에 도착했을 때 !
			answer = index;
		} else {
			if (ladder[y][index-1] == 1) {
				index = line[--lineIdx];
			} else if (ladder[y][index+1] == 1) {
				index = line[++lineIdx];
			}
			a(index, y-1);
		}
	}
	
	
}
