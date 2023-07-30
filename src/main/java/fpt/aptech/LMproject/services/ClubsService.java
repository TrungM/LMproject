/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.ClubsDTO;
import fpt.aptech.LMproject.entites.Clubs;
import fpt.aptech.LMproject.repository.ClubsRepository;
import fpt.aptech.LMproject.repository.StadiumsRepository;
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
    private StadiumsRepository repositoryStadiums;
    private StadiumsService stadiumsv;

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
    public void updateActiveClubs(Integer code,Integer active) {
        repository.updateActiveClubs(code,active);
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

}
