package com.example.gdg_project.user;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TB_User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long userId;

    @Column(name = "name")
    private String userName;
}