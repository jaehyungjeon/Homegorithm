package programmers.Level1.SpecialGenotype;

/*
	Question : 2번 형질이 보유하지 않으면서 1번이나 3번 형질을 보유하고 있는 대장균 개체의 수(COUNT)를 출력하는 SQL 문을 작성해주세요.
	1번과 3번 형질을 모두 보유하고 있는 경우도 1번이나 3번 형질을 보유하고 있는 경우에 포함합니다.
	
	Solution : 1. MY_SQL 전용 문제
			   2. &로 2진 계산으로 구하면 빠르게 구현할 수 있는 문제
*/

public class Solution {
	SELECT COUNT(*) AS COUNT
	FROM ECOLI_DATA
	WHERE (GENOTYPE & 2) = 0
	AND (GENOTYPE & 1 > 0 OR GENOTYPE & 4 > 0)
}
