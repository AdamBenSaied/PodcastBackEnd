package com.example.demo.repository;

import com.example.demo.model.VO.PodcastVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PodcastRepository extends JpaRepository<PodcastVO, Long> {
    List<PodcastVO> findByUserVO_Id(Long userId);
    List<PodcastVO> findByName(String podcastName);
    Optional<PodcastVO> findById(Long podcastId);



}
