package com.imooc.controller.kugou.rice;

import com.alibaba.fastjson.JSONObject;
import com.imooc.pojo.kugou.AbandonRiceResponse;
import org.n3r.idworker.utils.HttpClientUtil;
import org.n3r.idworker.utils.RtxAlerter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rice")
public class AbandonRiceController {

    @Autowired
    RtxAlerter rtxAlerter;

    private static HttpClientUtil httpClientUtil;

    @RequestMapping("/abandonRice")
    public AbandonRiceResponse abandonRice() throws Exception {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("action","getAllAbandonDinners");
        Map<String, String> headers = new HashMap<>();
        headers.put("host","qywx.kugou.com");
        headers.put("accept","application/json, text/plain, */*");
        headers.put("origin","https://qywx.kugou.com");
        headers.put("user-agent","Mozilla/5.0 (Linux; Android 9; MI 9 Build/PKQ1.181121.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/77.0.3865.120 MQQBrowser/6.2 TBS/045737 Mobile Safari/537.36 wxwork/4.0.0 ColorScheme/Light MicroMessenger/7.0.1 NetType/WIFI Language/zh Lang/zh");
        headers.put("sec-fetch-mode","cors");
        headers.put("x-requested-with","com.tencent.wework");
        headers.put("sec-fetch-site","same-origin");
        headers.put("referer","https://qywx.kugou.com/oa_h5/meal/riceMeal");
        headers.put("accept-language","zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7");
        headers.put("cookie","kg_mid=215d1a22f3e7e3cb1da643d6351aea69; kg_dfid=1boAxg1P9Ln84AURLr0wn787; PHPSESSID=cutdfr6iknala5ho9vv2lhnt31; userName=aryaye; noncestr=621442d79fa1a; timestamp=1645494999; signature=faecf10274931ef4f31596106bf14defcd9e6f85");
        headers.put("Connection","close");
        String url = "https://qywx.kugou.com/oa_h5/meal/apps/op.php";
        httpClientUtil = new HttpClientUtil();
        String response = httpClientUtil.postFromUrlEncodedHeaders(url, paramMap, headers);
        AbandonRiceResponse abandonRiceResponse = JSONObject.parseObject(response, AbandonRiceResponse.class);
        return abandonRiceResponse;
    }

    @RequestMapping("/sendMessage")
    public void sendMessage() {
        rtxAlerter.sentMessage("弃餐提醒", new StringBuilder()
                .append("scId:").append("111")
                .append(",round:").append("111").toString(),"aryaye"
        );
    }
}
