package DoubleArray;

import java.io.IOException;
import java.util.Scanner;

/*
	Question : 첫째 줄에 행렬의 크기 N 과 M이 주어진다. 둘째 줄부터 N개의 줄에 행렬 A의 원소 M개가 차례대로 주어진다. 
	이어서 N개의 줄에 행렬 B의 원소 M개가 차례대로 주어진다. N과 M은 100보다 작거나 같고, 행렬의 원소는 절댓값이 100보다 작거나 같은 정수이다.

	input			 
	3 3
	1 1 1
	2 2 2
	0 1 0
	3 3 3
	4 4 4
	5 5 100
	
	output
	4 4 4
	6 6 6
	5 6 100
	
	Solution : 1. 들어오는 것의 순서에서 for문을 하나 더 추가하여 합산을 계산
	
*/

public class ArraySum {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[N][M];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < M; j2++) {
					arr[j][j2] += sc.nextInt();
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}