package Sort;

import java.util.*;
import java.io.*;

/*
	Question : 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

	길이가 짧은 것부터
	길이가 같으면 사전 순으로

	input			 
	13
	but
	i
	wont
	hesitate
	no
	more
	no
	more
	it
	cannot
	wait
	im
	yours
	
	output
	i
	im
	it
	no
	but
	more
	wait
	wont
	yours
	cannot
	hesitate
	
	Solution : 1. HashSet을 활용한 중복제거 담기
			   2. compare 정렬 이용 -> 길이가 같지 않으면 길이순, 같으면 문자열 순 비교
*/

public class WordSort {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashSet<String> strSet = new HashSet<String>();
		int count = Integer.parseInt(br.readLine());
		for(int i=0; i<count; i++) {
			strSet.add(br.readLine());
		}
		
		List<String> strList = new ArrayList<>(strSet);
		Collections.sort(strList, (o1, o2) -> {
			int firstLen = o1.toString().length();
			int secondLen = o2.toString().length();
			if(firstLen != secondLen) {
				return Integer.compare(firstLen, secondLen);
			} else {
				return o1.compareTo(o2);
			}
		});
		
		while(!strList.isEmpty()) {
			if(strList.size() == 1) {
				sb.append(strList.get(0));
			} else {
				sb.append(strList.get(0) + "\n");
			}
			strList.remove(0);
		}
		
		System.out.println(sb.toString());
	}
}