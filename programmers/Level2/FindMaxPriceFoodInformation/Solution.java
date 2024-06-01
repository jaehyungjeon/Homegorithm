package programmers.Level2.FindMaxPriceFoodInformation;

/*
	Question : FOOD_PRODUCT 테이블에서 가격이 제일 비싼 식품의 식품 ID, 식품 이름, 식품 코드, 식품분류, 식품 가격을 조회하는 SQL문을 작성해주세요.
	
	Solution : 1. ROWNUM으로 구함.
*/

public class Solution {
	SELECT *
	FROM (SELECT *
	      FROM FOOD_PRODUCT
	      ORDER BY PRICE DESC
	) T
	WHERE ROWNUM = 1
}
