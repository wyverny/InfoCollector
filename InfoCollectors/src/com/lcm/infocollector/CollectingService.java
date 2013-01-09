package com.lcm.infocollector;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

public class CollectingService extends Service {

static final String TAG = "ANDROES";
    
    final Handler mHandler = new Handler();
    boolean stopTask = true;
    private static final int TIMER_PERIOD = 1 * 1000; // 1 sec
    private static final int MAXCOUNT = 10;
    private int mCounter;

    public void onStart(Intent intent, int startId) {
         processAlarm();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        processAlarm();
        return START_NOT_STICKY;
    }

    private void processAlarm() {
//        // Set volume
//        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
//        int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
//        // mAudioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT); // 무음
//        // mAudioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE); // 진동
//        mAudioManager.setStreamVolume(AudioManager.STREAM_ALARM, maxVolume, 0);
//        for(int i=1; i<=maxVolume; i++){
//            mAudioManager.adjustStreamVolume(AudioManager.STREAM_RING,  AudioManager.ADJUST_RAISE, 0);
//        }
//
//        // 벨소리 울리게 하기
//        RingtoneManager ringtoneManager = new RingtoneManager(this);
//        alarmRingtone = ringtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM));
//        alarmRingtone.play();

        stopTask = false;
        startTimer();
        
        // Service Stop
        this.stopSelf();
    }
    
    private void startTimer() {
        // TODO Auto-generated method stub
        Log.i("ANDROES", "start startAlarm() : mCounter: " + mCounter);
        final Runnable r = new Runnable() {
            @Override
            public void run() {
                // 주기적으로 반복될 내용
                if (++mCounter >= MAXCOUNT) {
                    stopTimer();
//                    alarmRingtone.stop();
                }
                Log.i("ANDROES", "mCounter : " + mCounter);
                if (!stopTask) mHandler.postDelayed(this, TIMER_PERIOD);
            }
        };
        if (!stopTask) mHandler.postDelayed(r, TIMER_PERIOD);
    }

    private void stopTimer() {
        // TODO Auto-generated method stub
        Log.i("ANDROES", "start stopAlarm() : mCounter: " + mCounter);
        stopTask = true;
    }

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
