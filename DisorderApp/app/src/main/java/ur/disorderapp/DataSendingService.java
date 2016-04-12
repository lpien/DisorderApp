package ur.disorderapp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.List;

import ur.disorderapp.model.Collection;
import ur.disorderapp.model.FirebaseData;
import ur.disorderapp.model.SelfAssessmentData;


public class DataSendingService extends IntentService
{
    public Collection sCollection;
    public static final String DEBUG_TAG = "[DEBUG]";
    public String mPhoneNumber;

    public DataSendingService()
    {
        super("DataSendingService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Toast.makeText(this, "send data when internet is available",
                Toast.LENGTH_SHORT).show();
        TelephonyManager tMgr = (TelephonyManager)getApplicationContext()
                .getSystemService(Context.TELEPHONY_SERVICE);
        sCollection = Collection.get(getApplicationContext());
        mPhoneNumber = tMgr.getLine1Number();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        if (intent != null) {
            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            boolean isWifiConn = networkInfo.isConnected();
            networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            boolean isMobileConn = networkInfo.isConnected();
            Log.d(DEBUG_TAG, "Wifi connected: " + isWifiConn);
            Log.d(DEBUG_TAG, "Mobile connected: " + isMobileConn);

            //Checking Internet connection every minute
            while(true){
                networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                isWifiConn = networkInfo.isConnected();
                networkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                isMobileConn = networkInfo.isConnected();
                Log.d(DEBUG_TAG, "Wifi connected: " + isWifiConn);
                Log.d(DEBUG_TAG, "Mobile connected: " + isMobileConn);


                if(isWifiConn || isMobileConn)
                {
                    Firebase.setAndroidContext(getApplicationContext());
                    Firebase ref =
                            new Firebase("https://brilliant-torch-1224.firebaseio.com/SelfMonitorData");

                    List<SelfAssessmentData> unsent = sCollection.getUnsentSelfAssessmentData();
                    List<SelfAssessmentData> list = sCollection.getSelfAssessmentData();
                    Log.d("TAG", "data: "+list);
                    Log.d("TAG", "unsent: "+unsent);

                    for (SelfAssessmentData data : unsent){
                        FirebaseData d = new FirebaseData(data,mPhoneNumber);

                        Log.d("Tag", "phonenumber: "+ mPhoneNumber);

                        Firebase dataRef1 = ref.child(mPhoneNumber);
                        Firebase dataRef2 = dataRef1.child(d.getDate());
                        dataRef2.setValue(d);

                        //change the SENT attribute from 0 to 1 in local database
                        data.setSent("1");
                        sCollection.updateData(data);

                    }
                }

                try {
                    Thread.sleep(10000);//sleep for 10 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
