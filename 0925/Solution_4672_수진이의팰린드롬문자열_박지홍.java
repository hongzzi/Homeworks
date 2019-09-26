package 수업;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_4672_수진이의팰린드롬문자열_박지홍 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int [] num = {0,1,3,6,10,15,21,28,36,45,55};
		
		for (int testCase = 1; testCase <= T; testCase++) {
			String W = br.readLine();	// 단어 1<=W<=10
			int[] cnt = new int[26];
			for (int i = 0; i < W.length(); i++) {
				cnt[W.charAt(i)-'a']++;
			}
			int sum = 0;	//회문의 갯수의 합
			
			for (int i = 0; i < cnt.length; i++) {
				sum += num[cnt[i]];
			}
			
			System.out.println(Arrays.toString(cnt));
			System.out.println("#"+testCase+" "+sum);
		}
	}
	

}
