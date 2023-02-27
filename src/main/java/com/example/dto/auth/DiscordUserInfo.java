package com.example.dto.auth;

import java.util.Map;

public class DiscordUserInfo implements OAuth2UserInfo {
	private Map<String, Object> attributes;

	public DiscordUserInfo(Map<String, Object> attributes) {
        this.attributes = attributes;
    }
    
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getProviderId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getProvider() {
        return "discord";
    }

    @Override
    public String getEmail() {
        return attributes.get("email").toString();
    }

    @Override
    public String getName() {
        return attributes.get("username").toString();
    }

    @Override
    public String getId() {
        return attributes.get("id").toString();
    }

    @Override
    public String getUserName() {
        return attributes.get("username").toString();
    }


}
