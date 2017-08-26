/*
 * CypherService
 */
package com.e.labor.service;

import java.security.SecureRandom;

/**
 *
 * @author jasonpalmer
 */
public interface CypherService {
    
    String encrypt(String unencrypted) throws Exception;
    
    String decrypt(String encrypted) throws Exception;
    
}
