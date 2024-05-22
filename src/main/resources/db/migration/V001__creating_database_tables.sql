-- Create users table
CREATE TABLE users (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    email_id VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(72) NOT NULL,
    date_of_birth DATE,
    status ENUM('PENDING_APPROVAL', 'APPROVED', 'DEACTIVATED') NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create deposit_accounts table
CREATE TABLE deposit_accounts (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    balance DECIMAL(19, 4) NOT NULL,
    user_id BINARY(16) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create residential_addresses table
CREATE TABLE residential_addresses (
    id BINARY(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    user_id BINARY(16) NOT NULL,
    street_address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    postal_code VARCHAR(10) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create transactions table
CREATE TABLE transactions (
    id BIGINT(16) PRIMARY KEY DEFAULT (UUID_TO_BIN(UUID())),
    type ENUM('DEPOSIT', 'WITHDRAW') NOT NULL,
    currency ENUM('USD') NOT NULL,
    amount DECIMAL(19, 4) NOT NULL,
    deposit_account_id BINARY(16) NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (deposit_account_id) REFERENCES deposit_accounts(id)
);
CREATE TABLE client (
    id BIGINT(16) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    delivery_address VARCHAR(255),
    document VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255),
    phone VARCHAR(255)
);

-- Create product table
CREATE TABLE product (
    id BIGINT(16) PRIMARY KEY AUTO_INCREMENT,
    available BOOLEAN NOT NULL,
    category TINYINT NOT NULL CHECK (category BETWEEN 0 AND 6),
    description VARCHAR(255) NOT NULL,
    fantasy_name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    uuid VARCHAR(255) NOT NULL
);
-- Create order table
CREATE TABLE orders (
    id BIGINT(16) PRIMARY KEY AUTO_INCREMENT,
    client_document VARCHAR(255) NOT NULL,
    creation_date_time DATETIME(6) NOT NULL,
    delivered BOOLEAN,
    delivered_date DATETIME(6),
    extra_information VARCHAR(511) NOT NULL,
    grand_total DOUBLE NOT NULL,
    product_uuid VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    sub_total DOUBLE NOT NULL,
    tax DOUBLE NOT NULL,
    uuid VARCHAR(255) NOT NULL
);

