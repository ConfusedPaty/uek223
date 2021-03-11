package ch.noser.uek223.domain.user;

import ch.noser.uek223.domain.user.dto.UserDTOBasic;
import ch.noser.uek223.domain.user.dto.UserDTOSave;
import ch.noser.uek223.domain.user.dto.UserDTOWithoutRoles;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTOBasic userToUserDTOBasic(User user);

    List<UserDTOBasic> usersToUserDTOsBasic(List<User> user);

    User userDTOSaveToUser(UserDTOSave userDTOSave);

    UserDTOWithoutRoles userToUserDTOWithoutRoles(User user);

    List<UserDTOWithoutRoles> usersToUserDTOsWithoutRoles(List<User> user);
}
