package com.mycompany.teatromoroarray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeatroMoroArray {
    static int totalEntradas=0, opcion=4, contadorEntradas;
    static double totalIngresos = 0, valorVIP = 15000, valorPlatea= 12000, valorBalcon=10000;
    static double descuento, valorBase, valorFinal;
    static final int cantidadEntradasTotal = 100;
    static String ubicacion;

    static List<String> ubicacionVendida = new ArrayList<>();
    static List<Double> precioFinal = new ArrayList<>();
    static List<Double> descuentosAplicados = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("BIENVENIDO A TEATRO MORO!");
        
        while (opcion>=1 && opcion<=4) {
            TeatroMoroArray.Menu();

            switch (opcion) {
                case 1:
                    TeatroMoroArray.ventaEntrada();
                    break;
                case 2:
                    TeatroMoroArray.mostrarResumen();
                    break;
                case 3:  
                    System.out.println("SALIENDO DEL SISTEMA... NOS VEMOS PRONTO");
                    opcion++;
                    break;
                default:
                    System.out.println("OPCION INVALIDA! POR FAVOR INGRESE UNA OPCION VALIDA.");
            }
        }
        scanner.close();
    }
public static void Menu(){
    Scanner scanner = new Scanner(System.in);
            System.out.println("****  MENU  ****");
            System.out.println("1-VENTA ENTRADAS");
            System.out.println("2-RESUMEN DE VENTAS");
            System.out.println("3-SALIR DEL PROGRAMA");
            System.out.println("POR FAVOR INGRESE UNA OPCION: ");
            opcion = scanner.nextInt();
}
    
    public static void ventaEntrada() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("POR FAVOR INGRESE EL (NOMBRE) DE LA ENTRADA QUE DESEA COMPRAR: ");
        System.out.println("-  VIP   || $15.000");
        System.out.println("- PLATEA || $12.000");
        System.out.println("- BALCON || $10.000");
        String ubicacion = scanner.nextLine().toUpperCase();
        double valorBase = 0;
        switch (ubicacion) {
            case "VIP":
                valorBase = valorVIP;
                break;
            case "PLATEA":
                valorBase = valorPlatea;
                break;
            case "BALCON":
                valorBase = valorBalcon;
                break;
            default:
                System.out.println("UBICACION INVALIDA, POR FAVOR INGRESE UNA OPCION VALIDA");
                System.out.println("-------------------------------------------------------");
                return;
        }

        System.out.println("POR FAVOR INGRESE SU EDAD: ");
        int edad = scanner.nextInt();
        double descuento;
        
        if(edad>=65){System.out.println("ERES ADULTO MAYOR, TIENES 15% DE DCTO.");descuento = 0.15;}                            
        else if (edad>9  && edad<26){System.out.println ("ERES ESTUDIANTE, TIENES 10% DE DCTO.");descuento=0.10;}
        else {System.out.println("LO SIENTO, NO TIENES DESCUENTOS ASOCIADOS");descuento=0;}
        System.out.println("--------------------------------------");
        double valorFinal = valorBase - (valorBase * descuento);

        // INGRESAR COMPRA DE ENTRADA
        ubicacionVendida.add(ubicacion);
        precioFinal.add(valorFinal);
        descuentosAplicados.add(descuento);
        contadorEntradas++;
     
        // GENERAR BOLETA DE COMPRA
        System.out.println("    BOLETA TEATRO MORO   ");
        System.out.println("----------------------------");
        System.out.println("UBICACION: " + ubicacion);
        System.out.println("PRECIO BASE: $"+ (int)valorBase);
        System.out.println("DESCUENTO APLICADO: %" +(int)(descuento*100));
        System.out.println("PRECIO FINAL: $"+ (int)valorFinal);
        System.out.println("----------------------------");
    }
    
    public static void mostrarResumen() {
        
        if (ubicacionVendida.isEmpty()) {
            System.out.println("NO SE PUEDE MOSTRAR RESUMEN, DEBE REALIZAR UNA COMPRA PRIMERO");
            System.out.println("-------------------------------------------------------------");
            return;}
        
            System.out.println("RESUMEN DE VENTAS DE ENTRADAS");
            System.out.println("TOTAL ENTRADAS VENDIDAS: " + contadorEntradas);
            System.out.println("-----------------------------");
        for (int i=0; i<ubicacionVendida.size(); i++) {
            System.out.println("VENTA N*: " + (i + 1));
            System.out.println("UBICACION: " + ubicacionVendida.get(i));
            System.out.println("DESCUENTO: %" + descuentosAplicados.get(i)*100);
            System.out.println("PRECIO FINAL: $"+ precioFinal.get(i));
            System.out.println("-----------------------------");
            }
            
    }
}

