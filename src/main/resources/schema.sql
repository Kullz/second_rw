CREATE TABLE STATION (
  ID INT NOT NULL AUTO_INCREMENT
  ,VERSION INT NOT NULL DEFAULT 0
  ,STATION_NAME VARCHAR(60) NOT NULL
  ,LATITUDE INT
  ,LONGITUDE INT
  ,UNIQUE UQ_STATION_1 (STATION_NAME, ID)
  ,PRIMARY KEY (ID)
);

CREATE TABLE TIME_TABLE(
  STATION_ID INT NOT NULL
  ,DEPARTURE_TIME TIMESTAMP NOT NULL
  ,UNIQUE UQ_TIME_TABLE_1 (STATION_ID, DEPARTURE_TIME)
  ,CONSTRAINT FK_TIME_TABLE_1 FOREIGN KEY (STATION_ID) REFERENCES STATION (ID)
);

CREATE TABLE TRAIN(
  ID_TRAIN_NUMBER INT NOT NULL AUTO_INCREMENT
  ,VERSION INT NOT NULL DEFAULT 0
  ,AVAILABLE_SEATS INT NOT NULL
  ,PRIMARY KEY (ID_TRAIN_NUMBER)
);

CREATE TABLE TRAIN_ROUTE(
  TRAIN_ID INT NOT NULL
  ,STATION_ID INT NOT NULL
  ,UNIQUE UQ_TRAIN_ROUTE_1 (TRAIN_ID, STATION_ID)
  ,CONSTRAINT FK_TRAIN_ROUTE_1 FOREIGN KEY (STATION_ID) REFERENCES STATION(ID)
  ,CONSTRAINT FK_TRAIN_ROUTE_2 FOREIGN KEY (TRAIN_ID) REFERENCES TRAIN(ID_TRAIN_NUMBER)
);

CREATE TABLE PASSENGER(
  ID INT NOT NULL AUTO_INCREMENT
  ,VERSION INT NOT NULL DEFAULT 0
  , FIRST_NAME VARCHAR(60) NOT NULL
  , LAST_NAME VARCHAR(60) NOT NULL
  , BIRTH_DATE DATE
  , PRIMARY KEY (ID)
  , UNIQUE UQ_PASSENGER_1 (FIRST_NAME, LAST_NAME)
);

CREATE TABLE TICKET(
  ID INT NOT NULL AUTO_INCREMENT
  ,VERSION INT NOT NULL DEFAULT 0
  ,TRAIN_NUMBER INT NOT NULL
  ,PASSENGER_ID INT NOT NULL
  ,UNIQUE UQ_TICKET_1 (TRAIN_NUMBER, PASSENGER_ID)
  ,PRIMARY KEY (ID)
  ,CONSTRAINT FK_TICKET_2 FOREIGN KEY (PASSENGER_ID) REFERENCES PASSENGER(ID)
);