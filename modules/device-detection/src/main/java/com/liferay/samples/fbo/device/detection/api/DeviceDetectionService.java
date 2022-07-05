package com.liferay.samples.fbo.device.detection.api;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

public interface DeviceDetectionService {
	
	public boolean isMobile(HttpServletRequest httpServletRequest);

	public boolean isMobile(PortletRequest portletRequest);

}
