package programmers.Level1.ClosedCharacter;

/*
	Question : 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
	예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.
	
	b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
	a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
	n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
	a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
	n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
	a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
	따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.
	
	문자열 s이 주어질 때, 위와 같이 정의된 연산을 수행하는 함수 solution을 완성해주세요.
	
	Solution : 1. lastIndexOf를 사용하여 일치하는 것이 없을 경우 -1로 반환해준다는 것을 활용하면 쉽다.
			   2. 중복되는 글자가 없을 경우에는 해당 인덱스에서 시작지점만큼의 거리를 차감해준다.
			   3. 그렇지 않을 경우, lastIndexOf 값인 -1을 넣는다.
			   4. 시작시에는 무조건 -1값을 넣는다.
*/

public class Solution {
	
	public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++) {
        	if(i != 0) {
        		int index = s.substring(0,i).lastIndexOf(s.charAt(i));
        		if(index != -1) {
        			answer[i] = i - index;
        		} else {
        			answer[i] = index;
        		}
        	} else {
        		answer[i] = -1;
        	}
        }

        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "banana";
		System.out.println(sol.solution(s));
	}
}
