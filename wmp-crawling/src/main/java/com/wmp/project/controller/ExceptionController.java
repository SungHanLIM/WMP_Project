package com.wmp.project.controller;

import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wmp.project.common.CommonConstants;

@Controller
public class ExceptionController implements ErrorController {
	private static Log logger = LogFactory.getLog(ExceptionController.class);
	static public final int UNKNOWN = 520;

	@RequestMapping(value = "/error")
	public String handleError(HttpServletRequest request, Model model) throws Exception {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		HttpStatus httpStatus = HttpStatus.valueOf(Integer.valueOf(status.toString()));

		if (status != null) {
			int statusCode = Integer.valueOf(status.toString());
			logger.info("httpStatus : " + statusCode);

			// 404 error
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				model.addAttribute("code", status.toString());
				model.addAttribute("msg", httpStatus.getReasonPhrase());
				model.addAttribute("timestamp", new Date());
				return CommonConstants.getPagePath(HttpStatus.NOT_FOUND.value());
			}

			// 500 error
			if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				return CommonConstants.getPagePath(HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
		}

		return CommonConstants.getPagePath(UNKNOWN);
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}