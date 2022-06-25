package com.example.gdg_project.badge;

import com.example.gdg_project.user.UserEntity;
import com.example.gdg_project.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BadgeService {
    @Autowired
    private HasBadgeRepository hasBadgeRepository;
    @Autowired
    private BadgeRepository badgeRepository;
    @Autowired
    private UserRepository userRepository;

//    public List<RecentBadgeDto> getRecentBadgesByUser(Long id) {
//        UserEntity user = userRepository.findById(id).get();
//        List<HasBadgeEntity> recentBadgeDtos = hasBadgeRepository.findAllByUserId(user);
//        ArrayList<BadgeEntity> recentBadgeDtosList = new ArrayList<>();
//
//        for (HasBadgeEntity badge : recentBadgeDtos) {
//            recentBadgeDtosList.add(badgeRepository.findById());
//        }
//    }

    public List<BadgeDto> getAllBadgesByUser(Long id){
        UserEntity user = userRepository.findAllByUserId(id);
        List<HasBadgeEntity> recentBadgeDtos = hasBadgeRepository.findAllByUserId(user);
        List<BadgeEntity> badgeEntityList = new ArrayList<>();
        for (HasBadgeEntity badge : recentBadgeDtos) {
            badgeEntityList = badgeRepository.findBadgeEntityByBadgeId(badge.getBadgeId().getBadgeId());
        }
        List<BadgeDto> badgeDtos = new ArrayList<>();
        for (BadgeEntity badgeDto : badgeEntityList) {
            BadgeDto myBadgeDto = new BadgeDto();
            myBadgeDto.setBadgeId(badgeDto.getBadgeId());
            myBadgeDto.setBadgeName(badgeDto.getBadgeName());
            myBadgeDto.setBadgeCondition(badgeDto.getCondition());
            myBadgeDto.setBadgeIconUrl(badgeDto.getIconUrl());
            badgeDtos.add(myBadgeDto);
        }
        return badgeDtos;
    }
}