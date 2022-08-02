package InputOutput;

import java.util.*;
import java.io.*;

/*
	Question : (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
	(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
		
	input			 
	472
	385
	
	output
	2360
	3776
	1416
	181720
	
	Solution : 곱셈
*/

public class Multiply {
	
	public static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int total = a * b;
		
		while(b > 0) {
			q.offer(b % 10);
			b /= 10;
		}
		
		while(!q.isEmpty()) {
			int mul = q.poll() * a;
			sb.append(mul + "\n");
		}
		
		sb.append(total);
		
		System.out.println(sb.toString());
	}
}
