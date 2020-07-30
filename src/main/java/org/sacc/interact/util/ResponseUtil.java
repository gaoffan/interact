package org.sacc.interact.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sacc.interact.model.RestResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {
    public static <T> void restResponse(HttpServletResponse resp, HttpStatus status, RestResult<T> responseVo) throws IOException {
        resp.setStatus(status.value());
        resp.setContentType(MediaType.APPLICATION_JSON.toString());
        resp.getOutputStream().write(new ObjectMapper().writeValueAsBytes(responseVo));
    }
}
