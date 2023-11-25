/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.DTO.SchedulesDTO;
import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.entites.Referees;
import fpt.aptech.LMproject.entites.Schedules;
import fpt.aptech.LMproject.entites.Season;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.ClubsRepository;
import fpt.aptech.LMproject.repository.RankingRepository;
import fpt.aptech.LMproject.repository.RefereesRepository;
import fpt.aptech.LMproject.repository.SchedulesRepository;
import fpt.aptech.LMproject.repository.SeasonRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
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
    public void createSchedule(List<RankingDTO> clubs) {

        int numRounds = 38;
        int matchesPerRound = 10;

        Season ss = repositoryseason.findById(clubs.get(1).getSeason())
                .orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(clubs.get(1).getSeason())));

        List<SchedulesDTO> matches = new ArrayList<>();

        for (int i = 0; i < clubs.size(); i++) {
            for (int j = i + 1; j < clubs.size(); j++) {
                SchedulesDTO match = new SchedulesDTO();
                match.setClubHome(clubs.get(i));
                match.setClubAway(clubs.get(j));
                match.setSeason(ss);
                matches.add(match);

            }
        }

        for (int round = 1; round <= numRounds; round++) {
            List<SchedulesDTO> currentRoundMatches = new ArrayList<>();
            Set<String> usedPairs = new HashSet<>();

            Collections.shuffle(matches);

            // Sử dụng while để đảm bảo có đủ số trận đấu trong mỗi vòng
            while (currentRoundMatches.size() < matchesPerRound) {
                for (SchedulesDTO match : matches) {
                    String pairKey = getPairKey(match);

                    // Check if the pair has already been used in this round
                    if (usedPairs.contains(pairKey)) {
                        continue;
                    }

                    currentRoundMatches.add(match);
                    usedPairs.add(pairKey);
                    matches.remove(match);
                    break;
                }
            }

            if (round == 1) {
                Collections.shuffle(currentRoundMatches);
                for (SchedulesDTO match : currentRoundMatches) {
                    Schedules scheduleEntity1 = new Schedules();
                    scheduleEntity1.setClubHome(mapToEntityRanking(match.getClubAway()));
                    scheduleEntity1.setClubAway(mapToEntityRanking(match.getClubHome()));
                    scheduleEntity1.setLeg("return");
                    scheduleEntity1.setSeason(match.getSeason());
                    scheduleEntity1.setRoundmatch(20);

                    schedule.save(scheduleEntity1);
                }

            } else {

                for (SchedulesDTO match : currentRoundMatches) {
                    Schedules scheduleEntity1 = new Schedules();
                    scheduleEntity1.setClubHome(mapToEntityRanking(match.getClubAway()));
                    scheduleEntity1.setClubAway(mapToEntityRanking(match.getClubHome()));
                    scheduleEntity1.setLeg("return");
                    scheduleEntity1.setSeason(match.getSeason());
                    scheduleEntity1.setRoundmatch(20 + round - 1);

                    schedule.save(scheduleEntity1);
                }

            }
            Collections.shuffle(currentRoundMatches);

            for (SchedulesDTO match : currentRoundMatches) {
                Schedules scheduleEntity = new Schedules();
                scheduleEntity.setClubHome(mapToEntityRanking(match.getClubHome()));
                scheduleEntity.setClubAway(mapToEntityRanking(match.getClubAway()));
                scheduleEntity.setLeg("first");
                scheduleEntity.setSeason(match.getSeason());
                scheduleEntity.setRoundmatch(round);

                schedule.save(scheduleEntity);
            }
        }
    }

    private String getPairKey(SchedulesDTO match) {
        // Creating a unique key for the pair using club IDs
        return match.getClubHome().getId() + "-" + match.getClubAway().getId();
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
    public SchedulesDTO updateAndFixMatches(SchedulesDTO update
    ) {
        Schedules a = mapToEntitySchdules(update);

        Schedules c = schedule.save(a);

        SchedulesDTO response = mapToDtoSchdules(c);

        return response;
    }

    // user and Admin 
    @Override
    public SchedulesDTO getMatchByID(Integer id
    ) {
        Optional<Schedules> a = schedule.findById(id);

        SchedulesDTO dto = mapToDtoSchdules(a.orElseThrow(() -> new ResourceNotFoundException("Schedules", "id", String.valueOf(id))));

        return dto;
    }

    @Override
    public void updateActiveMatches(Integer code, Integer active
    ) {
        schedule.updateActiveMatch(code, active);
    }

    @Override
    public List<SchedulesDTO> findClubsActive(Integer id
    ) {
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
    public List<SchedulesDTO> findLeg(String leg, Integer season
    ) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        List<Schedules> list = schedule.FindLeg(leg, a);
        List<SchedulesDTO> result = list.stream().map(rank -> mapToDtoSchdules(rank)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int legCount(String leg, Integer season
    ) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        return schedule.countLeg(leg, a);

    }

    @Override
    public boolean checkSeason(Integer season
    ) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));

        if (schedule.checkSeason(a) == true) {
            return true;
        } else {

            return false;
        }

    }

    @Override
    public void deleteSeasonTable(Integer season
    ) {
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
    public void updateSchduleActiveUI(Integer season
    ) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        schedule.updateScheduleUI(a);
    }

    @Override
    public List<SchedulesDTO> listMatchFollowClub(Integer id, Integer season
    ) {
        Season s = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        Ranking r = ranking.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ranking", "id", String.valueOf(id)));
        List<Schedules> list = schedule.FindByMatchClub(r, s);
        List<SchedulesDTO> result = list.stream().map(rank -> mapToDtoSchdules(rank)).collect(Collectors.toList());
        return result;
    }

    @Override
    public void updateMatchesHomepage(Integer isHome, Integer roundmatch) {
        schedule.updateHomepage(isHome, roundmatch);
    }

    @Override
    public List<SchedulesDTO> getMatchHomepage() {
        List<Schedules> list = schedule.getMatchHomepage();
        List<SchedulesDTO> result = list.stream().map(rank -> mapToDtoSchdules(rank)).collect(Collectors.toList());
        return result;
    }

    @Override
    public void updateResetMatchesHomepage(Integer roundmatch) {
        schedule.updateResetHomepage(roundmatch);
    }

    @Override
    public void updateType(Integer type, Integer id) {
        schedule.updateType(type, id);
    }

    @Override
    public List<SchedulesDTO> getResult() {
        List<Schedules> list = schedule.getResult();
        List<SchedulesDTO> result = list.stream().map(rank -> mapToDtoSchdules(rank)).collect(Collectors.toList());
        return result;
    }

}
