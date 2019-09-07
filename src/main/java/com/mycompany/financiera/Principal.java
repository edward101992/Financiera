/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financiera;
import java.util.Scanner;

/**
 *
 * @author SuperUs
 */
public class Principal {
    Scanner sc = new Scanner(System.in);
    Persona persona = new Persona();
    Antecedente antecedente = new Antecedente();
    Tipo tipo = new Tipo();
    
    public void menu(){ 
        String elije ="";
        System.out.println("1. Persona");
        System.out.println("2. Antecedentes");
        System.out.println("3. Tipo de Antecedentes");
        elije = sc.nextLine();           
        switch (elije) {        
            case "1":
                persona.menu();
                break;
            case "2":
                antecedente.menu();
                break;
            case "3":
                antecedente.agregarAntecedente();
            default:
                System.out.println("Opcion Incorrecta");
                break;
            }
    }  
}
