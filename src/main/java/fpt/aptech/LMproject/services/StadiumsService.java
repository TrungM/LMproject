/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.StadiumsDTO;
import fpt.aptech.LMproject.entites.Stadiums;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.ClubsRepository;
import fpt.aptech.LMproject.repository.StadiumsRepository;
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
public class StadiumsService implements IFStadiums {

    @Autowired
    private StadiumsRepository repository;
    @Autowired
    private ClubsRepository clubs;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<StadiumsDTO> findAll(int number) {

        if (number == 1) {
            Page<Stadiums> list = repository.findAll(PageRequest.of(0, 5));
            List<StadiumsDTO> stadiumsresult = list.stream().map(stadiums -> mapToDto(stadiums)).collect(Collectors.toList());
            return stadiumsresult;
        } else {
            Page<Stadiums> list = repository.findAll(PageRequest.of(0, 5));

            for (var i = 1; i <= number - 1; i++) {

                list = repository.findAll(list.nextPageable());
            }
            List<StadiumsDTO> stadiumsresult = list.stream().map(stadiums -> mapToDto(stadiums)).collect(Collectors.toList());
            return stadiumsresult;
        }

    }

    @Override
    public StadiumsDTO saveStadiums(StadiumsDTO newStadiums) {

        // covert DTO -> entity 
        Stadiums a = mapToEntity(newStadiums);

        //save booking
        Stadiums c = repository.save(a);

        //entity->DTO
        StadiumsDTO StadiumsResponse = mapToDto(c);

        return StadiumsResponse;

    }

    @Override
    public StadiumsDTO getStadiumsByID(int id) {

        Optional<Stadiums> stadiums = repository.findById(id);

        StadiumsDTO stadiumDTO = mapToDto(stadiums.orElseThrow(() -> new ResourceNotFoundException("Stadiums", "id", String.valueOf(id))));

        return stadiumDTO;

    }

    @Override
    public StadiumsDTO updateStadiums(StadiumsDTO updateStadiums) {
        // covert DTO -> entity 
        Stadiums a = mapToEntity(updateStadiums);

        //save booking
        Stadiums c = repository.save(a);

        //entity->DTO
        StadiumsDTO StadiumsResponse = mapToDto(c);

        return StadiumsResponse;
    }

    public StadiumsDTO mapToDto(Stadiums stadiums) {

        StadiumsDTO result = modelMapper.map(stadiums, StadiumsDTO.class);

        return result;

    }

    public Stadiums mapToEntity(StadiumsDTO stadiumsDTO) {
        Stadiums a = modelMapper.map(stadiumsDTO, Stadiums.class);
        return a;
    }

    @Override
    public void deleteByID(int id) {
        // tim doi tuong 

        Stadiums a = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stadiums", "id", String.valueOf(id)));

        repository.delete(a);

    }

    @Override
    public int PageTotal() {
        Page<Stadiums> list = repository.findAll(PageRequest.of(0, 5));
        return list.getTotalPages();

    }

    @Override
    public List<StadiumsDTO> findAllNoPagination() {
        List<Stadiums> list = repository.findAll();
        List<StadiumsDTO> stadiumsresult = list.stream().map(stadiums -> mapToDto(stadiums)).collect(Collectors.toList());
        return stadiumsresult;
    }

    @Override
    public void updateStadiumActive(Integer id) {

        repository.updateActiveByID(id);
    }

    @Override
    public void updateStadiumActive0(Integer id) {
        repository.updateActive0ByID(id);
    }

    @Override
    public void updateImageStadium(Integer id) {
        repository.updateImageStadiums(id);
    }

    @Override
    public boolean checkExistStadiums(Integer id) {
        Stadiums c = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stadiums", "id", String.valueOf(id)));
        return clubs.checkStadiums(c);
    }

}
