package ch.noser.uek223.domain.role;

import ch.noser.uek223.domain.authority.Authority;
import ch.noser.uek223.domain.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Role {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Set<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<Authority> authorities;

    public Role() {
    }

    public UUID getId() {
        return id;
    }

    public Role setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Role setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Role setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }
}
