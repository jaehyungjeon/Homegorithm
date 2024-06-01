package programmers.Level1.UsedTradeReview;

/*
	Question : USED_GOODS_BOARD와 USED_GOODS_REPLY 테이블에서 2022년 10월에 작성된 
	게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문을 작성해주세요. 
	
	결과는 댓글 작성일을 기준으로 오름차순 정렬해주시고, 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬해주세요.
	
	Solution : 1. 조건을 잘 맞춰주면 되는 문제
*/

public class Solution {
	SELECT A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, B.CONTENTS, TO_CHAR(B.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE
	FROM USED_GOODS_BOARD A,
	     USED_GOODS_REPLY B
	WHERE A.BOARD_ID = B.BOARD_ID
	AND TO_CHAR(A.CREATED_DATE, 'YYYYMM') = '202210'
	ORDER BY B.CREATED_DATE, A.TITLE
}
