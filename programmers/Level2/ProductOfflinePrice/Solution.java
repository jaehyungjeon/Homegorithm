package programmers.Level2.ProductOfflinePrice;

/*
	Question : PRODUCT 테이블과 OFFLINE_SALE 테이블에서 상품코드 별 매출액(판매가 * 판매량) 합계를 출력하는 SQL문을 작성해주세요. 
	결과는 매출액을 기준으로 내림차순 정렬해주시고 매출액이 같다면 상품코드를 기준으로 오름차순 정렬해주세요.

	Solution : 1. 서브쿼리 고민했으나, 단순하게 집계함수로 구할 수 있었다.
			   2. GROUP BY로 묶어주는 코드별로 SUM을 구한다.
*/

public class Solution {
	SELECT A.PRODUCT_CODE, SUM(A.PRICE * B.SALES_AMOUNT) AS SALES
	FROM PRODUCT A, OFFLINE_SALE B
	WHERE A.PRODUCT_ID = B.PRODUCT_ID
	GROUP BY A.PRODUCT_CODE
	ORDER BY SALES DESC, A.PRODUCT_CODE
}
