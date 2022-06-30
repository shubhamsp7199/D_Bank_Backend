package com.cg.service;

import com.cg.exception.DuplicateUserException;
import com.cg.exception.InvalidLoginCredentialException;
import com.cg.exception.NoSuchUserException;
import com.cg.model.User;
import com.cg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    public boolean isLoggedIn;

    public User tempUser;

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) throws DuplicateUserException{
        if(null == userRepository.findByUserName(user.getUserName()))
            return userRepository.save(user);
        throw new DuplicateUserException("This User is already registered.");

    }

    @Override
    public User loginUser(User user) throws InvalidLoginCredentialException {
        tempUser = userRepository.findByUserName(user.getUserName());
//        user.setUserId(tempUser.getUserId());
       if (null != tempUser){
           if (user.equals(tempUser)){
               isLoggedIn = true;
               return tempUser;
           }
       }
       throw new InvalidLoginCredentialException("Please enter valid Credential.");
    }

    @Override
    public String logout(String userName) throws NoSuchUserException {

        if (isLoggedIn){
            isLoggedIn = false;
            return "User logged out successfully.";
        }
        throw new NoSuchUserException(userName + "No such User found.");
    }
}
