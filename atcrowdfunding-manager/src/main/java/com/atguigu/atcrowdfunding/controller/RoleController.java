package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Page;
import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	//新增
	@RequestMapping("/insert")
	public @ResponseBody Object insert(Role role) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			roleService.insertRole(role);
			result.setSuccess(true);
		}catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	
	@RequestMapping("/add")
	public String add() {
		
		return "role/add";
	}
	/**
	 * 本次错误事务拦截异常，原因在于对于query开头的方法都只能以只读的方式执行，不可进行修改，如果进行修改会出现异常
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	public @ResponseBody Object delete(Integer id) {
		AJAXResult result = new AJAXResult();
		
		try {
			roleService.deleteRoleById(id);
			result.setSuccess(true);
		}catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	//修改
	@RequestMapping("/update")
	public @ResponseBody Object update(Role role) {
		AJAXResult result = new AJAXResult();
		
		try {
			System.out.println(role);
			roleService.updateRole(role);
			System.out.println(role);
			result.setSuccess(true);
		}catch (Exception e) {
			//e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	//跳转修改页面
	@RequestMapping("edit")
	public String edit(Integer id,Model model) {
		Role role = roleService.queryById(id);
		model.addAttribute("role", role);
		return "role/edit";
	}
	
	
	@RequestMapping("/doAssign")
	public @ResponseBody Object doAssign(Integer roleid, Integer[] permissionids) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("roleid", roleid);
			paramMap.put("permissionids", permissionids);
			roleService.insertRolePermission(paramMap);
			
			result.setSuccess(true);
		}catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/pageQuery")
	public Object pageQuery( String queryText, Integer pageno, Integer pagesize ) {
		
		AJAXResult result = new AJAXResult();
		
		try {
			
			// 分页查询
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("start", (pageno-1)*pagesize);
			map.put("size", pagesize);
			map.put("queryText", queryText);
			
			List<Role> roles = roleService.pageQueryData( map );
			// 当前页码			
			// 总的数据条数
			int totalsize = roleService.pageQueryCount( map );
			// 最大页码（总页码）
			int totalno = 0;
			if ( totalsize % pagesize == 0 ) {
				totalno = totalsize / pagesize;
			} else {
				totalno = totalsize / pagesize + 1;
			}
			
			// 分页对象
			Page<Role> rolePage = new Page<Role>();
			rolePage.setDatas(roles);
			rolePage.setTotalno(totalno);
			rolePage.setTotalsize(totalsize);
			rolePage.setPageno(pageno);
			
			result.setData(rolePage);
			result.setSuccess(true);
		} catch ( Exception e ) {
			e.printStackTrace();
			result.setSuccess(false);
		}
		
		return result;
		
	}
	
	
	@RequestMapping("/assign")
	public String assign() {
		
		return "role/assign";
	}
	
	
	@RequestMapping("/index")
	public String index() {
		
		return "role/index";
	}
}
