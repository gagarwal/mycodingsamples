public class InheritanceUsage {
	public static void main(String arg[]) {

		// Sam's Facebook
		Facebook samsFacebookProfile = new Facebook();

		String samsFacebookProfileName = "Sam Facebook";
		String samsFacebookEmail = "sam@facebook.com";
		String facebookConnectMethod = "addingFriends";

		samsFacebookProfile.setAcceptFriendRequest(true);
		samsFacebookProfile.setShareWallPublic(false);

		samsFacebookProfile.setName(samsFacebookProfileName);
		samsFacebookProfile.setEmail(samsFacebookEmail);
		samsFacebookProfile.ableToConnetToFriends();
		samsFacebookProfile.setConnectMethod(facebookConnectMethod);

		// Sams's Twitter
		Twitter samsTwitterProfile = new Twitter();

		String samsTwitterProfileName = "Sam Twitter";
		String samsTwitterEmailId = "sam@twitter.com";
		String twitterConnectMethod = "follow";
		boolean retweet = true;

		samsTwitterProfile.wantToRetweet(retweet);

		samsTwitterProfile.setName(samsTwitterProfileName);
		samsTwitterProfile.setEmail(samsTwitterEmailId);
		samsTwitterProfile.setConnectMethod(twitterConnectMethod);

		// Tom's Facebook
		Facebook tomFacebookProfile = new Facebook();

		String tomsFacebookProfileName = "Tom Facebook";
		String tomsFacebookEmail = "Tom@facebook.com";

		tomFacebookProfile.setAcceptFriendRequest(false);
		tomFacebookProfile.setShareWallPublic(true);

		tomFacebookProfile.setName(tomsFacebookProfileName);
		tomFacebookProfile.setEmail(tomsFacebookEmail);
		tomFacebookProfile.setConnectMethod(facebookConnectMethod);

		// Testing Sam's Twitter
		System.out.println();
		System.out.println("****Testing Sam's Twitter****");
		if (samsTwitterProfile.reTweet) {
			System.out.println("Sam retweeted a tweet");
		}

		if (samsTwitterProfile.getName().equals(samsTwitterProfileName)) {
			System.out.println("Sam's facebook profile name is "
					+ samsTwitterProfileName);
		}

		if (samsTwitterProfile.getEmail().equals(samsTwitterEmailId)) {
			System.out.println("Sam's twitter mail is " + samsTwitterEmailId);
		}

		if (samsTwitterProfile.ableToConnetToFriends()) {
			System.out
					.println("You are able to connect to your friends through facebook");
		}

		if (samsTwitterProfile.getConnectMethod().equals(twitterConnectMethod)) {
			System.out.println("Sam can connet to his friends by adding them");
		}

		// Testing Sam's Facebook
		System.out.println();
		System.out.println("****Testing Sam's Facebook****");
		if (samsFacebookProfile.acceptedFriendRequest()) {
			System.out
					.println("Facebook friend request to sam's profile is accepted");
		}

		if (!samsFacebookProfile.getShareWallPublic()) {
			System.out.println("Sam's facebook wall is not public");
		}

		if (samsFacebookProfile.getName().equals(samsFacebookProfileName)) {
			System.out.println("Sam's facebook profile name is "
					+ samsFacebookProfileName);
		}

		if (samsFacebookProfile.getEmail().equals(samsFacebookEmail)) {
			System.out.println("Sam's facebook email is " + samsFacebookEmail);
		}

		if (samsFacebookProfile.ableToConnetToFriends()) {
			System.out
					.println("You are able to connect to your friends through facebook");
		}

		if (samsFacebookProfile.getConnectMethod().equals(facebookConnectMethod)) {
			System.out
					.println("Sam can connect to his friends in facebook by adding them");
		}

		// Testing Tom's Facebook
		System.out.println();
		System.out.println("****Testing Tom's Facebook****");
		if (!tomFacebookProfile.acceptedFriendRequest()) {
			System.out
					.println("Facebook friend request to Tom's profile is not accepted");
		}

		if (tomFacebookProfile.getShareWallPublic()) {
			System.out.println("Tom's facebook wall is public");
		}

		if (tomFacebookProfile.getName().equals(tomsFacebookProfileName)) {
			System.out.println("Tom's facebook profile name is "
					+ tomsFacebookProfileName);
		}

		if (tomFacebookProfile.getEmail().equals(tomsFacebookEmail)) {
			System.out.println("Tom's facebook email is " + tomsFacebookEmail);
		}

		if (tomFacebookProfile.ableToConnetToFriends()) {
			System.out
					.println("You are able to connect to your friends through facebook");
		}

		if (tomFacebookProfile.getConnectMethod().equals(facebookConnectMethod)) {
			System.out
					.println("Tom can connect to his friends in facebook by adding them");
		}

	}
}