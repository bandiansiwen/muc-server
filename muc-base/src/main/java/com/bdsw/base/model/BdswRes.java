package com.bdsw.base.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain=true)
@Data
public class BdswRes<T> {

    private String tId;
    private Integer code;
    private String message;
    private T data;
}
