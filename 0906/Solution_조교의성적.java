package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_조교의성적 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		String[] score = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			int sn = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			Map<Integer, Integer> m = new HashMap<>();
			for (int i = 1; i <= k; i++) {
				st = new StringTokenizer(br.readLine());
				int ms = Integer.parseInt(st.nextToken());
				int fs = Integer.parseInt(st.nextToken());
				int hs = Integer.parseInt(st.nextToken());
				int s = (int) (ms*0.35 + fs*0.45 + hs*0.2);
				m.put(i, s);
			}
			
			List<Integer> list = (List<Integer>) m.values();
//			Arrays.sort(list,(o1,o2)->((Integer)o1).c);
//			
//			m.
//			
		}
	}

}
