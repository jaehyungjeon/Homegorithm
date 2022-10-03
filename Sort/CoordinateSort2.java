package Sort;

import java.util.*;
import java.io.*;

/*
	Question : 2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

	input			 
	5
	0 4
	1 2
	1 -1
	2 2
	3 3
	
	output
	1 -1
	1 2
	2 2
	3 3
	0 4
	
	Solution : 1. 이전 정렬에서 1번째 배열을 우선 비교 후 0번째 배열 비교
*/

public class CoordinateSort2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int count = Integer.parseInt(br.readLine());
		int[][] arr = new int[count][2];
		
		for(int i=0; i<count; i++) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(sc.nextToken());
			arr[i][1] = Integer.parseInt(sc.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		for(int[] val : arr) {
			for(int val2 : val) {
				sb.append(val2 + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}