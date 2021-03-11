package ch.noser.uek223.domain.user.dto;

import java.util.UUID;

public class UserDTOWithoutRoles {

    private UUID id;

    private String email;

    private String firstName;

    private String lastName;

    public UserDTOWithoutRoles() {
    }

    public UserDTOWithoutRoles(UUID id, String email, String firstName, String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return id;
    }

    public UserDTOWithoutRoles setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTOWithoutRoles setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTOWithoutRoles setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTOWithoutRoles setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
