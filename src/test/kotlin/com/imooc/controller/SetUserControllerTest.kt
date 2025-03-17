package com.imooc.controller

import com.imooc.util.CommonUserUtil
import com.imooc.util.HttpClientUtil
import com.imooc.util.HostConstant
import com.imooc.util.URIConstant
import com.alibaba.fastjson.JSON
import org.junit.Assert
import org.junit.Test
import org.junit.experimental.categories.Category
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.HashMap

@RunWith(SpringRunner::class)
@SpringBootTest
class SetUserControllerTest {

    @Autowired
    private lateinit var httpClientUtil: HttpClientUtil

    private var result: Any? = null

    @Test
    @TestSuitDescription(testCase = "setUser成功，并校验返回值")
    @Category(NewIntegrationTestCategory::class)
    fun setUserSuccessTest() {
        val commonUserUtil = CommonUserUtil()
        val param: MutableMap<String, String> = HashMap()
        val response = httpClientUtil.get(
            HostConstant.PLATFORM_USER_BUSINESS_ADDR + URIConstant.SET_USER,
            param,
            commonUserUtil.buildHeader()
        )
        result = JSON.parseObject(response)
        println("result: $result")

        // 1. 基本业务逻辑
        Assert.assertNotNull("返回失败-用户对象为空", result)

        // 2. 全部正常参数
        Assert.assertEquals("返回失败-name不为imooc2", "imooc2", result!!["name"])
        Assert.assertEquals("返回失败-age不为18", 18, result!!["age"])
        Assert.assertEquals("返回失败-password不为imooc2", "imooc2", result!!["password"])
        Assert.assertEquals("返回失败-desc不为hello imooc2~~", "hello imooc2~~", result!!["desc"])
    }
}