package com.nagarajan.profolio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "education")
public class Education {
    @Id
    private String id;
    private String institution;
    private String degree;
    private String grade;
    private String startDate;
    private String endDate;
    private String location;
    private String type;
    private int order;
}