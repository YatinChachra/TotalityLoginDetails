package com.example.android.totalitylogindetails;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static com.example.android.totalitylogindetails.MainActivity.mCursor;

//import com.example.android.TotalityLogin.TotalityContract;




public class MainActivity extends AppCompatActivity {

    TextView records;

   private Cursor mData;
    private int mCurrentState;

    private int COLUMN_ID=0,
                COLUMN_EMAIL=1,
                COLUMN_PASSWORD=2,
                COLUMN_DATE=3;

    public static String  dataRecieved=null;

    public static ContentResolver contentResolver1;

    private Context mContext;

    public static Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=getApplicationContext();

        records=(TextView) findViewById(R.id.record);

        contentResolver1=getContentResolver();

        new WordFetchTask().execute();


    }


    public void showCredentials(View view)
    {
        Intent i=new Intent(mContext,ListCredentials.class);
        startActivity(i);
    }


    // Use an async task to do the data fetch off of the main thread.
    public class WordFetchTask extends AsyncTask<Void, Void, Cursor> {

        // Invoked on a background thread
        @Override
        protected Cursor doInBackground(Void... params) {
            // Make the query to get the data

            // Get the content resolver
            ContentResolver resolver = getContentResolver();

            // Call the query method on the resolver with the correct Uri from the contract class
            Cursor cursor = resolver.query(TotalityLoginContract.CONTENT_URI,
                    null, null, null, null);

            mCursor=cursor;

            ListThread thread=new ListThread("ListThread");

            return cursor;
        }


        // Invoked on UI thread
        @Override
        protected void onPostExecute(Cursor cursor) {
            //super.onPostExecute(cursor);

            super.onPostExecute(mCursor);


            // Set the data for MainActivity
            mData = cursor;

            //cursor.moveToFirst();
            while(cursor.moveToNext())
            {
            dataRecieved=dataRecieved+"\n\n"+"Email: "+cursor.getString(COLUMN_EMAIL)+"\n"+"Password: "+cursor.getString(COLUMN_PASSWORD)+"\n"+"Date: "+cursor.getString(COLUMN_DATE);
                Log.e("MainActivity.java",dataRecieved);
                records.setText("Email: "+cursor.getString(COLUMN_EMAIL)+"\n"+"Password: "+cursor.getString(COLUMN_PASSWORD)+"\n"+"Date: "+cursor.getString(COLUMN_DATE));
            }
        }
    }


    public void refreshButton(View view)
    {new WordFetchTask().execute();}


}


class ListThread extends Thread
{
    ListThread(String name)
    {super(name);
    start();}

    @Override
    public void run() {

        // Call the query method on the resolver with the correct Uri from the contract class
        Cursor cursor = MainActivity.contentResolver1.query(TotalityLoginContract.CONTENT_URI,
                null, null, null, null);

        mCursor=cursor;


    }
}