package com.project.test.controller;

import com.project.test.dto.PositionDto;
import com.project.test.entities.Position;
import com.project.test.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recruitment/")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/positions")
    public List<Position> getAll(){
        return positionService.fetchAll();
    }

    @GetMapping("/position/{id}")
    public Position getById(@PathVariable UUID id){
        return positionService.fetchById(id);
    }

    @PostMapping("/position/create")
    public Position create(@RequestBody PositionDto positionDto){
        return positionService.createPosition(positionDto);
    }

    @PostMapping("/position/update")
    public Position update(@RequestBody PositionDto positionDto){
        return positionService.updatePosition(positionDto);
    }

    @DeleteMapping("/position/delete/{id}")
    private void delete(@PathVariable UUID id){
        positionService.deletePosition(id);
    }
}
