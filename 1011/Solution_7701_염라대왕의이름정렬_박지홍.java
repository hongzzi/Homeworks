package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution_7701_염라대왕의이름정렬_박지홍 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int len = Integer.parseInt(br.readLine());
			List<String> list = new ArrayList<>();
			Set<String> set = new TreeSet<String>();
			for (int i = 0; i < len; i++) {
				set.add(br.readLine());
			}
			for (String string : set) {
				list.add(string);
			}
			
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o1.length() == o2.length()) {
						return o1.compareTo(o2);
					} else {
						return o1.length() - o2.length();
					}
				}
			});
			
			System.out.println("#"+testCase);
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
