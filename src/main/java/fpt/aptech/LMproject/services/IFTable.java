/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fpt.aptech.LMproject.services;

import fpt.aptech.LMproject.entites.Schedules;

/**
 *
 * @author Minh Trung
 */
public interface IFTable {

    public void createNewSeason();

    public void createNewRanking();

    public Schedules createNewSchedulesfornewseason(Schedules newSchedules);

}
