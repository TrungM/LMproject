/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.FlagsDTO;
import fpt.aptech.LMproject.entites.Flags;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.FlagsRepository;
import fpt.aptech.LMproject.repository.PlayersRepository;
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
public class FlagsService implements IFFlags {

    @Autowired
    private FlagsRepository repository;
    
      @Autowired
    PlayersRepository players;

    ModelMapper modelMapper = new ModelMapper();

    public FlagsDTO mapToDto(Flags flags) {
        FlagsDTO result = modelMapper.map(flags, FlagsDTO.class);
        return result;
    }

    public Flags mapToEntity(FlagsDTO flagsDTO) {
        Flags flags = modelMapper.map(flagsDTO, Flags.class);
        return flags;
    }

    @Override
    public List<FlagsDTO> findAll(int number) {
        if (number == 1) {
            Page<Flags> list = repository.findAll(PageRequest.of(0, 5));
            List<FlagsDTO> flagsresult = list.stream().map(flags -> mapToDto(flags)).collect(Collectors.toList());
            return flagsresult;
        } else {
            Page<Flags> list = repository.findAll(PageRequest.of(0, 5));

            for (var i = 1; i <= number - 1; i++) {

                list = repository.findAll(list.nextPageable());
            }
            List<FlagsDTO> flagsresult = list.stream().map(flags -> mapToDto(flags)).collect(Collectors.toList());
            return flagsresult;
        }
    }

    @Override
    public List<FlagsDTO> findAllNoPagination() {
        List<Flags> list = repository.findAll();
        List<FlagsDTO> flagsresult = list.stream().map(flags -> mapToDto(flags)).collect(Collectors.toList());
        return flagsresult;
    }

    @Override
    public int PageTotal() {
        Page<Flags> list = repository.findAll(PageRequest.of(0, 5));
        return list.getTotalPages();
    }

    @Override
    public FlagsDTO saveFlags(FlagsDTO newFlags) {
        // covert DTO -> entity 
        Flags a = mapToEntity(newFlags);

        //save booking
        Flags c = repository.save(a);

        //entity->DTO
        FlagsDTO FlagsResponse = mapToDto(c);

        return FlagsResponse;
    }

    @Override
    public FlagsDTO updateFlags(FlagsDTO updateFlags) {
        // covert DTO -> entity 
        Flags a = mapToEntity(updateFlags);

        //save booking
        Flags c = repository.save(a);

        //entity->DTO
        FlagsDTO FlagsResponse = mapToDto(c);

        return FlagsResponse;
    }

    @Override
    public FlagsDTO getFlagsByID(int id) {
        Optional<Flags> flags = repository.findById(id);
        FlagsDTO flagsDTO = mapToDto(flags.orElseThrow(() -> new ResourceNotFoundException("Flags", "id", String.valueOf(id))));
        return flagsDTO;
    }

    @Override
    public void deleteByID(int id) {
        Flags a = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flags", "id", String.valueOf(id)));
        repository.delete(a);
    }

    @Override
    public void updateImageFlags(int id) {
       repository.updateImageFlags(id);
    }

    @Override
    public boolean checkExistFlags(Integer id) {
        Flags c = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flags", "id", String.valueOf(id)));
        return players.checkFlags(c);
    }

}
