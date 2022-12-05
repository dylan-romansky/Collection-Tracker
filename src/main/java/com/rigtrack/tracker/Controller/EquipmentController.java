package com.rigtrack.tracker.Controller;

import com.rigtrack.tracker.Entity.Equipment;
import com.rigtrack.tracker.Service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("eqp/")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;
    @PostMapping("/create")
    public Equipment createEquipment(@RequestBody Equipment equipment)  {
        return this.equipmentService.createEquipment(equipment);
    }
    @GetMapping("/getbyid/{id}")
    public Equipment getEquipmentById(@PathVariable Long id)    {
        return this.equipmentService.getEquipmentById(id);
    }
    @GetMapping("/getall")
    public List<Equipment> getAllEquipment()    {
        return this.equipmentService.getAllEquipment();
    }
    @PutMapping("/update")
    public Equipment updateEquipment(@RequestBody Equipment equipment)  {
        return this.equipmentService.updateEquipment(equipment);
    }
    @DeleteMapping("/deletebyid/{id}")
    public Long deleteEquipmentById(@PathVariable Long id)  {
        return this.equipmentService.deleteEquipmentById(id);
    }
}
