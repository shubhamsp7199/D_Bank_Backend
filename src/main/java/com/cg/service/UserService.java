package com.cg.service;

import com.cg.exception.DuplicateUserException;
import com.cg.exception.InvalidLoginCredentialException;
import com.cg.exception.NoSuchUserException;
import com.cg.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User registerUser(User user) throws DuplicateUserException;

    public User loginUser(User user) throws InvalidLoginCredentialException;

    public String logout(String userName) throws NoSuchUserException;
}
