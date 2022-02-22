package com.codeclass4u.model;

import lombok.Data;

import java.util.List;

@Data
public class OutputInput {

    private String id;
    private String type;
    private String status;
    private String source;
    private String engine;
    private List<String> options;
    private String filename;
    private String size;
    private String hash;
    private String checksum;
    private String content_type;
    private String created_at;
    private String modified_at;
    private Credentials credentials;
    private Parameters parameters;
    private Metadata metadata;
}
