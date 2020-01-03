package com.xzit.service;

import com.xzit.entity.model.PermissionMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ProjectName: xzithos
 * @Package: com.xzit.service
 * @ClassName: PermissionServiceTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/12/31 9:03
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PermissionServiceTest {
    @Autowired
    private PermissionService permissionService;
    @Test
    public void getPermissionMenuByLevel() throws Exception {
//        List<Permission> permissionMenuByLevel = permissionService.getPermissionMenuByLevel("11", "3");
//        System.out.println(permissionMenuByLevel.toArray().toString());
        List<PermissionMenu> permissionMenu = permissionService.getPermissionMenu(11 + "", -1 + "");
        System.out.println(permissionMenu.toString());
//        List<List<PermissionMenu>> permissionMenu = permissionService.getPermissionMenu("11", "-1");
//        System.out.println(permissionMenu.toString());
//        for(int i=0;i<permissionMenu.size();i++){
//            System.out.println(permissionMenu.get(i).toString());
//        }

//        PermissionMenu permissionMenu = permissionService.getPermissionMenu("11", "-1");
//        System.out.println(permissionMenu.toString()+"-----------");
//        System.out.println(permissionMenu.toString());
    }

}