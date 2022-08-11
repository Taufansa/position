package com.project.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PositionDto {
    private UUID id;

    private String type;

    private String url;

    private Date createdAt;

    private String company;

    private String companyUrl;

    private String location;

    private String title;

    private String description;
}
