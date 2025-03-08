-- Create Database
CREATE DATABASE IF NOT EXISTS organization;
USE organization;

-- Create Users Table (For Organizations)
CREATE TABLE users (
    uid INT AUTO_INCREMENT PRIMARY KEY,
    oname VARCHAR(100) NOT NULL,
    foundation VARCHAR(100),
    contact VARCHAR(15) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    address VARCHAR(255)
);

-- Create Donors Table
CREATE TABLE donors (
    did INT AUTO_INCREMENT PRIMARY KEY,
    dname VARCHAR(100) NOT NULL,
    demail VARCHAR(100) NOT NULL UNIQUE,
    dcontact VARCHAR(15) NOT NULL UNIQUE
);

-- Create Donations Table
CREATE TABLE donations (
    donation_id INT AUTO_INCREMENT PRIMARY KEY,
    dname VARCHAR(100),
    oname VARCHAR(100),
    item VARCHAR(100),
    quantity INT,
    donation_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
