package com.needham.crowdplay;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.User;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("in the onCreate");


    }

    public void openStudentView(View v) {
        Intent myIntent = new Intent(MainActivity.this, StudentActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void openTeacherView(View v) {
        Intent myIntent = new Intent(MainActivity.this, TeacherActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public class TumblrPostTask extends AsyncTask<Map<String, String>, Void, Boolean>
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

        protected Boolean doInBackground(Map<String, String>... args)
        {
            //user = client.user();
//            System.out.println("makig the post now");
//            TextPost post;
//            try {
//                post = client.newPost("therealcrowdplay.tumblr.com", TextPost.class);
//                HashSet<String>
//                Set<String> keySet = args.keySet();
//                Iterator iter = keySet.iterator();
//                String first = (String) iter.next();
//                post.setTitle(first);
//                post.setBody(" ");
//
//                List<String> tags = new ArrayList<String>();
//                tags.add("interesting");
//
//                post.setTags(null);
//                post.save();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//                System.out.println("crowdplay:: illegal access");
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//                System.out.println("crowdplay:: instantiation exception");
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("crowdplay:: generic error");
//                System.out.println("crowdplay:: generic error");
//            }

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
