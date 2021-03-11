package ch.noser.uek223.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User create(User user) {
        Optional<User> optional = userRepository.findByEmail(user.getEmail());

        if (optional.isPresent()) {
            throw new RuntimeException(String.format("%s with Email '%s' already exists", "User", user.getEmail()));
        }

        user.setId(null);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.saveAndFlush(user);

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(email));
    }
}
