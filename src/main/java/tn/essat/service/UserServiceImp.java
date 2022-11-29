package tn.essat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.essat.dao.IUser;
import tn.essat.model.User;

@Service
public class UserServiceImp implements IUserService {
	@Autowired
	IUser daou;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = daou.findByUsername(username);
		if (u == null) {
			throw new UsernameNotFoundException("Not exist!!!");
		}
		return u;
	}

	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return daou.findByUsername(username);
	}

}
