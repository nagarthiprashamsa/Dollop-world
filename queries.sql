-- Validate User Login
SELECT * FROM users WHERE email = ? AND contact = ?;

-- Validate Donor Login
SELECT * FROM donors WHERE demail = ? AND dcontact = ?;

-- Register a New User
INSERT INTO users (oname, foundation, contact, email, address) VALUES (?, ?, ?, ?, ?);

-- Register a New Donor
INSERT INTO donors (dname, demail, dcontact) VALUES (?, ?, ?);

-- Fetch Available Organizations by Type
SELECT oname FROM users WHERE foundation = ?;

-- Insert a New Donation
INSERT INTO donations (dname, oname, item, quantity, donation_time) VALUES (?, ?, ?, ?, NOW());

-- Fetch Donation History
SELECT * FROM donations WHERE dname = ?;
