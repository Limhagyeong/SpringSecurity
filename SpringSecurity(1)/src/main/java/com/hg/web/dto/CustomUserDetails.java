package com.hg.web.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hg.web.vo.prouser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails{
	
	private final prouser prouser;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();

        collection.add(new GrantedAuthority() {

            @Override
            public String getAuthority() {

                return prouser.getRole();
            }
        });

        return collection;
	} // 권한 검증

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return prouser.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return prouser.getUsername();
	}
}
