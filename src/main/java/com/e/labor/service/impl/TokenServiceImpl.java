/*
 * TokenServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.service.TokenService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author jasonpalmer
 */
@Service("tokenService")
public class TokenServiceImpl implements TokenService {

    private final static Logger LOG = LoggerFactory.getLogger(TokenServiceImpl.class.getName());

    @Value("${ms.register.secret}")
    private String SECRET_KEY;

    @Override
    public String getToken(Date notBefore, Date expires, String subject, Map<String, String> claims) {
        JwtBuilder signWith = Jwts.builder()
                .setIssuer("Moving Services")
                .setSubject(subject)
                .setIssuedAt(notBefore)
                .setExpiration(expires)
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(SECRET_KEY)
                );

        if (claims != null && !claims.isEmpty()) {
            Set<String> keys = claims.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                String value = claims.get(key);
                signWith.claim(key, value);
            }
        }
        return signWith
                .compact();
    }

}
