 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.entites.Season;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.ClubsRepository;
import fpt.aptech.LMproject.repository.RankingRepository;
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
public class RankingService implements IFRanking {
    
    @Autowired
    private RankingRepository repository;
    @Autowired
    SeasonRepository repositoryseason;
    @Autowired
    private ClubsRepository clubs;
    ModelMapper modelMapper = new ModelMapper();
    
    @Override
    public List<RankingDTO> getAll() {
        List<Ranking> list = repository.getAll();
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
    public RankingDTO getRankingByCodeClubs(Integer code) {
        
        Ranking a = repository.FindOneClubs(code);
        
        RankingDTO result = mapToDto(a);
        return result;
        
    }
    
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
    
    @Override
    public void deleteSeasonReank(Integer season, Integer clubid) {
        Clubs c = clubs.findById(clubid).orElseThrow(() -> new ResourceNotFoundException("Clubs", "id", String.valueOf(clubid)));
        repository.DeleteBySeason(season, c);
        
    }
    
    @Override
    public List<RankingDTO> getListUI() {
        List<Ranking> list = repository.getRankingUI();
        List<RankingDTO> result = list.stream().map(rank -> mapToDto(rank)).collect(Collectors.toList());
        return result;
    }
    
    @Override
    public void updateRankingActiveUI(Integer id) {
        repository.updateRankingUI(id);
        
    }

    @Override
    public RankingDTO getRankingByID(Integer id) {
      Ranking ranking = repository.getByID(id);
        RankingDTO result = mapToDto(ranking);
        return result;
    }
    
}
