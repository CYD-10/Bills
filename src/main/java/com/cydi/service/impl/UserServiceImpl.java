package com.cydi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cydi.domain.User;
import com.cydi.mapper.UserMapper;
import com.cydi.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
