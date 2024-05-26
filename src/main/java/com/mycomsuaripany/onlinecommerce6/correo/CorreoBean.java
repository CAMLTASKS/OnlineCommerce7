/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.correo;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Named(value = "correoBean")
@RequestScoped
public class CorreoBean {

    ConfiguracionCorreo configuracion;
    private String destinatario;
    private String asunto;
    private String mensaje;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String enviarCorreo() {
        configuracion = new ConfiguracionCorreo();
        Properties props = new Properties();
        props.put("mail.smtp.host", configuracion.getSmtpHost());
        props.put("mail.smtp.port", configuracion.getSmtpPort());
        props.put("mail.smtp.auth", configuracion.isSmtpAuth());
        props.put("mail.smtp.starttls.enable", configuracion.isStartTlsEnabled());
        props.put("mail.smtp.ssl.trust", configuracion.getSmtpHost());
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        configuracion.getSmtpUser(),
                        configuracion.getSmtpPassword()
                );
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(configuracion.getSmtpUser()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);
            return "exito"; // Página de éxito
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "error"; // Página de error
        }
    }
}
