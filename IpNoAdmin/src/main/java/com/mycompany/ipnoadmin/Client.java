/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ipnoadmin;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Julians-PC
 */
public class Client {
     public static void send(String data) {
        try {
            String serverAddress = "127.0.0.1"; // Ändern Sie dies auf die IP-Adresse oder den Hostnamen des Servers
            int serverPort = 50001; // Port des Servers

            Socket socket = new Socket(serverAddress, serverPort);
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            writer.println(data);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    
    
}
