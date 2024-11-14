package CodedBTA.mini_project.bo;

import CodedBTA.mini_project.entity.UserEntity;

public class GetUserResponse {
    private UserEntity user;

    public GetUserResponse(UserEntity user) {
        this.user = user;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
