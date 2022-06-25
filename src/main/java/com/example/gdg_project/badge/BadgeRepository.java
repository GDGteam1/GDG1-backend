package com.example.gdg_project.badge;

import com.example.gdg_project.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BadgeRepository extends JpaRepository<BadgeEntity, Long> {
}