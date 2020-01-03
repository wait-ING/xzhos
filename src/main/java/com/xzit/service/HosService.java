package com.xzit.service;

import com.xzit.entity.Hospital;
import com.xzit.utils.PageResult;
import com.xzit.utils.PageUtil;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.service
 * @ClassName: HosService
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/24 10:11
 * @Version: 1.0
 */
public interface HosService {
    /**
     * @description:医院查询（分页展示）
     * @author: GaJai
     * @time: 2019/12/24 10:11
     */
    PageResult getAllHos(PageUtil pageUtil);

}
