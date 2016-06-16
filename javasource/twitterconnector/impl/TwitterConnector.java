package twitterconnector.impl;

import com.mendix.logging.ILogNode;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by ako on 6/4/2016.
 */
public class TwitterConnector {
    private ILogNode logger;

    /**
     * Update twitter status
     *
     * @param consumerKey
     * @param consumerSecret
     * @param accessToken
     * @param accessTokenSecret
     * @param tweet
     * @return
     * @throws TwitterException
     */
    public String sendTweet(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, String tweet) throws TwitterException {
        info("sendTweet");
        Twitter twitter = getTwitterClient(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        Status status = twitter.updateStatus(tweet);
        info("Successfully updated the status to [" + status.getText() + "].");
        return status.getText();
    }

    /**
     * Get twitter client for the provided credentials.
     *
     * @param consumerKey
     * @param consumerSecret
     * @param accessToken
     * @param accessTokenSecret
     * @return
     */
    private Twitter getTwitterClient(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    /**
     * Send a direct message to the specified recipient. Recipient needs to be a follower.
     *
     * @param consumerKey
     * @param consumerSecret
     * @param accessToken
     * @param accessTokenSecret
     * @param recipient
     * @param tweet
     * @throws TwitterException
     */
    public void sendDirectMessage(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, String recipient, String tweet) throws TwitterException {
        info("sendTweet");
        Twitter twitter = getTwitterClient(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        DirectMessage message = twitter.sendDirectMessage(recipient,tweet);
        info(String.format("Successfully end message %s to %s",message.getText(),message.getRecipientScreenName()));
    }

    public void setLogger(ILogNode logger) {
        this.logger = logger;
    }
    private void info(String message){
        if(logger!=null){
            logger.info(message);
        } else {
            System.err.println(message);
        }
    }

}
