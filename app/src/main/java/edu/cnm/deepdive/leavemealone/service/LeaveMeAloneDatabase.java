/*
 *  Copyright 2024 CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.leavemealone.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.leavemealone.model.dao.AlertDao;
import edu.cnm.deepdive.leavemealone.model.dao.LocationDao;
import edu.cnm.deepdive.leavemealone.model.entity.Alert;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import edu.cnm.deepdive.leavemealone.service.LeaveMeAloneDatabase.Converters;
import java.time.Instant;

/**
 * Defines a connection to a local Room/SQLite database, All database reads/writes are performed
 * using data-access object (DAO) instances obtained from the singleton instance of this class.
 */
@Database(
    entities = {Alert.class, Location.class},
    version = 1
)
@TypeConverters({Converters.class})
public abstract class LeaveMeAloneDatabase extends RoomDatabase {

  /**  Name of SQLite database file. */
  public static final String NAME = "locations";

  LeaveMeAloneDatabase() {
    // Package-private constructor to avoid automatic HTML generation for Javadocs.
  }

  public abstract AlertDao getAlertDao();
  public abstract LocationDao getLocationDao();

  /**
   * Defines converters for otherwise unsupported types (initially, just {@link Instant}) to one of
   * those supported by Room/SQLite.
   */
  public static class Converters {

    /**
     * Returns the specified {@link Instant} {@code value} as a {@link Long}, corresponding to the
     * number of milliseconds elapsed since {@code 1970-01-01 00:00:00+00:00} encapsulated within
     * {@code value}. When {@code value} is {@code null}, this method returns {@code null} as well.
     *
     * @param value Input {@link Instant}
     * @return Epoch milliseconds encapsulated in {@code value}.
     */
    @TypeConverter
    @Nullable
    public static Long toLong(@Nullable Instant value) {
      return (value != null) ? value.toEpochMilli() : null;
    }

    /**
     * Returns an {@link Instant} instance containing the specified {@link Long} {@code value} epoch
     * milliseconds. That is, {@code value} is interpreted as a number of milliseconds elapsed since
     * {@code 1970-01-01 00:00:00+00:00}, and the corresponding {@link Instant} is returned. When
     * {@code value} is {@code null}, this method returns {@code null} as well.
     *
     * @param value Epoch milliseconds.
     * @return {@link Instant} corresponding to {@code value}.
     */
    @TypeConverter
    @Nullable
    public static Instant toInstant(@Nullable Long value) {
      return (value != null) ? Instant.ofEpochMilli(value) : null;
    }

  }

  /**
   * Implements methods to be invoked on key database events.
   */
  public static class Callback extends RoomDatabase.Callback {

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
      super.onCreate(db);
    }

  }

}
