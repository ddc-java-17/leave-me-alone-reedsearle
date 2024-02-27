package edu.cnm.deepdive.leavemealone.hilt;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.cnm.deepdive.leavemealone.model.dao.LocationDao;
import edu.cnm.deepdive.leavemealone.model.dao.UserDao;
import edu.cnm.deepdive.leavemealone.service.LeaveMeAloneDatabase;
import javax.inject.Singleton;

/**
 * Uses Dagger {@link Provides @Provides}-annotated methods to satisfy dependencies on concrete
 * implementations of {@link LeaveMeAloneDatabase} and {@link UserDao}.
 */

@InstallIn(SingletonComponent.class)
@Module
public class LeaveMeAloneDatabaseModule {

  LeaveMeAloneDatabaseModule() {
    // Package-private constructor to avoid automatic HTML documentation generation.
  }

  @Provides
  @Singleton
  LeaveMeAloneDatabase provideLocalDatabase(@ApplicationContext Context context) {
    return Room
        .databaseBuilder(context, LeaveMeAloneDatabase.class, LeaveMeAloneDatabase.NAME)
        .addCallback(new LeaveMeAloneDatabase.Callback())
        .build();
  }

  @Provides
  UserDao provideUserDao(LeaveMeAloneDatabase database) {
    return database.getUserDao();
  }

  @Provides
  public LocationDao providesLocationDao(LeaveMeAloneDatabase database) {
    return database.getLocationDao();
  }

  // TODO Add additional methods so satisfy dependencies on other DAO interface implementations.

}
