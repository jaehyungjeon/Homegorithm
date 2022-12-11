package DoubleArray;

import java.util.*;
import java.io.*;

/*
	Question : <그림 1>과 같이 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.

	예를 들어, 다음과 같이 81개의 수가 주어지면
	
	 	1열	2열	3열	4열	5열	6열	7열	8열	9열
	1행	3	23	85	34	17	74	25	52	65
	2행	10	7	39	42	88	52	14	72	63
	3행	87	42	18	78	53	45	18	84	53
	4행	34	28	64	85	12	16	75	36	55
	5행	21	77	45	35	28	75	90	76	1
	6행	25	87	65	15	28	11	37	28	74
	7행	65	27	75	41	7	89	78	64	39
	8행	47	47	70	45	23	65	3	41	44
	9행	87	13	82	38	31	12	29	29	80
	이들 중 최댓값은 90이고, 이 값은 5행 7열에 위치한다.

	input			 
	3 23 85 34 17 74 25 52 65
	10 7 39 42 88 52 14 72 63
	87 42 18 78 53 45 18 84 53
	34 28 64 85 12 16 75 36 55
	21 77 45 35 28 75 90 76 1
	25 87 65 15 28 11 37 28 74
	65 27 75 41 7 89 78 64 39
	47 47 70 45 23 65 3 41 44
	87 13 82 38 31 12 29 29 80
	
	output
	90
	5 7
	
	Solution : 1. 9행 9열로 이루어진 문제에서 라인별로 1차 쪼개고 token으로 2차 쪼갬
			   2. max일때를 찾고 동일한 max일때는 최신화 실시
			   3. StringBuilder로 묶어서 깔끔히 리턴
	
*/

public class Max {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        int max = 0;
        int maxLine = 0;
        int maxCol = 0;
        
        for(int i=0; i<9; i++) {
        	String str = br.readLine(); 
        	StringTokenizer sc = new StringTokenizer(str);
        	for(int j=0; j<9; j++) {
        		int val = Integer.parseInt(sc.nextToken());
        		if(max <= val) {
        			max = val;
        			maxLine = i+1;
        			maxCol = j+1;
        		}
        	}
        }
        
        sb.append(max + "\n");
        sb.append(maxLine + " " + maxCol);
        
        System.out.println(sb.toString());
        
	}
}