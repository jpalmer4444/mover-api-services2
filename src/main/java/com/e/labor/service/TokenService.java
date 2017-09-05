/*
 * TokenService
 * Responsible for generating tokens.
 */
package com.e.labor.service;

import java.util.Date;
import java.util.Map;

/**
 *
 * @author jasonpalmer
 */
public interface TokenService {
    
    String getToken(Date notBefore, Date expires, String subject, Map<String, String> claims);
    
}
