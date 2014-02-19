/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.carpooling.utiles;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 *
 * @author Cesar
 */
public class encryptUtil {
    
    public static String generarCadenaAleatoria()
    {
        String cadenaAleatoria = "";
        int longitud=20;
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while ( i <= longitud){
        char c = (char)r.nextInt(255);
                if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
                cadenaAleatoria += c;
                i ++;
                }
        }
        return cadenaAleatoria;
    }
    
    
    public static String toHexadecimal(byte[] digest){

         String hash = "";
         for(byte aux : digest) {
            int b = aux & 0xff;
            if (Integer.toHexString(b).length() == 1) hash += "0";
            hash += Integer.toHexString(b);
        }
        return hash;
    }
    
    public static String getStringMessageDigest(String message){
        byte[] digest = null;
        String algorithm="MD5";
        byte[] buffer = message.getBytes();
        try {

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.reset();
            messageDigest.update(buffer);
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error creando Digest");
        }
        return toHexadecimal(digest);

    }
}
