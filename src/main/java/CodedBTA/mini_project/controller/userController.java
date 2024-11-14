package CodedBTA.mini_project.controller;

import CodedBTA.mini_project.bo.auth.UpdateProfileRequest;
import CodedBTA.mini_project.bo.auth.UserResponse;
import CodedBTA.mini_project.entity.AccountEntity;
import CodedBTA.mini_project.entity.UserEntity;
import CodedBTA.mini_project.service.auth.AccountService;
import CodedBTA.mini_project.service.auth.JwtService;
import CodedBTA.mini_project.service.auth.UserSerivce;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class userController {
    private final UserSerivce userService;

    private final JwtService jwtService;

    private final AccountService accountService;

    public userController(UserSerivce userService, AccountService accountService, JwtService jwtService) {
        this.userService = userService;
        this.accountService = accountService;
        this.jwtService = jwtService;
    }
    @PutMapping("/update-profile")
    public ResponseEntity<UserEntity> updateProfile(@RequestBody UpdateProfileRequest updateProfileRequest){
        UserEntity updatedUser = userService.updateProfile(updateProfileRequest);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping("/profile")
    public UserResponse getProfile() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity user = userService.getUserByEmail(currentUsername);

        UserResponse userResponse = new UserResponse(user.getUserName(), user.getEmail(), user.getPhoneNumber(), user.getAddress());

        return userResponse;
    }

    @PostMapping("/account/create")
    public AccountEntity createAccount(HttpServletRequest request, @RequestBody Double initialBalance){
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        String email = jwtService.extractUsername(token);
        UserEntity user = userService.getUserByEmail(email);
        return accountService.createAccount(user,initialBalance);
    }

    @GetMapping("/account/getAccount")
    public AccountEntity getAccount(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        String email = jwtService.extractUsername(token);
        UserEntity user = userService.getUserByEmail(email);
        return accountService.getAccount(user);
    }
    @PutMapping("/account/updateBalance")
    public AccountEntity updateBalance(HttpServletRequest request, @RequestParam Double newBalance){
        String authHeader = request.getHeader("Authorization");
        String token = authHeader.substring(7);
        String email = jwtService.extractUsername(token);
        UserEntity user = userService.getUserByEmail(email);
        return accountService.updateBalance(user, newBalance);
    }
}
