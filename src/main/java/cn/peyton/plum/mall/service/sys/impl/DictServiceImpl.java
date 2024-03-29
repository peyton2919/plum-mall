package cn.peyton.plum.mall.service.sys.impl;

import cn.peyton.plum.core.inf.BaseConvertBo;
import cn.peyton.plum.core.inf.mapper.IBaseMapper;
import cn.peyton.plum.core.inf.service.RealizeService;
import cn.peyton.plum.mall.bo.DictBo;
import cn.peyton.plum.mall.mapper.sys.DictMapper;
import cn.peyton.plum.mall.param.sys.DictParam;
import cn.peyton.plum.mall.pojo.sys.Dict;
import cn.peyton.plum.mall.service.sys.DictService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <h3> 数据字典 Service 实现类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月11日 18:10:52
 * @version 1.0.0
 * </pre>
 */
@Service("dictService")
public class DictServiceImpl extends RealizeService<Long, Dict, DictParam> implements DictService {
    @Resource
    private DictMapper dictMapper;

    @Override
    public BaseConvertBo<Dict, DictParam> bo() {
        return new DictBo();
    }

    @Override
    public IBaseMapper<Long, Dict> mapper() {
        return dictMapper;
    }

    public DictServiceImpl() {
        enabledCache = true;
        keyPrefix = this.getClass().getName();
    }
}
