package programmers.Level1.MostExpensivePriceGoods;

/*
	Question : PRODUCT 테이블에서 판매 중인 상품 중 가장 높은 판매가를 출력하는 SQL문을 작성해주세요. 이때 컬럼명은 MAX_PRICE로 지정해주세요.
	
	Solution : 1. ROWNUM 활용
*/

public class Solution {
	SELECT T.PRICE AS MAX_PRICE
	FROM (SELECT PRICE
	      FROM PRODUCT
	      ORDER BY PRICE DESC
	) T
	WHERE ROWNUM = 1
}
