package Geometry;

import java.io.*;
import java.util.*;

/*
	Question : 어린 왕자는 소혹성 B-664에서 자신이 사랑하는 한 송이 장미를 위해 살아간다. 
	어느 날 장미가 위험에 빠지게 된 것을 알게 된 어린 왕자는, 장미를 구하기 위해 은하수를 따라 긴 여행을 하기 시작했다. 
	하지만 어린 왕자의 우주선은 그렇게 좋지 않아서 행성계 간의 이동을 최대한 피해서 여행해야 한다. 아래의 그림은 어린 왕자가 펼쳐본 은하수 지도의 일부이다.
	빨간 실선은 어린 왕자가 출발점에서 도착점까지 도달하는데 있어서 필요한 행성계 진입/이탈 횟수를 최소화하는 경로이며, 원은 행성계의 경계를 의미한다. 
	이러한 경로는 여러 개 존재할 수 있지만 적어도 3번의 행성계 진입/이탈이 필요하다는 것을 알 수 있다.
	위와 같은 은하수 지도, 출발점, 도착점이 주어졌을 때 어린 왕자에게 필요한 최소의 행성계 진입/이탈 횟수를 구하는 프로그램을 작성해 보자. 
	행성계의 경계가 맞닿거나 서로 교차하는 경우는 없다. 또한, 출발점이나 도착점이 행성계 경계에 걸쳐진 경우 역시 입력으로 주어지지 않는다.		
	
	input			 
	2
	-5 1 12 1
	7
	1 1 8
	-3 -1 1
	2 2 2
	5 5 1
	-4 5 1
	12 1 1
	12 1 2
	-5 1 5 1
	1
	0 0 2
	
	output
	3
	0
	
	Solution : 이해가 잘 안돼서 오픈 소스 참고..
			   결국 sqrt((x-x0)^2 + (y-y0)^2) < 0을 구하는 문제
*/

public class LittlePrince {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int len = in.nextInt(); // TestCase
		in.nextLine();
		
		for(int i=0; i<len; i++) {
			String str = in.nextLine();
			
			int x_start = Integer.parseInt(str.split(" ")[0]);
			int y_start = Integer.parseInt(str.split(" ")[1]);
			
			int x_end = Integer.parseInt(str.split(" ")[2]);
			int y_end = Integer.parseInt(str.split(" ")[3]);
			
			int through = 0;
			
			int count = in.nextInt();
			in.nextLine();
			
			for(int j=0; j<count; j++) {
				String circle = in.nextLine();
				
				int x = Integer.parseInt(circle.split(" ")[0]);
				int y = Integer.parseInt(circle.split(" ")[1]);
				int z = Integer.parseInt(circle.split(" ")[2]);
				
				boolean hasStart = hasContain(x_start, y_start, x, y, z);
				boolean hasEnd = hasContain(x_end, y_end, x, y, z);
				
				if(!(hasStart && hasEnd) && (hasStart || hasEnd)) {
					through++;
				}
			}
			System.out.println(through);
		}
		
	}
	
	 private static boolean hasContain(int xo, int yo, int x, int y, int z) {
	        return Math.sqrt(Math.pow(xo - x, 2) + Math.pow(yo - y, 2)) < z;
        }
}
