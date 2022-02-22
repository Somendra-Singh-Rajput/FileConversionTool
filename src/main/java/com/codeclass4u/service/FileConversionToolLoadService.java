package com.codeclass4u.service;

import com.codeclass4u.model.FileConversionInput;
import com.codeclass4u.model.FileConversionOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

@Service
public class FileConversionToolLoadService {

    @Value("${convert.url}")
    private String convertUrl;

    @Value("${convert.api}")
    private String convertApi;

    RestTemplate restTemplate = new RestTemplate();

    public FileConversionOutput convertFile(FileConversionInput fileConversionInput) throws IOException {

        FileConversionOutput fileConversionOutput = new FileConversionOutput();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(fileConversionInput);

        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = okhttp3.MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url(convertUrl)
                .post(body)
                .addHeader("x-oc-api-key", convertApi)
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();

        fileConversionOutput = jsonToObj(responseBody.string());
        return fileConversionOutput;
    }

    public FileConversionOutput jsonToObj(String json) throws JsonProcessingException {

        ObjectMapper m = new ObjectMapper();
        m.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        FileConversionOutput fileConversionOutput = m.readValue(json, new TypeReference<FileConversionOutput>() {});

        return fileConversionOutput;
    }
}
