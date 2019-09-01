package algo_지홍;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_박지홍 {

	static class Ref {
		int s;
		int e;
		int size;

		public Ref(int s, int e) {
			this.s = s;
			this.e = e;
			size = e-s;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		Queue<Ref> que = new LinkedList<Ref>();
		List<Ref> list = new ArrayList<Ref>();
		int maxRef = 1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new Ref(a,b));
		}
		
		Collections.sort(list, new Comparator<Ref>() {
			@Override
			public int compare(Ref o1, Ref o2) {
				return o1.s-o2.s;
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			que.add(list.get(i));
		}
		
		while(que.size() > 0) {
			Ref tmp = que.poll();
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Ref tmp2 = que.poll();
				if(tmp2.s > tmp.e) {
					tmp = tmp2;
					maxRef++;
				} else {
					if(tmp2.e <= tmp.e) {
						tmp.e = tmp2.e;
					} 
				}
			}
		}
		
		System.out.println(maxRef);
	}

}
