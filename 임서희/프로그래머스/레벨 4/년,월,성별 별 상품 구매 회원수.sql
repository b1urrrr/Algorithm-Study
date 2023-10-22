SELECT YEAR(O.SALES_DATE) AS YEAR, MONTH(O.SALES_DATE) AS MONTH, U.GENDER, COUNT(DISTINCT U.USER_ID) AS USERS
FROM USER_INFO U JOIN ONLINE_SALE O ON U.USER_ID = O.USER_ID
WHERE U.GENDER IS NOT NULL
GROUP BY YEAR(O.SALES_DATE), MONTH(O.SALES_DATE), U.GENDER
ORDER BY YEAR(O.SALES_DATE) ASC, MONTH(O.SALES_DATE) ASC, U.GENDER ASC;