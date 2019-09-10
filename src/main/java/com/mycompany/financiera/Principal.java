/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financiera;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

 /**
 *  Clase principal donde esta el menú de opciones y los arrayList de la información de cada persona
 * @author Edward Ramos
 * @author Victor Preciado
 */
public class Principal {
    Persona persona = new Persona();
    Antecedente antecedente = new Antecedente();
    Tipo tipo = new Tipo();
    Scanner sc = new Scanner(System.in);
    public static ArrayList<ArrayList<String>> listapersona= new ArrayList();
    public static ArrayList<ArrayList<String>> listaantecedente = new ArrayList();
    public static ArrayList<ArrayList<String>> listatipo = new ArrayList();
 /**
     * metodo menú en el cual se elige las personas
     * se pueden ver los antecedentes
     * y el tipo de antecedente
     */
    public void menu() throws IOException{ 
        String elije ="";
        Persona persona = new Persona();
        Antecedente antecedente = new Antecedente();
        Tipo tipo = new Tipo();
        persona.ficheroleer();
        antecedente.ficheroleer();
        tipo.ficheroleer();
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
                tipo.subMenu();
            default:
                System.out.println("Opcion Incorrecta");
                break;
            }
    }     
}
