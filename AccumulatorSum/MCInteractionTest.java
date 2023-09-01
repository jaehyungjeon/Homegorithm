package AccumulatorSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
	Question : 승재는 인간-컴퓨터 상호작용에서 생체공학 설계를 공부하다가 키보드 자판이 실용적인지 궁금해졌다. 이를 알아보기 위해 승재는 다음과 같은 생각을 했다. 

	'문자열에서 특정 알파벳이 몇 번 나타나는지 알아봐서 자주 나타나는 알파벳이 중지나 검지 위치에 오는 알파벳인지 확인하면 실용적인지 확인할 수 있을 것이다.'
	
	승재를 도와 특정 문자열 $S$, 특정 알파벳 $\alpha$와 문자열의 구간 $[l,r]$이 주어지면 $S$의 $l$번째 문자부터 $r$번째 문자 사이에 $\alpha$가 몇 번 나타나는지 구하는 프로그램을 작성하여라. 
	승재는 문자열의 문자는	$0$번째부터 세며, $l$번째와 $r$번째 문자를 포함해서 생각한다. 
	주의할 점은 승재는 호기심이 많기에 (통계적으로 크게 무의미하지만) 같은 문자열을 두고 질문을 $q$번 할 것이다.

	input
	seungjaehwang
	4
	a 0 5
	a 0 6
	a 6 10
	a 7 10
	
	output
	0
	1
	2
	1
	
	Solution : 1. 단순하게 accumulator로 구하려 했으나 실패하였다.
			   2. 실제 성공된 사례는 인터넷을 참조하여 MCInteraction에 구현하였다..
		
*/

public class MCInteractionTest {

	public static String[] StrArr;
	public static int[] arr;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StrArr = br.readLine().split("");
		int N = Integer.parseInt(br.readLine());
		arr = new int[StrArr.length+1];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			System.out.println(accumulator(str, start, end));
		}
	}
	
	// 누산기를 사용하여 계산하려 했으나 실패...
	private static int accumulator(String str, int start, int end) {
		for(int i=1; i<StrArr.length; i++) {
			arr[i] = arr[i-1];
			if(StrArr[i].equals(str)) {
				arr[i] += 1;
			}
		}
		
		if(start == 0) {
			return arr[end];
		} else {
			return arr[end] - arr[start-1];
		}
	}
	
}
