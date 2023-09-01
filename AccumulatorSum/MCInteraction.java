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
	
	Solution : 1. 대/소문자에 대한 구분도 있어서 기존 방식으로는 실패가 나왔던 것으로 보인다.
			   2. char기준으로 비교하기 위해 참고하였다.
			   3. 기존에 틀렸던 이유를 분석해 보니, 알파벳을 소문자만 받는다는 전제조건을 무시하였다. 대문자가 들어왔어도 처리가 되었기에 오류가 났을 것이다.
			   4. 2번째로는 StringBuilder의 미사용으로 인한 시간초과 오류가 났을 것으로 예상했다.
			   5. 결국 방식은 비교하고자 하는 문자(char)를 - 26으로 차감하면서 해당 배열에 넣었던 누적합에서 start 이전의 누적합을 차감해주는 방식이다.
			   6. 기존 누산기를 활용하여 계산한 것과 방식은 크게 벗어나진 않았으나, 정교하게 소스를 짤 수 있도록 노력해야겠다...
		
*/

public class MCInteraction {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[26];
		int[][] alphabet = new int[str.length()][26];
		
		for(int i=0; i<str.length(); i++) {
			arr[str.charAt(i) - 'a']++; // 해당 알파벳 배열의 인덱스값 증가
			for(int j=0; j<26; j++) {
				alphabet[i][j] = arr[j];
			}
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			char s = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			int temp = 0;
			temp = alphabet[end][s - 'a'];
			
			if(start != 0) {
				temp -= alphabet[start-1][s - 'a'];
			}
			
			sb.append(temp).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
