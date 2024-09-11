package com.application.market.security;

import java.io.Serializable;

public interface GrantedAuthority extends Serializable {

    String getAuthority();
}
