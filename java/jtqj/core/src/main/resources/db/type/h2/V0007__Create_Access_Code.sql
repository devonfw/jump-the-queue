CREATE TABLE AccessCode(
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  ticketNumber VARCHAR(5),
  creationTime TIMESTAMP,
  startTime TIMESTAMP,
  endTime TIMESTAMP,
  idVisitor BIGINT NOT NULL,
  idQueue BIGINT NOT NULL,
  CONSTRAINT PK_AccessCode PRIMARY KEY(id),
  CONSTRAINT FK_AccessCode_idVisitor FOREIGN KEY(idVisitor) REFERENCES Visitor(id),
  CONSTRAINT FK_AccessCode_idQueue FOREIGN KEY(idQueue) REFERENCES DailyQueue(id)
);