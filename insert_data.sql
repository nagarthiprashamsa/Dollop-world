-- Insert Sample Users (Organizations)
INSERT INTO users (oname, foundation, contact, email, address) VALUES
('Helping Hands', 'Orphanage', '9876543210', 'helpinghands@example.com', '123 Street, City'),
('Elder Care', 'Old Age Home', '8765432109', 'eldercare@example.com', '456 Avenue, City');

-- Insert Sample Donors
INSERT INTO donors (dname, demail, dcontact) VALUES
('John Doe', 'johndoe@example.com', '1234567890'),
('Jane Smith', 'janesmith@example.com', '2345678901');

-- Insert Sample Donations
INSERT INTO donations (dname, oname, item, quantity) VALUES
('John Doe', 'Helping Hands', 'Blankets', 10),
('Jane Smith', 'Elder Care', 'Groceries', 5);
