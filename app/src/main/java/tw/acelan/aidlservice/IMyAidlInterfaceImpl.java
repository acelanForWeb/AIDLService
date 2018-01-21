package tw.acelan.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

public class IMyAidlInterfaceImpl extends Service {
    private String TAG = "IMyAidlInterfaceImpl_log";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"IMyAidlInterface Service onbind.");
        IBinder binder =new IMyAidlInterface.Stub() {
            @Override
            public void setData(String data) throws RemoteException {
                //將別的應用程式傳遞過來的data進行Log輸出
                Log.i(TAG,"data = "+data);
            }
        };

        return binder;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.i(TAG,"IMyAidlInterface Service Started.");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG,"IMyAidlInterface Service onUnbind.");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"IMyAidlInterface Service destroyed.");
    }
}
