package com.yang.service;

import com.yang.api.IUpdateMessageReadService;
import com.yang.base.BaseRequestBody;
import com.yang.base.BaseResponse;
import com.yang.base.HeaderInfo;
import com.yang.base.PageRequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/svr/message/dcpmsmsg")
public class UpdateMessageReadServiceImpl implements IUpdateMessageReadService {

    @Override
    // @RequestMapping(value = "/updateMessageRead")
    public BaseResponse call(HeaderInfo header, @RequestBody PageRequestBody requestBody) {
        BaseResponse response = new BaseResponse();
        response.setResultCodeAndMessage(BaseResponse.RESULT_CODE_SUCCESS, "ok");
        return response;
    }

    private Map<String, String> getHeadersInfo(HttpServletRequest httpServletRequest) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = httpServletRequest.getHeader(key);
            map.put(key, value);
            System.out.println(key + ":" + value);
        }
        return map;
    }

    @RequestHeader
    @Override
    @RequestMapping(value = "/updateMessageRead")
    public BaseResponse call(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody PageRequestBody baseRequestBody) {
        System.out.println(baseRequestBody);
        getHeadersInfo(httpServletRequest);
        System.out.println(baseRequestBody);
        return null;
    }
}
