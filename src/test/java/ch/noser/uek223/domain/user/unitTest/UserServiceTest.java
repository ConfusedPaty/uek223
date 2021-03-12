package ch.noser.uek223.domain.user.unitTest;

import ch.noser.uek223.domain.user.User;
import ch.noser.uek223.domain.user.UserRepository;
import ch.noser.uek223.domain.user.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserServiceTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Mock
    private UserRepository userRepository;

    //have a look
    @Test
    public void testFindAll() {
        List<User> usersList = List.of(
                new User("b4c340c2-8251-11eb-8dcd-0242ac130003", "muster.mann@gmx.ch", "123Muster", "Peter", "Muster"),
                new User("b4c340c2-8252-11eb-8dcd-0242ac130003", "mustar.mann@gmx.ch", "321Muster", "Peter", "Muster"));
        when(userRepository.findAll()).thenReturn(usersList);
        Assertions.assertEquals(userService.findAll(), usersList);
    }

    @Test
    public void testCreateUser() {
        UUID uuid = UUID.randomUUID();
        String encryptedPassword = "bCryptEncryptedPassword";
        User user = new User();
        user.setFirstName("Test First Name").setLastName("Test Last Name").setEmail("Test Email").setPassword("Test Password");

        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        when(bCryptPasswordEncoder.encode(anyString())).thenReturn(encryptedPassword);
        when(userRepository.saveAndFlush(any(User.class))).then((u -> ((User) u.getArgument(0)).setId(uuid)));

        User userActual = userService.create(user);
        user.setId(uuid).setPassword(encryptedPassword);

        Assertions.assertEquals(user, userActual);
    }
}