package com.codeclass4u.model;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class FileConversionOutput {

    private String id;
    private String token;
    private String type;
    private Status status;
    private List<String> errors;
    private List<String> warnings;
    private String process;
    private String fail_on_input_error;
    private String fail_on_conversion_error;
    private List<OutputConversion> conversion;
    private List<String> limits;
    private List<OutputInput> input;
    private List<String> output;
    private String callback;
    private String notify_status;
    private String server;
    private String spent;
    private String created_at;
    private String modified_at;
}
