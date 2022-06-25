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

    private final EntityManager em;


//    @GetMapping("/user/badges/recent/{id}")
//    public List<RecentBadgeDto> getRecentBadgesByUser(@PathVariable Long id){
//        // 최신순으로 정렬해서 has_badge 가져오기
//        // 전체 가져와서 위 값에 포함되는 값은 isActive = true 로 변경
//
////      List<BadgeEntity>  badges =  badgeRepo.findAllRecentBadgesByUser();
//
//        List<RecentBadgeDto> badges = badgeService.getRecentBadgesByUser(id);
//        System.out.println(badges);
//        return badges;
//    }



}
