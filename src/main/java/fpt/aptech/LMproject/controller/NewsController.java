/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package fpt.aptech.LMproject.controller;

import fpt.aptech.LMproject.DTO.NewsDTO;
import fpt.aptech.LMproject.services.IFNews;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Minh Trung   
 */
@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private IFNews news;

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsDTO> listPage(@RequestParam("page") Integer number) {
        return news.findAll(number);
    }

    @GetMapping(value = "/list")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsDTO> listFull() {
        return news.findAllNoPagination();
    }

    @GetMapping(value = "/all/totalPage")
    @ResponseStatus(HttpStatus.OK)
    public int Totalpage() {
        return news.PageTotal();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsDTO get(@PathVariable Integer id) {
        return news.getNewsByID(id);
    }

    @GetMapping("/show/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NewsDTO show(@PathVariable Integer id) {
        return news.getNewsByID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDTO> put(@PathVariable Integer id, @RequestBody NewsDTO newsDTO) {
        newsDTO.setId(id);
        NewsDTO edit = news.updateNews(newsDTO);

        return new ResponseEntity<>(edit, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<NewsDTO> post(@RequestBody NewsDTO newsDTO) {
        return new ResponseEntity<>(news.saveNews(newsDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        news.deleteByID(id);
    }

    @PutMapping("/image/{id}")
    public ResponseEntity<NewsDTO> putImage(@PathVariable Integer id) {
        news.updateImageClubs(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/index")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsDTO> index() {
        return news.getAll();
    }

    @GetMapping("/home")
    @ResponseStatus(HttpStatus.OK)
    public List<NewsDTO> home() {
        return news.getAllHome();
    }
}
