package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 한수는 지금 (x, y)에 있다. 
	직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.		
	
	input			 
	6 2 10 3
	
	output
	1
	
	Solution : x에서의 최솟값 , y에서의 최솟값 구한다음에 둘 중 최솟값 반환
*/

public class EscapeRectangle {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(sc.nextToken());
		int y = Integer.parseInt(sc.nextToken());
		int w = Integer.parseInt(sc.nextToken());
		int h = Integer.parseInt(sc.nextToken());
		
		int totMin = Math.min(Math.min(w-x, x-0), Math.min(h-y, y-0));
		
		System.out.println(totMin);
	}
}
