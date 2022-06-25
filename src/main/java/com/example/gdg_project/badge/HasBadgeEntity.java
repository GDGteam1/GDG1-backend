package com.example.gdg_project.badge;

import com.example.gdg_project.common.BaseTimeEntity;
import com.example.gdg_project.user.UserEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_Has_Badge")
public class HasBadgeEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long hasBadgeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "badge_id")
    private BadgeEntity badgeId;
}