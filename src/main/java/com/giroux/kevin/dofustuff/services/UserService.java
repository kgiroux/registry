package com.giroux.kevin.dofustuff.services;

import com.giroux.kevin.dofustuff.commons.security.User;

public interface UserService {

    void createOrUpdateUser(final User user);

    User retrieveUserByLogin(final String login);

    void deleteUserByLogin(final String login);

    String securePassword(final String givenPassword);
}
