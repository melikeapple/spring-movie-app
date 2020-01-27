package com.searchmovie.service;

import com.searchmovie.model.FormModel;
import com.searchmovie.model.MovieModel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
public class MovieController {
    private final MovieService movieService;
    private RestTemplate restTemplate = new RestTemplate();
    public String url = "https://www.omdbapi.com/?apikey=e0fdc28c&i=tt8579674";

    public MovieController(MovieService movieService) {
        super();
        this.movieService = movieService;
    }

    @GetMapping(value = {"/", "/index"})
    public String getHomePage(FormModel formModel) {
        return "index";
    }
    @Cacheable
    @PostMapping(value = {"/", "/index"})
    public String getResultPage(Model model, @ModelAttribute FormModel formModel) {
        String param = "type" + "=" + formModel.getFtype() + "&" + "query" + "=" + formModel.getFquery();

        return "redirect:/result?" + param;
    }

    @GetMapping(value = {"/result"})
    public String goResultPage(Model model, @RequestParam(required=false) String type, String query) {
        MovieModel movie = this.movieService.getAll(type, query);
        model.addAttribute("movie", movie);
        return "result";
    }

}
