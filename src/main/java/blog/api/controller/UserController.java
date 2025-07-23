package blog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import blog.api.model.User;
import blog.api.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) throws Exception {

        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);

    }

    @GetMapping
    public ResponseEntity<List<User>> findUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserByIdUser(@PathVariable Long id) {
        User user = userService.findUserByID(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody  User user) {
        User updateUser = userService.updateUser(user);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
       userService.deleteUser(id);
       return ResponseEntity.noContent().build();
    }
}
