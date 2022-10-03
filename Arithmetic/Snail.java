package Arithmetic;

import java.util.*;
import java.io.*;

/*
	Question : 땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
	달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
	달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

	input			 
	2 1 5
	
	output
	4
	
	Solution : 나머지를 계산
	
*/

public class Snail {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(sc.nextToken());
		int B = Integer.parseInt(sc.nextToken());
		int V = Integer.parseInt(sc.nextToken());
		
		int day = (V - B) / (A - B);
        
		if ((V - B) % (A - B) != 0) {
			day++;
		}
		
		System.out.println(day);
	}
}