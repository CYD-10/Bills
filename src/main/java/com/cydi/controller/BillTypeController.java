package com.cydi.controller;

import com.cydi.common.DataGridView;
import com.cydi.service.BilltypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cyd
 * @Package com.cydi.controller
 * @date 2020/6/1 18:22
 */
@RestController
@RequestMapping("/billtype")
public class BillTypeController {

    @Autowired
    private BilltypeService billtypeService;


    @RequestMapping("loadAllBillType")
    public DataGridView loadAllBillType() {
        return new DataGridView(0L, billtypeService.list());
    }

}