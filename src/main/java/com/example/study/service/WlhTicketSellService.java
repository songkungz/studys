package com.example.study.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.study.bean.WlhTicketSellDetail;
import com.example.study.dto.TimeRangeQueryDTO;
import com.example.study.mapper.WlhTicketSellMapper;
import com.example.study.vo.TicketChannelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WlhTicketSellService extends ServiceImpl<WlhTicketSellMapper, WlhTicketSellDetail> {
    @Autowired
    private WlhTicketSellMapper wlhTicketSellMapper;
    /**
     * 售票查询数量（按年，月，周(近7天)）
     */
    public List<TicketChannelVO> selectTicketSellCount(TimeRangeQueryDTO queryDTO){
        List<TicketChannelVO> count = wlhTicketSellMapper.selectTicketSellCount(queryDTO);
        return count;
    }
    /**
     * 售票趋势查询（按年，月，周(近7天)）
     */
    public  List<TicketChannelVO> selectTicketSellTrend(TimeRangeQueryDTO queryDTO ){
          List<TicketChannelVO> trend = wlhTicketSellMapper.selectTicketSellTrend(queryDTO);
          return trend;
    }
    /**
     * 查询全部售票量
     */
    public List<TicketChannelVO>  selectAllTicketSellCount(){
        List<TicketChannelVO> allCount = wlhTicketSellMapper.selectAllTicketSellCount();
        return allCount;
    }
    /**
     *渠道售票统计（按年，月，近七日，今天）
     */
    public List<TicketChannelVO> selectTicketSellCountByChannel(TimeRangeQueryDTO queryDTO){
        Integer type = queryDTO.getType();

        //
        switch (type){
            case 0:  //按年查询
                break;
            case 1: //按月查询
                break;
            case 2: //按近七天查询
                break;
            case 3: //按天查询
                break;
            default:
                break;

        }
        return null;
    }
}
