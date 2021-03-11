package ch.noser.uek223.domain.user;

import ch.noser.uek223.domain.authority.Authority;
import ch.noser.uek223.domain.authority.dto.AuthorityDTO;
import ch.noser.uek223.domain.role.Role;
import ch.noser.uek223.domain.role.dto.RoleDTO;
import ch.noser.uek223.domain.user.dto.UserDTOBasic;
import ch.noser.uek223.domain.user.dto.UserDTOSave;
import ch.noser.uek223.domain.user.dto.UserDTOWithoutRoles;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-11T16:41:42+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.2.jar, environment: Java 15 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTOBasic userToUserDTOBasic(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOBasic userDTOBasic = new UserDTOBasic();

        userDTOBasic.setId( user.getId() );
        userDTOBasic.setEmail( user.getEmail() );
        userDTOBasic.setFirstName( user.getFirstName() );
        userDTOBasic.setLastName( user.getLastName() );
        userDTOBasic.setRoles( roleSetToRoleDTOSet( user.getRoles() ) );

        return userDTOBasic;
    }

    @Override
    public List<UserDTOBasic> usersToUserDTOsBasic(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDTOBasic> list = new ArrayList<UserDTOBasic>( user.size() );
        for ( User user1 : user ) {
            list.add( userToUserDTOBasic( user1 ) );
        }

        return list;
    }

    @Override
    public User userDTOSaveToUser(UserDTOSave userDTOSave) {
        if ( userDTOSave == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDTOSave.getEmail() );
        user.setPassword( userDTOSave.getPassword() );
        user.setFirstName( userDTOSave.getFirstName() );
        user.setLastName( userDTOSave.getLastName() );

        return user;
    }

    @Override
    public UserDTOWithoutRoles userToUserDTOWithoutRoles(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOWithoutRoles userDTOWithoutRoles = new UserDTOWithoutRoles();

        userDTOWithoutRoles.setId( user.getId() );
        userDTOWithoutRoles.setEmail( user.getEmail() );
        userDTOWithoutRoles.setFirstName( user.getFirstName() );
        userDTOWithoutRoles.setLastName( user.getLastName() );

        return userDTOWithoutRoles;
    }

    @Override
    public List<UserDTOWithoutRoles> usersToUserDTOsWithoutRoles(List<User> user) {
        if ( user == null ) {
            return null;
        }

        List<UserDTOWithoutRoles> list = new ArrayList<UserDTOWithoutRoles>( user.size() );
        for ( User user1 : user ) {
            list.add( userToUserDTOWithoutRoles( user1 ) );
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

    protected RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setId( role.getId() );
        roleDTO.setName( role.getName() );
        roleDTO.setAuthorities( authoritySetToAuthorityDTOSet( role.getAuthorities() ) );

        return roleDTO;
    }

    protected Set<RoleDTO> roleSetToRoleDTOSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDTO> set1 = new HashSet<RoleDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleDTO( role ) );
        }

        return set1;
    }
}
