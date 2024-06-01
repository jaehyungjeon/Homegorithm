package programmers.Level2.FindParentGenotype;

/*
	Question : 대장균들은 일정 주기로 분화하며, 분화를 시작한 개체를 부모 개체, 분화가 되어 나온 개체를 자식 개체라고 합니다.
	다음은 실험실에서 배양한 대장균들의 정보를 담은 ECOLI_DATA 테이블입니다. 
	ECOLI_DATA 테이블의 구조는 다음과 같으며, ID, PARENT_ID, SIZE_OF_COLONY, DIFFERENTIATION_DATE, GENOTYPE 은 
	각각 대장균 개체의 ID, 부모 개체의 ID, 개체의 크기, 분화되어 나온 날짜, 개체의 형질을 나타냅니다.
	
	Solution : 1. MY_SQL 전용 문제 -> INNER JOIN으로 구현
*/

public class Solution {
	/* JOIN & CONDITION */
	SELECT A.ID, A.GENOTYPE, B.GENOTYPE AS PARENT_GENOTYPE
	FROM ECOLI_DATA A
	INNER JOIN ECOLI_DATA B
	ON B.ID = A.PARENT_ID
	WHERE A.GENOTYPE & B.GENOTYPE = B.GENOTYPE
	ORDER BY A.ID
}
