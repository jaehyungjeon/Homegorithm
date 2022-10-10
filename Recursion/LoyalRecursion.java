package Recursion;

import java.util.*;
import java.io.*;

/*
	Question : 정휘는 후배들이 재귀 함수를 잘 다루는 재귀의 귀재인지 알아보기 위해 재귀 함수와 관련된 문제를 출제하기로 했다.

	팰린드롬이란, 앞에서부터 읽었을 때와 뒤에서부터 읽었을 때가 같은 문자열을 말한다. 팰린드롬의 예시로 AAA, ABBA, ABABA 등이 있고, 팰린드롬이 아닌 문자열의 예시로 ABCA, PALINDROME 등이 있다.

	어떤 문자열이 팰린드롬인지 판별하는 문제는 재귀 함수를 이용해 쉽게 해결할 수 있다. 아래 코드의 isPalindrome 함수는 주어진 문자열이 팰린드롬이면 1, 팰린드롬이 아니면 0을 반환하는 함수다.
	
	#include <stdio.h>
	#include <string.h>
	
	int recursion(const char *s, int l, int r){
	    if(l >= r) return 1;
	    else if(s[l] != s[r]) return 0;
	    else return recursion(s, l+1, r-1);
	}
	
	int isPalindrome(const char *s){
	    return recursion(s, 0, strlen(s)-1);
	}
	
	int main(){
	    printf("ABBA: %d\n", isPalindrome("ABBA")); // 1
	    printf("ABC: %d\n", isPalindrome("ABC"));   // 0
	}
	정휘는 위에 작성된 isPalindrome 함수를 이용하여 어떤 문자열이 팰린드롬인지 여부를 판단하려고 한다.
	
	구체적으로는, 문자열 $S$를 isPalindrome 함수의 인자로 전달하여 팰린드롬 여부를 반환값으로 알아낼 것이다. 더불어 판별하는 과정에서 recursion 함수를 몇 번 호출하는지 셀 것이다.
	
	정휘를 따라 여러분도 함수의 반환값과 recursion 함수의 호출 횟수를 구해보자.

	input			 
	5
	AAA
	ABBA
	ABABA
	ABCA
	PALINDROME
	
	output
	1 2
	1 3
	1 3
	0 2
	0 1
	
	Solution : 주어진 팰린드롬 함수 사용, 리턴을 String으로 바꾸어 합산한 cnt까지 함께 리턴하는 것으로 변경
*/

public class LoyalRecursion {
	
    public static String recursion(String s, int l, int r, int cnt){
    	StringBuilder sb = new StringBuilder();
    	cnt++;
    	
        if(l >= r) {
        	sb.append(1 + " " + cnt);
        	return sb.toString();
        }
        else if(s.charAt(l) != s.charAt(r)) {
        	sb.append(0 + " " + cnt);
        	return sb.toString();
        }
        else return recursion(s, l+1, r-1, cnt);
    }
    
    public static String isPalindrome(String s, int cnt){
        return recursion(s, 0, s.length()-1, cnt);
    }
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int count = Integer.parseInt(br.readLine());
    	
    	for(int i=0; i<count; i++) {
    		String str = br.readLine();
    		int cnt = 0;
    		System.out.println(isPalindrome(str, cnt));
    	}
    }
}