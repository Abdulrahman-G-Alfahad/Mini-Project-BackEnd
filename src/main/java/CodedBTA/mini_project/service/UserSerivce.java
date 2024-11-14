package CodedBTA.mini_project.service;

import CodedBTA.mini_project.bo.UpdateProfileRequest;
import CodedBTA.mini_project.entity.UserEntity;

public interface UserSerivce {
    UserEntity updateProfile(UpdateProfileRequest updateProfileRequest);
    UserEntity getUserByEmail(String email);
}
