# SQL data definition language (DDL)

```sqlite
CREATE TABLE IF NOT EXISTS `ClientProfile`
(
    `client_id`     INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`          TEXT                              NOT NULL,
    `date_of_birth` INTEGER                           NOT NULL,
    `address`       TEXT                              NOT NULL,
    `phone_number`  INTEGER                           NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `ClientProfile` ON `ClientProfile` (`name`);

CREATE INDEX IF NOT EXISTS `ClientProfile` ON `ClientProfile` (`date_of_birth`);

CREATE INDEX IF NOT EXISTS `ClientProfile` ON `ClientProfile` (`address`);

CREATE INDEX IF NOT EXISTS `ClientProfile` ON `ClientProfile` (`phone_number`);



CREATE TABLE IF NOT EXISTS `Assessment`
(
    `assessment_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `client_id`       INTEGER                           NOT NULL,
    `assessment_type` INTEGER,
    `timestamp`       INTEGER                           NOT NULL,
    FOREIGN KEY (`client_id`) REFERENCES `ClientProfile` (`client_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE UNIQUE INDEX IF NOT EXISTS `Assessment` ON `Assessment` (`assessment_id`);



CREATE TABLE IF NOT EXISTS `Labor`
(
    `labor_id`             INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `assessment_id`        INTEGER                           NOT NULL,
    `rupture_of_membranes` INTEGER                           NOT NULL,
    `contraction`          INTEGER                           NOT NULL,
    FOREIGN KEY (`assessment_id`) REFERENCES `Assessment` (`assessment_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS `FetalCondition`
(
    `fetal_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `assessment_id` INTEGER                           NOT NULL,
    `fhr`           INTEGER                           NOT NULL,
    `timestamp`     INTEGER                           NOT NULL,
    FOREIGN KEY (`assessment_id`) REFERENCES `Assessment` (`assessment_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);
``` 

[Download](ddl.sql)