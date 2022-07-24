package Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/*
	Question : 시골에 있는 태양이의 삼촌 댁에는 커다란 참외밭이 있다. 
	문득 태양이는 이 밭에서 자라는 참외가 도대체 몇 개나 되는지 궁금해졌다. 어떻게 알아낼 수 있는지 골똘히 생각하다가 드디어 좋은 아이디어가 떠올랐다. 
	유레카! 1m2의 넓이에 자라는 참외 개수를 헤아린 다음, 참외밭의 넓이를 구하면 비례식을 이용하여 참외의 총개수를 구할 수 있다.

	1m2의 넓이에 자라는 참외의 개수는 헤아렸고, 이제 참외밭의 넓이만 구하면 된다. 참외밭은 ㄱ-자 모양이거나 ㄱ-자를 90도, 180도, 270도 회전한 모양(┏, ┗, ┛ 모양)의 육각형이다. 
	다행히도 밭의 경계(육각형의 변)는 모두 동서 방향이거나 남북 방향이었다. 밭의 한 모퉁이에서 출발하여 밭의 둘레를 돌면서 밭경계 길이를 모두 측정하였다.

	예를 들어 참외밭이 위 그림과 같은 모양이라고 하자. 그림에서 오른쪽은 동쪽, 왼쪽은 서쪽, 아래쪽은 남쪽, 위쪽은 북쪽이다. 
	이 그림의 왼쪽위 꼭짓점에서 출발하여, 반시계방향으로 남쪽으로 30m, 동쪽으로 60m, 남쪽으로 20m, 동쪽으로 100m, 북쪽으로 50m, 서쪽으로 160m 이동하면 다시 출발점으로 되돌아가게 된다.

	위 그림의 참외밭  면적은 6800m2이다. 만약 1m2의 넓이에 자라는 참외의 개수가 7이라면, 이 밭에서 자라는 참외의 개수는 47600으로 계산된다.

	1m2의 넓이에 자라는 참외의 개수와, 참외밭을 이루는 육각형의 임의의 한 꼭짓점에서 출발하여 반시계방향으로 둘레를 돌면서 지나는 변의 방향과 길이가 순서대로 주어진다. 
	이 참외밭에서 자라는 참외의 수를 구하는 프로그램을 작성하시오.
	
	input			 
	7
	4 50
	2 160
	3 30
	1 60
	3 20
	1 100
	
	output
	47600
	
	Solution : 1. 실패가 많았던 문제였다. 일단 클래스 하나를 더 선언하여 동서남북에 따라 인덱스와 거리의 최대, 최소 값들을 넣도로 셋팅하였다.
			   2. while문으로 값을 받아주고
			   3. 길이의 max, min값을 넣는다.
			   4. list.add(list.get(0))로 리스트 값을 재셋팅한다.
			   5. 동서남북에 따른 곱을 통해 전체에서 마이너스 할 영역을 셋팅한다.
			   6. (전체 - 뺄 부분) * N으로 결과값을 도출한다.

*/

public class MelonField {
	static class Node {
		int idx;
		int length;
		
		public Node(int idx, int length){
			this.idx = idx;
			this.length = length;
		}
	}
	
	public static void main(String[] args) throws IOException {
		List<Node> list = new ArrayList<Node>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int tot = 6;
		
		while(tot > 0) {
			String str = br.readLine();
			StringTokenizer sc = new StringTokenizer(str);
			int idx = Integer.parseInt(sc.nextToken());
			int length = Integer.parseInt(sc.nextToken());
			list.add(new Node(idx, length));
			
			tot--;
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).idx == 1 || list.get(i).idx == 2) {
				map.put(0, Math.max(list.get(i).length, map.getOrDefault(3, 0)));
			} else if(list.get(i).idx == 3 || list.get(i).idx == 4){
				map.put(1, Math.max(list.get(i).length, map.getOrDefault(4, 0)));
			}
		}
		
		list.add(list.get(0));
		
		int MinusField = 0;
		for(int i=0; i<list.size() - 1; i++) {
			Node a = list.get(i);
			Node b = list.get(i+1);
			if((a.idx == 1 && b.idx == 3) || (a.idx == 2 && b.idx == 4) || (a.idx == 3 && b.idx == 2) || (a.idx == 4 && b.idx == 1)) {
				MinusField = a.length * b.length;
				break;
			}
		}
		
		int totField = ((map.get(0) * map.get(1)) - MinusField) * count;
		
		System.out.println(totField);
	}
}
