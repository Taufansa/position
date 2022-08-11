package com.project.test.services;

import com.project.test.dto.PositionDto;
import com.project.test.entities.Position;
import com.project.test.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public List<Position> fetchAll(){
        return positionRepository.findAll();
    }

    public Position fetchById(UUID id){
        return positionRepository.findById(id).get();
    }

    public Position createPosition(PositionDto positionDto){
        var position = Position.builder()
                .company(positionDto.getCompany())
                .type(positionDto.getType())
                .url(positionDto.getUrl())
                .companyUrl(positionDto.getCompanyUrl())
                .location(positionDto.getLocation())
                .title(positionDto.getTitle())
                .description(positionDto.getDescription())
                .build();
        return positionRepository.save(position);
    }

    public Position updatePosition(PositionDto positionDto) {
        var position = positionRepository.findById(positionDto.getId()).get();
        position.setCompany(positionDto.getCompany());
        position.setType(positionDto.getType());
        position.setUrl(position.getUrl());
        position.setCompanyUrl(position.getCompanyUrl());
        position.setLocation(positionDto.getLocation());
        position.setTitle(position.getTitle());
        position.setDescription(position.getDescription());
        return positionRepository.save(position);
    }

    public void deletePosition(UUID id){
        positionRepository.deleteById(id);
    }


}
