package ch.noser.uek223.domain.user.dto;

public class UserDTOSave {

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    public UserDTOSave() {
    }

    public UserDTOSave(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public UserDTOSave setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTOSave setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserDTOSave setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserDTOSave setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}
