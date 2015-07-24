class SocialNetworkProfile {
	String name;
	String email;
	final boolean contactFriends = true;
	String wayToConnect;

	void setName(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}

	void setEmail(String email) {
		this.email = email;
	}

	String getEmail() {
		return email;
	}

	boolean ableToConnetToFriends() {
		return contactFriends;
	}

	void setConnectMethod(String wayToConnect) {
		this.wayToConnect = wayToConnect;
	}

	String getConnectMethod() {
		return wayToConnect;
	}
}
