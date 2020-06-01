package com.cydi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cydi.common.DataGridView;
import com.cydi.common.ResultObj;
import com.cydi.domain.Bills;
import com.cydi.domain.Billtype;
import com.cydi.service.BillsService;
import com.cydi.service.BilltypeService;
import com.cydi.vo.BillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author cyd
 * @Package com.cydi.controller
 * @date 2020/6/1 12:13
 */
@Controller
@RequestMapping("bills")
public class BillsController {
    @Autowired
    private BillsService billsService;

    @Autowired
    private BilltypeService billTypeService;

    /**
     * 跳转到主页面
     * @return
     */
    @RequestMapping("toBillsList")
    public String toBillsList(){
        return "list";
    }

    @RequestMapping("loadAllBills")
    @ResponseBody
    public DataGridView loadAllBills(BillVO billVO){
        
        IPage<Bills> page=new Page<>(billVO.getPage(), billVO.getLimit());
        QueryWrapper<Bills> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(null!=billVO.getTypeid()&&billVO.getTypeid()!=0, "typeid", billVO.getTypeid());
        queryWrapper.ge(billVO.getStartDate()!=null,"billtime", billVO.getStartDate());
        queryWrapper.le(billVO.getEndDate()!=null, "billtime",billVO.getEndDate());
        queryWrapper.orderByDesc("billtime");
        billsService.page(page, queryWrapper);

        List<Bills> records = page.getRecords();
        for (Bills bills : records) {
            Billtype billtype = this.billTypeService.getById(bills.getTypeid());
            bills.setTypeName(billtype.getName());
        }
        return new DataGridView(page.getTotal(), records);
    }

    /**
     * 添加账单
     */
    @RequestMapping("addBills")
    @ResponseBody
    public ResultObj addBills(BillVO billVO) {
        try {
            this.billsService.save(billVO);
            return new ResultObj(200, "录入成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObj(-1, "录入失败");
        }
    }
}
