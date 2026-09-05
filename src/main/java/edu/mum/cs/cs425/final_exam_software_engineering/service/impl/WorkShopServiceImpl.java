package edu.mum.cs.cs425.final_exam_software_engineering.service.impl;

import edu.mum.cs.cs425.final_exam_software_engineering.model.Registration;
import edu.mum.cs.cs425.final_exam_software_engineering.model.WorkShop;
import edu.mum.cs.cs425.final_exam_software_engineering.repository.RegistrationRepository;
import edu.mum.cs.cs425.final_exam_software_engineering.repository.WorkShopRepository;
import edu.mum.cs.cs425.final_exam_software_engineering.service.RegistrationService;
import edu.mum.cs.cs425.final_exam_software_engineering.service.WorkShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("workShopService")
public class WorkShopServiceImpl implements WorkShopService {

    private final WorkShopRepository workShopRepository;

    @Autowired
    public WorkShopServiceImpl(WorkShopRepository workShopRepository) {
        this.workShopRepository = workShopRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkShop> findAll() {
        return workShopRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public WorkShop findById(Long id) {
        return workShopRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("WorkShop with id " + id + " does not exist."));
    }

    @Override
    @Transactional
    public WorkShop save(WorkShop workShop) {
        return workShopRepository.save(workShop);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        workShopRepository.deleteById(id);
    }
}