package com.example.demoproweb.api.requests;

import com.example.demoproweb.common.AbstractBaseRequest;
import lombok.Data;

@Data
public class LoginRequest extends AbstractBaseRequest {

    String username;

    String password;
}
