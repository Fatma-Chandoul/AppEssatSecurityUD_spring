package tn.essat.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import tn.essat.model.User;
@Service
public interface IUserService extends UserDetailsService {
	User findByUsername (String username);
	

}
