package Recursion;

import java.util.*;
import java.io.*;

/*
	Question : 오늘도 서준이는 병합 정렬 수업 조교를 하고 있다. 아빠가 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

	N개의 서로 다른 양의 정수가 저장된 배열 A가 있다. 병합 정렬로 배열 A를 오름차순 정렬할 경우 배열 A에 K 번째 저장되는 수를 구해서 우리 서준이를 도와주자.
	
	크기가 N인 배열에 대한 병합 정렬 의사 코드는 다음과 같다.
	
	merge_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
	    if (p < r) then {
	        q <- ⌊(p + r) / 2⌋;       # q는 p, r의 중간 지점
	        merge_sort(A, p, q);      # 전반부 정렬
	        merge_sort(A, q + 1, r);  # 후반부 정렬
	        merge(A, p, q, r);        # 병합
	    }
	}
	
	# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
	# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
	merge(A[], p, q, r) {
	    i <- p; j <- q + 1; t <- 1;
	    while (i ≤ q and j ≤ r) {
	        if (A[i] ≤ A[j])
	        then tmp[t++] <- A[i++]; # tmp[t] <- A[i]; t++; i++;
	        else tmp[t++] <- A[j++]; # tmp[t] <- A[j]; t++; j++;
	    }
	    while (i ≤ q)  # 왼쪽 배열 부분이 남은 경우
	        tmp[t++] <- A[i++];
	    while (j ≤ r)  # 오른쪽 배열 부분이 남은 경우
	        tmp[t++] <- A[j++];
	    i <- p; t <- 1;
	    while (i ≤ r)  # 결과를 A[p..r]에 저장
	        A[i++] <- tmp[t++]; 
	}

	input			 
	5 7
	4 5 1 3 2
	
	output
	3
	
	Solution : 1. 끝수를 재귀로 탐색
			   2. 주어진 함수를 변형하여 사용
*/

public class AbsorptionSort {
	
	public static int[] tmp, A;
	public static int count = 0;
	public static int result = -1;
	public static int k;
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer sc = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(sc.nextToken());
    	k = Integer.parseInt(sc.nextToken());
    	
    	A = new int[n];
    	sc = new StringTokenizer(br.readLine());
    	
    	for(int i=0; i<n; i++) {
    		A[i] = Integer.parseInt(sc.nextToken());
    	}
    	
    	tmp = new int[n];
    	merge_sort(A, 0, n-1);
    	System.out.println(result);
    }
    
	public static void merge_sort(int[] A, int p, int r) {
		if(count > k) return;
	    if (p < r) {
	        int q = (p + r) / 2;
	        merge_sort(A, p, q);
	        merge_sort(A, q + 1, r);
	        merge(A, p, q, r);
	    }
	}
	
	public static void merge(int[] A, int p, int q, int r) {
		int i = p;
		int j = q+1;
		int t = 0;
	    while (i <= q && j <= r) {
	        if (A[i] <= A[j]) tmp[t++] = A[i++];
	        else tmp[t++] = A[j++];
	    }
	    while (i <= q) 
	        tmp[t++] = A[i++];
	    while (j <= r)
	        tmp[t++] = A[j++];
	    	i = p;
	    	t = 0;
	    while (i <= r) {
	    	count++;
	    	if(count == k) {
	    		result = tmp[t];
	    		break;
	    	}
	    	
	        A[i++] = tmp[t++]; 
	    }
	}
}