package org.mcupdater.settings;

import org.mcupdater.MCUApp;
import org.mcupdater.model.JSON;

@JSON
public class Profile {
	private String style;
	private String name;
	private String username;
	private String sessionKey;
	private String accessToken;
	private String lastInstance;
	private String uuid;

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSessionKey(MCUApp caller) throws Exception {
		if (this.sessionKey == null || this.sessionKey.isEmpty()) {
			if (this.style.equals("Yggdrasil")) {
				return caller.getAuthManager().getSessionKey(this);
			/*
				AuthManager auth = new AuthManager();
				*/
			}
		}
		return sessionKey;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getLastInstance() {
		return lastInstance;
	}

	public void setLastInstance(String lastInstance) {
		this.lastInstance = lastInstance;
	}

	public String getUUID() {
		return uuid;
	}

	public void setUUID(String uuid) { this.uuid = uuid; }

	@Override
	public String toString() { return this.getName(); }
}
