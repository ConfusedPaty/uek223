package ch.noser.uek223.domain.role;

import ch.noser.uek223.domain.authority.Authority;
import ch.noser.uek223.domain.authority.dto.AuthorityDTO;
import ch.noser.uek223.domain.role.dto.RoleDTO;
import ch.noser.uek223.domain.role.dto.RoleDTOWithoutAuthorities;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-12T10:34:05+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.2.jar, environment: Java 15 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setName( role.getName() );
        roleDTO.setAuthorities( authoritySetToAuthorityDTOSet( role.getAuthorities() ) );

        return roleDTO;
    }

    @Override
    public List<RoleDTO> rolesToRoleDTOs(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDTO> list = new ArrayList<RoleDTO>( roles.size() );
        for ( Role role : roles ) {
            list.add( roleToRoleDTO( role ) );
        }

        return list;
    }

    @Override
    public RoleDTOWithoutAuthorities roleToRoleDTOWithoutAuthorities(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTOWithoutAuthorities roleDTOWithoutAuthorities = new RoleDTOWithoutAuthorities();

        roleDTOWithoutAuthorities.setId( role.getId() );
        roleDTOWithoutAuthorities.setName( role.getName() );

        return roleDTOWithoutAuthorities;
    }

    @Override
    public List<RoleDTOWithoutAuthorities> rolesToRoleDTOsWithoutAuthorities(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDTOWithoutAuthorities> list = new ArrayList<RoleDTOWithoutAuthorities>( roles.size() );
        for ( Role role : roles ) {
            list.add( roleToRoleDTOWithoutAuthorities( role ) );
        }

        return list;
    }

    protected AuthorityDTO authorityToAuthorityDTO(Authority authority) {
        if ( authority == null ) {
            return null;
        }

        AuthorityDTO authorityDTO = new AuthorityDTO();

        authorityDTO.setId( authority.getId() );
        authorityDTO.setName( authority.getName() );

        return authorityDTO;
    }

    protected Set<AuthorityDTO> authoritySetToAuthorityDTOSet(Set<Authority> set) {
        if ( set == null ) {
            return null;
        }

        Set<AuthorityDTO> set1 = new HashSet<AuthorityDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Authority authority : set ) {
            set1.add( authorityToAuthorityDTO( authority ) );
        }

        return set1;
    }
}
