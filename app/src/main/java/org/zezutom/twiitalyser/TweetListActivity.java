package org.zezutom.twiitalyser;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.LoadCallback;
import com.twitter.sdk.android.tweetui.TweetViewFetchAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tom on 21/02/2015.
 */
public class TweetListActivity extends ListActivity {

    // TODO remove the hardcoded ids
    List<Long> tweetIds = Arrays.asList(503435417459249153L,
            510908133917487104L,
            473514864153870337L,
            477788140900347904L);

    final TweetViewFetchAdapter adapter =
            new TweetViewFetchAdapter<CompactTweetView>(
                    TweetListActivity.this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet_list);
        setListAdapter(adapter);
        adapter.setTweetIds(tweetIds,
                new LoadCallback<List<Tweet>>() {
                    @Override
                    public void success(List<Tweet> tweets) {
                        Toast.makeText(TweetListActivity.this, "Success: " + ((tweets == null) ? "no tweets!" : tweets.size()), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(TwitterException exception) {
                        Toast.makeText(TweetListActivity.this, "Oops!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
