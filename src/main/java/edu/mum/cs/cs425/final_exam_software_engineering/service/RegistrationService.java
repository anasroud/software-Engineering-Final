package edu.mum.cs.cs425.final_exam_software_engineering.service;

import edu.mum.cs.cs425.final_exam_software_engineering.model.Registration;
import edu.mum.cs.cs425.final_exam_software_engineering.model.WorkShop;

import java.util.List;

public interface RegistrationService {

    List<Registration> findAll();

    Registration findById(Long id);

    List<Registration> findAllByWorkShop(Long workShop);

    Registration registerWorkShop(Long workShop, Registration registration);


    void deleteById(Long id);
}