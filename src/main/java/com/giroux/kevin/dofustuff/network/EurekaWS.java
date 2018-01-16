package com.giroux.kevin.dofustuff.network;

import com.netflix.discovery.shared.Application;
import com.netflix.eureka.EurekaServerContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/applications")
@CrossOrigin("*")
public class EurekaWS {

	/**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(EurekaWS.class);
	
	@RequestMapping(name ="Get all application", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public List<Application> getApplication() {
		return EurekaServerContextHolder.getInstance().getServerContext().getRegistry().getSortedApplications();
		
	}
}
