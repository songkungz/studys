package com.example.study.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TicketChannelVO {
    /**
     * 售票渠道名称
     */
    private String channelName;
    /**
     * 售票数量
     */
    private Integer count;
    /**
     * 日期
     */
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;
}
