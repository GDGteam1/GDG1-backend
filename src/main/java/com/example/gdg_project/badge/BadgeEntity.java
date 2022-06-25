package com.example.gdg_project.badge;

import com.example.gdg_project.common.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_Badge")
public class BadgeEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long badgeId;

    @Column(name = "name")
    private String badgeName;

    @Column(name = "icon_url")
    private String iconUrl;

    @Column(name = "condition")
    private String condition;
}