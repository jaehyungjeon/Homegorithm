package Condition;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

/*
	Question : 1에서부터 6까지의 눈을 가진 3개의 주사위를 던져서 다음과 같은 규칙에 따라 상금을 받는 게임이 있다. 
	같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
	같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다. 
	모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.  
	예를 들어, 3개의 눈 3, 3, 6이 주어지면 상금은 1,000+3×100으로 계산되어 1,300원을 받게 된다. 
	또 3개의 눈이 2, 2, 2로 주어지면 10,000+2×1,000 으로 계산되어 12,000원을 받게 된다. 
	3개의 눈이 6, 2, 5로 주어지면 그중 가장 큰 값이 6이므로 6×100으로 계산되어 600원을 상금으로 받게 된다.
	3개 주사위의 나온 눈이 주어질 때, 상금을 계산하는 프로그램을 작성 하시오.

	input			 
	3 3 6
	
	output
	1300
	
	Solution : 쉬운 방법이 있을 수 있겠지만.. map으로 풀면 개괄적일 것 같았으나 속도가 132ms..
			   map에 담고 사이즈 형식으로 비교해보았다.
*/

public class ThreeDice {
	
	public static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(sc.nextToken());
		map.put(a, map.getOrDefault(a, 0)+1);
		
		int b = Integer.parseInt(sc.nextToken());
		map.put(b, map.getOrDefault(b, 0)+1);
		
		int c = Integer.parseInt(sc.nextToken());
		map.put(c, map.getOrDefault(c, 0)+1);
		
		int cost = 0;
		if(map.size() == 1) { // 모두 같을 경우
			cost = 10000 + (a * 1000); 
		} else if(map.size() == 2) { // 2개가 같을 경우
			for(Entry<Integer, Integer> entry : map.entrySet()) {
				if(entry.getValue() == 2) {
					cost = 1000 + (entry.getKey() * 100);
					break;
				}
			}
		} else {
		    List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
		    Collections.sort(entries, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));
		    cost = entries.get(0).getKey() * 100;
		}
		
		System.out.println(cost);
	}
}