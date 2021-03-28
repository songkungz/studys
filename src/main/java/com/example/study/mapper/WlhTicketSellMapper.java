package com.example.study.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.study.bean.WlhTicketSellDetail;
import com.example.study.dto.TimeRangeQueryDTO;
import com.example.study.vo.TicketChannelVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WlhTicketSellMapper extends BaseMapper<WlhTicketSellDetail> {
    /**
     * 售票查询数量（按年，月，周(近7天)）
     */
    public List<TicketChannelVO> selectTicketSellCount(TimeRangeQueryDTO queryDTO);
    /**
     * 售票趋势查询（按年，月，周(近7天)）
     */
    public  List<TicketChannelVO> selectTicketSellTrend(TimeRangeQueryDTO queryDTO);
    /**
     * 查询全部售票量
     */
    public List<TicketChannelVO>  selectAllTicketSellCount();
    /**
     *渠道售票统计（按年，月，近七日，今天）
     */
      public List<TicketChannelVO> selectTicketSellCountByChannel(TimeRangeQueryDTO queryDTO);
}
