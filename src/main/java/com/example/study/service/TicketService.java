package com.example.study.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.bean.WlhTicketSellDetail;
import com.example.study.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends ServiceImpl<TicketMapper, WlhTicketSellDetail>  {
    @Autowired
    private TicketMapper ticketMapper;
    public WlhTicketSellDetail selectAllTicketDetail(){
        WlhTicketSellDetail tickets = ticketMapper.selectOne(new QueryWrapper<WlhTicketSellDetail>()
                .eq("scenic_id",1));
        return tickets;
    }
}
