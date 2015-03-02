CREATE TABLE Dissagregation_Dictionary
(
Dissag_Id int NOT NULL AUTO_INCREMENT,
Dissagregation_Name varchar(255) NOT NULL,
PRIMARY KEY (Dissag_Id)
)

CREATE TABLE Concept_Dictionary
(
Concept_Id int NOT NULL AUTO_INCREMENT,
Concept_Name varchar(255) NOT NULL,
PRIMARY KEY (Concept_Id)
)

CREATE TABLE Topic
(
T_Id int NOT NULL AUTO_INCREMENT,
topic_name varchar(255) NOT NULL,
concept_id INT,
dissag_id INT,
PRIMARY KEY (T_Id),
FOREIGN KEY (concept_Id) REFERENCES Concept_Dictionary(Concept_Id),
FOREIGN KEY (dissag_Id) REFERENCES Dissagregation_Dictionary(Dissag_Id)
)
