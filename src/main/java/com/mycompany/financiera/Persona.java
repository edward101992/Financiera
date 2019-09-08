/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financiera;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SuperUs
 */
public class Persona implements Serializable{
    Scanner sc = new Scanner(System.in);
    private String nombre;
    private String cedula;
    private String edad;
    private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * get variable nombre
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * set variable nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * get varibale cedula
     * @return cedula
     */
    public String getCedula() {
        return cedula;
    }
    /**
     * set variable cedula
     * @param cedula 
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    /**
     * get variable edad
     * @return edad
     */
    public String getEdad() {
        return edad;
    }
    /**
     * set variable edad
     * @param edad 
     */
    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Persona(String nombre, String cedula, String edad, String genero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.genero = genero;
    }

    public Persona() {
    }
    
     public void menu(){
        String elije="";
        System.out.println("**********   Persona   *********");
        System.out.println("1. Registrar Persona");
        System.out.println("2. Editar Persona");
        System.out.println("3. Ver reporte de persona");
        elije=sc.nextLine();
           switch(elije){
            case "1":
                registrarPersona();
                break;
            case "2":
                editarPersona();
                break;
            case "3":
                verAntecedente();
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
    }
     
    public void registrarPersona(){
        int contador = 0;
        System.out.println("Registrar Personas");
        System.out.println("Digite nombre: ");
        nombre = sc.nextLine();
        System.out.println("Digite cedula: ");
        cedula= sc.nextLine();             
        System.out.println("Digite edad: ");
        edad = sc.nextLine();
        System.out.println("Digite Genero");
        genero = sc.nextLine();
        Principal.listapersona.add(new ArrayList<String>());
        contador = (Principal.listapersona.size());
        Principal.listapersona.get(contador).add(nombre);
        Principal.listapersona.get(contador).add(cedula);
        Principal.listapersona.get(contador).add(edad);
        Principal.listapersona.get(contador).add(genero);
    }
    
    public void editarPersona(){
        System.out.println("Digite Documento");
        cedula = sc.nextLine();
    }
    
    public void verAntecedente(){
        System.out.println("Digite Documento para ver antecedentes");
        sc.nextLine();      
    }
     
}
