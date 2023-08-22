package TimeComplexity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	Question : 오늘도 서준이는 알고리즘의 수행시간 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

	입력의 크기 n이 주어지면 MenOfPassion 알고리즘 수행 시간을 예제 출력과 같은 방식으로 출력해보자.
	
	MenOfPassion 알고리즘은 다음과 같다.
	
	MenOfPassion(A[], n) {
	    sum <- 0;
	    for i <- 1 to n
	        sum <- sum + A[i]; # 코드1
	    return sum;
	}
	
	input			 
	7
	
	output
	7
	1
	
	Solution : 1. 시간복잡도 O(n)  

*/

public class Algorithm2 {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(br.readLine());
		System.out.println("1");
	}

}
