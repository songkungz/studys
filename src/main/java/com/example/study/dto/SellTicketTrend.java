package com.example.study.dto;


import lombok.Data;

@Data
public class SellTicketTrend {
    /**
     * 售票趋势(时间)
     */
    private String date;
    /**
     *数量
     */
    private Integer num;
}
