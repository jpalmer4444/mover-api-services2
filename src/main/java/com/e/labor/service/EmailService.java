/*
 * EmailService
 */
package com.e.labor.service;

//import java.util.Map;
//import org.springframework.mail.SimpleMailMessage;

/**
 *
 * @author jasonpalmer
 */
public interface EmailService {

    /**
     * Sends e-mail using Velocity template for the body and the properties
     * passed in as Velocity variables.
     *
     * @param msg The e-mail message to be sent, except for the body.
     * @param templateFilename
     * @param hTemplateVariables Variables to use when processing the template.
     */
    /*public void send(SimpleMailMessage msg, String templateFilename, Map<String, Object> hTemplateVariables);*/

}
