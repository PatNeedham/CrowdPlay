package com.needham.crowdplay;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.TextPost;
import com.tumblr.jumblr.types.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TumblrPostTask t = new TumblrPostTask();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public class TumblrPostTask extends AsyncTask<String, Void, Boolean>
    {
        private final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        User user;
        JumblrClient client;
        @Override
        protected void onPreExecute()
        {
            this.dialog.setMessage("Exporting Info...");
            this.dialog.show();

            client = new JumblrClient(
                    "3b85kPHWOJNH8a0uWjoB9FJH8nMBgpVqxG3qBnTyI15kLIedVm",
                    "GWYbbaNIP1iOIuAoFuazkSEwqyw2cbRILonLRWcgFcR6k2QTCv");
            client.setToken(
                    "cTOV86uH6HoyWcEqnIqkOxnPMmpovo75jutdaN6XfvdxXe9zon",
                    "NVvgi0qGu0InHPve6JM155FwzTUHsFlD4vu6tNKd8bEmJtKlnD");
        }

        protected Boolean doInBackground(final String... args)
        {
            user = client.user();

            TextPost post;
            try {
                post = client.newPost(client.user().getName(), TextPost.class);
                post.setTitle("sample-title");
                post.setBody("sample-body");
                post.save();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                System.out.println("illegal access");
            } catch (InstantiationException e) {
                e.printStackTrace();
                System.out.println("instantiation exception");
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success)
        {
            if (this.dialog.isShowing())
            {
                this.dialog.dismiss();
            }

            if(success )
            {
                Log.e("POST", "SUCCESS");
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
