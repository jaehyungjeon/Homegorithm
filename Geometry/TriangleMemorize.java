package Geometry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/*
	Question : 창영이는 삼각형의 종류를 잘 구분하지 못한다. 따라서 프로그램을 이용해 이를 외우려고 한다.

	삼각형의 세 각을 입력받은 다음, 
	
	세 각의 크기가 모두 60이면, Equilateral
	세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
	세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
	세 각의 합이 180이 아닌 경우에는 Error
	를 출력하는 프로그램을 작성하시오. 
	
	input
	60
	70
	50
	
	output
	Scalene
	
	Solution : 1. 삼각형이니까 3개만 받는다고 가정하자.
	 		   2. 귀찮아서.. HashSet사용해서 중복 제거함.
	 		   3. set의 사이즈로 비교하면 깔-끔.

*/

public class TriangleMemorize {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> set = new HashSet<Integer>();
		
		int[] arr = new int[3];
		int sum = 0;
		for(int i=0; i<3; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			set.add(arr[i]);
		}
		
		if(sum != 180) {
			System.out.println("Error");
		} else if(sum == 180 && set.size() == 1) {
			System.out.println("Equilateral");
		} else if(sum == 180 && set.size() == 2) {
			System.out.println("Isosceles");
		} else {
			System.out.println("Scalene");
		}
	}

}
