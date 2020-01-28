package com.fh.service.impl;

import com.fh.mapper.PayLogMapper;
import com.fh.service.PayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayLogServiceImpl implements PayLogService {

    @Autowired
    private PayLogMapper payLogMapper;

}
