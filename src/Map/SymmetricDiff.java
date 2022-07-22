package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
	Question : 자연수를 원소로 갖는 공집합이 아닌 두 집합 A와 B가 있다. 이때, 두 집합의 대칭 차집합의 원소의 개수를 출력하는 프로그램을 작성하시오. 
	두 집합 A와 B가 있을 때, (A-B)와 (B-A)의 합집합을 A와 B의 대칭 차집합이라고 한다.

	예를 들어, A = { 1, 2, 4 } 이고, B = { 2, 3, 4, 5, 6 } 라고 할 때,  A-B = { 1 } 이고, B-A = { 3, 5, 6 } 이므로, 대칭 차집합의 원소의 개수는 1 + 3 = 4개이다.		
	
	input			 
	3 5
	1 2 4
	2 3 4 5 6
	
	output
	4
	
	Solution : 리스트로 쓰니까 용량 초과.. HashSet은 먹힘
*/

public class SymmetricDiff {
	
	public static int N, M;
	public static HashSet<Integer> firstArr = new HashSet<Integer>();
	public static HashSet<Integer> secondArr = new HashSet<Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		StringTokenizer sc = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			firstArr.add(Integer.parseInt(sc.nextToken()));
		}
		
		StringTokenizer sb = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			secondArr.add(Integer.parseInt(sb.nextToken()));
		}
		
		int firstDiff = 0;
		for(int a : firstArr) {
			if(!secondArr.contains(a)) {
				firstDiff++;
			}
		}
		
		int secondDiff = 0;
		for(int a : secondArr) {
			if(!firstArr.contains(a)) {
				secondDiff++;
			}
		}
		
		System.out.println(firstDiff + secondDiff);
	}
}
