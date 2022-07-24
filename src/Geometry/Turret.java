package Geometry;

import java.util.*;
import java.io.*;

/*
	Question : 조규현과 백승환은 터렛에 근무하는 직원이다. 하지만 워낙 존재감이 없어서 인구수는 차지하지 않는다. 다음은 조규현과 백승환의 사진이다.
	
	이석원은 조규현과 백승환에게 상대편 마린(류재명)의 위치를 계산하라는 명령을 내렸다. 조규현과 백승환은 각각 자신의 터렛 위치에서 현재 적까지의 거리를 계산했다.
	조규현의 좌표 (x1, y1)와 백승환의 좌표 (x2, y2)가 주어지고, 조규현이 계산한 류재명과의 거리 r1과 백승환이 계산한 류재명과의 거리 r2가 주어졌을 때, 
	류재명이 있을 수 있는 좌표의 수를 출력하는 프로그램을 작성하시오.
	
	input			 
	3
	0 0 13 40 0 37
	0 0 3 0 7 4
	1 1 1 1 1 5
	
	output
	2
	1
	0
	
	Solution : 1. 내용은 이해가 잘 안돼서 풀이를 보고 접근했음...
			   2. 결국, 논리는 두 위치의 접점의 갯수를 찾는 것.
			   3. 아예 같으면 위치할 곳이 없으므로 -1 return
			   4. 외접하지 않고, 내접도 하지 않을 경우 0 return
			   5. 외접, 내접일 경우 1 return
			   6. 원이 겹쳐질 경우 2 return(else)
*/

public class Turret {
	
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(sc.nextToken());
			int y1 = Integer.parseInt(sc.nextToken());
			int r1 = Integer.parseInt(sc.nextToken());
			int x2 = Integer.parseInt(sc.nextToken());
			int y2 = Integer.parseInt(sc.nextToken());
			int r2 = Integer.parseInt(sc.nextToken());
			
			System.out.println(point_result(x1, y1, r1, x2, y2, r2));
		}
	}
	
	public static int point_result(int x1, int y1, int r1, int x2, int y2, int r2) {
		int dist = (int)(Math.pow(Math.abs(x2-x1), 2) + Math.pow(Math.abs(y2-y1), 2));
		
		if(x1==x2 && y1==y2 && r1==r2) { // 중심이 같고 거리가 같을 경우
			return -1;
		} else if(dist > Math.pow(Math.abs(r1 + r2), 2) || dist < Math.pow(Math.abs(r2 - r1), 2)) { // 두 원의 반지름 합보다 중점간의 거리가 더 길 경우 | 원 안에 원이 있으나, 내접하지는 않는 경우 
			return 0;
		} else if(dist == Math.pow(Math.abs(r1 + r2), 2) || dist == Math.pow(Math.abs(r2 - r1), 2)) { // 외접 | 내접
			return 1;
		} else {
			return 2;
		}
	}
}
