package com.example.ung_dung_blog.model.repository;

import com.example.ung_dung_blog.model.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM blog as b WHERE b.title like concat('%',:title,'%')", nativeQuery = true)
    Page<Blog> findByTitle(Pageable pageable, @Param(value = "title") String title);

    @Modifying
    @Transactional
    @Query(value = "update blog as b set is_flag_delete = 1 where b.id = :id ", nativeQuery = true)
    void isDelete(@Param(value = "id") Integer id);
}
