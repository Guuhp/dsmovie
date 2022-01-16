package com.guuhp.dsmovie.Repositories;

import com.guuhp.dsmovie.Entities.Score;
import com.guuhp.dsmovie.Entities.ScorePK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
