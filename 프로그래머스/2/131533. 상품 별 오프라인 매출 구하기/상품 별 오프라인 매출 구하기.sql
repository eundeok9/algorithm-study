SELECT P.PRODUCT_CODE, SUM(P.PRICE * S.SALES_AMOUNT) AS SALES
FROM PRODUCT AS P, OFFLINE_SALE AS S
WHERE P.PRODUCT_ID = S.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE;