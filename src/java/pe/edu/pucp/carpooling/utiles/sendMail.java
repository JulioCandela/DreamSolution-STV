/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.utiles;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Cesar
 */
public class sendMail {
    
    
    public static boolean sendMailCodeSecurity(String user,String codeSecurity)
    {
        try
        {
            System.out.println(user+" "+codeSecurity);
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "subeteapp@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("subeteapp@gmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(user));
            message.setSubject("Mensaje de bienvenida - Súbete");
            message.setText(
                "Bienvenido a Súbete!!! Gracias por subirte a esta nueva forma de transporte."
                    + "Por medidas de seguridad, se te ha enviado un código de verificación. Ingrésalo únicamente la primera vez que uses este servicio."
                    + "\n"
                    + ""
                    + "Usuario: "+user+
                    "\n"
                    + "\n"
                    + "Código de seguridad: "+codeSecurity+""
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "Atentamente,"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "SúbeteApp Perú"
                    
                    );
            

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("subeteapp@gmail.com", "eileen20077041");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
    }
    
    
    public static void sendMailRecoverPassword(String user,String password)
    {
        try
        {
            System.out.println(user+" "+password);
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "sharepoolapp@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sharepoolapp@gmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(user));
            message.setSubject("SharePool:Recuperación de cuenta");
            message.setText(
                "Este es el sistema de recuperación de cuenta de SharePool"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "Usuario: "+user+
                    "\n"
                    + "\n"
                    + "Contraseña: "+password+""
                    + "\n"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "Atentamente,"
                    + "\n"
                    + "\n"
                    + "\n"
                    + "SharePoolApp Perú"
                    
                    );
            

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("sharepoolapp@gmail.com", "eileen20077041");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
}
