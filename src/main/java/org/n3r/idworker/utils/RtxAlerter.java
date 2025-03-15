package org.n3r.idworker.utils;

import com.imooc.pojo.KmrV1MvBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: aryaye
 * @Date: 2022/2/23 15:18
 * @Description:
 */
@Component
public class RtxAlerter {

    private static final Logger logger = LoggerFactory.getLogger(RtxAlerter.class);

    private static HttpClientUtil httpClientUtil;

    /**
     * @Description targets 为告警目标，多个以英文逗号隔开
     * @Date 2022/2/23 15:20
     */
    public void sentMessage(String title, String content, String targets) {
        try {

            Map<String,String> params = new HashMap<>();
            params.put("appKey","10001");
            params.put("title",URLEncoder.encode(title, "UTF-8"));
            params.put("content",URLEncoder.encode(content, "UTF-8"));
            params.put("userName",URLEncoder.encode(targets, "UTF-8"));
            params.put("rtxType","sendRtxTip");

            httpClientUtil = new HttpClientUtil();
            httpClientUtil.getSetHeaders("http://u2.kugou.net:11770/sendRtxByPost", params, null);

        } catch (Exception e) {
            logger.error("RTX请求失败,title:{},content:{}", content, e);
        }
    }

    public static void main(String[] args) {
        List<KmrV1MvBase> list = new ArrayList<>();
        KmrV1MvBase kmrV1MvBase1 = new KmrV1MvBase();
        kmrV1MvBase1.setVideo_id(222);
        kmrV1MvBase1.setIs_publish(0);
        list.add(kmrV1MvBase1);
        KmrV1MvBase kmrV1MvBase2 = new KmrV1MvBase();
        kmrV1MvBase2.setVideo_id(333);
        kmrV1MvBase2.setIs_publish(1);
        list.add(kmrV1MvBase2);
        KmrV1MvBase kmrV1MvBase3 = new KmrV1MvBase();
        kmrV1MvBase3.setVideo_id(111);
        kmrV1MvBase3.setIs_publish(2);
        list.add(kmrV1MvBase3);
        KmrV1MvBase kmrV1MvBase4 = new KmrV1MvBase();
        kmrV1MvBase4.setVideo_id(444);
        kmrV1MvBase4.setIs_publish(0);
        list.add(kmrV1MvBase4);
        Map<Long, Integer> collect = list.stream().collect(Collectors.toMap(KmrV1MvBase::getVideo_id, KmrV1MvBase::getIs_publish, (a, b) -> a));
        System.out.println(collect.toString());
    }
}
