package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기_박지홍 {

	private static int[][] m;
	private static int[][] dap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // 스타일러쉬 코드 줄 수 1 <= p, q <= 10
			int q = Integer.parseInt(st.nextToken()); // 당신의 코드 줄 수

			m = new int[p][4];

			for (int j = 0; j < m.length; j++) {
				String line = br.readLine();
				int index = 0;
				while (line.charAt(index) == '.') {
					index++;
				}
				m[j][0] = index;

				if (j > 0) { // 누적 괄호 갯수
					m[j][1] = m[j - 1][1];
					m[j][2] = m[j - 1][2];
					m[j][3] = m[j - 1][3];
				}

				for (int k = index; k < line.length(); k++) {
					switch (line.charAt(k)) {
					case '(':
						m[j][1]++;
						break;
					case ')':
						m[j][1]--;
						break;
					case '{':
						m[j][2]++;
						break;
					case '}':
						m[j][2]--;
						break;
					case '[':
						m[j][3]++;
						break;
					case ']':
						m[j][3]--;
						break;
					}
				}
			} // 스타일리쉬 마스터 코더 분석

			for (int k = 0; k < m.length; k++) {
				System.out.println(Arrays.toString(m[k]));
			}

			dap = new int[p][4];

			for (int j = 0; j < m.length; j++) {
				String line = br.readLine();
				int index = 0;

				if (j > 0) { // 누적 괄호 갯수
					dap[j][1] = dap[j - 1][1];
					dap[j][2] = dap[j - 1][2];
					dap[j][3] = dap[j - 1][3];
				}

				for (int k = index; k < line.length(); k++) {
					switch (line.charAt(k)) {
					case '(':
						dap[j][1]++;
						break;
					case ')':
						dap[j][1]--;
						break;
					case '{':
						dap[j][2]++;
						break;
					case '}':
						dap[j][2]--;
						break;
					case '[':
						dap[j][3]++;
						break;
					case ']':
						dap[j][3]--;
						break;
					}
				}
			} // 내 코드 분석

		    // 내 코드를 분석한 배열 dap의 .의 개수 열을 사용하지 않는 값 -2로 초기화 하자
            for (int j = 0; j < q; j++) {
                dap[j][0] = -2;    // 초기화
            }
            
            for (int R = 1; R <= 20; R++) {
                for (int C = 1; C <= 20; C++) {
                    for (int S = 1; S <= 20; S++) {
                        if (check(R,C,S)) {    // 마스터 코드에서 답이 맞는지 체크
                            cal(R,C,S);// 구한 답 RCS 값을 내 코드에 적용했을 때 각 줄에 답을 구하기
                        }
                    }
                }
            }
            System.out.print("#" + i + " 0");
            for (int j = 1; j < dap.length; j++) {
                System.out.print(" " + dap[j][0]);
            }

		} // end of tc

	} // end of main

    /** 내 코드에서 R,C,S값으로 .의 개수를 구하기 */
    private static void cal(int R, int C, int S) {
        for (int i = 1; i < dap.length; i++) {
            int x = dap[i-1][1] * R + dap[i-1][2] * C + dap[i-1][3] * S;    // 다음 줄의 .의 개수
            if(dap[i][0] == -2) {    // 처음 들어온 것이라면
                dap[i][0] = x;    // 저장
            } else if (dap[i][0] == -1) {    // 유일한 해가 아니면
                
            } else if (dap[i][0] != x) {    // 이전에 답은 구한 적 있는데, 현재 계산한 결과와 다르면, 해가 여러개라는 뜻이다.
                dap[i][0] = -1;    // 유일한 해가 아니다
            }
        }
    }
    /** 스타일리쉬 코드에서 RCS 값이 맞는지 체크 */
    private static boolean check(int R, int C, int S) {
        for (int i = 1; i < m.length; i++) {
            if(m[i][0] != m[i-1][1] * R + m[i-1][2] * C + m[i-1][3] * S) {
                return false;    // 한 번이라도 틀리면 답이 아니다
            }
        }
        
        return true;
    }

} // end of class

/**
 * StringTokenizer st = new StringTokenizer(br.readLine()); int p =
 * Integer.parseInt(st.nextToken()); int q = Integer.parseInt(st.nextToken());
 * 
 * int[][] master = new int[p][4]; int[][] me = new int[q][4]; int[] operation =
 * new int[6];
 * 
 * for (int j = 0; j < master.length; j++) { String tmp = br.readLine(); int dot
 * = 0; boolean flag = false;
 * 
 * master[j][1] = operation[0] - operation[1]; master[j][2] = operation[2] -
 * operation[3]; master[j][3] = operation[4] - operation[5];
 * 
 * for (int k = 0; k < tmp.length(); k++) { char c = tmp.charAt(k); if (!flag &&
 * c == '.') { // 처음에 연속된 만큼만 ~ dot++; } else { flag = true; switch (c) { case
 * '(': operation[0]++; break; case ')': operation[1]++; break; case '{':
 * operation[2]++; break; case '}': operation[3]++; break; case '[':
 * operation[4]++; break; case ']': operation[5]++; break; } } } master[j][0] =
 * dot; } // 스타일리쉬 마스터 코더 분석 master[p-1][1] = operation[0] - operation[1];
 * master[p-1][2] = operation[2] - operation[3]; master[p-1][3] = operation[4] -
 * operation[5];
 */
