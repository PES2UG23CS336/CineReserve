package com.cinereserve.cinereserve.controller;

import com.cinereserve.cinereserve.model.entity.Show;
import com.cinereserve.cinereserve.service.ShowService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shows")
public class ShowController {
    private final ShowService service;
    public ShowController(ShowService service) { this.service = service; }

    @PostMapping
    public Show add(@RequestBody Map<String,Object> body) {
        Long movieId  = Long.valueOf(body.get("movieId").toString());
        Long screenId = Long.valueOf(body.get("screenId").toString());
        LocalDateTime time = LocalDateTime.parse(body.get("startTime").toString());
        return service.add(movieId, screenId, time);
    }

    @GetMapping
    public List<Show> getAll() { return service.getAll(); }

    @GetMapping("/movie/{movieId}")
    public List<Show> getByMovie(@PathVariable Long movieId) {
        return service.getByMovie(movieId);
    }
}
