(select cart_id from cart_products where name = 'Milk')
intersect
(select cart_id from cart_products where name = 'Yogurt');