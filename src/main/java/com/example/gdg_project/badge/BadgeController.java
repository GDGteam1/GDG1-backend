package com.example.gdg_project.badge;

import com.example.gdg_project.common.model.response.ResponseEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BadgeController {
    @Autowired
    private BadgeService badgeService;

    @ApiOperation(value = "배지 전체 조회 API", notes = "모든 배지들 불러오기")
    @GetMapping("/user/badges/all/{id}")
    public List<BadgeDto> getAllBadgesByUser(@PathVariable Long id) {
        return badgeService.getAllBadgesByUser(id);
    }

    @ApiOperation(value = "배지 최근 조회 API", notes = "최근 배지들 불러오기")
    @GetMapping("/user/badges/recent/{id}")
    public List<BadgeDto> getRecentBadgesByUser(@PathVariable Long id) {
        return badgeService.getRecentBadgesByUser(id);
    }

}