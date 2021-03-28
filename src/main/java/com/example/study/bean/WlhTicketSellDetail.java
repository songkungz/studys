package com.example.study.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@TableName("tb_ticket_sell_detail")
public class WlhTicketSellDetail{
    /**
     * 景区id
     */
    @TableId
    private Long scenicId;
    /**
     *景区名称
     */
    private String scenicName;
    /**
     *售票时间
     */
    private Date sellTime;
    /**
     *售票来源
     */
    private String sellSource;
    /**
     *门票号
     */
    private String ticketNo;
    /**
     *门票名称
     */
    private String ticketName;
    /**
     *门票价格
     */
    private BigDecimal ticketPrice;
    /**
     *门票类型（0-成人票，1-儿童票，2-学生票）
     */
    private Byte ticketModelName;
    /**
     *各票种售票数量
     */
    private Integer ticketSellCount;
    /**
     *证件类型(0-身份证，1-护照，2-学生证)
     */
    private Byte certificateType;
    /**
     *证件号
     */
    private String certificateNo;
    /**
     *电话号码
     */
    private String phoneNo;
    /**
     *退票时间
     */
    private Date returnTicketTime;
    /**
     * 支付方式
     */
    private String payment;
    /**
     * 售票地点
     */
    private String takeTicketPlace;
    /**
     *售票人员
     */
    private String operatorName;
}
