package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_4050_재관이의대량할인 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			Integer[] arr = new Integer[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr, Comparator.reverseOrder());
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if(i%3==2) {
					continue;
				}
				sum += arr[i];
			}
			
			System.out.println("#"+testCase+" "+sum);
		}
	}
}
