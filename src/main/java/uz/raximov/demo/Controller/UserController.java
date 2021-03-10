package uz.raximov.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import uz.raximov.demo.Entity.User;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Service.UserService;
import uz.raximov.demo.payload.UserDTO;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Page<User> page(@RequestParam Integer page){
        return userService.page(page);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @DeleteMapping("{id}")
    public Delete delete(@PathVariable Integer id){
        return userService.delete(id);
    }

    @PostMapping
    public User add(@RequestBody UserDTO user){
        return userService.add(user);
    }

    @PutMapping("/{id}")
    public User edit(@PathVariable Integer id, @RequestBody UserDTO user){
        return userService.edit(id, user);
    }
}
