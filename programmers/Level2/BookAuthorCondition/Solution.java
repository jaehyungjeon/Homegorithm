package programmers.Level2.BookAuthorCondition;

/*
	Question : '경제' 카테고리에 속하는 도서들의 도서 ID(BOOK_ID), 저자명(AUTHOR_NAME), 출판일(PUBLISHED_DATE) 리스트를 출력하는 SQL문을 작성해주세요.
	결과는 출판일을 기준으로 오름차순 정렬해주세요.

	Solution : 1. 조인 문제
*/

public class Solution {
	SELECT A.BOOK_ID, B.AUTHOR_NAME, TO_CHAR(A.PUBLISHED_DATE, 'YYYY-MM-DD') AS PUBLISHED_DATE
	FROM BOOK A, AUTHOR B
	WHERE A.AUTHOR_ID = B.AUTHOR_ID
	AND A.CATEGORY = '경제'
	ORDER BY A.PUBLISHED_DATE
}
