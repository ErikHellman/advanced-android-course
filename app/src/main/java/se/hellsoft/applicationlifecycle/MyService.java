package se.hellsoft.applicationlifecycle;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.support.annotation.Nullable;

import hugo.weaving.DebugLog;

public class MyService extends Service {

    @DebugLog
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @DebugLog
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // What does the different return values for this method mean for the lifecycle of the app?
        return super.onStartCommand(intent, flags, startId);
    }

    @DebugLog
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // What does it mean if this method returns null?
        return null;
    }

    @DebugLog
    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @DebugLog
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @DebugLog
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @DebugLog
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @DebugLog
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @DebugLog
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }

    @DebugLog
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
    }
}
