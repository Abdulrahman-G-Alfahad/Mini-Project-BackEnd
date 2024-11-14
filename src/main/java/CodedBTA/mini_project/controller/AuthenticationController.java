package CodedBTA.mini_project.controller;

import CodedBTA.mini_project.bo.auth.AuthenticationResponse;
import CodedBTA.mini_project.bo.auth.LoginUserRequest;
import CodedBTA.mini_project.bo.auth.LogoutResponse;
import CodedBTA.mini_project.bo.auth.RegisterUserRequest;
import CodedBTA.mini_project.entity.UserEntity;
import CodedBTA.mini_project.service.auth.AuthService;
import CodedBTA.mini_project.service.auth.AuthenticationService;
import CodedBTA.mini_project.service.auth.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<UserEntity> register(@RequestBody RegisterUserRequest registerUserRequest) {
        UserEntity registeredUser = authenticationService.signup(registerUserRequest);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody LoginUserRequest loginUserRequest) {
        UserEntity authenticatedUser = authenticationService.authenticate(loginUserRequest);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        AuthenticationResponse loginResponse = new AuthenticationResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setId(authenticatedUser.getId());
        loginResponse.setUsername(authenticatedUser.getUsername());

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutResponse authenticationRequest){
        authenticationService.logout(authenticationRequest);

        return  ResponseEntity.ok(null);
    }


}
