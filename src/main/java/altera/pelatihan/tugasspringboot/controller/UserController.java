package altera.pelatihan.tugasspringboot.controller;

import altera.pelatihan.tugasspringboot.model.UserModel;
import altera.pelatihan.tugasspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registrasi")
    public String save(@RequestBody UserModel userModel) {
        return userService.save(userModel);
    }

    @GetMapping
    public List<UserModel> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserModel getById(@PathVariable("id") String id) {
        return userService.findOne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") String id) {
        userService.deleteOne(id);
    }
}
