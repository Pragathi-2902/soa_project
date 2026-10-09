package com.ps003.ticketmovie;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @GetMapping
    public String getMovies() {
        return "Movie Service: Inception, Interstellar, Avengers";
    }

    @GetMapping("/{id}")
    public String getMovie(@PathVariable int id) {
        return "Movie Service: Movie ID = " + id;
    }

    @PostMapping
    public String addMovie(@RequestBody String movie) {
        return "Movie added successfully: " + movie;
    }

}
