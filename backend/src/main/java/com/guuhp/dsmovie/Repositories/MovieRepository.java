package com.guuhp.dsmovie.Repositories;

import com.guuhp.dsmovie.Entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
   
}
