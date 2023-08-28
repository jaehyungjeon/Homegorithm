package Intensification2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
	Question : 총총이는 친구 곰곰이의 소개로 제2회 곰곰컵에 출연할 기회를 얻었다!
	총총이는 자신의 묘기인 무지개 댄스를 선보여, 여러분의 환심을 사려 한다. 이 댄스는 중독성이 강하기 때문에, 한번 보게 된 사람은 모두 따라 하게 돼버린다.
	무지개 댄스를 추는 총총 2마리 사람들이 만난 기록이 시간 순서대로 $N$개 주어진다. (총총이는 토끼이지만 이 문제에서는 편의상 사람이라고 가정한다.)
	
	무지개 댄스를 추지 않고 있던 사람이 무지개 댄스를 추고 있던 사람을 만나게 된다면, 만난 시점 이후로 무지개 댄스를 추게 된다.
	기록이 시작되기 이전 무지개 댄스를 추고 있는 사람은 총총이 뿐이라고 할 때, 마지막 기록 이후 무지개 댄스를 추는 사람이 몇 명인지 구해보자!
	
	input
	12
	bnb2011 chansol
	chansol chogahui05
	chogahui05 jthis
	jthis ChongChong -- 2
	jthis jyheo98
	jyheo98 lms0806
	lms0806 pichulia
	pichulia pjshwa
	pjshwa r4pidstart
	r4pidstart swoon
	swoon tony9402
	tony9402 bnb2011
	
	output
	10
	
	Solution : 1. 처음에 총총이가 들어가있는걸 가정하므로 set에 넣어줌.
			   2. 리스트에 들어있으면 계속 set에 추가해준다.
	   
*/

public class ChongChongi {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		set.add("ChongChong");
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String per1 = st.nextToken();
			String per2 = st.nextToken();
			
			if(set.contains(per1) || set.contains(per2)) {
				set.add(per1);
				set.add(per2);
			}
		}
		
		br.close();
		
		System.out.println(set.size());
	}

}
