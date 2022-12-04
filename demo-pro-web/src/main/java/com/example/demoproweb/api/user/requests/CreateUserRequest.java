package com.example.demoproweb.api.user.requests;

import com.example.demoproweb.common.AbstractBaseRequest;
import lombok.Data;


@Data
public class CreateUserRequest extends AbstractBaseRequest {

    String account;

    String password;
}
