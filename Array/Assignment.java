package Array;

import java.util.*;
import java.io.*;

/*
	Question : X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
	교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.

	input			 
	3
	1
	4
	5
	7
	9
	6
	10
	11
	12
	13
	14
	15
	16
	17
	18
	19
	20
	21
	22
	23
	24
	25
	26
	27
	28
	29
	30
	
	output
	2
	8
	
	Solution : 배열 초기화, 받는 번호-1 에 1로 세팅 후 1이 아니면 출력
*/

public class Assignment {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[31];
		
		for(int i=0; i<30; i++) {
			arr[i] = 0;
		}
		
		for(int i=0; i<28; i++) {
			arr[sc.nextInt()-1] = 1;
		}
		
		for(int i=0; i<30; i++) {
			if(arr[i] != 1) {
				System.out.println(i+1);
			}
		}
	}
}