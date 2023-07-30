/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.SeasonDTO;
import fpt.aptech.LMproject.entites.Season;
import fpt.aptech.LMproject.repository.SeasonRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Minh Trung
 */
@Service
public class SeasonService implements IFSeason {

    @Autowired
    private SeasonRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<SeasonDTO> findAllNoPaginationSeason() {
        List<Season> list = repository.findAll();
        List<SeasonDTO> result = list.stream().map(a -> mapToDto(a)).collect(Collectors.toList());
        return result;
    }

    @Override
    public SeasonDTO createSeason(SeasonDTO season) {
        Season a = mapToEntity(season);

        Season s = repository.save(a);
        SeasonDTO SeasonResponse = mapToDto(s);

        return SeasonResponse;

    }

    public SeasonDTO mapToDto(Season season) {

        SeasonDTO result = modelMapper.map(season, SeasonDTO.class);

        return result;

    }

    public Season mapToEntity(SeasonDTO seasonDTO) {
        Season a = modelMapper.map(seasonDTO, Season.class);
        return a;
    }
}
