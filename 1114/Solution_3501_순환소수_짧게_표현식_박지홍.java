package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_3501_순환소수_짧게_표현식_박지홍 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());	// 분자 p, 1 <= p , q <= 10^5 
			int q = Integer.parseInt(st.nextToken());	// 분자 q, 1 <= p , q <= 10^5
			
			sb.append("#").append(testCase).append(' ');
			
			int 몫 = p/q;
			int 나머지 = p%q;
			
			// 나누어 떨어지면 소수가 아니니깐, 출력하고 다음 testCase로 넘어가기
			if (나머지 == 0) {
				sb.append(몫).append('\n');
				continue;
			}
			
			// 나누어 떨어지지 않으면 소수가 있는거니까, 소수점 . 추가
			sb.append(몫).append('.');
			
			HashMap<Integer, Integer> hm = new HashMap<>(); // 키 나머지값 : 밸류 index 위치

			for (int i = sb.length(); 나머지 > 0; i++) {	// 현재 저장되는 몫의 인덱스 
				// 순환하는 소수 찾기
				if(hm.containsKey(나머지)) {	// 순환소수 발견
					sb.insert(hm.get(나머지).intValue(), '(');
					sb.append(')');
					break;
				}
				hm.put(나머지, i);
				나머지 *= 10;
				몫 = 나머지 / q;
				나머지 = 나머지 % q;
				sb.append(몫);
			}
			
			sb.append('\n');
			
		}
		System.out.println(sb);
	}
}
	