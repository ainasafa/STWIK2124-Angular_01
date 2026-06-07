package backend.controller;


import backend.dto.LoginRequest;
import backend.entity.User;
import backend.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private Repository Repository;

    @PostMapping("/login")
    public User login(
            @RequestBody LoginRequest request) {

        User user = Repository
                .findByUsername(request.getUsername());

        if(user != null &&
           user.getPassword().equals(
                   request.getPassword())) {

            return user;
        }

        return null;
    }
}