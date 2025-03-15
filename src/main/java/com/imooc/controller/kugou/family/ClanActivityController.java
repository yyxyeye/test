//package com.imooc.controller.kugou.family;
//
//import com.imooc.pojo.IMoocJSONResult;
//import com.imooc.pojo.kugou.ClanActivityInfo;
//import com.imooc.service.kugou.ClanActivityInfoService;
//import org.n3r.idworker.Sid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("mybatis")
//public class ClanActivityController {
//
//    @Autowired
//    private ClanActivityInfoService clanActivityInfoService;
//
//    @Autowired
//    private Sid sid;
//
//    @RequestMapping("/saveClanActivityInfo")
//    public IMoocJSONResult saveUser() throws Exception {
//
//        String userId = sid.nextShort();
//
//        ClanActivityInfo info = new ClanActivityInfo();
//        info.setActivityId(123532L);
//
//        clanActivityInfoService.saveClanActivityInfo(info);
//
//        return IMoocJSONResult.ok("保存成功");
//    }
//
//    public static void main(String[] args) {
//
//    }
//}
