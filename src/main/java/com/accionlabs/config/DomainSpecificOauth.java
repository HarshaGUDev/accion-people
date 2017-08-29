package com.accionlabs.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

@Component
public class DomainSpecificOauth implements AuthoritiesExtractor {

	private String allowedDomain = "accionlabs.com";

	@Override
	public List<GrantedAuthority> extractAuthorities(Map<String, Object> map) {

		final String domain = (String) map.get("domain");
		if (!allowedDomain.contains(domain)) {
			throw new BadCredentialsException("Not an allowed domain");
		}
		final List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		return list;

	}
}
