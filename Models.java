class User {
    private String username;
    private String password;
    private String email;
    private String role;
    private String status;
    private String created_at;
    private String updated_at;

    public User(String username, String password, String email, String role, String status, String created_at, String updated_at) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}