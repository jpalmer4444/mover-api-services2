/*
 * EmailServiceImpl
 */
package com.e.labor.service.impl;

import com.e.labor.service.EmailService;
//import java.util.Map;
//import javax.mail.internet.MimeMessage;
//import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.mail.javamail.MimeMessagePreparator;
//import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 *
 * @author jasonpalmer
 */
public class EmailServiceImpl implements EmailService {
    
    private static final Logger LOG = LoggerFactory.getLogger(EmailServiceImpl.class);

    //private final VelocityEngine velocityEngine;
    //private final JavaMailSender mailSender;

    /**
     * Constructor
     * @param velocityEngine
     * @param mailSender
     */
    //@Autowired
    /*public EmailServiceImpl(VelocityEngine velocityEngine,
                               JavaMailSender mailSender) {
        this.velocityEngine = velocityEngine;
        this.mailSender = mailSender;
    }*/

    /*@Override
    public void send(
            SimpleMailMessage msg, 
            String templateFilename, 
            Map<String, Object> hTemplateVariables
    ) {
        
        MimeMessagePreparator preparator = (MimeMessage mimeMessage) -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setTo(msg.getTo());
            message.setFrom(msg.getFrom());
            message.setSubject(msg.getSubject());
            
            String body = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/" + templateFilename, "UTF-8", hTemplateVariables);
            
            LOG.info("body={}", body);
            
            message.setText(body, true);
        };

         mailSender.send(preparator);
        
    }*/
    
}
