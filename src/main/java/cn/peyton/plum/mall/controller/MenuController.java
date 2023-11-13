package cn.peyton.plum.mall.controller;

import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.mall.service.MenuService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3> 菜单 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping("/findall")
    public JSONResult<?> findAll(){
        return JSONResult.success(menuService.findMenuListByShareIdAndType(1L,2));
    }



}
