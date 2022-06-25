package com.example.gdg_project.user;

import com.example.gdg_project.badge.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepo;

    @Autowired
    private BadgeService badgeService;

    @RequestMapping(value="/user/{id}",  method = RequestMethod.GET)
    public @ResponseBody GetUserOutputDto getUser(@PathVariable("id") Long userId){
        Optional<UserEntity> userOpt =  userRepo.findById(userId);
        UserEntity  user =  userOpt.get();
        GetUserOutputDto output = new GetUserOutputDto();
        output.userId = user.getUserId();
        output.userName = user.getUserName();
        return output;
    }
}
