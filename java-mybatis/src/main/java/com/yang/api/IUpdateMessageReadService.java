package com.yang.api;

import com.yang.base.*;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IUpdateMessageReadService extends IBaseService<PageRequestBody, BaseResponse> {

    BaseResponse call(HeaderInfo header, PageRequestBody requestBody);

    BaseResponse call(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody PageRequestBody baseRequestBody);
}
