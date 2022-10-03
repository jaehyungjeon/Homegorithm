package Sort;

import java.util.*;

import javax.print.DocFlavor.STRING;

import java.io.*;

/*
	Question : 수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

	산술평균 : N개의 수들의 합을 N으로 나눈 값
	중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
	최빈값 : N개의 수들 중 가장 많이 나타나는 값
	범위 : N개의 수들 중 최댓값과 최솟값의 차이
	N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

	input			 
	5
	-1
	-2
	-3
	-1
	-2
	
	output
	-2
	-2
	-1
	2
	
	Solution : 1. 산술평균 : Math.round 이용하여 반올림
			   2. 중앙값 : 전체 수 / 2를 리스트에서 뽑으면 무조건 중앙값
			   3. 최빈값 : map에 key에 따른 value를 담고, value의 max를 먼저 구함. 다시 for문으로 조회하여 value가 max인 것과 동일한 것끼리만 묶고 정렬 후 get(1)으로 가져옴(2개 이상), 1개면 get(0)
			   4. 범위 : Math.max, Math.min 이용
*/

public class Statistics {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> numList = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int total = 0;
		int maxNum = Integer.MIN_VALUE;
		int minNum = Integer.MAX_VALUE;
		
		int count = Integer.parseInt(br.readLine());
		for(int i=0; i<count; i++) {
			int num = Integer.parseInt(br.readLine());
			total += num;
			maxNum = Math.max(maxNum, num);
			minNum = Math.min(minNum, num);
			numList.add(num);
			map.put(num, map.getOrDefault(num, 0)+1);
		}

		int max = 0;
		for(int val : map.values()) {
			max = Integer.max(max, val);
		}
		
		List<Integer> maxList = new ArrayList<>();
		for(int val : map.keySet()) {
			if(map.get(val).equals(max)) {
				maxList.add(val);
			}
		}
		
		Collections.sort(maxList);
		Collections.sort(numList);
		sb.append(Math.round((double)total/count) + "\n"); // 산술평균
		sb.append(numList.get(count/2) + "\n"); // 중앙값
		sb.append((maxList.size() > 1 ? maxList.get(1) : maxList.get(0)) + "\n"); // 최빈값
		sb.append(maxNum - minNum); // 범위
		
		System.out.println(sb.toString());
	}
}
