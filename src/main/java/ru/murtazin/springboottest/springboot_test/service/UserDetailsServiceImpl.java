package ru.murtazin.springboottest.springboot_test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.murtazin.springboottest.springboot_test.dao.UserDao;
import ru.murtazin.springboottest.springboot_test.model.User;


import javax.transaction.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userDao.findByUsername(username);
        user.getAuthorities().size();
        if (user==null){
            throw new UsernameNotFoundException(String.format("Not found user '%s' ",username ));
        }

        return user;
    }
}
