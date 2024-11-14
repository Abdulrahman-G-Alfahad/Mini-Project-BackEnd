package CodedBTA.mini_project.service.auth;

import CodedBTA.mini_project.bo.auth.LoginUserRequest;
import CodedBTA.mini_project.bo.auth.UpdateProfileRequest;
import CodedBTA.mini_project.entity.UserEntity;

public interface UserSerivce {
    UserEntity updateProfile(UpdateProfileRequest updateProfileRequest);
    UserEntity getUserByEmail(String email);
}
