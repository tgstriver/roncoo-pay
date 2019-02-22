package com.roncoo.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>功能说明:
 * 该控制类用来支撑商户查询订单结果
 * </b>
 */
@Controller
@RequestMapping("merchantOrderQuery")
public class MerchantOrderQueryController {

    @RequestMapping
    public void singleOrderQuery(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }
}
