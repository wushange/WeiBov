package com.wsg.lovehome.injector.module;

import android.content.Context;

import com.wsg.lovehome.db.DaoMaster;
import com.wsg.lovehome.db.DaoSession;
import com.wsg.lovehome.db.ForumDao;
import com.wsg.lovehome.db.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sll on 2015/3/4.
 */
@Module
public class DBModule {

  @Provides
  @Singleton DaoMaster.DevOpenHelper provideDevOpenHelper(Context context) {
    return new DaoMaster.DevOpenHelper(context, "app.db", null);
  }

  @Provides
  @Singleton DaoMaster provideDaoMaster(DaoMaster.DevOpenHelper helper) {
    return new DaoMaster(helper.getWritableDatabase());
  }

  @Provides
  @Singleton DaoSession provideDaoSession(DaoMaster master) {
    return master.newSession();
  }

  @Provides
  @Singleton
  ForumDao getForumDao(DaoSession session) {
    return session.getForumDao();
  }

  @Provides
  @Singleton
  UserDao getUserDao(DaoSession session) {
    return session.getUserDao();
  }
}
