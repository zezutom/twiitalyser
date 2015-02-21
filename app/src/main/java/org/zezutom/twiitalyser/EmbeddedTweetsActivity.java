package org.zezutom.twiitalyser;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.LoadCallback;
import com.twitter.sdk.android.tweetui.TweetUtils;

import java.util.Arrays;
import java.util.List;


public class EmbeddedTweetsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_embedded_tweets);

        final FrameLayout myLayout
                = (FrameLayout) findViewById(R.id.my_tweet_layout);

        // TODO remove the hardcoded item and load list dynamically - search query
        final List<Long> tweetIds =
                Arrays.asList(510908133917487104L, 20L);

        TweetUtils.loadTweets(tweetIds, new LoadCallback<List<Tweet>>() {
            @Override
            public void success(List<Tweet> tweets) {
                Toast.makeText(EmbeddedTweetsActivity.this,
                        "Success: " + tweets.size(), Toast.LENGTH_SHORT).show();

                for (Tweet tweet : tweets) {
                    myLayout.addView(
                            new CompactTweetView(
                                    EmbeddedTweetsActivity.this,
                                    tweet));
                }
            }

            @Override
            public void failure(TwitterException e) {
                Toast.makeText(EmbeddedTweetsActivity.this,
                        "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tweet, menu);
        return true;
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
