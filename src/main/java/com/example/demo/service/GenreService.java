package com.example.demo.service;

import com.example.demo.model.VO.GenreVO;
import com.example.demo.model.WVO.GenreWVO;
import com.example.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


public GenreWVO getGenreById(Long genreId)
{
GenreVO genreVO = genreRepository.findByIdGenre(genreId);

GenreWVO genreWVO = new GenreWVO(genreVO.getName(),genreVO.getDescription(),genreVO.isKidFriendly());

return genreWVO;

}

}
