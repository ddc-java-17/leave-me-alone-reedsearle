package edu.cnm.deepdive.leavemealone.hilt;

import android.content.Context;
import androidx.room.Room;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import edu.cnm.deepdive.leavemealone.model.dao.AlertDao;
import edu.cnm.deepdive.leavemealone.model.dao.LocationDao;
import edu.cnm.deepdive.leavemealone.service.LeaveMeAloneDatabase;
import javax.inject.Singleton;

/**
 * Uses Dagger {@link Provides @Provides}-annotated methods to satisfy dependencies on concrete
 * implementations of {@link LeaveMeAloneDatabase}.
 */

@InstallIn(SingletonComponent.class)
@Module
public class LeaveMeAloneDatabaseModule {

  LeaveMeAloneDatabaseModule() {
    // Package-private constructor to avoid automatic HTML documentation generation.
  }

  /**
   * This creates the local database
   * @param context
   * @return
   */
  @Provides
  @Singleton
  LeaveMeAloneDatabase provideLocalDatabase(@ApplicationContext Context context) {
    return Room
        .databaseBuilder(context, LeaveMeAloneDatabase.class, LeaveMeAloneDatabase.NAME)
        .addCallback(new LeaveMeAloneDatabase.Callback())
        .build();
  }

  /**
   * THis provides the alert dao to the repositories
   * @param database
   * @return
   */
  @Provides
  @Singleton
  AlertDao provideAlertDao(LeaveMeAloneDatabase database) {
    return database.getAlertDao();
  }

  /**
   * This provides the location dao to the repositories
   * @param database
   * @return
   */
  @Provides
  @Singleton
  public LocationDao providesLocationDao(LeaveMeAloneDatabase database) {
    return database.getLocationDao();
  }


}
