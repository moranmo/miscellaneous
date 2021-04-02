CREATE TABLE Customer (
  CUST_ID varchar(255)  NOT NULL,
  NAME varchar(255) NOT NULL,
  AGE varchar(255)  NOT NULL,
   )

select * from Customer



GO

CREATE PROCEDURE AddACustomer
AS
BEGIN
INSERT INTO [Customer] (CUST_ID, NAME,AGE) VALUES (2 ,'tom2',12);
END


exec AddACustomer

go

CREATE PROCEDURE addReportColums(@coll NVARCHAR(50)) AS
BEGIN
DECLARE @sql NVARCHAR(MAX)
SET @sql = 'ALTER TABLE dbo.customer ADD ' + @coll + ' VARCHAR(20) NULL'
EXEC(@sql)
END


go;

CREATE TYPE TempType AS TABLE
(TempId   INT, 
 TempName VARCHAR(100)
)

go

CREATE PROCEDURE AddColumnsWtihTVP 
@ParTempType TempType READONLY
AS

DECLARE @name VARCHAR(50) 
DECLARE db_cursor CURSOR FOR 
-- Populate the cursor with your logic
-- * UPDATE WITH YOUR SPECIFIC CODE HERE *
SELECT TempName FROM @ParTempType 


-- Open the Cursor
OPEN db_cursor

-- 3 - Fetch the next record from the cursor
FETCH NEXT FROM db_cursor INTO @name  

-- Set the status for the cursor
WHILE @@FETCH_STATUS = 0  
 
BEGIN  
	-- 4 - Begin the custom business logic
	-- * UPDATE WITH YOUR SPECIFIC CODE HERE *
	DECLARE @sql NVARCHAR(MAX)
	SET @sql = 'ALTER TABLE dbo.customer ADD ' + @name + ' VARCHAR(20) NULL'
	EXEC(@sql)

	-- 5 - Fetch the next record from the cursor
 	FETCH NEXT FROM db_cursor INTO @name 
END 

-- 6 - Close the cursor
CLOSE db_cursor  

-- 7 - Deallocate the cursor
DEALLOCATE db_cursor 


select * from Customer











