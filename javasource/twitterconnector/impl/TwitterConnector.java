package twitterconnector.impl;

import com.mendix.logging.ILogNode;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by ako on 6/4/2016.
 */
public class TwitterConnector {
    private ILogNode logger;


    public String sendTweet(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, String tweet) throws TwitterException {
        info("sendTweet");
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Status status = twitter.updateStatus(tweet);
        info("Successfully updated the status to [" + status.getText() + "].");
        return status.getText();
    }

    public void setLogger(ILogNode logger) {
        this.logger = logger;
    }
    private void info(String message){
        if(logger!=null){
            logger.info(message);
        }
    }

}
