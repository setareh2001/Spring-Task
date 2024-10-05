package org.example.controller;


import org.example.model.Movie;
import org.example.service.PageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/page")
public class PageController {

    private final PageService pageService;

    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/movie/{imdbCode}")
    public Movie getMovieByImdbCode(@PathVariable String imdbCode) {
        return pageService.getMovieByImdbCode(imdbCode);
    }
}
