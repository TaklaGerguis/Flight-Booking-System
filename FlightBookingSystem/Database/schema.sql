DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer
(
    customerID     	serial,
    firstName       VARCHAR(45),
    lastName        VARCHAR(45),
    email           VARCHAR(45),
    password        VARCHAR(45),
    age             INT,

    PRIMARY KEY(customerID)
);

DROP TABLE IF EXISTS Airport;
CREATE TABLE Airport
(
    code	      	VARCHAR(45),
    name         	VARCHAR(45),
    city         	VARCHAR(45),
    country         VARCHAR(45), 
    PRIMARY KEY(code)
);

DROP TABLE IF EXISTS Flight;
CREATE TABLE Flight
(
    flightID        Serial,
	departurePortCode VARCHAR(45),
	arrivalPortCode  VARCHAR(45),
    departureTime   TIME DEFAULT '00:00:00',
    departureDate   DATE ,
    arrivalTime     TIME DEFAULT '00:00:00',
    arrivalDate     DATE,
	flightClass     VARCHAR(45),
	flightPrice     VARCHAR(45),
    updatedAt		TIMESTAMP DEFAULT 'now'::timestamp,
    PRIMARY KEY(flightID),
	FOREIGN KEY(departurePortCode) REFERENCES Airport(code) 
    ON DELETE CASCADE,
	FOREIGN KEY(arrivalPortCode) REFERENCES Airport(code) 
    ON DELETE CASCADE
);



DROP TABLE IF EXISTS Booking;
CREATE TABLE Booking
(
    ticketID        serial,
    flightID        INT,
    seatNum         VARCHAR(45),
    class           VARCHAR(45),
    customerID     		INT,
    updatedAt		TIMESTAMP DEFAULT 'now'::timestamp,
    
    
    PRIMARY KEY(ticketID),
    FOREIGN KEY(flightID) REFERENCES Flight(flightID) 
    ON DELETE CASCADE,
    FOREIGN KEY(customerID) REFERENCES Customer(customerID)
    ON DELETE CASCADE
);

