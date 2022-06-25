package com.example.gdg_project.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true) // 2
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    public List<CategoryEntity> findByCategoryName(String categoryName);
}
