DROP TABLE IF EXISTS customer cascade;
CREATE TABLE customer
(
    id     	serial,
    firstName       VARCHAR(45),
    lastName        VARCHAR(45),
    email           VARCHAR(45),
    password        VARCHAR(45)

    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS flight cascade;
CREATE TABLE flight
(
    id        Serial,
	departure_city VARCHAR(45),
	arrival_city  VARCHAR(45),
    departure_date   VARCHAR(45) ,
    arrival_date     VARCHAR(45),
	buissness_class_fare    varchar(45),
	economic_class_fare     varchar(45),
    updatedAt		TIMESTAMP DEFAULT 'now'::timestamp,
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS reservation cascade;
CREATE TABLE Reservation
(
    id   serial,
    flightID        int,
	customerID     		int,
    flight_class     VARCHAR(45),
    updatedAT      TIMESTAMP DEFAULT 'now'::timestamp,
    
    PRIMARY KEY(id),
    FOREIGN KEY(flightID) REFERENCES Flight(id) 
    ON DELETE CASCADE,
    FOREIGN KEY(customerID) REFERENCES customer(id)
    ON DELETE CASCADE
);
