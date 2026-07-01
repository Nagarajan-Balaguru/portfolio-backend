package com.nagarajan.profolio.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Data
@Document(collection = "profile")
public class Profile {
    @Id
    private String id;
    private String name;
    private String tagline;
    private String bio;
    private String avatarUrl;
    private String resumeUrl;
    private String location;
    private String email;
    private String phone;
    private Map<String, String> socialLinks;
}