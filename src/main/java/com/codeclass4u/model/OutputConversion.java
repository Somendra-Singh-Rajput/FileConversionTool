package com.codeclass4u.model;

import lombok.Data;

import java.util.List;

@Data
public class OutputConversion {
    private String id;
    private String target;
    private String category;
    private Options options;
    private Metadata metadata;
    private List<String> output_target;
}
