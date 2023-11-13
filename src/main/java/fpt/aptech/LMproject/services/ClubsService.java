/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.ClubsDTO;
import fpt.aptech.LMproject.DTO.ClubsRefSeasonDTO;
import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.entites.ClubsRefSeason;
import fpt.aptech.LMproject.entites.Season;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.ClubsRefSeasonRepository;
import fpt.aptech.LMproject.repository.ClubsRepository;
import fpt.aptech.LMproject.repository.PlayersRepository;
import fpt.aptech.LMproject.repository.SeasonRepository;
import java.util.List;
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
public class ClubsService implements IFClubs {

    @Autowired
    private ClubsRepository repository;

    @Autowired
    private ClubsRefSeasonRepository clubrefSeason;
    @Autowired
    private SeasonRepository repositoryseason;

    @Autowired
    private PlayersRepository players;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ClubsDTO> getAll(int number) {
        if (number == 1) {
            Page<Clubs> list = repository.findAll(PageRequest.of(0, 5));
            List<ClubsDTO> clubsresult = list.stream().map(clubs -> mapToDto(clubs)).collect(Collectors.toList());
            return clubsresult;
        } else {
            Page<Clubs> list = repository.findAll(PageRequest.of(0, 5));

            for (var i = 1; i <= number - 1; i++) {

                list = repository.findAll(list.nextPageable());
            }
            List<ClubsDTO> clubsresult = list.stream().map(clubs -> mapToDto(clubs)).collect(Collectors.toList());
            return clubsresult;
        }

    }

    @Override
    public int PageTotal() {
        Page<Clubs> list = repository.findAll(PageRequest.of(0, 5));
        return list.getTotalPages();

    }

    @Override
    public ClubsDTO saveClubs(ClubsDTO club) {
        // covert DTO -> entity 
        Clubs clubs = mapToEntity(club);
        //save booking
        Clubs c = repository.save(clubs);
        //entity->DTO
        ClubsDTO ClubsResponse = mapToDto(c);
        return ClubsResponse;
    }

    @Override
    public ClubsDTO getClubByCode(String code) {
        Clubs clubs = repository.FindOneClubs(code);
        ClubsDTO clubsresult = mapToDto(clubs);
        return clubsresult;
    }

    @Override
    public void deleteByID(Integer id) {
        repository.DeleteByCode(id);

    }

    public ClubsDTO mapToDto(Clubs clubs) {
        ClubsDTO result = modelMapper.map(clubs, ClubsDTO.class);
        return result;
    }

    public Clubs mapToEntity(ClubsDTO clubsDTO) {
        Clubs clubs = modelMapper.map(clubsDTO, Clubs.class);
        return clubs;
    }

    public ClubsRefSeasonDTO mapToDtoRef(ClubsRefSeason clubs) {
        ClubsRefSeasonDTO result = modelMapper.map(clubs, ClubsRefSeasonDTO.class);
        return result;
    }

    public ClubsRefSeason mapToEntityRef(ClubsRefSeasonDTO clubsDTO) {
        ClubsRefSeason clubs = modelMapper.map(clubsDTO, ClubsRefSeason.class);
        return clubs;
    }

    @Override
    public List<ClubsDTO> searchByName(String nameclubs) {
        List<Clubs> searchclubs = repository.FindByNameClubs(nameclubs);
        List<ClubsDTO> clubsresult = searchclubs.stream().map(Clubs -> mapToDto(Clubs)).collect(Collectors.toList());
        return clubsresult;

    }

    @Override
    public ClubsDTO updateClubs(ClubsDTO updateclubs) {

        Clubs club = repository.FindOneClubs(updateclubs.getCodeClub());

        club.setName(updateclubs.getName());
        club.setImage(updateclubs.getImage());
        club.setLogo(updateclubs.getLogo());
        club.setLinkclub(updateclubs.getLinkclub());
        club.setActive(updateclubs.getActive());
        club.setStadiumid(updateclubs.getStadiumid());

        Clubs c = repository.save(club);
        ClubsDTO ClubsResponse = mapToDto(c);
        return ClubsResponse;
    }

    @Override
    public List<ClubsDTO> findAllNoPagination() {
        List<Clubs> list = repository.findAll();
        List<ClubsDTO> clubsresult = list.stream().map(clubs -> mapToDto(clubs)).collect(Collectors.toList());
        return clubsresult;
    }

    @Override
    public void updateImageClubs(Integer id) {
        repository.updateImageClubs(id);

    }

    @Override
    public void updateActiveClubs(Integer code, Integer active) {
        repository.updateActiveClubs(code, active);
    }

    @Override
    public List<ClubsDTO> listActiveClub() {
        List<Clubs> list = repository.FindClubsActive();
        List<ClubsDTO> clubsresult = list.stream().map(clubs -> mapToDto(clubs)).collect(Collectors.toList());
        return clubsresult;
    }

    @Override
    public void resetActiveClubs() {
        repository.ResetActiveClubs();
    }

    @Override
    public List<ClubsDTO> getActive() {
        List<Clubs> list = repository.FindByActive();
        List<ClubsDTO> clubsresult = list.stream().map(clubs -> mapToDto(clubs)).collect(Collectors.toList());
        return clubsresult;
    }

    @Override
    public int clubCount() {
        return repository.countClubsActive();
    }

    @Override
    public ClubsRefSeasonDTO addClubsForSeason(ClubsRefSeasonDTO ref) {

        ClubsRefSeason clubs = mapToEntityRef(ref);
        ClubsRefSeason c = clubrefSeason.save(clubs);
        ClubsRefSeasonDTO response = mapToDtoRef(c);
        return response;
    }

    @Override
    public List<ClubsRefSeasonDTO> listRefClub() {

        List<ClubsRefSeason> list = clubrefSeason.findAll();
        List<ClubsRefSeasonDTO> result = list.stream().map(rank -> mapToDtoRef(rank)).collect(Collectors.toList());
        return result;
    }

    @Override
    public int clubCountRef(Integer season) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));

        return clubrefSeason.countClubsRef(a);

    }

    @Override
    public void deleteChooseClub(Integer season, Integer clubID) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));
        Clubs c = repository.findById(clubID).orElseThrow(() -> new ResourceNotFoundException("Clubs", "id", String.valueOf(clubID)));

        clubrefSeason.DeleteByChooseClub(a, c);

    }

    @Override
    public void updateClubsRefActiveUI(Integer season) {
        Season a = repositoryseason.findById(season).orElseThrow(() -> new ResourceNotFoundException("Season", "id", String.valueOf(season)));

        clubrefSeason.updateClubsRefActive(a);
    }

    @Override
    public List<ClubsRefSeasonDTO> listRefClubUI() {
        List<ClubsRefSeason> list = clubrefSeason.getAll();
        List<ClubsRefSeasonDTO> result = list.stream().map(rank -> mapToDtoRef(rank)).collect(Collectors.toList());
        return result;
    }

    @Override
    public boolean checkExistclubs(Integer id) {
        Clubs c = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Clubs", "id", String.valueOf(id)));
        return clubrefSeason.checkExistClubs(c);
    }

    @Override
    public boolean checkExistClubPlayers(Integer id) {
        Clubs c = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Clubs", "id", String.valueOf(id)));
        return players.checkClubs(c);
    }

}
