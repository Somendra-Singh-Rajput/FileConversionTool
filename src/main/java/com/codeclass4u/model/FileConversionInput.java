package com.codeclass4u.model;

import lombok.Data;
import java.util.List;

@Data
public class FileConversionInput {

    private List<Input> input;
    private List<Conversion> conversion;

}
