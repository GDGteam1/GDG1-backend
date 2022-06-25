package com.example.gdg_project.badge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BadgeRepository extends JpaRepository<BadgeEntity, Long> {
//    @Query("select b.id as badgeId, b.\"name\" as badgeName, b.\"condition\" as badgeCondition, b.icon_url as badgeIconUrl\n" +
//            "\tleft join tb_has_badge hb on hb.badge_id = b.id \n" +
//            "\twhere hb.user_id = 1\n" +
//            "\torder by hb.regist_date \n" +
//            "\tlimit 3")
//    List<RecentBadgeDto> findAllRecentBadgesByUser();
}