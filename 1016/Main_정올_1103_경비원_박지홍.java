package 수업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_1103_경비원_박지홍 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int cnt = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		int max = 2 * (r + c);
		
		for (int i = 0; i <= cnt; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			switch (dir) {
			case 1:
				list.add(x);
				break;
			case 2:
				list.add(r + c + c - x);
				break;
			case 3:
				list.add(max - x);
				break;
			case 4:
				list.add(c + x);
				break;
			}
		}
		int distSum = 0;
		int d = list.get(list.size() - 1);
		for (int i = 0; i < cnt; i++) {
			int a = 0;
			int b = 0;
			if (d < list.get(i)) {
				a = d;
				b = list.get(i);
			} else {
				a = list.get(i);
				b = d;
			}
			if (b - a <= (max - b) + a) {
				distSum += b - a;
			} else {
				distSum += (max - b) + a;
			}
		}
		System.out.println(distSum);
	}
}
