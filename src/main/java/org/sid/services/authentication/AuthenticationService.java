package org.sid.services.authentication;


import org.sid.DTO.authentication.AuthenticationRequest;

import java.io.IOException;

public interface AuthenticationService {

    public Boolean authenticate(AuthenticationRequest authenticationRequest) throws IOException , Exception ;

}
