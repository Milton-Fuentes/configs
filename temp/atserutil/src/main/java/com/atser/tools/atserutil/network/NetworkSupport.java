/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.util.SubnetUtils;
import org.apache.commons.net.util.SubnetUtils.SubnetInfo;

/**
 *
 * @author droldan
 */
public class NetworkSupport {

    public static boolean isIPAddressAllowed(String subnet, String ipAddress) {
        String[] array = subnet.split(",");
        for (String segment : array) {
            if (isIPAllowed(segment.trim(), ipAddress)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isIPAllowed(String subnet, String ipAddress) {
        SubnetUtils utils = new SubnetUtils(subnet);
        SubnetInfo info = utils.getInfo();
        if (info.getNetmask().equals("255.255.255.255")) { // IPv4
            return info.getNetworkAddress().equals(ipAddress);
        }
        return info.isInRange(ipAddress);
    }

    private static Boolean urlRecursivePattern(String[] pattern, String[] path, int index) {
        if ((pattern.length - 1) == index && pattern[index].equals("*")) {
            return Boolean.TRUE;
        }
        if (path[index].equals(pattern[index])) {
            index++;
            if ((pattern.length - 1) < index) {
                return Boolean.TRUE;
            }
            return urlRecursivePattern(pattern, path, index);
        }
        return Boolean.FALSE;
    }

    public static Boolean isRESTPathAllowed(String pattern, String path) {
        if (pattern == null || path == null || pattern.length() <= 1 || path.length() <= 1) {
            return Boolean.FALSE;
        }

        String[] arrayPattern = pattern.trim().replaceAll("\\s+", "").replaceAll("^/", "").split("/");
        String[] arrayPath = path.trim().replaceAll("\\s+", "").replaceAll("^/", "").split("/");

        if (arrayPath.length < 2 || arrayPattern.length > arrayPath.length) {
            return Boolean.FALSE;
        }

        if (pattern.length() == 2 && pattern.startsWith("/") && pattern.endsWith("*")) {
            return Boolean.TRUE;
        }

        return urlRecursivePattern(arrayPattern, arrayPath, 0);
    }

    public static String getMac() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();

        } catch (SocketException e) {
        } catch (java.net.UnknownHostException ex) {
            Logger.getLogger(NetworkSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Ping to address
     *
     * @param addr
     * @return
     */
    public static boolean ping(String addr) {
        try {
            boolean reachable = (java.lang.Runtime.getRuntime().exec("ping " + addr).waitFor() == 0);
            if (reachable) {
                return true;
            }
        } catch (IOException | InterruptedException e) {
            return false;
        }
        return false;
    }

    /**
     * Método Ping a red En caso de que se tenga alguna red virtual activa por
     * una máquina virtual lo reconoce como que la pc tiene conexión
     *
     * @return true si hay conexión de red, false si no hay
     */
    public static boolean _ping() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

            while (interfaces.hasMoreElements()) {
                NetworkInterface interf = interfaces.nextElement();
                if (interf.isUp() && !interf.isLoopback()) {
                    return true;
                }
            }
        } catch (SocketException ex) {
            Logger.getLogger(NetworkSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Get My Public IP
     *
     * @return
     */
    public static String getPublicIP() {
        String ipAddr;
        try {
            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
            ipAddr = sc.readLine().trim();
        } catch (Exception e) {
            ipAddr = "127.0.0.1";
        }
        return ipAddr;
    }
}
