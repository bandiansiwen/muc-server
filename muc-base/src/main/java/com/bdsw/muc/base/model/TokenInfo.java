package com.bdsw.muc.base.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain=true)
@Data
public class TokenInfo {

    private String userId;
    private String userName;
}
