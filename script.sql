CREATE TABLE private.tb_delivery (

	
	delivery_id serial PRIMARY key ,
	
    account_id numeric ,
	
	account_name varchar(50),

    order_id varchar(50),

    seller_id numeric, 

    seller_name varchar(50),

    gruide_number varchar(50),

    tracking_url varchar(300),

    download_date date); 

    

CREATE TABLE private.tb_delivery_state (

    delivery_state_id serial PRIMARY key ,

    account_id numeric ,
	
	account_name varchar(50),
	
    order_id varchar(50),
	
	seller_name varchar(50),
	
    gruide_number varchar(50),

    tracking_url varchar(300),

    state varchar(50),

    description text,

    download_date date);     



CREATE TABLE private.tb_delivery_evidence (
	Delivery_Evidence_Id serial PRIMARY key ,

    delivery_state_id numeric,

    evidence_url text,

    download_date date);      