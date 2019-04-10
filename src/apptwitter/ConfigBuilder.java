package apptwitter;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author finfanterodal
 */
public class ConfigBuilder {

    ConfigurationBuilder cb = new ConfigurationBuilder();

    /**
     *
     * @return twitter objeto de Twitter
     */
    public Twitter instanciarConfigBuilder() {

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("*********************")
                .setOAuthConsumerSecret("******************************************")
                .setOAuthAccessToken("**************************************************")
                .setOAuthAccessTokenSecret("******************************************");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }
}
