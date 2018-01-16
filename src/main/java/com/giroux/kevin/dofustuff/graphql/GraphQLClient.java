package com.giroux.kevin.dofustuff.graphql;

import com.giroux.kevin.dofustuff.commons.security.RefreshToken;

public interface GraphQLClient {
    /**
     * Execute GetQuery on RealmServer
     * @param query
     * @return
     */
    RefreshToken executeGet(final String query);
}
