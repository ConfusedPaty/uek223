package ch.noser.uek223.domain.user;

import ch.noser.uek223.domain.user.dto.UserDTOBasic;
import ch.noser.uek223.domain.user.dto.UserDTOSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserWeb {

    private UserService userService;
    private UserMapper userMapper;

    @Autowired
    public UserWeb(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping({"", "/"})
    @PostAuthorize("hasAuthority('CAN_RETRIEVE_ALL_USERS')")
    public ResponseEntity<List<UserDTOBasic>> findAll() {
        return ResponseEntity.ok().body(userMapper.usersToUserDTOsBasic(userService.findAll()));
    }

    @GetMapping({"/{id}", "/{id}/"})
    @PostAuthorize("hasAuthority('CAN_RETRIEVE_ALL_USERS') OR (hasAuthority('CAN_RETRIEVE_USER') AND #id == authentication.principal.user.id)")
    public ResponseEntity<UserDTOBasic> findById(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(userMapper.userToUserDTOBasic(userService.findById(id)));
    }

    @PostMapping({"", "/"})
    public ResponseEntity<UserDTOBasic> create(@RequestBody UserDTOSave userDTOSave) {
        return ResponseEntity.ok().body(userMapper.userToUserDTOBasic(userService.create(userMapper.userDTOSaveToUser(userDTOSave))));
    }
}
