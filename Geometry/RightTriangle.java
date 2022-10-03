package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	Question : 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
	
	input			 
	6 8 10
	25 52 60
	5 12 13
	0 0 0
	
	output
	right
	wrong
	right
	
	Solution : 피타고라스의 정리를 이용하면 된다. 가장 작은것 부터 정렬해서 1번째의 제곱 + 2번째의 제곱 == 3번째의 제곱 -> right // 아닐경우 wrong
*/

public class RightTriangle {

	public static int[] arr;
	public static int x, y, z;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		arr = new int[3];
		
		while(true) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			x = Integer.parseInt(sc.nextToken());
			y = Integer.parseInt(sc.nextToken());
			z = Integer.parseInt(sc.nextToken());
			
			arr[0] = x;
			arr[1] = y;
			arr[2] = z;
			
			Arrays.sort(arr);
			
			x = arr[0];
			y = arr[1];
			z = arr[2];
			
			if(x == 0 && y==0 && z==0) {
				break;
			} else if(((x*x)+(y*y)) == (z*z)) {
				sb.append("right \n");
			} else {
				sb.append("wrong \n");
			}
		}
		
		System.out.println(sb.toString());
	}
}