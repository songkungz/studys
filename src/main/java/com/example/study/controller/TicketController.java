package com.example.study.controller;

import com.example.study.bean.WlhTicketSellDetail;
import com.example.study.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @RequestMapping("/getAll")
    @ResponseBody
    public WlhTicketSellDetail getAllTicketSellDetail(){
        System.out.println("ticket getAll 执行了");
     WlhTicketSellDetail details = ticketService.selectAllTicketDetail();
        return details;
    }
}
