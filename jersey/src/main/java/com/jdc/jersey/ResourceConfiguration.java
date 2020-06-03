package com.jdc.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.jdc.jersey.resources.Members;

@Component
public class ResourceConfiguration extends ResourceConfig {

	public ResourceConfiguration() {
		register(Members.class);
	}
}
