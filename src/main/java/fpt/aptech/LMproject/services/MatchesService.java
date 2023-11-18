/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RankingDTO;
import fpt.aptech.LMproject.DTO.SchedulesDTO;
import fpt.aptech.LMproject.entites.Ranking;
import fpt.aptech.LMproject.entites.Schedules;
import fpt.aptech.LMproject.entites.Season;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.ClubsRepository;
import fpt.aptech.LMproject.repository.RankingRepository;
import fpt.aptech.LMproject.repository.SchedulesRepository;
import fpt.aptech.LMproject.repository.SeasonRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
    public void createSchdule(List<RankingDTO> clubs) {

        int numRounds = 38;
        int matchesPerRound = 10;

        List<SchedulesDTO> matches = new ArrayList<>();
        Set<RankingDTO> selectedTeams = new HashSet<>();

        Season ss = repositoryseason.findById(clubs.get(1).getSeason())
                .orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(clubs.get(1).getSeason())));

        for (int i = 0; i < clubs.size(); i++) {
            for (int j = i + 1; j < clubs.size(); j++) {
                SchedulesDTO a = new SchedulesDTO();
                a.setClubHome(clubs.get(i));
                a.setClubAway(clubs.get(j));
                a.setSeason(ss);
                matches.add(a);
            }
        }

        Collections.shuffle(matches);

        for (int round = 1; round <= numRounds; round++) {
            List<SchedulesDTO> currentRoundMatches = new ArrayList<>();

            // Sử dụng while để đảm bảo có đủ số trận đấu trong mỗi vòng
            while (currentRoundMatches.size() < matchesPerRound) {
                for (SchedulesDTO match : matches) {
                    if (!selectedTeams.contains(match.getClubHome()) && !selectedTeams.contains(match.getClubAway())) {
                        currentRoundMatches.add(match);
                        selectedTeams.add(match.getClubHome());
                        selectedTeams.add(match.getClubAway());
                    }
                    // Kiểm tra xem đã đủ số trận cho vòng hiện tại chưa
                    if (currentRoundMatches.size() >= matchesPerRound) {
                        break;
                    }
                }
            }

            for (SchedulesDTO match : currentRoundMatches) {
                Schedules scheduleEntity = new Schedules();
                scheduleEntity.setClubHome(mapToEntityRanking(match.getClubHome()));
                scheduleEntity.setClubAway(mapToEntityRanking(match.getClubAway()));
                scheduleEntity.setLeg(round > 19 ? "return" : "first");
                scheduleEntity.setSeason(match.getSeason());
                scheduleEntity.setRoundmatch(round);

                schedule.save(scheduleEntity);
            }

            // Loại bỏ đội đã chọn để chuẩn bị cho vòng kế tiếp
            selectedTeams.clear();
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
    public SchedulesDTO updateAndFixMatches(SchedulesDTO update
    ) {
        Schedules a = mapToEntitySchdules(update);

        Schedules c = schedule.save(a);

        SchedulesDTO response = mapToDtoSchdules(c);

        return response;
    }

    @Override
    public SchedulesDTO getMatchByID(Integer id
    ) {
        Optional<Schedules> a = schedule.findById(id);

        SchedulesDTO dto = mapToDtoSchdules(a.orElseThrow(() -> new ResourceNotFoundException("Stadiums", "id", String.valueOf(id))));

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

}
