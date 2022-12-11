package DoubleArray;

import java.util.*;
import java.io.*;

/*
	Question : 가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 이 도화지 위에 가로, 세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다. 
	이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오.
	
	예를 들어 흰색 도화지 위에 세 장의 검은색 색종이를 그림과 같은 모양으로 붙였다면 검은색 영역의 넓이는 260이 된다.

	input			 
	3
	3 7
	15 7
	5 2
	
	output
	260
	
	Solution : 1. 이미 지나간 길을 1로 변경하면서 카운트를 증가하면 됨.
	
*/

public class ColorPaper {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[][] arr = new int[101][101];
		int total = 0;
		
		for(int n=0; n<count; n++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int y=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					if(arr[i][j] == 0) {
						arr[i][j]=1;
						total++;
					}
				}
			}
			
		}
		
		System.out.println(total);
	}
}