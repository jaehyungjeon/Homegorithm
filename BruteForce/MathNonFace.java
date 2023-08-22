package BruteForce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 수현이는 4차 산업혁명 시대에 살고 있는 중학생이다. 코로나 19로 인해, 수현이는 버추얼 학교로 버추얼 출석해 버추얼 강의를 듣고 있다. 
	수현이의 버추얼 선생님은 문자가 2개인 연립방정식을 해결하는 방법에 대해 강의하고, 다음과 같은 문제를 숙제로 냈다.

	다음 연립방정식에서 $x$와 $y$의 값을 계산하시오.
	 
	\[\begin{cases}ax+by=c\\dx+ey=f\end{cases}\] 
	4차 산업혁명 시대에 숙제나 하고 앉아있는 것보다 버추얼 친구들을 만나러 가는 게 더 가치있는 일이라고 생각했던 수현이는 이런 연립방정식을 풀 시간이 없었다. 
	다행히도, 버추얼 강의의 숙제 제출은 인터넷 창의 빈 칸에 수들을 입력하는 식이다. 각 칸에는 
	$-999$ 이상 $999$ 이하의 정수만 입력할 수 있다. 수현이가 버추얼 친구들을 만나러 버추얼 세계로 떠날 수 있게 도와주자.
	
	input			 
	1 3 -1 4 1 7
	---------------
	2 5 8 3 -4 -11
	
	output
	2 -1
	---------------
	-1 2
	
	Solution : 1. for문을 돌려서 해의 값이 같은 경우에 return

*/

public class MathNonFace {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int val1 = Integer.parseInt(st.nextToken());
		
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int val2 = Integer.parseInt(st.nextToken());
		
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				if(x1*i+y1*j==val1 && x2*i+y2*j==val2) {
					System.out.println(i+" "+j);
					System.exit(0);
				}
			}
		}
		
	}

}
