DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS transactions;
 
CREATE TABLE cards (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  card_number VARCHAR(16) NOT NULL,
  availabe_amount DECIMAL
  
);

CREATE TABLE transactions (
	id INT AUTO_INCREMENT  PRIMARY KEY,
    date_transaction TIMESTAMP,
    amount DECIMAL
);

ALTER TABLE cards
ADD FOREIGN KEY ()transaction_id) REFERENCES transactions(id)

 
INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');