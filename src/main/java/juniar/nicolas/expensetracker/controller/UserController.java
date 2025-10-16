package juniar.nicolas.expensetracker.controller;

import juniar.nicolas.expensetracker.dto.UserDTO;
import juniar.nicolas.expensetracker.entity.User;
import juniar.nicolas.expensetracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }
}
