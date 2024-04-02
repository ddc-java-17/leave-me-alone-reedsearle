-- Generated 2024-04-01 21:29:33-0600 for database version 1

CREATE TABLE IF NOT EXISTS `alert`
(
    `alert_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `triggered` INTEGER                           NOT NULL,
    `timestamp` INTEGER                           NOT NULL,
    `photoname` TEXT
);

CREATE INDEX IF NOT EXISTS `index_alert_triggered` ON `alert` (`triggered`);

CREATE INDEX IF NOT EXISTS `index_alert_timestamp` ON `alert` (`timestamp`);

CREATE TABLE IF NOT EXISTS `location`
(
    `location_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `alert_id`    INTEGER                           NOT NULL,
    `secure`      INTEGER                           NOT NULL,
    `latitude`    REAL,
    `longitude`   REAL
);

CREATE INDEX IF NOT EXISTS `index_location_secure` ON `location` (`secure`);