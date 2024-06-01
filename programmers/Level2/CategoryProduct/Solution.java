package programmers.Level2.CategoryProduct;

/*
	Question : 다음은 어느 의류 쇼핑몰에서 판매중인 상품들의 정보를 담은 PRODUCT 테이블입니다. 
	PRODUCT 테이블은 아래와 같은 구조로 되어있으며, PRODUCT_ID, PRODUCT_CODE, PRICE는 각각 상품 ID, 상품코드, 판매가를 나타냅니다.

	Column name	Type	Nullable
	PRODUCT_ID	INTEGER	FALSE
	PRODUCT_CODE	VARCHAR(8)	FALSE
	PRICE	INTEGER	FALSE
	상품 별로 중복되지 않는 8자리 상품코드 값을 가지며, 앞 2자리는 카테고리 코드를 의미합니다.
	
	Solution : 1. SUBSTR을 사용할 수도 있지만... LPAD로 왼쪽부터 자름 
*/

public class Solution {
	/* LPAD 버전 */
	SELECT LPAD(PRODUCT_CODE, 2) AS CATEGORY, COUNT(*) AS PRODUCTS
	FROM PRODUCT
	GROUP BY LPAD(PRODUCT_CODE, 2)
	ORDER BY LPAD(PRODUCT_CODE, 2)
	
	/* SUBSTR 버전 */
	SELECT SUBSTR(PRODUCT_CODE, 0, 2) AS CATEGORY, COUNT(*) AS PRODUCTS
	FROM PRODUCT
	GROUP BY SUBSTR(PRODUCT_CODE, 0, 2)
	ORDER BY SUBSTR(PRODUCT_CODE, 0, 2)
}
