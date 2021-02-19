package com.example.demo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BookJSON extends BookJSONRequest implements Serializable {

    // Serializable to avoid Cannot serialize redis ERROR !

    private Long id;
    private List<VersionJSON> versions;
    private Integer nbOfVersion;

}
