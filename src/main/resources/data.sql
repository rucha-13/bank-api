INSERT INTO Customer(customer_id, name, date_of_birth,nationality,email_address,address) VALUES 
(1, 'John Doe', '1990-09-15','SAUDI','user1@leantech.me','1 National Arabic'),
(2, 'Jene Bloggs', '1987-09-22','BRITISH','user2@leantech.me','140 Tabemacle street'),
(3, 'Mike Smith', '1995-02-07','AMERICAN','user3@leantech.me','20045 Ocean Drive, CA')
;
INSERT INTO Account(account_id,CUSTOMER_CUSTOMER_ID  
,type,account_number,iban,status,balance,currency_code) VALUES(1,3,'Savings',789654123051,'SA00000078965412','ACTIVE',123.56,'SAR'),
(2,1,'Checking',789654123052,'SA00000078965412','CLOSED',0,'GBP'),
(3,2,'Deposit',789654123053,'SA00000078965412','ACTIVE',6578.21,'GBP');

INSERT INTO Transaction
(transaction_id,ACCOUNT_ACCOUNT_ID,type,description,amount,currency_code,timestamp) VALUES
(1,1,'Transfer','Transfer from Saving',33.256,'BHD','2020-05-01 11:37:45'),
(2,1,'Transfer','Transfer from Another',11.99,'SAR','2020-05-01 12:44:03'),
(3,1,'Card Payment','Amazon',-3.68,'SAR','2020-04-22 11:12:59'),
(4,1,'Card Payment','McDonalds',-11.58,'SAR','2020-04-30 19:25:45'),
(5,2,'Direct Debit','Utility Payment',-180,'GBP','2020-06-11 01:55:01'),
(6,3,'Refund','Return of Clothing',56,'CHF','2008-01-25 6:28:31'),
(7,3,'Transfer','Transfer from Saving',1000.45,'CHF','2020-05-01 11:37:45');

INSERT INTO Token
(TOKEN_ID,TOKEN_VALUE ) values(1,'sdf79a8sd7f79adf'),(2,'45kh2345jh245hhk'),(3,'adf098adsfa098ss');
