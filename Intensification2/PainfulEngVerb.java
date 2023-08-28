package Intensification2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/*
	Question : 화은이는 이번 영어 시험에서 틀린 문제를 바탕으로 영어 단어 암기를 하려고 한다. 
	그 과정에서 효율적으로 영어 단어를 외우기 위해 영어 단어장을 만들려 하고 있다. 화은이가 만들고자 하는 단어장의 단어 순서는 다음과 같은 우선순위를 차례로 적용하여 만들어진다.

	자주 나오는 단어일수록 앞에 배치한다.
	해당 단어의 길이가 길수록 앞에 배치한다.
	알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
	 
	$M$보다 짧은 길이의 단어의 경우 읽는 것만으로도 외울 수 있기 때문에 길이가 
	$M$이상인 단어들만 외운다고 한다. 화은이가 괴로운 영단어 암기를 효율적으로 할 수 있도록 단어장을 만들어 주자.
	
	input
	7 4
	apple
	ant
	sand
	apple
	append
	sand
	sand
	
	output
	sand
	apple
	append
	
	Solution : 1. 정렬을 이해한다면 쉽게 풀 수 있는 문제였다.
			   2. 맵을 통해 해당 key, value에 대한 정보를 넣고 List로 단어의 순서를 추출한다.
			   3. stream을 이용하여 compare을 시도한다.
   
*/

public class PainfulEngVerb {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			String key = br.readLine();
			if(key.length() >= len) {
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
		}
		
		List<String> verbList = map.keySet().stream().collect(Collectors.toList());
		verbList.sort((o1, o2) -> {
			int first = map.get(o1);
			int second = map.get(o2);
			
			if(first == second) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o2.length() - o1.length();
			}
			
			return second - first; // 자주 나온 순 내림차순
		});
		
		for(String str : verbList) {
			sb.append(str).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
