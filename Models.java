class User {
    private String username;
    private String password;
    private String email;
    private String role;
    private String status;
    
    public User(String username, String password, String email, String role, String status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.status = status;
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
}

class Ticket {
    private String id;
    private String description;
    private String status;

    public Ticket() {
    }

    public Ticket(String id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}