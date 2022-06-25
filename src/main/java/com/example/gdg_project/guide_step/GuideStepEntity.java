package com.example.gdg_project.guide_step;

import lombok.*;

import javax.persistence.*;

import com.example.gdg_project.common.BaseTimeEntity;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity 
@Table(name = "TB_GuideStep")
public class GuideStepEntity extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long badgeId;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;
}
