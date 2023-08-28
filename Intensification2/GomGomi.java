package Intensification2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
	Question : 알고리즘 입문방 오픈 채팅방에서는 새로운 분들이 입장을 할 때마다 곰곰티콘을 사용해 인사를 한다. 
	이를 본 문자열 킬러 임스는 채팅방의 기록을 수집해 그 중 곰곰티콘이 사용된 횟수를 구해 보기로 했다.

	ENTER는 새로운 사람이 채팅방에 입장했음을 나타낸다. 그 외는 채팅을 입력한 유저의 닉네임을 나타낸다. 닉네임은 숫자 또는 영문 대소문자로 구성되어 있다.
	
	새로운 사람이 입장한 이후 처음 채팅을 입력하는 사람은 반드시 곰곰티콘으로 인사를 한다. 그 외의 기록은 곰곰티콘을 쓰지 않은 평범한 채팅 기록이다.
	
	채팅 기록 중 곰곰티콘이 사용된 횟수를 구해보자!
	
	input
	9
	ENTER
	pjshwa
	chansol
	chogahui05
	lms0806
	pichulia
	r4pidstart
	swoon
	tony9402
	
	output
	8
	
	Solution : 1. HashSet을 리스트형식으로 만들어서 Enter일 경우에는 새롭게 Set을 추가해준다.
			   2. 선언한 Set에 값을 넣어주고 리스트의 사이즈만큼 for문을 돌린다.
			   3. 돌린 for문의 size를 계속 더해준다.
		   
*/

public class GomGomi {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int idx = -1;
		int answer = 0;
		List<HashSet<String>> list = new ArrayList<>();
		
		while(N-- > 0) {
			String str = br.readLine();
			if(str.equals("ENTER")) {
				list.add(new HashSet<>());
				idx += 1;
			} else {
				list.get(idx).add(str);
			}
		}
		
		for(HashSet<String> t : list) {
			answer += t.size();
		}
		
		System.out.println(answer);
		
	}

}
