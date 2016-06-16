package testtwitterconnector.tests;

import ca.szc.configparser.Ini;
import org.junit.Test;
import twitter4j.TwitterException;
import twitterconnector.impl.TwitterConnector;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Map;

/**
 * Created by ako on 15-6-2016.
 */
public class TestTwitterConnector {

    @Test
    public void testSendTweet() throws TwitterException, IOException {
        // get configuration
        Path input = Paths.get(System.getProperty("user.home") + "/.twitterconnector.cfg");
        Ini ini = new Ini().read(input);
        Map<String, String> configs = ini.getSections().get("UnitTesting");

        TwitterConnector conn = new TwitterConnector();
        final String CONSUMER_KEY = configs.get("consumer_key");
        final String CONSUMER_SECRET = configs.get("consumer_secret");
        final String ACCESS_TOKEN = configs.get("access_token");
        final String ACCESS_TOKEN_SECRET = configs.get("access_token_secret");
        final String twitter_message = String.format("Testing this twitter rest api at %s",(new Date()).toString());

        conn.sendTweet(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,ACCESS_TOKEN_SECRET,twitter_message);
    }
}
