package com.rigtrack.tracker.Service;

import com.rigtrack.tracker.Entity.Equipment;

import java.util.List;

public interface EquipmentService {
    Equipment createEquipment(Equipment equipment);
    Equipment updateEquipment(Equipment equipment);
    List<Equipment> getAllEquipment();
    Equipment getEquipmentById(Long id);
    Long deleteEquipmentById(Long id);
}
