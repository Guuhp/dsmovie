package com.guuhp.Services;

import com.guuhp.dsmovie.Entities.Movie;
import com.guuhp.dsmovie.Repositories.MovieRepository;
import com.guuhp.dsmovie.dto.MovieDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result =  repository.findAll(pageable);
        Page<MovieDTO> page = result.map(x -> new MovieDTO(x));// aqui o filme esta sendo conv para Dto por conta das camadas
        return page;
    }

    @Transactional(readOnly = true)//realizar um tratamento de excessoes DPS
    public MovieDTO findById(Long id) {
        Movie result =  repository.findById(id).get();
        MovieDTO dto = new MovieDTO(result);
        return dto;
    }


}
