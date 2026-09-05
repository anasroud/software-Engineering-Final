package edu.mum.cs.cs425.final_exam_software_engineering.service;

import edu.mum.cs.cs425.final_exam_software_engineering.model.Registration;
import edu.mum.cs.cs425.final_exam_software_engineering.model.WorkShop;

import java.util.List;

public interface WorkShopService {

    List<WorkShop> findAll();

    WorkShop findById(Long id);

    WorkShop save(WorkShop workShop);
    void deleteById(Long id);
}