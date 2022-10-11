/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.mail;

import com.atser.tools.atserutil.enumerator.eCarrier;
import com.atser.tools.atserutil.string.StringSupport;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Slf4j
public class MailSender {

    /*public static Boolean sendEmailDefault(Session mailSession, MailMessage msg) {
        try {
            MimeMessage m = new MimeMessage(mailSession);
            Address from = new InternetAddress("wwwmail@atser.com");
            int toCount = msg.getTo().length;
            Set<Address> toAddrs = new LinkedHashSet<>();
            for (int i = 0; i < toCount; ++i) {
                if (msg.getTo()[i] != null) {
                    toAddrs.add(new InternetAddress(msg.getTo()[i]));
                }
            }

            m.setFrom(from);
            Address[] toAddrsConvert = new InternetAddress[toAddrs.size()];
            toAddrsConvert = toAddrs.toArray(toAddrsConvert);
            m.setRecipients(Message.RecipientType.TO, toAddrsConvert);
            m.setSubject(msg.getSubject());
            m.setSentDate(new java.util.Date());
            m.setContent(msg.getMessageText(), "text/html");
            Transport.send(m);
        } catch (javax.mail.MessagingException e) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }*/
    /**
     * Send Email Default
     *
     * @param mailSession
     * @param msg
     * @return
     */
    public static Boolean sendEmailDefault(Session mailSession, MailMessage msg) {
        try {
            MimeMessage m = new MimeMessage(mailSession);
            Address from;
            if (StringSupport.isNullOrEmpty(msg.from)) {
                from = new InternetAddress("wwwmail@atser.com");
            } else {
                from = new InternetAddress(msg.from);
            }
            m.setFrom(from);
            int toCount = msg.getTo().length;
            Set<Address> toAddrs = new LinkedHashSet<>();
            for (int i = 0; i < toCount; ++i) {
                if (msg.getTo()[i] != null) {
                    toAddrs.add(new InternetAddress(msg.getTo()[i]));
                }
            }
            Address[] toAddrsConvert = new InternetAddress[toAddrs.size()];
            toAddrsConvert = toAddrs.toArray(toAddrsConvert);
            m.setRecipients(Message.RecipientType.TO, toAddrsConvert);

            // Send BCC
            if (msg.getCc() != null) {
                Set<Address> bccAddrs = new LinkedHashSet<>();
                for (String scc : msg.getCc()) {
                    if (scc != null) {
                        bccAddrs.add(new InternetAddress(scc));
                    }
                }
                Address[] bccAddrsConvert = new InternetAddress[bccAddrs.size()];
                bccAddrsConvert = bccAddrs.toArray(bccAddrsConvert);
                m.setRecipients(Message.RecipientType.BCC, bccAddrsConvert);
            }

            m.setSubject(msg.getSubject());
            m.setSentDate(new java.util.Date());
            m.setContent(msg.getMessageText(), "text/html");
            Transport.send(m);
        } catch (javax.mail.MessagingException e) {
            log.error("@ATSER - LocalizedMessage: " + e.getLocalizedMessage());
            log.error("@ATSER - Message: " + e.getMessage());
            if (e.getCause() != null) {
                log.error("@ATSER - Cause: " + e.getCause().toString());
            }
            log.error("@ATSER - MessagingException as String: " + e.toString());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static String getSmsEmail(String phone, String carrier) {
        if (StringSupport.isNotNullAndNotEmpty(phone, carrier)) {
            eCarrier ec = eCarrier.valueOf(carrier);
            return phone + "@" + ec.getValue();
        }
        return null;
    }
}
