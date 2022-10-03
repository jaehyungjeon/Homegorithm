package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/*
	Question : 한수는 지금 (x, y)에 있다. 
	세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오.		
	
	input			 
	5 5
	5 7
	7 5
	
	output
	7 7
	
	Solution : 좀 개판으로 짜긴 했지만.. 일단 들어오는 값 받아주고
			   value 값 기준 1개만 있으면 그걸 출력해주면 됨.
			   최종 return은 StringBuilder로 연결해주었음.
*/

public class MakeRectangle {

	public static int x, y;
	public static Map<Integer, Integer> xlist = new HashMap<Integer, Integer>();
	public static Map<Integer, Integer> ylist = new HashMap<Integer, Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		x = Integer.parseInt(sc.nextToken());
		y = Integer.parseInt(sc.nextToken());
		xlist.put(x, xlist.getOrDefault(x, 0) + 1);
		ylist.put(y, ylist.getOrDefault(y, 0) + 1);
		
		StringTokenizer sc2 = new StringTokenizer(br.readLine());
		x = Integer.parseInt(sc2.nextToken());
		y = Integer.parseInt(sc2.nextToken());
		xlist.put(x, xlist.getOrDefault(x, 0) + 1);
		ylist.put(y, ylist.getOrDefault(y, 0) + 1);
		
		StringTokenizer sc3 = new StringTokenizer(br.readLine());
		x = Integer.parseInt(sc3.nextToken());
		y = Integer.parseInt(sc3.nextToken());
		xlist.put(x, xlist.getOrDefault(x, 0) + 1);
		ylist.put(y, ylist.getOrDefault(y, 0) + 1);

		for(Entry<Integer, Integer> a : xlist.entrySet()) {
			if(a.getValue() == 1) {
				sb.append(a.getKey() + " ");
			}
		}
		
		for(Entry<Integer, Integer> b : ylist.entrySet()) {
			if(b.getValue() == 1) {
				sb.append(b.getKey());
			}
		}
		
		System.out.println(sb.toString());
	}

}
