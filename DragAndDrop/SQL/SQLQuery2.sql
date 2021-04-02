CREATE TABLE POS_TBL (
		pos_id numeric(10)  NOT NULL IDENTITY (1,1),
		panel_name varchar(20) NOT NULL,
		pos_xo numeric(20) NOT NULL,
		pos_yo numeric(20) NOT NULL,
		pos_x1 numeric(20) NOT NULL,
		pos_y1 numeric(20) NOT NULL,
	PRIMARY KEY (pos_id)
	)

	

	INSERT INTO POS_TBL (panel_name, pos_xo, pos_yo, pos_x1, pos_y1)
VALUES ('city', 50, 10, 50, 10);

	CREATE TABLE CUST_TBL (
		 customer_id numeric(10)  NOT NULL IDENTITY (1,1),
		 email varchar(45) NOT NULL,
		 first_name varchar(45) NOT NULL,
		 last_name varchar(45) NOT NULL,
		 age numeric(11) NOT NULL,
	PRIMARY KEY (customer_id)
	   )


	   select * from POS_TBL

