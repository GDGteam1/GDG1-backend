package com.example.gdg_project.badge;

import com.example.gdg_project.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

<<<<<<< HEAD
@Repository
public interface BadgeRepository extends JpaRepository<BadgeEntity,Long> {
    List<BadgeEntity> findBadgeEntityByBadgeId(Long badgeId);

}
=======
public interface BadgeRepository extends JpaRepository<BadgeEntity, Long> {
//    @Query("select b.id as badgeId, b.\"name\" as badgeName, b.\"condition\" as badgeCondition, b.icon_url as badgeIconUrl\n" +
//            "\tleft join tb_has_badge hb on hb.badge_id = b.id \n" +
//            "\twhere hb.user_id = 1\n" +
//            "\torder by hb.regist_date \n" +
//            "\tlimit 3")
//    List<RecentBadgeDto> findAllRecentBadgesByUser();
}
>>>>>>> 564ae19facb335d7499640887372397b6fa1f27d
