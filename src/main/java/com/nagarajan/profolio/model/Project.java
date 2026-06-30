package com.nagarajan.profolio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "projects")
public class Project {
    @Id
    private String id;
    private String title;
    private String description;
    private List<String> techStack;
    private String githubUrl;
    private String liveUrl;
    private String thumbnail;
    private boolean featured;
    private int order;
}