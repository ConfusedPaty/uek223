package ch.noser.uek223.domain.role.dto;

import java.util.UUID;

public class RoleDTOWithoutAuthorities {

    private UUID id;

    private String name;

    public RoleDTOWithoutAuthorities() {
    }

    public RoleDTOWithoutAuthorities(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public RoleDTOWithoutAuthorities setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleDTOWithoutAuthorities setName(String name) {
        this.name = name;
        return this;
    }
}
