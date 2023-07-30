/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.repository.RankingRepository;
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
public class RankingService implements IFRanking {

    @Autowired
    private RankingRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<RankingDTO> getAll() {
        List<Ranking> list = repository.findAll();
        List<RankingDTO> result = list.stream().map(rank -> mapToDto(rank)).collect(Collectors.toList());
        return result;

    }

    public RankingDTO mapToDto(Ranking rank) {
        RankingDTO result = modelMapper.map(rank, RankingDTO.class);
        return result;
    }

    public Ranking mapToEntity(RankingDTO rankingDTO) {
        Ranking r = modelMapper.map(rankingDTO, Ranking.class);
        return r;
    }

    @Override
    public RankingDTO createTable(RankingDTO s) {

        Ranking a = mapToEntity(s);

        Ranking c = repository.save(a);

        RankingDTO response = mapToDto(c);

        return response;
    }

    @Override
    public RankingDTO updateTables(RankingDTO update) {
        Ranking a = mapToEntity(update);

        Ranking c = repository.save(a);

        RankingDTO response = mapToDto(c);

        return response;
    }

    @Override
    public void deleteByID(int id) {

        repository.DeleteByCode(id);

    }
    
    
    @Override
    public RankingDTO getRankingByID(Integer code) {
        
        Ranking a= repository.FindOneClubs(code);

        RankingDTO result = mapToDto(a);
        return result;

    }
}
