package CodedBTA.mini_project.service.auth;

import CodedBTA.mini_project.bo.auth.LoginUserRequest;
import CodedBTA.mini_project.bo.auth.LogoutResponse;
import CodedBTA.mini_project.bo.auth.RegisterUserRequest;
import CodedBTA.mini_project.entity.UserEntity;
import CodedBTA.mini_project.exception.BodyGuardException;
import CodedBTA.mini_project.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements AuthService{
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity signup(RegisterUserRequest request) {
        UserEntity user = new UserEntity();
        user.setUserName(request.getEmail());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void logout(LogoutResponse logoutResponse){
        requiredNonNull(logoutResponse.getToken(), "token");
    }

    private void requiredNonNull(Object object, String name){
        if (object == null || object.toString().isEmpty()){
            throw new BodyGuardException(name + " can't be empty");
        }
    }

    @Override
    public UserEntity authenticate(LoginUserRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        return userRepository.findByEmail(request.getUsername())
                .orElseThrow();
    }
}