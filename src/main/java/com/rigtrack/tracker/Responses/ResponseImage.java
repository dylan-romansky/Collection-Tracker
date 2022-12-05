package com.rigtrack.tracker.Responses;

import lombok.Getter;
import lombok.Setter;

public class ResponseImage {
    @Getter
    @Setter
    private String name;
    @Getter @Setter
    private String url;
    @Getter @Setter
    private String type;
    @Getter @Setter
    private long size;
    public ResponseImage(String name, String url, String type, long size)   {
        this.name = name;
        this.url = url;
        this.type = type;
        this.size = size;
    }
}
