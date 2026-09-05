package edu.mum.cs.cs425.final_exam_software_engineering.service.impl;

import edu.mum.cs.cs425.final_exam_software_engineering.model.Registration;
import edu.mum.cs.cs425.final_exam_software_engineering.model.WorkShop;
import edu.mum.cs.cs425.final_exam_software_engineering.repository.RegistrationRepository;
import edu.mum.cs.cs425.final_exam_software_engineering.repository.WorkShopRepository;
import edu.mum.cs.cs425.final_exam_software_engineering.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final WorkShopRepository workShopRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository, WorkShopRepository workShopRepository) {
        this.registrationRepository = registrationRepository;
        this.workShopRepository = workShopRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Registration> findAll() {
        return registrationRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Registration findById(Long id) {
        return registrationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registration with id " + id + " does not exist."));
    }

    @Override
    public List<Registration> findAllByWorkShop(Long workShop) {
        List <Registration> registrations = new ArrayList<>();
        registrationRepository.findAll().forEach(registration -> {
            if (registration.getWorkshop().equals(workShop)) {
                registrations.add(registration);
            }
        });
        return registrations;
    }

    @Override
    public Registration registerWorkShop(Long workShop, Registration registration) {
        // get the capacity of the work shop and check if its above 0
        if (workShopRepository.findById(workShop).isPresent()) {
            WorkShop workshop = workShopRepository.findById(workShop).get();
            if (workshop.getCapacity() > 0 && workshop.getRegistration_deadline().isAfter(LocalDate.now())
            ) {
               return registrationRepository.save(registration);
            } else {
                return registration;
            }
        }

        return registration;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        registrationRepository.deleteById(id);
    }
}