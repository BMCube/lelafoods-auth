USE `bmcube_gateway`;

LOCK TABLES `Customer` WRITE;
INSERT INTO `Customer` VALUES ('EN302',2,3);
UNLOCK TABLES;

LOCK TABLES `DeliveryManager` WRITE;
INSERT INTO `DeliveryManager` VALUES (5);
UNLOCK TABLES;

LOCK TABLES `RestaurantManager` WRITE;
INSERT INTO `RestaurantManager` VALUES (4);
UNLOCK TABLES;

LOCK TABLES `User_roles` WRITE;
INSERT INTO `User_roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_CUSTOMER'),(4,'ROLE_RESTAURANT_MANAGER'),(5,'ROLE_DELIVERY_MANAGER');
UNLOCK TABLES;

LOCK TABLES `address` WRITE;
INSERT INTO `address` VALUES (3,'Batavia','USA','52533','1009 3rd St,');
UNLOCK TABLES;

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'George','Cannon','','$2a$10$KYAJ2KNZnqUV4vDU5GUgu.FzUBHiVFeAeUVeMptsTLpPzcqUHigQ2','admin@lelafoods.com'),(2,'Peter','Crews','','$2a$10$IRH2JfD2wS0rS71esQX.mOWT/5wCt8xse7rEE7Hw/KulGRw.IX2dm','customer@lelafoods.com'),(4,'Restaurant','Manager','','$2a$10$M9OZJiUd9FEwXA1r5UcB4.tzhGS3.bcfjnVyhkTKsVDJHddlbx2E6','rman@lelafoods.com'),(5,'Delivery','Manager','','$2a$10$XWJL.ZaFGzlA8dF0IiyriehwaNBu4QkWOjNYti5zWYM9otgKvldUG','dman@lelafoods.com');
UNLOCK TABLES;
