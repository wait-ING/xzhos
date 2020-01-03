package com.xzit.entity.model;

import com.xzit.entity.Permission;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.entity.model
 * @ClassName: PermissionMenu
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/31 0:23
 * @Version: 1.0
 */
@Data
@ToString(callSuper = true)
public class PermissionMenu extends Permission{

    private List<PermissionMenu> subPermission=new ArrayList<PermissionMenu>();


}
