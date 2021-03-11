package ch.noser.uek223.domain.role;

import ch.noser.uek223.domain.role.dto.RoleDTO;
import ch.noser.uek223.domain.role.dto.RoleDTOWithoutAuthorities;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO roleToRoleDTO(Role role);

    List<RoleDTO> rolesToRoleDTOs(List<Role> roles);

    RoleDTOWithoutAuthorities roleToRoleDTOWithoutAuthorities(Role role);

    List<RoleDTOWithoutAuthorities> rolesToRoleDTOsWithoutAuthorities(List<Role> roles);
}
