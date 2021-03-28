package com.example.study.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.study.bean.WlhTicketSellDetail;
import com.example.study.dto.TimeRangeQueryDTO;
import com.example.study.dto.WlhTicketSellDetailDTO;
import com.example.study.service.WlhTicketSellService;
import com.example.study.utils.JsonResult;
import com.example.study.vo.TicketChannelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sell")
public class TicketSellController {
    @Autowired
    private WlhTicketSellService ticketSellService;
    /**
     * 售票明细添加
     */
    @PostMapping("/sellDetailCreate")
    public JsonResult create(@RequestBody WlhTicketSellDetailDTO ticketSellDetailDTO) {
        WlhTicketSellDetail ticketSellDetail = new WlhTicketSellDetail();
        BeanUtils.copyProperties(ticketSellDetailDTO, ticketSellDetail);
        ticketSellDetail.setScenicId(IdWorker.getId());
        boolean save = ticketSellService.save(ticketSellDetail);
        if (save) {
            return JsonResult.success();
        } else {
            return JsonResult.error("添加失败");
        }

    }

    /**
     * 售票明细删除(通过id)
     * @param ticketSellDetailDTO
     * @return
     */

    @PostMapping("/sellDetailDeleteById")
    public JsonResult delete(@RequestBody WlhTicketSellDetailDTO ticketSellDetailDTO) {
        WlhTicketSellDetail ticketSellDetail = new WlhTicketSellDetail();
        BeanUtils.copyProperties(ticketSellDetailDTO, ticketSellDetail);
        boolean delete = ticketSellService.removeById(ticketSellDetail.getScenicId());
        if (delete) {
            return JsonResult.success();
        } else {
            return JsonResult.error("删除失败");
        }

    }

    /**
     * 售票明细查询
     * @return
     */

    public List<WlhTicketSellDetail> selectAll() {
        return null;
    }

    /**
     * timeRangeQueryDTO
     * istatrtTime:查询时间段的开始时间
     * endTme：查询时间段的结束时间
     * @param
     * @return
     */
    @RequestMapping("/querySellTicket")
    @ResponseBody
    public JsonResult querySellTicket(TimeRangeQueryDTO timeRangeQueryDTO){
//        checkTimeRangeQuery(timeRangeQueryDTO);
        if(timeRangeQueryDTO == null){
            timeRangeQueryDTO.setBeginTime(new Date());
        }
        List<TicketChannelVO> sellCount = ticketSellService.selectTicketSellCount(timeRangeQueryDTO);
        return JsonResult.success(sellCount);
    }
    @RequestMapping("/querySellTicketTrend")
    @ResponseBody
    public JsonResult querySellTicketTrend(TimeRangeQueryDTO timeRangeQueryDTO){
//        checkTimeRangeQuery(timeRangeQueryDTO);
        if(timeRangeQueryDTO == null){
            timeRangeQueryDTO.setBeginTime(new Date());
        }
        List<TicketChannelVO> sellCount = ticketSellService.selectTicketSellTrend(timeRangeQueryDTO);
        return JsonResult.success(sellCount);
    }

//    @PostMapping("/querySellTicketTrend")
//    public JsonResult querySellTicketTrend(TimeRangeQueryDTO timeRangeQueryDTO){
//        checkTimeRangeQuery(timeRangeQueryDTO);
//        ArrayList<Integer> resultNum = new ArrayList<>();
////        type为0时  获取本月   为 1 时获取本年
//        if (timeRangeQueryDTO.getType() == 0) {
//            for (int i = 0; i < 31; i++) {
//                resultNum.add(0);
//            }
////        查询数据
//            List<SellTicketTrend> list = ticketSellService.selectTicketSellTrend(timeRangeQueryDTO);
////        根据数据的天数修改对应的默认值
//            for (int j = 0; j < list.size(); j++) {
////            list从0开始 天数从一开始 因此 对应天数位置需要-1
//                resultNum.set(list.get(j).getDays() - 1, list.get(j).getNum());
//            }
//            return JsonResult.success(resultNum);
////            统计年数据
//        } else if (timeRangeQueryDTO.getType() == 1) {
////            默认12个月的数量为0
//            for (int i = 0; i < 12; i++) {
//                resultNum.add(0);
//            }
////            此时days 为 月份 不是  天数
//            List<SellTicketTrend> list = ticketSellService.selectTicketSellTrend(timeRangeQueryDTO);
//            for (int j = 0; j < list.size(); j++) {
////            list从0开始 月份 从 一 开始 因此 对应天数位置需要-1
//                resultNum.set(list.get(j).getDays() - 1, list.get(j).getNum());
//            }
//            return JsonResult.success(resultNum);
//        }
//        return JsonResult.success(resultNum);
//    }

}