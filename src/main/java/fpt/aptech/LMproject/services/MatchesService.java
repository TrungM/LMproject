/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.DTO.SchedulesDTO;
import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.entites.Schedules;
import fpt.aptech.LMproject.entites.Season;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.ClubsRepository;
import fpt.aptech.LMproject.repository.RankingRepository;
import fpt.aptech.LMproject.repository.SchedulesRepository;
import fpt.aptech.LMproject.repository.SeasonRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Minh Trung
 */
@Service
public class MatchesService implements IFMatches {

    @Autowired
    SchedulesRepository schedule;
    @Autowired
    RankingRepository ranking;
    @Autowired
    SeasonRepository repositoryseason;

    @Autowired
    private ClubsRepository clubs;

    ModelMapper modelMapper = new ModelMapper();

    public SchedulesDTO mapToDtoSchdules(Schedules a) {

        SchedulesDTO result = modelMapper.map(a, SchedulesDTO.class);

        return result;

    }

    public Schedules mapToEntitySchdules(SchedulesDTO s) {
        Schedules a = modelMapper.map(s, Schedules.class);
        return a;
    }

    public Ranking mapToEntityRanking(RankingDTO rankingDTO) {
        Ranking r = modelMapper.map(rankingDTO, Ranking.class);
        return r;
    }

    @Override
    public void createSchdule(List<RankingDTO> clubs) {

        int numRounds = 38;

        List<RankingDTO> homeClubs = new ArrayList<>();
        List<RankingDTO> awayClubs = new ArrayList<>();
        List<SchedulesDTO> matches = new ArrayList<>();

        int halfSize = clubs.size() / 2;

        Season ss = repositoryseason.findById(clubs.get(1).getSeason()).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(clubs.get(1).getSeason())));
        for (int i = 0; i < clubs.size(); i++) {
            for (int j = i + 1; j < clubs.size(); j++) {
                SchedulesDTO a = new SchedulesDTO();

                a.setClubHome(clubs.get(i));
                a.setClubAway(clubs.get(j));
                a.setSeason(ss);

                Schedules m = new Schedules();
                m.setClubHome(mapToEntityRanking(a.getClubHome()));
                m.setClubAway(mapToEntityRanking(a.getClubAway()));
                m.setLeg("first");
                m.setSeason(a.getSeason());

                schedule.save(m);

                Schedules m2 = new Schedules();
                m2.setClubHome(mapToEntityRanking(a.getClubAway()));
                m2.setClubAway(mapToEntityRanking(a.getClubHome()));
                m2.setLeg("return");
                m2.setSeason(a.getSeason());

                schedule.save(m2);
            }
        }
    }

    @Override
    public List<SchedulesDTO> findAll() {
        List<Schedules> list = schedule.findAll();
        List<SchedulesDTO> result = list.stream().map(rank -> mapToDtoSchdules(rank)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int SchduleCount() {
        return schedule.countSchedulesActive();

    }

    @Override
    public SchedulesDTO updateAndFixMatches(SchedulesDTO update) {
        Schedules a = mapToEntitySchdules(update);

        Schedules c = schedule.save(a);

        SchedulesDTO response = mapToDtoSchdules(c);

        return response;
    }

    @Override
    public SchedulesDTO getMatchByID(Integer id) {
        Optional<Schedules> a = schedule.findById(id);

        SchedulesDTO dto = mapToDtoSchdules(a.orElseThrow(() -> new ResourceNotFoundException("Stadiums", "id", String.valueOf(id))));

        return dto;
    }

    @Override
    public void updateActiveMatches(Integer code, Integer active) {
        schedule.updateActiveMatch(code, active);
    }

    @Override
    public List<SchedulesDTO> findClubsActive(Integer id) {
        Ranking a = ranking.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ranking", "id", String.valueOf(id)));

        List<Schedules> list = schedule.FindByMatchNameClub(a);
        List<SchedulesDTO> result = list.stream().map(c -> mapToDtoSchdules(c)).collect(Collectors.toList());
        return result;
    }

    @Override
    public void deleteAll() {
        schedule.deleteAll();
    }

    @Override
    public List<SchedulesDTO> findLeg(String leg, Integer season) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        List<Schedules> list = schedule.FindLeg(leg, a);
        List<SchedulesDTO> result = list.stream().map(rank -> mapToDtoSchdules(rank)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int legCount(String leg, Integer season) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        return schedule.countLeg(leg, a);

    }

    @Override
    public boolean checkSeason(Integer season) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));

        if (schedule.checkSeason(a) == true) {
            return true;
        } else {

            return false;
        }

    }

    @Override
    public void deleteSeasonTable(Integer season) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        schedule.DeleteBySeason(a);

    }

    @Override
    public List<SchedulesDTO> getListUI() {
        List<Schedules> list = schedule.getSchedulesUI();
        List<SchedulesDTO> result = list.stream().map(rank -> mapToDtoSchdules(rank)).collect(Collectors.toList());
        return result;
    }

    @Override
    public void updateSchduleActiveUI(Integer season) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        schedule.updateScheduleUI(a);
    }

}
