package CodedBTA.mini_project.controller;

import CodedBTA.mini_project.bo.GetAllUsersResponse;
import CodedBTA.mini_project.entity.UserEntity;
import CodedBTA.mini_project.exception.UserNotFound;
import CodedBTA.mini_project.service.AdminService;
import CodedBTA.mini_project.service.AdminServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class AdminController {


    private final AdminService adminService;

    public AdminController(AdminServiceImp adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all-users")
    public ResponseEntity<GetAllUsersResponse> getAllUsers(){
        List<UserEntity> users = adminService.getUsers();
        return ResponseEntity.ok(new GetAllUsersResponse(users));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUserById(@PathVariable(name = "id") String id){
        try {
            return ResponseEntity.ok(adminService.getUser(Long.valueOf(id)));
        } catch (UserNotFound userNotFound){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delet-user/{id}")
    public deleteById(@PathVariable(name = "id") String id){

    }
}
