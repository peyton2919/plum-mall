package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.err.GlobalException;
import cn.peyton.plum.core.imgs.MultipartFileImageOperation;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.PageQuery;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.utils.FileUtils;
import cn.peyton.plum.core.utils.LogUtils;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.mall.param.sys.MaterialParam;
import cn.peyton.plum.mall.param.sys.UserParam;
import cn.peyton.plum.mall.service.sys.MaterialService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
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
public class MaterialController extends RealizeController
        implements IController<Long, MaterialParam> {
    @Resource
    private MaterialService materialService;

    // type:{[0 商品 product] [1 头像 avatar] [2 广告 advert] [3 其他 other] [4 logo] 不能为空
    // keyLong 分组Id 当 type = product 时不能为空
    // keyword 关键字 {查找 name}
    // pageNo 当前页码 不能为空
    @Token
    @Valid
    @PostMapping("/manager/search")
    @Override
    public JSONResult<?> list(Query query) {
        int category = convert(query.getType());
        if (category == -1) { return JSONResult.fail(PARAM_TYPE_FAIL); }
        if (category == 0 && (null == query.getLongValue() || query.getLongValue() < 1L)) {
            return JSONResult.fail(PARAM+SELECT+TIP_MATERIAL_GROUP);
        }
        MaterialParam _param = new MaterialParam();
        if(category == 0){
            _param.setGroupId(query.getLongValue());
        }
        _param.setCategory(category);

        return page(_param,new PageQuery(query.getPageNo()),materialService,true);
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
        return handle(record, null, false, materialService, TIP_MATERIAL, NAME, UPDATE);
    }

    // 根据 分组Id 查找
    @Token
    @Valid
    @PostMapping("/mategroup")
    public JSONResult<?> findByGroupId(@Min(message = "分组Id要大于0的数！")long groupId,
                                    @Min(message = "当前页码要大于0的数！")Integer pageNo) {

        MaterialParam _param = new MaterialParam();
        _param.setGroupId(groupId);
        return page(_param,new PageQuery(pageNo),materialService,true);
    }

    @Token
    @Valid
    @PostMapping("/manager/delete")
    public JSONResult<?> delete(@NotBlank(message = "Id 不能为空;") @Min(value = 1,message = "最小为1")Long id) throws GlobalException {
        MaterialParam _param = materialService.findById(id);
        if(null != _param){
            /** 完整路径{用于图片写到磁盘} */
            String completePath = "";
            switch (_param.getCategory()){
                case 0:
                    completePath = PATH_IMG_PRODUCT.replace("/images/product/","");
                    break;
                case 1:
                    completePath = PATH_IMG_AVATAR.replace("/images/avatar/","");
                    break;
                case 2:
                    completePath = PATH_IMG_ADVERT.replace("/images/advert/","");
                    break;
                case 3:
                    completePath = PATH_IMG_OTHER.replace("/images/other/","");
                    break;
                case 4:
                    completePath = PATH_IMG_LOGO.replace("/images/logo/","");
                    break;
                default:
                    break;
            }
            if(materialService.delete(id)){
                if(!_param.getUrl().contains("http")){
                    if(FileUtils.delFile(completePath + _param.getSrc())){
                        return JSONResult.success(TIP_MATERIAL + DELETE + SUCCESS);
                    }
                    else {
                        throw new GlobalException();
                    }
                }
            }
        }
        return JSONResult.fail(TIP_MATERIAL + DELETE + FAIL);
    }

    @Token
    @PostMapping("/manager/upload")
    public JSONResult uploadImages(MultipartFile file, HttpServletRequest request) {
        UserParam _user = getToken(new UserParam());
        Long groupId = null;
        String type = request.getHeader("type");
        int category = convert(type);
        if (category == -1) { return JSONResult.fail(PARAM_TYPE_FAIL); }
        if (category == 0) {
            String _tmpGroupId = request.getHeader("groupId");
            if(null == _tmpGroupId){
                return JSONResult.fail(PARAM+SELECT+TIP_MATERIAL_GROUP);
            }
            groupId = Long.valueOf(_tmpGroupId);
            if (groupId < 1L) {
                return JSONResult.fail(PARAM + SELECT + TIP_MATERIAL_GROUP);
            }
        }

        String _imgName = null;
        boolean _ub = true;
        if (null == file) {
            return JSONResult.fail(UPLOAD + TIP_MATERIAL + NULL);
        }
        /** 完整路径{用于图片写到磁盘} */
        String completePath = "";
        Integer imgWidth = IMG_PRODUCT_WIDTH;
        /** 简单路径{用于图片写到数据库} */
        String simplePath = "";
        switch (category){
            case 0: // 商品
                completePath = PATH_IMG_PRODUCT;
                simplePath = PATH_IMG_PRODUCT_SIMPLE;
                break;
            case 1: //头像
                completePath = PATH_IMG_AVATAR;
                simplePath = PATH_IMG_AVATAR_SIMPLE;
                imgWidth = IMG_AVATAR_WIDTH;
                break;
            case 2: // 广告
                completePath = PATH_IMG_ADVERT;
                simplePath = PATH_IMG_ADVERT_SIMPLE;
                imgWidth = IMG_ADVERT_WIDTH;
                break;
            case 3: // 其他
                completePath = PATH_IMG_OTHER;
                simplePath = PATH_IMG_OTHER_SIMPLE;
                break;
            case 4: // LOGO
                completePath = PATH_IMG_LOGO;
                simplePath = PATH_IMG_LOGO_SIMPLE;
                break;
            default:
                break;
        }
        try {
            _imgName = MultipartFileImageOperation.compression(file, completePath, imgWidth, true);
            //_path = ImageProcessing.execute(file.getInputStream(),
            //        file.getOriginalFilename(), PATH_IMG_PRODUCT, null);
        } catch (IOException e) {
            LogUtils.error(e.getMessage());
            return JSONResult.fail(TIP_MATERIAL + UPLOAD + FAIL);
        }
        try {
            MaterialParam _param = new MaterialParam();
            _param.setCreateId(_user.getId());
            _param.setCreateType(_user.getUserType());
            if (null != groupId && groupId > 0L) {
                _param.setGroupId(groupId);
            }
            _param.setCategory(category);
            _param.setName(_imgName);
            _param.setSrc(simplePath + _imgName);
            _param.setUrl(_param.getSrc());

            MaterialParam _add = materialService.insert(_param);
            if (null != _add) {
                _ub = false;
                return JSONResult.success(_add);
            }
        } catch (Exception e) {
            LogUtils.error(e.getMessage());
        }finally {
            if (_ub){
                //删除图片
                FileUtils.delFile(completePath + _imgName);
            }
        }
        return JSONResult.fail(TIP_MATERIAL + UPLOAD + FAIL);
    }


    /**
     * <h4>字符串转数字</h4>
     * @param type 类型名称  [0 商品 product] [1 头像 avatar] [2 广告 advert] [3 其他 other]
     * @return 数值
     */
    private int convert(String type) {
        if ("product".equals(type)) {
            return 0;
        }else if ("avatar".equals(type)) {
            return 1;
        }else if ("advert".equals(type)) {
            return 2;
        }else if ("other".equals(type)) {
            return 3;
        }else if ("logo".equals(type)) {
            return 4;
        }
        return -1;
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
