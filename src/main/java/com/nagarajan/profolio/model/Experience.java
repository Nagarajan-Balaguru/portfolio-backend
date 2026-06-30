package com.nagarajan.profolio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "experience")
public class Experience {
    @Id
    private String id;
    private String company;
    private String companyLogoUrl;
    private String role;
    private String startDate;
    private String endDate;
    private boolean current;
    private List<String> highlights;
    private int order;
}