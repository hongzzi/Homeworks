package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_박지홍 {
	
	static class Animal {
		int x;
		int y;
		public Animal(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] set = new int[M];
		int kill = 0;
		List<Animal> list = new ArrayList<Animal>();
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			set[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(set);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x > set[set.length-1]+L || x < set[0]-L) continue;
			if(y > L) continue;
			list.add(new Animal(x, y));
		}
		
		Collections.sort(list, new Comparator<Animal>() {
			@Override
			public int compare(Animal o1, Animal o2) {
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				} else {
					return o1.x - o2.x;
				}
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			Animal a = list.get(i);
			for (int j = 0; j < set.length; j++) {
				if ( L >= Math.abs(set[j]-a.x)+a.y ) {
					kill ++;
					break;
				}
			}
		}
		
		System.out.println(kill);
	}
}
