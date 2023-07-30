/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.RankingDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFRanking {

    public List<RankingDTO> getAll();

    public RankingDTO createTable(RankingDTO s);

    public RankingDTO updateTables(RankingDTO update);

    public void deleteByID(int id);

    public RankingDTO getRankingByID(Integer code);

}
