package com.rigtrack.tracker.Service;

import com.rigtrack.tracker.Dao.EquipmentDao;
import com.rigtrack.tracker.Dao.ImageDao;
import com.rigtrack.tracker.Entity.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentDao equipmentDao;
    @Autowired
    ImageDao imageDao;
    @Override
    public Equipment createEquipment(Equipment equipment) {
        return equipmentDao.save(equipment);
    }

    @Override
    public Equipment updateEquipment(Equipment equipment) {
        Equipment oldEqp = equipmentDao.findById(equipment.getId()).get();
        oldEqp.setName(equipment.getName());
        oldEqp.setDescription(equipment.getDescription());
        if (oldEqp.getImageId() != equipment.getImageId() && oldEqp.getImageId().length() != 0)
            imageDao.deleteById(oldEqp.getImageId());
        oldEqp.setImageId(equipment.getImageId());
        return equipmentDao.save(oldEqp);
    }

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentDao.findAll();
    }

    @Override
    public Equipment getEquipmentById(Long id) {
        return equipmentDao.findById(id).get();
    }

    @Override
    public Long deleteEquipmentById(Long id) {
        Equipment t = equipmentDao.findById(id).get();
        if (t.getImageId().length() != 0)
            imageDao.deleteById(t.getImageId());
        equipmentDao.deleteById(id);
        return id;
    }
}
