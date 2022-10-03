package Sort;

import java.util.*;
import java.io.*;

/*
	Question : 수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

	Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
	
	X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

	input			 
	5
	2 4 -10 4 -9
	
	output
	2 3 0 3 1
	
	Solution : 1. 정렬과 key를 이용한 값 세팅
*/

public class CoordinateCompress {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		
		int[] ori = new int[count];
		int[] sort = new int[count];
		Map<Integer, Integer> map = new HashMap<>();
		
		String[] tmp = br.readLine().split(" "); 
		for(int i=0; i<count; i++) {
			sort[i] = ori[i] = Integer.parseInt(tmp[i]);
		}
		
		Arrays.sort(sort);
		
		int rank = 0;
		for(int val : sort) {
			if(!map.containsKey(val)) {
				map.put(val, rank);
				rank++;
			}
		}
		
		for(int val : ori) {
			int ranking = map.get(val);
			sb.append(ranking + " ");
		}
		
		System.out.println(sb.toString());
	}
}