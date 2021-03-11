package ch.noser.uek223.domain.authority;

import ch.noser.uek223.domain.role.Role;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Authority {

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

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Authority() {
    }

    public UUID getId() {
        return id;
    }

    public Authority setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Authority setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Authority setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }
}