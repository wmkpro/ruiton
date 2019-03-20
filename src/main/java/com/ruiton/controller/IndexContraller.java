/**
 * 
 */
package com.ruiton.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author weiminke
 *
 */
@Slf4j
@RestController
public class IndexContraller extends BaseController{
	@RequestMapping("/index")
	public ModelAndView orderlistUI(){
		modelAndView("index/index");
		return modelAndView;
	}
}
