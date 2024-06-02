package programmers.Level2.IngredientIceCreamOrderCount;

/*
	Question : 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회하는 SQL 문을 작성해주세요. 
	이때 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정해주세요.
	이때 결과는 시간대 순으로 정렬해야 합니다.

	Solution : 1. GROUP BY 활용 및 SUM으로 집계
*/

public class Solution {
	SELECT B.INGREDIENT_TYPE, SUM(A.TOTAL_ORDER) AS TOTAL_ORDER
	FROM FIRST_HALF A, ICECREAM_INFO B
	WHERE A.FLAVOR = B.FLAVOR
	GROUP BY B.INGREDIENT_TYPE
	ORDER BY TOTAL_ORDER
}
