package com.giroux.kevin.dofustuff.services.impl;

import com.giroux.kevin.dofustuff.commons.security.RefreshToken;
import com.giroux.kevin.dofustuff.commons.security.User;
import com.giroux.kevin.dofustuff.persistences.UserPersistence;
import com.giroux.kevin.dofustuff.services.GraphQLService;
import com.giroux.kevin.dofustuff.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserPersistence userPersistence;

    @Autowired
    private GraphQLService graphQLService;

    @Override
    public void createOrUpdateUser(User user) {

    }
    @Override
    public User retrieveUserByLogin(String login) {
        RefreshToken refreshToken = this.graphQLService.performeAuth(login);

        User user = new User();
        user.setId(refreshToken.getTokenData().getIdentity());
        user.setUsername(login);
        user.setToken(refreshToken.getToken());
        user.setTokenExpired(LocalDateTime.ofInstant(Instant.ofEpochMilli(refreshToken.getTokenData().getExpires()), ZoneId.systemDefault()));
        return user;
    }

    @Override
    public void deleteUserByLogin(String login) {

    }

    @Override
    public String securePassword(String givenPassword) {
        return null;
    }
}
