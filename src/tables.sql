drop database  if exists test;
create database test;
CREATE TABLE expense (
                         expenseID INT AUTO_INCREMENT PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         category VARCHAR(255) NOT NULL,
                         amount DOUBLE NOT NULL,
                         dateIncurred DATE NOT NULL
);

CREATE TABLE Income (
                        incomeID INT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        amount DOUBLE NOT NULL,
                        dateIncurred DATE NOT NULL
);