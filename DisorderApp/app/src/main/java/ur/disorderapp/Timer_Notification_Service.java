package ur.disorderapp;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class Timer_Notification_Service extends IntentService {

    public Timer_Notification_Service() {
        super("Timer_Notification_Service");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this, "timer starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                while(true) {
                    Thread.sleep(30000);//Every 30 seconds
                    // create a handler to post messages to the main thread
                    Handler mHandler = new Handler(getMainLooper());
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {

                            NotificationCompat.Builder mBuilder =
                                    (NotificationCompat.Builder)
                                            new NotificationCompat.Builder(getApplicationContext())
                                                    .setSmallIcon(R.drawable.ic_menu_send)
                                                    .setContentTitle("My notification")
                                                    .setContentText("My notification");

                            // Creates an explicit intent for an Activity in your app
                            Intent resultIntent = new Intent(getBaseContext(), MainActivity.class);

                            // The stack builder object will contain an artificial back stack for the
                            // started Activity.
                            // This ensures that navigating backward from the Activity leads out of
                            // your application to the Home screen.
                            TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());

                            // Adds the back stack for the Intent (but not the Intent itself)
                            stackBuilder.addParentStack(MainActivity.class);

                            // Adds the Intent that starts the Activity to the top of the stack
                            stackBuilder.addNextIntent(resultIntent);
                            PendingIntent resultPendingIntent =
                                    stackBuilder.getPendingIntent(
                                            0,
                                            PendingIntent.FLAG_UPDATE_CURRENT
                                    );
                            mBuilder.setContentIntent(resultPendingIntent);
                            NotificationManager mNotificationManager =
                                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                            // mId allows you to update the notification later on.
                            mNotificationManager.notify(1, mBuilder.build());

                            //Toast.makeText(getApplicationContext(), "Timer Stopped", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }
        }
    }


}
