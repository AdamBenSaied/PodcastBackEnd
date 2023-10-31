package com.example.demo.repository;

import com.example.demo.model.VO.InventairePodcastVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventairePodcastRepository extends JpaRepository<InventairePodcastVO,Long> {

   List<InventairePodcastVO> findById_InventaireVO_UserVO_Mail(String userMail);

}
