package cn.peyton.plum.mall.controller.pc.manager.sys;

import cn.peyton.plum.core.anno.token.Token;
import cn.peyton.plum.core.inf.controller.IController;
import cn.peyton.plum.core.inf.controller.RealizeController;
import cn.peyton.plum.core.json.JSONResult;
import cn.peyton.plum.core.page.Query;
import cn.peyton.plum.core.validator.anno.Valid;
import cn.peyton.plum.core.validator.constraints.Min;
import cn.peyton.plum.core.validator.constraints.NotBlank;
import cn.peyton.plum.core.validator.constraints.Size;
import cn.peyton.plum.mall.param.sys.CityParam;
import cn.peyton.plum.mall.service.sys.CityService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3> 城市 Controller 类</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2023年12月01日 19:03:49
 * @version 1.0.0
 * </pre>
*/
@RestController
@RequestMapping("/pc/city")
public class CityController extends RealizeController
		implements IController<Integer, CityParam> {

	@Resource
	private CityService cityService;

	// 所有数据
	@Token
	@PostMapping("/manager/tree")
	public JSONResult<?> findByTree(){
		List<CityParam> result = cityService.findByTree();
		if (null != result) {
			return JSONResult.success(DATA_LOADING_SUCCESS,result);
		}
		return JSONResult.fail(JSONResult.Props.NO_DATA,NO_DATA);
	}

	// 根据 pid 查找
	@Token
	@PostMapping("/manager/treepid")
	public JSONResult<?> findByPid(@NotBlank(message = "pid不能为空") @Min(value = 0,message = "最小值为0") Integer pid){
		List<CityParam> result = cityService.findByPid(pid,null);
		if (null != result) {
			return JSONResult.success(DATA_LOADING_SUCCESS,result);
		}
		return JSONResult.fail(JSONResult.Props.NO_DATA,NO_DATA);
	}

	// 下拉框
	@Token
	@PostMapping("/manager/down")
	public JSONResult<?> down(){
		List<CityParam> result = cityService.findByDown(2);
		if (null != result) {
			return JSONResult.success(DATA_LOADING_SUCCESS,result);
		}
		return JSONResult.fail(JSONResult.Props.NO_DATA,NO_DATA);
	}

	@Override
	public JSONResult<?> list(Query<CityParam> query) {
		return null;
	}

	@Token
	@Valid
	@PostMapping("/manager/create")
	@Override
	public JSONResult<?> create(CityParam record) {
		record.setMergerName(convertMergerName(record.getName()));
		if (null == record.getPid() || record.getPid() <= 0) {
			record.setPid(0);
			record.setLevel(0);
		} else {
			CityParam param = cityService.findById(record.getPid());
			if (null == param) {
				return JSONResult.fail(ERROR);
			}
			record.setLevel(param.getLevel() + 1);
			if (!record.getMergerName().equals(param.getMergerName())) {
				record.setMergerName(param.getMergerName()+","+record.getMergerName());
			}
		}
		CityParam _param = new CityParam();
		_param.setPid(record.getPid());
		_param.setName(record.getName());
		return handle(record, _param, false, cityService, TIP_AREA, CREATE);
	}


	@Token
	@Valid
	@PostMapping("/manager/edit")
	@Override
	public JSONResult<?> edit(CityParam record) {
		record.setMergerName(convertMergerName(record.getName()));
		if (null == record.getPid() || record.getPid() <= 0) {
			record.setPid(0);
			record.setLevel(0);
		} else {
			CityParam param = cityService.findById(record.getPid());
			if (null == param) {
				return JSONResult.fail(ERROR);
			}
			record.setLevel(param.getLevel() + 1);
			if (!record.getMergerName().equals(param.getMergerName())) {
				record.setMergerName(param.getMergerName()+","+record.getMergerName());
			}
		}
		// 同时更新 level pid merger_name
		// record.id 查找 子类
		CityParam _param = new CityParam();
		_param.setId(record.getId());
		_param.setPid(record.getPid());
		_param.setName(record.getName());
		return handle(record, _param, true, cityService, TIP_AREA, UPDATE);
	}

	@Token
	@Valid
	@PostMapping("/manager/delete")
	@Override
	public JSONResult<?> delete(@NotBlank(message = "菜单Id不能为空") @Min(value = 1,message = "最小值为1") Integer id) {
		// todo 要用到批量删除
		return delete(id, cityService, TIP_AREA);
	}

	@Token
	@Valid
	@PostMapping("/manager/upstatus")
	public JSONResult<?> editStatus(@NotBlank(message = "菜单Id不能为空") @Min(message = "要大于0的数！")Integer id,
									@Size(min = 0,max = 1) Integer status){
		CityParam _param = cityService.findById(id);
		if (null == _param) {
			return JSONResult.fail(ERROR);
		}
		// level = 0 关闭当前对象所有子类与子子类
		List<Integer> ids = new ArrayList<>();
		if (_param.getLevel() == 0) {
			ids = cityService.findLevel1(id);
			ids.add(id);
		}else if(_param.getLevel() == 1){ // level = 1 关闭 pid = id 的所有子类和 自己
			ids = cityService.findLevel2(id);
			ids.add(id);
		} else {
			ids.add(id);
		}
		//level = 2 关闭当前对象
		// 判断子类关闭与开启
		return handle(cityService.batchUpdate(ids, status), STATUS, BATCH, MODIFY);
	}

	/**
	 * <h4>转换合并名称</h4>
	 * @param name 名称
	 * @return
	 */
	private String convertMergerName(String name) {
		if (null == name || "".equals(name.trim())) {
			return name;
		}
		if (name.contains("省")) {
			return name.replace("省", "");
		}else if (name.contains("市")) {
			return name.replace("市", "");
		}else if (name.contains("壮族自治区")) {
			return name.replace("壮族自治区", "");
		}else if (name.contains("盟")) {
			return name.replace("盟", "");
		}else if (name.contains("回族自治区")) {
			return name.replace("回族自治区", "");
		}else if (name.contains("维吾尔自治区")) {
			return name.replace("维吾尔自治区", "");
		}else if (name.contains("特别行政区")) {
			return name.replace("特别行政区", "");
		}else if (name.contains("自治区")) {
			return name.replace("自治区", "");
		}else if (name.contains("地区")) {
			return name.replace("地区", "");
		}else if (name.contains("蒙古自治州")) {
			return name.replace("蒙古自治州", "");
		}else if (name.contains("回族自治州")) {
			return name.replace("回族自治州", "");
		}
		else if (name.contains("黎族苗族自治县")) {
			return name.replace("黎族苗族自治县", "");
		}else if (name.contains("黎族自治县")) {
			return name.replace("黎族自治县", "");
		}
		return name;
	}



}
