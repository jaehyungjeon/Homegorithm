package Geometry;

import java.util.*;
import java.io.*;

/*
	Question : 19세기 독일 수학자 헤르만 민코프스키는 비유클리드 기하학 중 택시 기하학을 고안했다.
	택시 기하학에서 두 점 T1(x1,y1), T2(x2,y2) 사이의 거리는 다음과 같이 구할 수 있다.
	D(T1,T2) = |x1-x2| + |y1-y2|
	두 점 사이의 거리를 제외한 나머지 정의는 유클리드 기하학에서의 정의와 같다.
	
	따라서 택시 기하학에서 원의 정의는 유클리드 기하학에서 원의 정의와 같다.
	원: 평면 상의 어떤 점에서 거리가 일정한 점들의 집합
	반지름 R이 주어졌을 때, 유클리드 기하학에서 원의 넓이와, 택시 기하학에서 원의 넓이를 구하는 프로그램을 작성하시오.
	
	input			 
	1
	
	output
	3.141593
	2.000000
	
	Solution : 1. 유클리드 : 반지름 * 반지름 * 3.14...
			   2. 현대 기하학 : (반지름*2) * 반지름... 

*/

public class TaxiGeo {
	
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		double eculid = (N * N) * Math.PI;
		System.out.println(String.format("%.6f", eculid));
		
		double modern = (N * 2) * N;
		System.out.println(String.format("%.6f", modern));
	}
}
