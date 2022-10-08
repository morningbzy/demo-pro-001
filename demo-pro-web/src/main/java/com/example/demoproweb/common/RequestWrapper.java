package com.example.demoproweb.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.annotation.Resource;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;


@Slf4j
public class RequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body; // 报文

    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.body = handleSmDecrypt(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bodyInputStream = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bodyInputStream.read();
            }

            @Override
            public boolean isFinished() {
                return bodyInputStream.available() <= 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int available() throws IOException {
                return bodyInputStream.available();
            }
        };
    }

    public byte[] getDecryptBody() {
        return this.body;
    }

    private byte[] handleSmDecrypt(HttpServletRequest request) throws IOException {
        log.info(request.getHeader("D"));
        return StreamUtils.copyToByteArray(request.getInputStream());
    }

}
