/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RefereesDTO;
import fpt.aptech.LMproject.entites.Referees;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.RefereesRepository;
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
public class RefereesService implements IFReferees{
    
    @Autowired
    private RefereesRepository repository;
    ModelMapper modelMapper = new ModelMapper();

    public RefereesDTO mapToDto(Referees referees) {
        RefereesDTO result = modelMapper.map(referees, RefereesDTO.class);
        return result;
    }

    public Referees mapToEntity(RefereesDTO refereesDTO) {
        Referees referees = modelMapper.map(refereesDTO, Referees.class);
        return referees;
    }

    @Override
    public List<RefereesDTO> findAll(int number) {
        if (number == 1) {
            Page<Referees> list = repository.findAll(PageRequest.of(0, 5));
            List<RefereesDTO> refereesresult = list.stream().map(news -> mapToDto(news)).collect(Collectors.toList());
            return refereesresult;
        } else {
            Page<Referees> list = repository.findAll(PageRequest.of(0, 5));

            for (var i = 1; i <= number - 1; i++) {

                list = repository.findAll(list.nextPageable());
            }
            List<RefereesDTO> refereesresult = list.stream().map(news -> mapToDto(news)).collect(Collectors.toList());
            return refereesresult;
        }
    }

    @Override
    public List<RefereesDTO> findAllNoPagination() {
        List<Referees> list = repository.findAll();
        List<RefereesDTO> refereesresult = list.stream().map(news -> mapToDto(news)).collect(Collectors.toList());
        return refereesresult;
    }

    @Override
    public int PageTotal() {
        Page<Referees> list = repository.findAll(PageRequest.of(0, 5));
        return list.getTotalPages();
    }

    @Override
    public RefereesDTO saveReferees(RefereesDTO newReferees) {
        // covert DTO -> entity 
        Referees a = mapToEntity(newReferees);

        //save booking
        Referees c = repository.save(a);

        //entity->DTO
        RefereesDTO RefereesResponse = mapToDto(c);

        return RefereesResponse;

    }

    @Override
    public RefereesDTO updateReferees(RefereesDTO updateReferees) {
        // covert DTO -> entity 
        Referees a = mapToEntity(updateReferees);

        //save booking
        Referees c = repository.save(a);

        //entity->DTO
        RefereesDTO RefereesResponse = mapToDto(c);

        return RefereesResponse;
    }

    @Override
    public RefereesDTO getRefereesByID(int id) {
        Optional<Referees> Positions = repository.findById(id);
        RefereesDTO stadiumDTO = mapToDto(Positions.orElseThrow(() -> new ResourceNotFoundException("Referees", "id", String.valueOf(id))));
        return stadiumDTO;
    }

    @Override
    public void deleteByID(int id) {
        Referees a = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Referees", "id", String.valueOf(id)));
        repository.delete(a);
    }
    
}
