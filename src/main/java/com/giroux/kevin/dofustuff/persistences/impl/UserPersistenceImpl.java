package com.giroux.kevin.dofustuff.persistences.impl;

import com.giroux.kevin.dofustuff.commons.security.User;
import com.giroux.kevin.dofustuff.persistences.UserPersistence;
import com.giroux.kevin.dofustuff.persistences.factory.UserFactory;
import com.giroux.kevin.dofustuff.persistences.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserPersistenceImpl implements UserPersistence{

    @Autowired
    private UserFactory userFactory;

    @Autowired
    private UserRepository userRepository;


    @Override
    public void createUserOrUpdateByConnexion(User user) {

    }

    @Override
    public User retrieveUserByLogin(String login) {
        return null;
    }

    @Override
    public void deleteUserByLogin(String login) {

    }


}
