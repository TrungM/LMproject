/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.NewsDTO;
import fpt.aptech.LMproject.entites.News;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.NewsRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author Minh Trung
 */
@Service
public class NewsService implements IFNews {

    @Autowired
    private NewsRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    public NewsDTO mapToDto(News news) {
        NewsDTO result = modelMapper.map(news, NewsDTO.class);
        return result;
    }

    public News mapToEntity(NewsDTO newsDTO) {
        News news = modelMapper.map(newsDTO, News.class);
        return news;
    }

    @Override
    public List<NewsDTO> findAll(int number) {
        if (number == 1) {
            Page<News> list = repository.findAll(PageRequest.of(0, 5));
            List<NewsDTO> newsresult = list.stream().map(news -> mapToDto(news)).collect(Collectors.toList());
            return newsresult;
        } else {
            Page<News> list = repository.findAll(PageRequest.of(0, 5));

            for (var i = 1; i <= number - 1; i++) {

                list = repository.findAll(list.nextPageable());
            }
            List<NewsDTO> newsresult = list.stream().map(news -> mapToDto(news)).collect(Collectors.toList());
            return newsresult;
        }
    }

    @Override
    public List<NewsDTO> findAllNoPagination() {
        List<News> list = repository.findAll();
        List<NewsDTO> newsresult = list.stream().map(news -> mapToDto(news)).collect(Collectors.toList());
        return newsresult;
    }

    @Override
    public int PageTotal() {
        Page<News> list = repository.findAll(PageRequest.of(0, 5));
        return list.getTotalPages();
    }

    @Override
    public NewsDTO saveNews(NewsDTO saveNews) {
        // covert DTO -> entity 
        News a = mapToEntity(saveNews);

        //save booking
        News c = repository.save(a);

        //entity->DTO
        NewsDTO NewsResponse = mapToDto(c);

        return NewsResponse;
    }

    @Override
    public NewsDTO updateNews(NewsDTO updateNews) {
        // covert DTO -> entity 
        News a = mapToEntity(updateNews);

        //save booking
        News c = repository.save(a);

        //entity->DTO
        NewsDTO NewsResponse = mapToDto(c);

        return NewsResponse;
    }

    @Override
    public NewsDTO getNewsByID(int id) {
        Optional<News> news = repository.findById(id);
        NewsDTO newsDTO = mapToDto(news.orElseThrow(() -> new ResourceNotFoundException("News", "id", String.valueOf(id))));
        return newsDTO;

    }

    @Override
    public void deleteByID(int id) {
        News a = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Positions", "id", String.valueOf(id)));
        repository.delete(a);
    }

    @Override
    public void updateImageClubs(Integer id) {
        repository.updateImageNews(id);

    }

    @Override
    public List<NewsDTO> getAll() {
        List<News> list = repository.getAll();
        List<NewsDTO> newsresult = list.stream().map(news -> mapToDto(news)).collect(Collectors.toList());
        return newsresult;
    }

    @Override
    public List<NewsDTO> getAllHome() {
        List<News> list = repository.getNewsHome();
        List<NewsDTO> newsresult = list.stream().map(news -> mapToDto(news)).collect(Collectors.toList());
        return newsresult;
    }

}
