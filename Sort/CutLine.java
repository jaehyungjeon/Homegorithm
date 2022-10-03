package Sort;

import java.util.*;

import javax.print.DocFlavor.STRING;

import java.io.*;

/*
	Question : 2022 연세대학교 미래캠퍼스 슬기로운 코딩생할에 N명의 학생들이 응시했다.

	이들 중 점수가 가장 높은 k명은 상을 받을 것이다. 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
	
	커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.

	input			 
	5 2
	100 76 85 93 98
	
	output
	98
	
	Solution : 1. Arrays.sort 내장함수를 내림차순으로 Compare하여 해당 index의 cut 점수를 뽑음.
*/

public class CutLine {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int count = Integer.parseInt(sc.nextToken());
		int cut = Integer.parseInt(sc.nextToken());
		
		String score = br.readLine();
		String[] arr = score.split(" ");
		Integer[] score_arr = new Integer[arr.length];
		int i = 0;
		for(String str : arr) {
			score_arr[i++] = Integer.parseInt(str);
		}
		
		Arrays.sort(score_arr, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		System.out.println(score_arr[cut-1]);
		
	}
}
