package com.guuhp.Services;

import com.guuhp.dsmovie.Entities.Movie;
import com.guuhp.dsmovie.Entities.Score;
import com.guuhp.dsmovie.Entities.User;
import com.guuhp.dsmovie.Repositories.MovieRepository;
import com.guuhp.dsmovie.Repositories.ScoreRepository;
import com.guuhp.dsmovie.Repositories.UserRepository;
import com.guuhp.dsmovie.dto.MovieDTO;
import com.guuhp.dsmovie.dto.ScoreDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO savescore(ScoreDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail());

        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        Score score = new Score();
        score.setUser(user);
        score.SetMovie(movie);
        score.setValue(dto.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for (Score s : movie.getScores()) {
            sum += s.getValue();
        }

        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);
        return new MovieDTO(movie);
    }
}
