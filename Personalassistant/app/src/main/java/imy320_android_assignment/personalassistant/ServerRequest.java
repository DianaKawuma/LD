package imy320_android_assignment.personalassistant;



import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.xml.sax.helpers.DefaultHandler;


import java.net.HttpURLConnection;
import java.security.BasicPermission;
import java.util.ArrayList;

public class ServerRequest {
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 100 * 15;
    public static final String SERVER_ADRESS = "http://localhost/phpmyadmin";

    public ServerRequest(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }

    public void storeUserDataInBackground(User user, GetUserCallBack userCallBack){
        progressDialog.show();
        new StoreUserDataAsyncTask(user, userCallBack).execute();
    }
    public void fetchUserDataInBackground(User user, GetUserCallBack callBack){
        progressDialog.show();
    }

    public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void>{
        User user;
        GetUserCallBack userCallBack;

        public  StoreUserDataAsyncTask(User user, GetUserCallBack userCallBack){
            this.user = user;
            this.userCallBack = userCallBack;
        }

        @Override
        protected Void doInBackground(Void... params){
            ContentValues values = new ContentValues();
            values.put("name",user.name);
            values.put("surname", user.surname);
            values.put("username",user.username);
            values.put("password", user.password);




            return null;
        }

        @Override
        protected  void onPostExecute(Void aVoid){
            progressDialog.dismiss();
            userCallBack.done(null);
            super.onPostExecute(aVoid);
        }


    }

}
