package CodedBTA.mini_project.service;

import CodedBTA.mini_project.entity.UserEntity;
import CodedBTA.mini_project.exception.UserNotFound;
import CodedBTA.mini_project.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService{

    private final UserRepository userRepository;

    public AdminServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getUsers() {
        return ((List<UserEntity>) userRepository.findAll());
    }

    @Override
    public UserEntity getUser(Long id) throws UserNotFound {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            throw new UserNotFound("User does not exist");
        }

    }

    @Override
    public void deleteUser(Long id) throws UserNotFound {
        UserEntity user = getUser(id);
        userRepository.delete(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
