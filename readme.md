# Mendix Twitter Connector

## Introduction

This connector enables you to post twitter updates from your Mendix microflows.

## Usage

You need a consumer key and an access token from twitter to post to a
single account:
* First you need to register your application on [apps.twitter.com][4]
* Next you need to [generate access tokens][3] for the app.

You can store this information in an entity or using constants.

To post a twitter update, using a microflow as illustrated below. After
including the connector from the appstore, you can drag and drop the
*update twitter status* action from your toolbox on your microflow.

![Post Tweet from microflow][1]

The action needs a few parameters:
* ConsumerKey and consumerSecret as provided when you register your app with twitter.
* AccessToken and accessTokenSecret which you can generate for the app.
* The actual message you want to post to twitter.

![Configure tweet action][2]

The action returns a string describing the result status.

## Development

Development of this connector is done through a git project on Github.

All java jar dependencies are managed using an ivy file. You can download all
dependencies by running runivy.cmd. This will save all jars in the userlib folder.

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

* Update twitter status action using oauth1

  [1]: docs/images/post_tweet_mf.png
  [2]: docs/images/configure_post_tweet.png
  [3]: https://dev.twitter.com/oauth/overview/application-owner-access-tokens
  [4]: https://apps.twitter.com/
  [5]: https://dev.twitter.com/oauth/overview/introduction
  [6]: http://twitter4j.org/en/index.html