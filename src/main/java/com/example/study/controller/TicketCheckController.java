package com.example.study.controller;


import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.study.bean.WlhTicketCheckDetail;
import com.example.study.dto.WlhTicketCheckDetailDTO;
import com.example.study.service.WlhTicketCheckService;
import com.example.study.utils.JsonResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class TicketCheckController {
    @Autowired
    private WlhTicketCheckService ticketService;

    /**
     * 检票明细添加
     * @param ticketDetailDTO
     * @return
     */
    @PostMapping("/checkDetailCreate")
    public JsonResult create(@RequestBody WlhTicketCheckDetailDTO ticketDetailDTO) {
        WlhTicketCheckDetail ticketCheckDetail = new WlhTicketCheckDetail();
        BeanUtils.copyProperties(ticketDetailDTO, ticketCheckDetail);
        ticketCheckDetail.setScenicId(IdWorker.getId());
        boolean save = ticketService.save(ticketCheckDetail);
        if (save) {
            return JsonResult.success();
        } else {
            return JsonResult.error("添加失败");
        }
      }


}
