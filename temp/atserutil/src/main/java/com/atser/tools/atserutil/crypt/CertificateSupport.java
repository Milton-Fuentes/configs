package com.atser.tools.atserutil.crypt;

import com.atser.tools.atserutil.file.FileSupport;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;

/**
 * Created by dropal.
 */
public class CertificateSupport {
    
    /*public static Integer ValidateCerAndKey(String passsword, File cer, File pKey) {
        try {
            byte[] certificate = FileSupport.FileToByte(cer);
            byte[] privateKey = FileSupport.FileToByte(pKey);

            ByteArrayInputStream bais = new ByteArrayInputStream(certificate);

            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            Certificate cert = cf.generateCertificate(bais);
            bais.close();
            RSAPublicKey publicKey = (RSAPublicKey) cert.getPublicKey();

            PKCS8Key pkcs8Key = new PKCS8Key(privateKey, passsword.toCharArray());
            RSAPrivateCrtKey key = (RSAPrivateCrtKey) pkcs8Key.getPrivateKey();

            if (key.getModulus().compareTo(publicKey.getModulus()) != 0) {
                return 1; // No se corresponde el certificado y la clave privada
            }
            return 0; // Correcto
        } catch (IOException e) {
            return 2; // excepción
        } catch (BadPaddingException e) {
            return 1; // la contraseña no se corresponde a  la Clave Privada
        } catch (GeneralSecurityException e) {
            return 2; // excepción
        }
    }*/

    public static Date ExpiredCerDate(String cer) throws FileNotFoundException, CertificateException {
        FileInputStream inStream = new FileInputStream(cer);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);

        return cert.getNotAfter();
    }

    public static Date CreationCerDate(String cer) throws FileNotFoundException, CertificateException {
        FileInputStream inStream = new FileInputStream(cer);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);

        return cert.getNotBefore();

    }

    public static String CerPersonName(String pathCer) {
        String certText = "";
        try {
            FileInputStream inStream = new FileInputStream(pathCer);
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);

            certText = cert.getSubjectDN().toString();
            String[] certArray = certText.split(",");
            for (String certArray1 : certArray) {
                if (certArray1.trim().startsWith("CN=")) {
                    certText = certArray1.split("=")[1];
                    return certText;
                }
            }
            certText = "";
        } catch (FileNotFoundException | CertificateException ex) {
            Logger.getLogger(FileSupport.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        return certText;
    }

    public static String getSerialNumberCertificate(File certificate) throws IOException, CertificateException {
        ByteArrayInputStream bais = new ByteArrayInputStream(FileSupport.FileToByte(certificate));
        CertificateFactory cf = null;

        cf = CertificateFactory.getInstance("X.509");

        X509Certificate cert = null;

        cert = (X509Certificate) cf.generateCertificate(bais);
        byte[] serialNumberBA = cert.getSerialNumber().toByteArray();
        String serialNumber = new String(serialNumberBA);
        bais.close();
        return serialNumber;
    }
}
