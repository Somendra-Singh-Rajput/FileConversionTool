package com.codeclass4u.controller;

import com.codeclass4u.model.FileConversionInput;
import com.codeclass4u.model.FileConversionOutput;
import com.codeclass4u.service.FileConversionToolLoadService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fileConversionTool")
public class FileConversionToolController {

    Logger log = LoggerFactory.getLogger(FileConversionToolController.class);

    @Autowired
    FileConversionToolLoadService fileConversionToolLoadService;

    @PostMapping(path = "/convert", produces= MediaType.APPLICATION_JSON_VALUE)
    public String fileConverter(@RequestBody FileConversionInput fileConversionInput) throws JsonProcessingException {

        FileConversionOutput fileConversionOutput = new FileConversionOutput();

        try{
            fileConversionOutput = fileConversionToolLoadService.convertFile(fileConversionInput);
        }catch (Exception e){
            e.printStackTrace();
        }

        String str = objToJson(fileConversionOutput);

        return str;
    }
    public String objToJson(FileConversionOutput fileConversionOutput) throws JsonProcessingException {

        ObjectMapper m = new ObjectMapper();
        m.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        String  str = m.writeValueAsString(fileConversionOutput);

        return str;
    }
}
