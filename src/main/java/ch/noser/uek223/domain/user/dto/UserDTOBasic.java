package ch.noser.uek223.domain.user.dto;

import ch.noser.uek223.domain.role.dto.RoleDTO;

import java.util.Set;
import java.util.UUID;

public class UserDTOBasic {

    private UUID id;

    private String email;

    private String firstName;

    private String lastName;

    private Set<RoleDTO> roles;

    public UserDTOBasic() {
    }

    public UserDTOBasic(UUID id, String email, String firstName, String lastName, Set<RoleDTO> roles) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public UserDTOBasic setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTOBasic setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTOBasic setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTOBasic setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public UserDTOBasic setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
        return this;
    }
}
