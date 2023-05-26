package com.example.backend.dto.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateWorkerRequest {
    private String spec;
    private Long person;
    private Long team;
}
