package com.example.gdg_project.badge;

import com.example.gdg_project.user.UserEntity;
import com.example.gdg_project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BadgeService {
    @Autowired
    private HasBadgeRepository hasBadgeRepository;
    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private UserRepository userRepository;

    public List<BadgeDto> getRecentBadgesByUser(Long id) {

        UserEntity user = userRepository.findAllByUserId(id);
        List<HasBadgeEntity> badgesbyUser = hasBadgeRepository.findAllByUserId(user);
        List<Long> hasBadgeIds = badgesbyUser.stream().map(s -> s.getBadgeId().getBadgeId()).collect(Collectors.toList());
        List<BadgeEntity> allBadges = badgeRepository.findAll();

        // sort desc
        Collections.sort(allBadges, (s1, s2) ->
                Long.compare(s2.getRegistDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli(), s1.getRegistDate().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()));


        List<BadgeDto> result = new ArrayList<>();
        int count = 0;
        for (BadgeEntity badge : allBadges) {
            if (count == 3){
                break;
            }
           boolean isActive =  hasBadgeIds.contains(badge.getBadgeId());
           if (isActive){
               BadgeDto myBadgeDto = new BadgeDto();
               myBadgeDto.setBadgeId(badge.getBadgeId());
               myBadgeDto.setBadgeName(badge.getBadgeName());
               myBadgeDto.setBadgeCondition(badge.getCondition());
               myBadgeDto.setBadgeIconUrl(badge.getIconUrl());
               myBadgeDto.setActive(isActive);
               result.add(myBadgeDto);

               count+=1;
           }else{
               continue;
           }
        }

        return result;
    }

    public List<BadgeDto> getAllBadgesByUser(Long id){
        UserEntity user = userRepository.findAllByUserId(id);
        List<HasBadgeEntity> badgesbyUser = hasBadgeRepository.findAllByUserId(user);
        List<Long> hasBadgeIds = badgesbyUser.stream().map(s -> s.getBadgeId().getBadgeId()).collect(Collectors.toList());
        List<BadgeEntity> allBadges = badgeRepository.findAll();

        List<BadgeDto> result = new ArrayList<>();
//        List<BadgeEntity> badgeEntityList = new ArrayList<>();
        for (BadgeEntity badge : allBadges) {
            boolean isActive =  hasBadgeIds.contains(badge.getBadgeId());
            BadgeDto myBadgeDto = new BadgeDto();
            myBadgeDto.setBadgeId(badge.getBadgeId());
            myBadgeDto.setBadgeName(badge.getBadgeName());
            myBadgeDto.setBadgeCondition(badge.getCondition());
            myBadgeDto.setBadgeIconUrl(badge.getIconUrl());
            myBadgeDto.setActive(isActive);
            result.add(myBadgeDto);
        }
        return result;
    }
}