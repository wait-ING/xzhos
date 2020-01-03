package com.xzit.service.impl;

import com.xzit.service.HosService;
import com.xzit.utils.PageResult;
import com.xzit.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.service.impl
 * @ClassName: HosServiceImpl
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/24 10:14
 * @Version: 1.0
 */
@Service
public class HosServiceImpl implements HosService {
//    @Autowired
//    private HospitalMapper hospitalMapper;

    /**
     * @description:分页查询医院
     * @author: GaJai
     * @time: 2019/12/24 10:15
     */
    @Override
    public PageResult getAllHos(PageUtil pageUtil) {
//        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
//        HospitalExample getHosExample=new HospitalExample();
//
//        HospitalExample.Criteria criteria = getHosExample.createCriteria();
//        criteria.andDataStateEqualTo(1+"");
//
//        List<Hospital> hospitals = hospitalMapper.selectByExample(getHosExample);
//        System.out.println("医院数据："+hospitals.size());
//        PageInfo pageInfo=new PageInfo(hospitals);
//        return new PageResult(hospitals,Integer.parseInt(pageInfo.getTotal()+""),pageInfo.getPageSize(),pageUtil.getPage());
        return null;
    }
}
