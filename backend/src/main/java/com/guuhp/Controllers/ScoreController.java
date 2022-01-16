package com.guuhp.Controllers;

import com.guuhp.Services.ScoreService;
import com.guuhp.dsmovie.dto.MovieDTO;
import com.guuhp.dsmovie.dto.ScoreDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        MovieDTO moviedto = service.savescore(dto);
        return moviedto;
    }
}
