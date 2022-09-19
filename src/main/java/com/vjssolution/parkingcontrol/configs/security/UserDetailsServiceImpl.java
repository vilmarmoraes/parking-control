package com.vjssolution.parkingcontrol.configs.security;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vjssolution.parkingcontrol.models.UserModel;
import com.vjssolution.parkingcontrol.repositories.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	final UserRepository userRepository;

	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userRepository.findByUserName(username)
				.orElseThrow(()-> new UsernameNotFoundException("User Not Found with username: " + username));
		return new User(userModel.getUsername(),userModel.getPassword(),true,true,true,true,userModel.getAuthorities());
	}

}
