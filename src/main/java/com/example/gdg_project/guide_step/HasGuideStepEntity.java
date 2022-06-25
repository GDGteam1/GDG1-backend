package com.example.gdg_project.guide_step;

import lombok.*;

import javax.persistence.*;

import com.example.gdg_project.category.CategoryEntity;
import com.example.gdg_project.common.BaseTimeEntity;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TB_Has_GuideStep")
public class HasGuideStepEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long hasGuideStepEntity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryId;

    @ManyToOne
    @JoinColumn(name = "guide_step_id")
    private GuideStepEntity guideStepId;
}
