package edu.mum.cs.cs425.final_exam_software_engineering.repository;

import edu.mum.cs.cs425.final_exam_software_engineering.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}