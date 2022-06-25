package com.example.gdg_project.category;

import com.example.gdg_project.common.BaseTimeEntity;
import com.example.gdg_project.user.UserEntity;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_Read_Category")
public class ReadCategoryEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long readCategoryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryId;
}