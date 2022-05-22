CREATE TABLE users (
    username varchar (50) PRIMARY KEY NOT NULL,
    password varchar (500) NOT NULL,
    enabled boolean NOT NULL DEFAULT FALSE
);

CREATE TABLE authorities (
    username varchar (50) NOT NULL,
    authority varchar (50) NOT NULL,
    CONSTRAINT fk_authority_users FOREIGN KEY (username) REFERENCES users (username) ON DELETE CASCADE
);
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

CREATE TABLE user_information (
    id uuid PRIMARY KEY,
    username varchar (50) UNIQUE NOT NULL REFERENCES users (username) ON DELETE CASCADE,
    first_name varchar (63) NOT NULL,
    last_name varchar (63) NOT NULL,
    email varchar (255) NOT NULL
);

CREATE TABLE customers (
    id uuid PRIMARY KEY,
    user_id uuid UNIQUE NOT NULL REFERENCES user_information (id) ON DELETE CASCADE
);


CREATE TABLE auth_log (
    id uuid PRIMARY KEY,
    username varchar(50) NOT NULL REFERENCES users (username) ON DELETE CASCADE,
    log_time timestamp NOT NULL DEFAULT now(),
    log_action varchar (32) NOT NULL
);

-- admin password is StrongPassword
INSERT INTO users (username, password, enabled)
    VALUES
    ('admin', '$2a$12$c3dUM4Wws7E9umjkWgDiVuxr/SQ657sBJW6TEnGqBdlgAEGBuz.Iq', true);

INSERT INTO authorities (username, authority)
    VALUES
    ('admin', 'ROLE_ADMIN');

