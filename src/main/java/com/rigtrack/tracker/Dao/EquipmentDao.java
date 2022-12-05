package com.rigtrack.tracker.Dao;

import com.rigtrack.tracker.Entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentDao extends JpaRepository<Equipment, Long> {
}
