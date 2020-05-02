package com.github.springsecurity.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * application properties for swagger and others
 *
 * @author Sunny Srivastava
 * @since 1.0
 */
@Configuration
@ConfigurationProperties("app")
@JsonIgnoreProperties({ "$$beanFactory", "others" })
public class AppProperties {

	private String name;
	private String description;
	private String version;
	private String ownerName;
	private String ownerMail;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(final String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerMail() {
		return ownerMail;
	}

	public void setOwnerMail(final String ownerMail) {
		this.ownerMail = ownerMail;
	}

}
