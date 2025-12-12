package com.bookverse.single_file_monolith.dto;

/**
 * User DTO - user-service'den gelen kullanıcı verilerini temsil eder.
 * Bu sınıf, mikroservisler arası iletişimde kullanılır.
 */
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String fullName;

    // Default Constructor
    public UserDTO() {
    }

    // Constructor
    public UserDTO(Long id, String username, String email, String fullName) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullName = fullName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
