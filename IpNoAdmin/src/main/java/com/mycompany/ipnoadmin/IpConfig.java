/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipnoadmin;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Properties;
/**           

 *
 * @author Julians-PC
 */
public class IpConfig {

    private String ip;
    private String subnet;
    private String gateway;

    public IpConfig(String ip, String subnet, String gateway) {

        this.ip = ip;
        this.subnet = subnet;
        this.gateway = gateway;
    }

    public static String[] getIpConfig() {
        String[] ipConfig = new String[3];
        try {
            ipConfig[0] = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String gateway = System.getenv("GATEWAY_INTERFACE");
        if (gateway != null) {
            ipConfig[1] = gateway;
            System.out.println(gateway);
        }

        return ipConfig;

    }

    public static String getDhcp() {
        try {
            Properties sysProps = System.getProperties();
            Enumeration<?> e = sysProps.propertyNames();
            
            while (e.hasMoreElements()) {
                String key = (String) e.nextElement();
                String value = sysProps.getProperty(key);
                if (key.startsWith("dhcp.")) {
                    return "true";
                }
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return "false";
    }

    public static String[] getNetworkAdapter(){
        int i= 0;
        String[] networkAdapter = new String[10];
        try {  
            
            String query = "Select * FROM Win32_NetworkAdapterConfiguration WHERE IPEnabled = true";
            WmiQuery<Win32_NetworkAdapterConfiguration> wmiQuery = new WmiQuery<>("Win32_NetworkAdapterConfiguration", query);

            
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }       
       return networkAdapter;
        
        
    }
    
}

