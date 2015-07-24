public class Facebook extends SocialNetworkProfile {

	boolean acceptFriendRequest;
	boolean shareWallPublic;

	void setAcceptFriendRequest(boolean acceptFriendRequest) {
		this.acceptFriendRequest = acceptFriendRequest;
	}

	boolean acceptedFriendRequest() {
		return acceptFriendRequest;
	}

	void setShareWallPublic(boolean shareWallPublic) {
		this.shareWallPublic = shareWallPublic;
	}

	boolean getShareWallPublic() {
		return shareWallPublic;
	}	

}
