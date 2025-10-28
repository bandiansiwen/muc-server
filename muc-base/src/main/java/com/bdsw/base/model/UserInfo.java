package com.bdsw.base.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain=true)
@Data
public class UserInfo {

    private String userId;
    private String userName;
}
