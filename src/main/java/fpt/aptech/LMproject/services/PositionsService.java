/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.PositionsDTO;
import fpt.aptech.LMproject.entites.Positions;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
import fpt.aptech.LMproject.repository.PlayersRepository;
import fpt.aptech.LMproject.repository.PositionsRepository;
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
public class PositionsService implements IFPositions {

    @Autowired
    private PositionsRepository repository;
    
        @Autowired
    private PlayersRepository players;
    ModelMapper modelMapper = new ModelMapper();

    public PositionsDTO mapToDto(Positions positions) {
        PositionsDTO result = modelMapper.map(positions, PositionsDTO.class);
        return result;
    }

    public Positions mapToEntity(PositionsDTO positionsDTO) {
        Positions positions = modelMapper.map(positionsDTO, Positions.class);
        return positions;
    }

    @Override
    public List<PositionsDTO> findAll(int number) {
        if (number == 1) {
            Page<Positions> list = repository.findAll(PageRequest.of(0, 5));
            List<PositionsDTO> positionresult = list.stream().map(positions -> mapToDto(positions)).collect(Collectors.toList());
            return positionresult;
        } else {
            Page<Positions> list = repository.findAll(PageRequest.of(0, 5));

            for (var i = 1; i <= number - 1; i++) {

                list = repository.findAll(list.nextPageable());
            }
            List<PositionsDTO> positionsresult = list.stream().map(positions -> mapToDto(positions)).collect(Collectors.toList());
            return positionsresult;
        }
    }

    @Override
    public List<PositionsDTO> findAllNoPagination() {
        List<Positions> list = repository.findAll();
        List<PositionsDTO> positionresult = list.stream().map(positions -> mapToDto(positions)).collect(Collectors.toList());
        return positionresult;
    }

    @Override
    public int PageTotal() {
        Page<Positions> list = repository.findAll(PageRequest.of(0, 5));
        return list.getTotalPages();
    }

    @Override
    public PositionsDTO savePositions(PositionsDTO newPositions) {
        // covert DTO -> entity 
        Positions a = mapToEntity(newPositions);

        //save booking
        Positions c = repository.save(a);

        //entity->DTO
        PositionsDTO PositionsResponse = mapToDto(c);

        return PositionsResponse;
    }

    @Override
    public PositionsDTO updatePositions(PositionsDTO updatePositions) {
        // covert DTO -> entity 
        Positions a = mapToEntity(updatePositions);

        //save booking
        Positions c = repository.save(a);

        //entity->DTO
        PositionsDTO StadiumsResponse = mapToDto(c);

        return StadiumsResponse;
    }

    @Override
    public PositionsDTO getPositionsByID(int id) {
        Optional<Positions> Positions = repository.findById(id);
        PositionsDTO dto = mapToDto(Positions.orElseThrow(() -> new ResourceNotFoundException("Positions", "id", String.valueOf(id))));
        return dto;
    }

    @Override
    public void deleteByID(int id) {
        Positions a = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Positions", "id", String.valueOf(id)));
        repository.delete(a);
    }

    @Override
    public boolean checkExistPositions(Integer id) {
         Positions a = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Positions", "id", String.valueOf(id)));
       return  players.checkPositions(a);
    }
}
