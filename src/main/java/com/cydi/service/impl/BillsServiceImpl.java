package com.cydi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cydi.domain.Bills;
import com.cydi.mapper.BillsMapper;
import com.cydi.service.BillsService;
import org.springframework.stereotype.Service;

@Service
public class BillsServiceImpl extends ServiceImpl<BillsMapper, Bills> implements BillsService {

}
