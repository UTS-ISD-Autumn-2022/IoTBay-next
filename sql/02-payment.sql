CREATE TABLE payment_Option (
    id uuid PRIMARY KEY,
    customer_id uuid REFERENCES customers (id)
    
);
Create TABLE CARD_PAYEMNT (
    id uuid PRIMARY KEY,
    card_name varchar (255) NOT NULL,
    card_number varchar (16) NOT NULL,
    card_cvc varchar (3) NOT NULL,
    card_expiry_month varchar (2) NOT NULL,
    card_expiry_year varchar (4) NOT NULL,

    FOREIGN KEY (id) REFERENCES payment_option (id)
    );

CREATE TABLE BANK_PAYMENT(
    id uuid PRIMARY KEY,
    BANK_NAME varchar (255) NOT NULL,
    BANK_ACCOUNT_NUMBER varchar (9) NOT NULL,
    BSB_NUMBER varchar (6) NOT NULL,

    FOREIGN KEY (id) REFERENCES payment_option (id)
);

