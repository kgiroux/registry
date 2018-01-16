package com.giroux.kevin.dofustuff.services;

import com.giroux.kevin.dofustuff.commons.security.RefreshToken;

public interface GraphQLService {
    /**
     * Ask User from database
     * @param login
     * @return
     */
    RefreshToken performeAuth(final String login);
}
