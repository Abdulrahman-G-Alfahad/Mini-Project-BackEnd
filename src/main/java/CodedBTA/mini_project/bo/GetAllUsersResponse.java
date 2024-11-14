package CodedBTA.mini_project.bo;

import CodedBTA.mini_project.entity.UserEntity;

import java.util.List;

public class GetAllUsersResponse {

    private List<UserEntity> users;

    public GetAllUsersResponse(List<UserEntity> users) {
        this.users = users;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
