package DetectarIP;

//-*- coding: utf-8 -*-

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class InformacionRed {

 public static void main(String[] args) {
     try {
         // Obtener la lista de interfaces de red
         Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

         while (interfaces.hasMoreElements()) {
             NetworkInterface interfaz = interfaces.nextElement();

             // Obtener las direcciones IP asociadas con la interfaz
             Enumeration<InetAddress> direccionesIP = interfaz.getInetAddresses();
             while (direccionesIP.hasMoreElements()) {
                 InetAddress direccionIP = direccionesIP.nextElement();
                 System.out.println("Interfaz: " + interfaz.getDisplayName());

                 if (direccionIP instanceof Inet4Address) {
                     // IPv4
                     System.out.printf("   Dirección IPv4: %s%n", direccionIP.getHostAddress());
                 } else if (direccionIP instanceof Inet6Address) {
                     // IPv6
                     System.out.printf("   Dirección IPv6: %s%n", direccionIP.getHostAddress().split("%")[0]);
                 }

                 // Obtener la puerta de enlace (si es la interfaz principal)
                 if (interfaz.isUp() && !interfaz.isLoopback()) {
                     System.out.printf("   Puerta de enlace: %s%n", obtenerPuertaEnlace(interfaz));
                 }

                 // Obtener la dirección MAC
                 byte[] mac = interfaz.getHardwareAddress();
                 if (mac != null) {
                     StringBuilder direccionMac = new StringBuilder();
                     for (int i = 0; i < mac.length; i++) {
                         direccionMac.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                     }
                     System.out.printf("   Dirección MAC: %s%n", direccionMac.toString());
                 }
                 System.out.println();
             }
         }

     } catch (SocketException e) {
         System.err.println("Error al obtener información de red: " + e.getMessage());
     }
 }

 private static String obtenerPuertaEnlace(NetworkInterface interfaz) {
     Enumeration<InetAddress> direcciones = interfaz.getInetAddresses();
     while (direcciones.hasMoreElements()) {
         InetAddress direccion = direcciones.nextElement();
         if (!direccion.isLoopbackAddress() && direccion.getHostAddress().indexOf(':') == -1) {
             return direccion.getHostAddress();
         }
     }
     return null;
 }
}




