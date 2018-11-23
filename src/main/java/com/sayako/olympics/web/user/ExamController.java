package com.sayako.olympics.web.user;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sayako.olympics.entity.ExamSearchDTO;
import com.sayako.olympics.service.ExamService;
import com.sayako.olympics.utils.PageDataResult;

@Controller
@RequestMapping("/exam")
public class ExamController {

	private static final Logger logger = LoggerFactory.getLogger(ExamController.class);
	@Autowired
	private ExamService examService;
	@RequestMapping("/examList")
	public String toExamList() {
		return "/exam/examList";
	}

	/**
	 * 分页查询试题列表
	 * 
	 * @return ok/fail
	 */
	@RequestMapping(value = "/getExams", method = RequestMethod.POST)
	@ResponseBody
	@RequiresPermissions(value = "exammanage")
	public PageDataResult getUsers(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,
			ExamSearchDTO examSearch) {
		logger.debug("分页查询试题列表！搜索条件：examSearch：" + examSearch + ",page:" + page + ",每页记录数量limit:" + limit);
		PageDataResult pdr = new PageDataResult();
		try {
			if (null == page) {
				page = 1;
			}
			if (null == limit) {
				limit = 10;
			}
			// 获取用户和角色列表
			pdr = examService.getExams(examSearch, page, limit);
			logger.debug("试题列表查询=pdr:" + pdr);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("试题列表查询异常！", e);
		}
		return pdr;
	}

	/**
	 * 设置用户[新增或更新]
	 * 
	 * @return ok/fail
	 */
//	@RequestMapping(value = "/setUser", method = RequestMethod.POST)
//	@ResponseBody
//	public String setUser(@RequestParam("roleIds") String roleIds, User user) {
//		logger.debug("设置用户[新增或更新]！user:" + user + ",roleIds:" + roleIds);
//		try {
//			if (null == user) {
//				logger.debug("置用户[新增或更新]，结果=请您填写用户信息");
//				return "请您填写用户信息";
//			}
//			if (StringUtils.isEmpty(roleIds)) {
//				logger.debug("置用户[新增或更新]，结果=请您给用户设置角色");
//				return "请您给用户设置角色";
//			}
//			User existUser = (User) SecurityUtils.getSubject().getPrincipal();
//			if (null == existUser) {
//				logger.debug("置用户[新增或更新]，结果=您未登录或登录超时，请您登录后再试");
//				return "您未登录或登录超时，请您登录后再试";
//			}
//			user.setInsertUid(existUser.getId());
//			// 设置用户[新增或更新]
//			logger.info("设置用户[新增或更新]成功！user=" + user + ",roleIds=" + roleIds + "，操作的用户ID=" + existUser.getId());
//			return userService.setUser(user, roleIds);
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("设置用户[新增或更新]异常！", e);
//			return "操作异常，请您稍后再试";
//		}
//	}

	/**
	 * 删除用户
	 * 
	 * @return ok/fail
	 */
//	@RequestMapping(value = "/delUser", method = RequestMethod.POST)
//	@ResponseBody
//	public String delUser(@RequestParam("id") Integer id, @RequestParam("version") Integer version) {
//		logger.debug("删除用户！id:" + id + ",version:" + version);
//		String msg = "";
//		try {
//			if (null == id || null == version) {
//				logger.debug("删除用户，结果=请求参数有误，请您稍后再试");
//				return "请求参数有误，请您稍后再试";
//			}
//			User existUser = (User) SecurityUtils.getSubject().getPrincipal();
//			if (null == existUser) {
//				logger.debug("删除用户，结果=您未登录或登录超时，请您登录后再试");
//				return "您未登录或登录超时，请您登录后再试";
//			}
//			// 删除用户
//			msg = userService.setDelUser(id, 1, existUser.getId(), version);
//			logger.info("删除用户:" + msg + "！userId=" + id + "，操作用户id:" + existUser.getId() + ",version:" + version);
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("删除用户异常！", e);
//			msg = "操作异常，请您稍后再试";
//		}
//		return msg;
//	}

	/**
	 *
	 * @描述：恢复用户
	 * @创建人：wyait
	 * @创建时间：2018年4月27日 上午9:49:14
	 * @param id
	 * @return
	 */
//	@RequestMapping(value = "/recoverUser", method = RequestMethod.POST)
//	@ResponseBody
//	public String recoverUser(@RequestParam("id") Integer id, @RequestParam("version") Integer version) {
//		logger.debug("恢复用户！id:" + id + ",version:" + version);
//		String msg = "";
//		try {
//			User existUser = (User) SecurityUtils.getSubject().getPrincipal();
//			if (null == existUser) {
//				return "您未登录或登录超时，请您登录后再试";
//			}
//			if (null == id || null == version) {
//				return "请求参数有误，请您稍后再试";
//			}
//			// 删除用户
//			msg = userService.setDelUser(id, 0, existUser.getId(), version);
//			logger.info("恢复用户【" + this.getClass().getName() + ".recoverUser】" + msg + "。用户userId=" + id + "，操作的用户ID="
//					+ existUser.getId() + ",version:" + version);
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error("恢复用户【" + this.getClass().getName() + ".recoverUser】用户异常！", e);
//			msg = "操作异常，请您稍后再试";
//		}
//		return msg;
//	}

	/**
	 * 查询用户数据
	 * 
	 * @return map
	 */
//	@RequestMapping(value = "/getUserAndRoles", method = RequestMethod.GET)
//	@ResponseBody
//	public Map<String, Object> getUserAndRoles(@RequestParam("id") Integer id) {
//		logger.debug("查询用户数据！id:" + id);
//		Map<String, Object> map = new HashMap<>();
//		try {
//			if (null == id) {
//				logger.debug("查询用户数据==请求参数有误，请您稍后再试");
//				map.put("msg", "请求参数有误，请您稍后再试");
//				return map;
//			}
//			// 查询用户
//			UserRolesVO urvo = userService.getUserAndRoles(id);
//			logger.debug("查询用户数据！urvo=" + urvo);
//			if (null != urvo) {
//				map.put("user", urvo);
//				// 获取全部角色数据
//				List<Role> roles = this.authService.getRoles();
//				logger.debug("查询角色数据！roles=" + roles);
//				if (null != roles && roles.size() > 0) {
//					map.put("roles", roles);
//				}
//				map.put("msg", "ok");
//			} else {
//				map.put("msg", "查询用户信息有误，请您稍后再试");
//			}
//			logger.debug("查询用户数据成功！map=" + map);
//			return map;
//		} catch (Exception e) {
//			e.printStackTrace();
//			map.put("msg", "查询用户错误，请您稍后再试");
//			logger.error("查询用户数据异常！", e);
//		}
//		return map;
//	}


}