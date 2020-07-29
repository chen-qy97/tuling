package com.example.tuling.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/test")
@Api(value = "测试controller")
public class TestController {

    @GetMapping("/aaa")
    @ApiOperation(value = "测试请求requestGet", notes="测试请求requestGet")
    public String requestGet(){
        String str = "你好呀！";
        return str;
    }

    @ResponseBody
    @PostMapping("/formSubmit")
    public String formSubmit(@RequestParam(value = "aaa") String aaa,
                             @RequestParam(value = "bbb") String bbb) throws Exception {
        System.out.println(aaa);
        return aaa+"   "+bbb;
    }

    private Map<String, String> getHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        Map headerMap = new HashMap();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String header = request.getHeader(headerName);
            headerMap.put(headerName, header);
        }
        return headerMap;
    }

    private static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }

        outSteam.close();
        inStream.close();
        return outSteam.toByteArray();
    }

}
