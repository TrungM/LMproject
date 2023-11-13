/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.PlayersDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFPlayers {

    public List<PlayersDTO> findAll(int number);

    public List<PlayersDTO> findAllNoPagination();

    public int PageTotal();

    public PlayersDTO savePlayers(PlayersDTO newPlayers);

    public List<PlayersDTO> searchByName(String nameplayers);

    public void updateImagePlayers(Integer id);

    public PlayersDTO updatePlayer(PlayersDTO updatePlayers);

    public void deleteByID(int id);

    public PlayersDTO getPlayersByID(Integer id);

    public List<PlayersDTO> getAll();

}
