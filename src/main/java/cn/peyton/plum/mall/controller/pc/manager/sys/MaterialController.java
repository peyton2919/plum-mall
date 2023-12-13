package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.imgs.MultipartFileImageOperation;
import cn.peyton.plum.core.inf.controller.IBasePCController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.FileUtils;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.mall.controller.base.PcController;
import cn.peyton.plum.mall.param.sys.MaterialParam;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.service.sys.MaterialService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * <h3> 素材库 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年11月10日 14:53:23
 * @version 1.0.0
 * </pre>
 */
@RestController
@RequestMapping("/pc/material")
public class MaterialController extends PcController<MaterialParam>
        implements IBasePCController<Long, MaterialParam> {
    @Resource
    private MaterialService materialService;

    @Override
    public JSONResult<?> all(String keyword, Integer pageNo) {
        return null;
    }

    @Override
    public JSONResult<?> search(Query query) {
        return null;
    }

    @Override
    public JSONResult<?> create(MaterialParam record) {
        return null;
    }
    @Token
    @Valid
    @PostMapping("/manager/edit")
    @Override
    public JSONResult<?> edit(MaterialParam record) {
        return baseEdit(record,null,materialService,"图片名称");
    }

    @Token
    @Valid
    @PostMapping("/mategroup")
    public JSONResult<?> findByGroupId(@Min(message = "分组Id要大于0的数！")long groupId,
                                    @Min(message = "当前页码要大于0的数！")Integer pageNo) {

        MaterialParam _param = new MaterialParam();
        _param.setGroupId(groupId);

        return baseFindBykeywordAll(_param,new PageQuery(pageNo),materialService,null);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> delete(Long id) throws GlobalException {
        MaterialParam _param = materialService.findById(id);
        if(null != _param){
            if(materialService.delete(id)){
                if(!_param.getUrl().contains("http")){
                    if(FileUtils.delFile(PATH_IMG_PRODUCT + _param.getSrc())){
                        return JSONResult.success("图片删除成功");
                    }
                    else {
                        throw new GlobalException();
                    }
                }
            }
        }
        return JSONResult.fail("图片删除失败");
    }
    @Token
    @PostMapping("/manager/upload")
    public JSONResult uploadImages(MultipartFile file,
              @Min(value = 1,message = "最小值为1")
              Long groupId) {
        UserParam _user = handleToken(new UserParam());

        String _imgName = null;
        boolean _ub = true;
        if (null == file) {
            return JSONResult.fail("上传图片为空...");
        }
        try {
            _imgName = MultipartFileImageOperation.compression(file, PATH_IMG_PRODUCT, IMG_PRODUCT_WIDTH, true);
            //_path = ImageProcessing.execute(file.getInputStream(),
            //        file.getOriginalFilename(), PATH_IMG_PRODUCT, null);
        } catch (IOException e) {
            LogUtils.error(e.getMessage());
            return JSONResult.fail("上传图片出错了");
        }
        try {
            MaterialParam _param = new MaterialParam();
            _param.setCreateId(_user.getId());
            _param.setCreateType(_user.getUserType());
            _param.setGroupId(groupId);
            _param.setName(_imgName);
            _param.setSrc(PATH_IMG_PRODUCT_SIMPLE + _imgName);
            _param.setUrl(_param.getSrc());

            MaterialParam _add = materialService.add(_param);
            if (null != _add) {
                _ub = false;
                return JSONResult.success(_add);
            }
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }finally {
            if (_ub){
                //删除图片
                FileUtils.delFile(PATH_IMG_PRODUCT + _imgName);
            }
        }
        return JSONResult.fail("图片上传失败...");
    }
}

    //public JSONResult<?> edit(@Min(value = 1,message = "最小值为1") Long id,
    //                          @NotBlank(message = "名称不能为空")
    //                          String name) {
    //    MaterialParam _param = new MaterialParam();
    //    _param.setId(id);
    //    _param.setName(name);
    //    return baseEdit(_param,null,materialService,"图片名称");
    //}
