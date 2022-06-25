package com.example.gdg_project.category;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_Category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long categoryId;

    @Column(name = "name")
    private String categoryName;
}