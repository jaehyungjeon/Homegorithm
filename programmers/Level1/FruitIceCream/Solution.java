package programmers.Level1.FruitIceCream;

/*
	Question : 상반기 아이스크림 총주문량이 3,000보다 높으면서 아이스크림의 주 성분이 과일인 아이스크림의 맛을 총주문량이 큰 순서대로 조회하는 SQL 문을 작성해주세요.

	Solution : 1. 조인으로 BASE를 구하는 문제
*/

public class Solution {
	SELECT A.FLAVOR
	FROM FIRST_HALF A,
	     ICECREAM_INFO B
	WHERE A.FLAVOR = B.FLAVOR
	AND B.INGREDIENT_TYPE LIKE '%fruit%'
	AND A.TOTAL_ORDER > 3000
	ORDER BY A.TOTAL_ORDER DESC
}
