INSERT INTO ITEM (ITEM_ID, ITEM_DESCRIPTION)
VALUES
('abcd','item description 1'),
('efgh','item description 2'),
('lmno','item description 3'),
('pqrs','item description 4');

INSERT INTO AUCTION (AUCTION_ITEM_ID,CURRENT_BID,MAX_AUTO_BID_AMT,RESERVE_PRICE,BIDDER_NAME,ITEM_ID)
VALUES
(100, 12.45,2.35,10.00,'John Doe','abcd'),
(101, 20.75,22.82,18.00,'Jill Yves','efgh'),
(102, 45.75,39.45,50.00,'Brian Llyod','lmno'),
(103, 55.20,22.15,65.00,'Chris James','pqrs');