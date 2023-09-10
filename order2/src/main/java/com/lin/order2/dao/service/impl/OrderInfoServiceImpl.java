package com.lin.order2.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.common.pojo.OrderInfo;
import com.lin.order2.dao.mapper.OrderInfoMapper;
import com.lin.order2.dao.service.OrderInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author linSheng
 * @since 2023-08-28
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
