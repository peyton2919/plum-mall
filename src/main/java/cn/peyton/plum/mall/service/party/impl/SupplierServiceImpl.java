package cn.peyton.plum.mall.service.party.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.AbstractRealizeService;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.mall.bo.SupplierBo;
import cn.peyton.plum.mall.mapper.party.SupplierMapper;
import cn.peyton.plum.mall.param.party.SupplierParam;
import cn.peyton.plum.mall.pojo.party.Supplier;
import cn.peyton.plum.mall.service.party.SupplierService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <h3> 供应商信息 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:53
 * @version 1.0.0
 * </pre>
 */
@Service("supplierService")
public class SupplierServiceImpl extends AbstractRealizeService<Long, Supplier, SupplierParam> implements SupplierService {
    private String TABLE_NAME = "tb_supplier";
    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public BaseConvertBo<Supplier, SupplierParam> initBo() {
        return new SupplierBo();
    }

    @Override
    public IBaseMapper<Long, Supplier> initMapper() {
        return supplierMapper;
    }

    public SupplierServiceImpl () {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }

    @Override
    public List<SupplierParam> findByDownList() {
        String key = keyPrefix + "_202312251328";
        if (enabledCache) {
            Object obj = cache.get(key);
            if (null != obj) {
                System.out.printf("从缓存获取到对象: key= %s;\n", key);
                return (List<SupplierParam>) obj;
            }
        }
        List<SupplierParam> res = initBo().adapter(supplierMapper.selectByDownList());
        if (null != res && enabledCache) {
            LogUtils.info(key);
            cache.put(key, res);
        }
        return res;
    }

    @Override
    public Boolean upDelete(Long id) {
        if (supplierMapper.updateDeleteStatus(TABLE_NAME, id) > 0) {

            if (enabledCache) {
                System.out.println("删除操作, 清空缓存;");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateInfo(Long id, Long infoId) {
        if (supplierMapper.updateInfo(id, infoId) > 0) {
            if (enabledCache) {
                System.out.println("删除操作, 清空缓存;");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean upStatus(Long id, Integer status) {
        int res = supplierMapper.upStatus(id, status);
        if (res > 0) {
            if(enabledCache){
                System.out.println("更新状态操作清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean checkStatus(String keyword, String type, Integer status) {

        return supplierMapper.checkStatus(TABLE_NAME,keyword, type, status) > 0;
    }

    @Override
    public SupplierParam login(String keyword, String password, String loginType) {
        Supplier supplier = supplierMapper.login(keyword, password, loginType);
        return (null == supplier) ? null : new SupplierParam().compat(supplier);
    }


    @Override
    public Boolean isPassword(Long id, String password) {
        return supplierMapper.isPassword(TABLE_NAME, id, password) > 0;
    }

    @Override
    public  Boolean updateLastLogin(SupplierParam param) {
        int res = supplierMapper.updateLastLogin(TABLE_NAME, param.convert());
        if (res > 0) {
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean updatePassword(Long id, String pwd) {
        int res = supplierMapper.updatePassword(TABLE_NAME, id, pwd);
        if (res > 0) {
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }

    @Override
    public Integer isPhone(String phone) {
        return supplierMapper.isPhone(TABLE_NAME, phone);
    }

    @Override
    public Boolean updateAvatar(Long id, String avatar) {
        int res = supplierMapper.updateAvatar(TABLE_NAME, id, avatar);
        if (res > 0) {
            if (enabledCache) {
                System.out.println("更新操作,清空缓存");
                removeCache();
            }
            return true;
        }
        return false;
    }
}
