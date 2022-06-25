package com.example.gdg_project.badge;

import com.example.gdg_project.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BadgeRepository extends JpaRepository<BadgeEntity,Long> {
    List<BadgeEntity> findBadgeEntityByBadgeId(Long badgeId);
}

