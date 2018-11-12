package nl.bongers.config;

public class Credentials {

    private final String baseUrl;
    private final String username;
    private final String password;

    public Credentials(String baseUrl, String username, String password) {
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}