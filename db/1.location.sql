use projectdb

create table location (id int PRIMARY KEY,code varchar(20),name varchar(20),type varchar(10))

select * from location

drop table location

ALTER TABLE CMS_USER_CLAIM_TRANSACTION_DETAILS
ADD COLUMN STATUS int(2) AFTER IS_USER_COMMIT;

ALTER TABLE CMS_USER_CLAIM_TRANSACTION_DETAILS MODIFY STATUS VARCHAR(20);