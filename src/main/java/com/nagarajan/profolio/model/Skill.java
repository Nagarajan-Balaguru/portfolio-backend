package com.nagarajan.profolio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "skills")
public class Skill {
    @Id
    private String id;
    private String name;
    private String icon;
    private String category;
    private int proficiency;
}