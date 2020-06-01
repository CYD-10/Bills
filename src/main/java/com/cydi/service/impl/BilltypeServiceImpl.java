package com.cydi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cydi.domain.Billtype;
import com.cydi.mapper.BilltypeMapper;
import com.cydi.service.BilltypeService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class BilltypeServiceImpl extends ServiceImpl<BilltypeMapper, Billtype> implements BilltypeService {

	
	@Override
	public Billtype getById(Serializable id) {
		return super.getById(id);
	}
}
