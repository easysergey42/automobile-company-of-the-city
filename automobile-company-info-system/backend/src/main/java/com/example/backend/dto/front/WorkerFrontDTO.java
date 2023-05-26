package com.example.backend.dto.front;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkerFrontDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Long team;
    private String spec;
}
