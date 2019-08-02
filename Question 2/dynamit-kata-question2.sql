BEGIN TRANSACTION;

//Create the table
CREATE TABLE tvprices (
    TVModel VARCHAR,
    DateUpdated TIMESTAMP,
    Price MONEY
);


//INSERTS DATA INTO TABLE//
INSERT INTO tvprices (TVModel, DateUpdated, Price)
VALUES 
('Samsung v100', '2012-02-23 23:00:00', 549.99),
('Sony x300', '2012-05-22 00:00:00', 359.99),
('Samsung v100', '2013-01-22 10:20:00', 359.99),
('Samsung v100', '2013-02-22 00:00:00', 399.99),
('Sony x300', '2013-02-23 00:00:00', 329.99),
('Samsung v100', '2013-02-23 21:30:00', 639.99),
('Sony x300', '2013-05-23 22:00:00', 629.99),
('Sony x300', '2013-05-23 22:00:00', 629.99),
('Samsung z100', '2013-06-11 22:00:00', 879.99);

//Read and list the table
SELECT TVModel, DateUpdated, Price FROM tvprices;

//Read and list the table sorted by date updated
SELECT TVModel, DateUpdated, Price FROM tvprices
ORDER BY DateUpdated DESC;

//Return a unique list of TV Models and the most recent price associated with each model
SELECT * FROM
(SELECT DISTINCT ON (TVModel) 
TVModel, DateUpdated, Price
FROM tvprices
ORDER BY TVModel, DateUpdated DESC) values
ORDER BY DateUpdated DESC;

//Bonus: repeat the last item with a single query
SELECT DISTINCT ON (TVModel) 
TVModel, DateUpdated, Price
FROM tvprices
ORDER BY TVModel, DateUpdated DESC;


COMMIT;
ROLLBACK;