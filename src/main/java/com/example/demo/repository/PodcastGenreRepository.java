package com.example.demo.repository;

import com.example.demo.model.VO.GenreVO;
import com.example.demo.model.VO.PodcastGenreVO;
import com.example.demo.model.VO.PodcastVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PodcastGenreRepository extends JpaRepository<PodcastGenreVO, Long> {


    List<PodcastGenreVO> findByGenreVO_Name(String genreName);

    List<PodcastGenreVO> findByPodcastVO_Id(Long podcastId);

    PodcastGenreVO findByGenreVO_IdGenre(Long id);

}
