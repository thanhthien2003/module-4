package com.example.bai_2.model.repository;

import com.example.bai_2.model.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IMusicRepository extends JpaRepository<Music,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update music as b set is_flag_delete = 1 where b.id = :id ", nativeQuery = true)
    void isDelete(@Param(value = "id") Integer id);
}
