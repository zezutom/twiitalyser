package org.zezutom.twiitalyser;

import android.app.Application;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetui.TweetUi;

import io.fabric.sdk.android.Fabric;

/**
 * Created by tom on 21/02/2015.
 */
public class App extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    protected static final String TWITTER_KEY = "ETwK0cQxCo8cKXqUmwEq19hpf";
    protected static final String TWITTER_SECRET = "KB9SJFahqmkuyVfQgNB5WxaUFlVEQ2ce4l3bYQxoSBJ6WAreDt";

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig =
                new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);

        Fabric.with(this, new TwitterCore(authConfig),
                new TweetUi());
    }
}
