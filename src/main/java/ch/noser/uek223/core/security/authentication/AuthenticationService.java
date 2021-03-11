package ch.noser.uek223.core.security.authentication;

import ch.noser.uek223.domain.user.dto.UserDTOBasic;

import java.util.UUID;

public interface AuthenticationService {

    UserDTOBasic getAuthenticationResponse(UUID userId);

    void authenticate(String authenticationHeader);

}
