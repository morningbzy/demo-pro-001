package com.example.demoproweb.api.requests;

import com.example.demoproweb.common.AbstractBaseRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class TestRequest extends AbstractBaseRequest {

    private String t;
}
