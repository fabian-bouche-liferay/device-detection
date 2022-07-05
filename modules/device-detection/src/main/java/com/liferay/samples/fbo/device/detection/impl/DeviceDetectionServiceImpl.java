package com.liferay.samples.fbo.device.detection.impl;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.samples.fbo.device.detection.api.DeviceDetectionService;

import javax.portlet.PortletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = DeviceDetectionService.class
		)
public class DeviceDetectionServiceImpl implements DeviceDetectionService {

	@Override
	public boolean isMobile(HttpServletRequest httpServletRequest) {
		Cookie[] cookies = httpServletRequest.getCookies();
		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++) {
				if("device-detection-mobile".equals(cookies[i].getName())) {
					return GetterUtil.getBoolean(cookies[i].getValue());
				}
			}
		}
		return false;
	}

	@Override
	public boolean isMobile(PortletRequest portletRequest) {
		return isMobile(_portal.getHttpServletRequest(portletRequest));
	}

	@Reference
	private Portal _portal;
	
}
