package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_1157_단어공부_박지홍 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		int[] srr = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			srr[(str.charAt(i)-'A')]++;
		}
		
		int index = 0;
		int max = 0;
		for (int i = 0; i < srr.length; i++) {
			if(srr[i] > max) {
				index = i;
				max = srr[i];
			} else if(srr[i] == max) {
				index = -1;
			}
		}
		
		System.out.println(index==-1 ? "?" : (char)(index+'A'));
	}
}
