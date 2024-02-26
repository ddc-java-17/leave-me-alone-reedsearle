package edu.cnm.deepdive.leavemealone.hilt;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.cnm.deepdive.leavemealone.model.dao.LocationDao;
import edu.cnm.deepdive.leavemealone.model.dao.UserDao;
import edu.cnm.deepdive.leavemealone.model.entity.Location;
import edu.cnm.deepdive.leavemealone.model.entity.User;
import edu.cnm.deepdive.leavemealone.service.LMADatabase;
import javax.inject.Singleton;

/**
 * Uses Dagger {@link Provides @Provides}-annotated methods to satisfy dependencies on concrete
 * implementations of {@link LMADatabase} and {@link UserDao}.
 */

@InstallIn(SingletonComponent.class)
@Module
public abstract class LMADatabaseModule extends RoomDatabase {

  LMADatabaseModule() {
    // Package-private constructor to avoid automatic HTML documentation generation.
  }

  @Provides
  @Singleton
  LMADatabase provideLocalDatabase(@ApplicationContext Context context) {
    return Room
        .databaseBuilder(context, LMADatabase.class, LMADatabase.NAME)
        .addCallback(new LMADatabase.Callback())
        .build();
  }

  @Provides
  UserDao provideUserDao(LMADatabase database) {
    return database.getUserDao();
  }

  @Provides
  public LocationDao providesLocationDao(LMADatabase database) {
    return database.getLocationDao();
  }

  // TODO Add additional methods so satisfy dependencies on other DAO interface implementations.

}
