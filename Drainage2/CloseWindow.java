package Drainage2;

/*
	Question : 골드바흐의 추측: 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다.
	
	짝수 N을 두 소수의 합으로 나타내는 표현을 골드바흐 파티션이라고 한다. 짝수 N이 주어졌을 때, 골드바흐 파티션의 개수를 구해보자. 두 소수의 순서만 다른 것은 같은 파티션이다.
	
	input
	5
	6
	8
	10
	12
	100
	
	output
	1
	1
	2
	1
	6
	
	Solution : 1. 로직 헷갈려서 답안 참고.
			   2. 소수를 boolean 배열에 넣는 로직은 결국 sqrt를 이용하여 구하는 것과 동일한 로직이다.(반복문의 횟수를 줄여줌)
			   3. 중앙 인덱스를 기준으로 끝과 끝의 값을 더했을 때, 값이 일치하면 되는 것이므로 사이즈 값을 구해준다.
			   4. 사이즈 값 자체를 리턴시켜준다.

*/

public class CloseWindow {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	}

}
