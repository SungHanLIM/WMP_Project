package com.wmp.project.controller;

import java.io.IOException;
import java.util.Map;
import java.util.PriorityQueue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wmp.project.common.CommonConstants;
import com.wmp.project.service.WmpService;
import com.wmp.project.util.HTMLParser;

@Controller
public class WmpController {
	private static Log logger = LogFactory.getLog(WmpController.class);
	
	@Autowired
	WmpService wmpService;
	
	@RequestMapping(value = "/cmdStrDivision.do", method = RequestMethod.POST)
	public ModelAndView memberRegi(
			@RequestParam(value = "url", required = true) String url,
			@RequestParam(value = "unit", required = true) int unit, 
			@RequestParam(value = "typeId", required = true) int typeId) {
		
		ModelAndView mav = new ModelAndView("index");
		HTMLParser htmlParser = null;
		try {
			htmlParser = new HTMLParser(url, typeId == 1 ? true : false);
		} catch (IOException e) {
			logger.error(e, e);
			
			mav.addObject("code", Integer.toString(HttpStatus.BAD_REQUEST.value()));
			mav.addObject("result", "Invaild URL.");
			return mav;
		}
		
		try {
			String htmlStr = htmlParser.getHtml();
			PriorityQueue<String> pqEng = wmpService.lineUpStr(wmpService.setPattern(htmlStr, CommonConstants.getPattern(CommonConstants.patternEng)), true);
			PriorityQueue<String> pqNum = wmpService.lineUpStr(wmpService.setPattern(htmlStr, CommonConstants.getPattern(CommonConstants.patternNum)), true);
			String mixedStr = wmpService.mixStr(pqEng, pqNum);

			Map<String, Object> resultMap = wmpService.divideStr(mixedStr, unit);
			mav.addObject("code", Integer.toString(HttpStatus.OK.value()));
			mav.addObject("result", HttpStatus.OK.name());
			mav.addObject("quotient", resultMap.get("quotient"));
			mav.addObject("remainder", resultMap.get("remainder"));
		} catch (Exception e) {
			logger.error(e, e);
			mav.addObject("code", Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			mav.addObject("result", HttpStatus.INTERNAL_SERVER_ERROR.name());
			return mav;
		}

		return mav;
		
	}
}
