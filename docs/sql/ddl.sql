-- Generated 2024-02-27 16:39:30-0700 for database version 1

CREATE TABLE IF NOT EXISTS `user`
(
    `user_id`      INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `oauth_key`    TEXT                              NOT NULL,
    `display_name` TEXT                              NOT NULL COLLATE NOCASE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_oauth_key` ON `user` (`oauth_key`);

CREATE UNIQUE INDEX IF NOT EXISTS `index_user_display_name` ON `user` (`display_name`);

CREATE TABLE IF NOT EXISTS `location`
(
    `location_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `secure`      INTEGER                           NOT NULL,
    `tracked`     INTEGER                           NOT NULL,
    `timestamp`   INTEGER                           NOT NULL,
    `latitude`    REAL,
    `longitude`   REAL
);

CREATE INDEX IF NOT EXISTS `index_location_secure` ON `location` (`secure`);

CREATE INDEX IF NOT EXISTS `index_location_tracked` ON `location` (`tracked`);

CREATE INDEX IF NOT EXISTS `index_location_timestamp` ON `location` (`timestamp`);