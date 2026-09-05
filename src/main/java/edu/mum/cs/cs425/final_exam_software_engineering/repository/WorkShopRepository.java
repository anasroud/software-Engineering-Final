package edu.mum.cs.cs425.final_exam_software_engineering.repository;

import edu.mum.cs.cs425.final_exam_software_engineering.model.WorkShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkShopRepository extends JpaRepository<WorkShop, Long> {
}