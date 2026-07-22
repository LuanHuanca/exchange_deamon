CREATE DATABASE IF NOT EXISTS exchange_db;
USE exchange_db;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    currency_code VARCHAR(10) NOT NULL,
    official_rate DECIMAL(12, 5) NOT NULL,
    buy_rate DECIMAL(12, 5) NOT NULL,
    sell_rate DECIMAL(12, 5) NOT NULL,
    source VARCHAR(100) NOT NULL,
    rate_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    UNIQUE KEY unique_currency_date (currency_code, rate_date)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;