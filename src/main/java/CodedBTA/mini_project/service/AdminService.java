package CodedBTA.mini_project.service;

import CodedBTA.mini_project.entity.UserEntity;
import CodedBTA.mini_project.exception.UserNotFound;

import java.util.List;

public interface AdminService {
    List<UserEntity> getUsers();
    UserEntity getUser(Long id) throws UserNotFound;
    void deleteUser(Long id) throws UserNotFound;
}
