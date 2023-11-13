/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.DTO.FlagsDTO;
import java.util.List;

/**
 *
 * @author Minh Trung
 */
public interface IFFlags {

    public List<FlagsDTO> findAll(int number);

    public List<FlagsDTO> findAllNoPagination();

    public int PageTotal();

    public FlagsDTO saveFlags(FlagsDTO newFlags);

    public FlagsDTO updateFlags(FlagsDTO updateFlags);

    public FlagsDTO getFlagsByID(int id);
    
    public void  updateImageFlags (int id);

    public void deleteByID(int id);
    
    public boolean checkExistFlags(Integer id);
}
