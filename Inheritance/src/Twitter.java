public class Twitter extends SocialNetworkProfile
{
	boolean reTweet;

	void wantToRetweet(boolean reTweet) {
		this.reTweet = reTweet;
	}

	boolean retweet() {
		return reTweet;
	}
}
