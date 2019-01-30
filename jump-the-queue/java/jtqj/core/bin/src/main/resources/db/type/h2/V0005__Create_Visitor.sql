create table Visitor(
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  username VARCHAR(255),
  name VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  password VARCHAR(255),
  phoneNumber VARCHAR(255),
  email VARCHAR(255),
  acceptedComercial BOOL DEFAULT '0',
  acceptedTerms BOOL NOT NULL DEFAULT '0',
  userType BOOL DEFAULT '0',
  CONSTRAINT PK_Visitor PRIMARY KEY(id),
);