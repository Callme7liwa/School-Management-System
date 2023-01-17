package org.sid.services.authentication;

import org.sid.DTO.authentication.AuthenticationRequest;
import org.sid.entities.Student;
import org.sid.entities.User;
import org.sid.repositories.ProfessorRepository;
import org.sid.repositories.StudentRepository;

import java.io.IOException;

public class AuthenticationServiceImpl  implements  AuthenticationService{

    private StudentRepository studentRepository ; 
    private ProfessorRepository professorRepository ; 

    @Override
    public Boolean authenticate(AuthenticationRequest authenticationRequest) throws IOException, Exception {
        // Boolean authenticationResult  ; 
        // User user = new Student();
        // user.getC
        // switch(authenticationRequest.getType_user())
        // {
        //     case "student" : authenticationResult = studentRepository.AuthenticateStudent(authenticationRequest.getEmail(), authenticationRequest.getPassword())  ;  break ; 
        //     case "professor" : authenticationResult = professorRepository.authenticateProfessor(authenticationRequest.getEmail(), authenticationRequest.getPassword()) ; break ; 
        //     case "admin" : authenticationResult = professorRepository.authenticateProfessor(authenticationRequest.getEmail(), authenticationRequest.getPassword()) ; break ; 
        //     default : return false ; 
        // }
        // return authenticationResult ; 
        return true ; 
    }
}
