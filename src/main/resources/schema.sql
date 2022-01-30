-- DROP TABLE IF EXISTS C_CARD;
--
-- CREATE TABLE C_CARD (
--                         customer_number INT AUTO_INCREMENT PRIMARY KEY ,
--         card_number VARCHAR(20) NOT NULL ,
--         pan_number VARCHAR(20) ,
--         issued_date DATE
-- )

DROP TABLE IF EXISTS TABLE_KEY;

CREATE TABLE TABLE_KEY (
                          key_id INT AUTO_INCREMENT PRIMARY KEY ,
                          key_column VARCHAR(20),
                          key_value INT
)