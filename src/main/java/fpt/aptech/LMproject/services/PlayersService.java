/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.PlayersDTO;
import fpt.aptech.LMproject.entites.Players;
import fpt.aptech.LMproject.exceptions.ResourceNotFoundException;
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
public class PlayersService implements IFPlayers {

    @Autowired
    PlayersRepository repository;

    ModelMapper modelMapper = new ModelMapper();

    public PlayersDTO mapToDto(Players players) {
        PlayersDTO result = modelMapper.map(players, PlayersDTO.class);
        return result;
    }

    public Players mapToEntity(PlayersDTO playersDTO) {
        Players players = modelMapper.map(playersDTO, Players.class);
        return players;
    }

    @Override
    public List<PlayersDTO> findAll(int number) {
        if (number == 1) {
            Page<Players> list = repository.findAll(PageRequest.of(0, 5));
            List<PlayersDTO> playersresult = list.stream().map(players -> mapToDto(players)).collect(Collectors.toList());
            return playersresult;
        } else {
            Page<Players> list = repository.findAll(PageRequest.of(0, 5));

            for (var i = 1; i <= number - 1; i++) {

                list = repository.findAll(list.nextPageable());
            }
            List<PlayersDTO> playersresult = list.stream().map(players -> mapToDto(players)).collect(Collectors.toList());
            return playersresult;
        }
    }

    @Override
    public List<PlayersDTO> findAllNoPagination() {
        List<Players> list = repository.findAll();
        List<PlayersDTO> playersresult = list.stream().map(Players -> mapToDto(Players)).collect(Collectors.toList());
        return playersresult;
    }

    @Override
    public int PageTotal() {
        Page<Players> list = repository.findAll(PageRequest.of(0, 5));
        return list.getTotalPages();
    }

    @Override
    public PlayersDTO savePlayers(PlayersDTO newPlayers) {
        // covert DTO -> entity 
        Players clubs = mapToEntity(newPlayers);
        //save booking
        Players c = repository.save(clubs);
        //entity->DTO
        PlayersDTO PlayersResponse = mapToDto(c);
        return PlayersResponse;
    }

    @Override
    public List<PlayersDTO> searchByName(String nameplayers) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateImagePlayers(Integer id) {
        repository.updateImagePlayers(id);
    }

    @Override
    public PlayersDTO updatePlayer(PlayersDTO updatePlayers) {
        Players players = mapToEntity(updatePlayers);
        Players c = repository.save(players);
        PlayersDTO PlayersResponse = mapToDto(c);
        return PlayersResponse;
    }

    @Override
    public void deleteByID(int id) {
        Players a = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Players", "id", String.valueOf(id)));
        repository.delete(a);
    }

    @Override
    public PlayersDTO getPlayersByID(Integer id) {
        Optional<Players> player = repository.findById(id);
        PlayersDTO a = mapToDto(player.orElseThrow(() -> new ResourceNotFoundException("Players", "id", String.valueOf(id))));
        return a;
    }

    @Override
    public List<PlayersDTO> getAll() {
        List<Players> list = repository.getAll();
        List<PlayersDTO> playersresult = list.stream().map(Players -> mapToDto(Players)).collect(Collectors.toList());
        return playersresult;
    }

}
