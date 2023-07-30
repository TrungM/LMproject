/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.DTO.SchedulesDTO;
import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.entites.Schedules;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.SchedulesRepository;
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

        for (int i = 0; i < clubs.size(); i++) {

            if (i < halfSize) {
                homeClubs.add(clubs.get(i));
            } else {
                awayClubs.add(clubs.get(i));
            }
        }

        for (int round = 1; round <= numRounds; round++) {

            for (int i = 0; i < halfSize; i++) {
                SchedulesDTO a = new SchedulesDTO();

                a.setClubHome(homeClubs.get(i));
                a.setClubAway(awayClubs.get(i));
                matches.add(a);

            }

        }
        RankingDTO h = awayClubs.get(0);
        awayClubs.remove(0);
        awayClubs.add(h);

        for (SchedulesDTO a : matches) {

            Schedules m = new Schedules();
            m.setClubHome(mapToEntityRanking(a.getClubHome()));
            m.setClubAway(mapToEntityRanking(a.getClubAway()));
            schedule.save(m);

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

}
