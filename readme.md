# Mendix Twitter Connector

## Introduction

This connector enables you to post Twitter updates from your Mendix microflows.

## Usage

You need a consumer key and an access token from twitter to post to a
single account:
* First you need to register your application on [apps.twitter.com][4]
* Next you need to [generate access tokens][3] for the app.

You can store this information in an entity or using constants.

### Update twitter status

To post a Twitter update, using a microflow as illustrated below. After
including the connector from the appstore, you can drag and drop the
*update Twitter status* action from your toolbox on your microflow.

![Twitter action in Mendix toolbox][9]

Here's an example how to use the action in a microflow:

![Post Tweet from microflow][1]

The action needs a few parameters:
* ConsumerKey and consumerSecret as provided when you register your app with twitter.
* AccessToken and accessTokenSecret which you can generate for the app.
* The actual message you want to post to Twitter.

![Configure tweet action][2]

The action returns a string describing the result status.

### Send direct message

You can send direct message to your followers as follows:

![Send direct message from microflow][7]

Configuration of the action:

![Configure direct message action][8]

## Development

Development of this connector is done through a git project on [Github][10].

All java jar dependencies are managed using an ivy file. You can download all
dependencies by running runivy.cmd. This will save all jars in the userlib folder. There are two different
scripts to run ivy:
* runivy.cmd - downloads all dependencies required for running and testing the project
* runivy-export.cmd - downloads only the dependencies required for distributing the connector mpk.

Before you start to develop the connector you need to run runivy.cmd. After you validate everything works, run runivy-export.cmd.
This will delete all jars in the userlib folder and only download the jars required for creating the connector mpk.

This connector uses the unofficial [Twitter4j][6] twitter library.

For the unit tests you need to provide qn authentication information configuration file $HOME/.twitterconnector.cfg:

    [UnitTesting]
    consumer_key=XXXXXX
    consumer_secret=XXXXXX
    access_token=XXXXXX
    access_token_secret=XXXXXX

## License

This connector is licensed under the Apache v2 license.

## Changelog

2016-jun-16 - revision 1.0

* Update Twitter status action using oauth1
* Added action to send direct message

2016-jun-29 - revision 1.0.1

* Changed name of message parameter in java action to avoid clashes with other objects

  [1]: docs/images/post_tweet_mf.png
  [2]: docs/images/configure_post_tweet.png
  [3]: https://dev.twitter.com/oauth/overview/application-owner-access-tokens
  [4]: https://apps.twitter.com/
  [5]: https://dev.twitter.com/oauth/overview/introduction
  [6]: http://twitter4j.org/en/index.html
  [7]: docs/images/send_direct_message.png
  [8]: docs/images/configure_direct_message.png
  [9]: docs/images/twitter_toolbox.png
  [10]: https://github.com/ako/TwitterConnector