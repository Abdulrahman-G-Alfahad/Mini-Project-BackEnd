package CodedBTA.mini_project.service.auth;

import CodedBTA.mini_project.bo.auth.LoginUserRequest;
import CodedBTA.mini_project.bo.auth.LogoutResponse;
import CodedBTA.mini_project.bo.auth.RegisterUserRequest;
import CodedBTA.mini_project.entity.UserEntity;

public interface AuthService {
    UserEntity signup(RegisterUserRequest request);
    void logout(LogoutResponse logoutResponse);
    UserEntity authenticate(LoginUserRequest request);
}
