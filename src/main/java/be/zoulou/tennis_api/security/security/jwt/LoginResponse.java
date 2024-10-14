package be.zoulou.tennis_api.security.security.jwt;

import java.util.List;

public class LoginResponse {

    private String username;
    private String jwtToken;
    private List<String> roles;
    private Long userId;

    public LoginResponse(String jwtToken, String username, List<String> roles, Long userId) {
        this.jwtToken = jwtToken;
        this.username = username;
        this.roles = roles;
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
