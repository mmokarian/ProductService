 --------------------------------
 -- Populate tables with data
 --------------------------------
-- populate products
 INSERT INTO product (id,name,description,price) VALUES (1, 'DLink Systems -520B','D-Link helps you connect to more of everything. We offer award-winning networking products and services for home consumers, businesses, and service', 12.99);
 INSERT INTO product (id,name,description,price) VALUES (2, 'Zoom 3095-00-00G','ZoomGuard Advanced Lightning Protection Hardware supports voice mail for computers with sound capability, (voice mail software is required, Windows software provided)', 14.50);
 INSERT INTO product (id,name,description,price) VALUES (3, 'Linksys E1200','The Linksys E1200 offers fast speed and reliable range so you can create a powerful wireless home network. Connect computers, wireless printers', 14.50);
 INSERT INTO product (id,name,description,price) VALUES (4, 'Packard Bell Common Item','Packard Bell Common Item (Packard Bell) Wireless LAN Card Atheros MiniPCI Express 802.11b/g Wireless Lan 04G033054041, AR5BXB63', 10.08);
 INSERT INTO product (id,name,description,price) VALUES (5, 'Packard Bell EasyNote J2801','Packard Bell EasyNote J2801 Various Item Cable for Mainboard to USB Circuit Board', 8.50);

 -- populate user
 INSERT INTO user (id,username,password) VALUES (1,'Maysam Mokarian', 'cGFzc3dvcmQ=');

 -- populate carts
 INSERT INTO cart (userid, productid) VALUES (1,1);
 INSERT INTO cart (userid, productid) VALUES (1,2);

