package com.example.gdg_project.guide_step;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_GuideStep")
public class GuideStepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long badgeId;

    @Column(name = "imgUrl")
    private String imgUrl;

    @Column(name = "description")
    private String description;
}
