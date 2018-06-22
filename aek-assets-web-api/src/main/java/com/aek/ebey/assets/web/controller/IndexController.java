package com.aek.ebey.assets.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aek.common.core.base.BaseController;
import com.aek.common.core.util.ResponseUtil;

/**
 * <p>
 * 资产Controller
 * </p>
 *
 * @author aek
 * @since 2017-04-13
 */
@RestController
@RequestMapping("/assets")
public class IndexController extends BaseController {

	@RequestMapping("/index")
	public Object index(){
		return response();
	}

	
	@RequestMapping("/unauthorized")
	public Object unauthorized(){
		return ResponseUtil.getNotPermsResult();
	}


}
