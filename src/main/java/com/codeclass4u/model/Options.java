package com.codeclass4u.model;

import lombok.Data;

@Data
public class Options {

    private String download_password;
    private String allow_multiple_outputs;
    private String preset;
    private String output_filename;
    private String dpi;
    private String width;
    private String height;
    private String resize_unit;
    private String ai_upscale;
    private String crop_top;
    private String crop_bottom;
    private String crop_left;
    private String crop_right;
    private String crop_origin_x;
    private String crop_origin_y;
    private String crop_width;
    private String crop_height;
    private String color;
    private String enhance;
    private String normalize;
    private String sharpen;
    private String antialias;
    private String despeckle;
    private String equalize;
    private String deskew;
    private String black_white_threshold;
    private String quality;
    private String rotate;
    private String alpha_channel;
    private String resolution_unit;
}
