CREATE TABLE roles (
    id uuid PRIMARY KEY,
    name varchar (255) UNIQUE NOT NULL
);

CREATE TABLE user_credentials (
    id uuid PRIMARY KEY,
    username varchar (255) UNIQUE NOT NULL,
    password_hash char (60) NOT NULL,
    role_id uuid REFERENCES roles (id) NOT NULL,
    first_name varchar (63) NOT NULL,
    last_name varchar (63) NOT NULL,
    email varchar (255) NOT NULL
);

CREATE TABLE customers (
    id uuid PRIMARY KEY,
    credential_id uuid REFERENCES user_credentials (id) UNIQUE NOT NULL
);

CREATE TABLE address (
    id uuid PRIMARY KEY,
    customer_id uuid REFERENCES customers (id),
    street text NOT NULL,
    suburb varchar (255) NOT NULL,
    state varchar (255) NOT NULL,
    postcode varchar (7) NOT NULL,
    country varchar (255) NOT NULL
);

