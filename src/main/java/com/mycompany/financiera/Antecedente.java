/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financiera;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author SuperUs
 */
public class Antecedente {
    Scanner sc = new Scanner(System.in);
    private String codigo;
    private String fecha = "dd/MM/yyyy";
    private String descripcion;
    private String estado;

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    public void menu(){       
        String elije="";
        System.out.println("**********   Antecedentes   *********");
        System.out.println("1. Agregar Antecedente");
        System.out.println("2. Eliminar Antecedente");
        elije = sc.nextLine();
        switch(elije){
            case "1":
                agregarAntecedente();
                break;
            case "2":
                eliminarAntecedente();
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
                
        }
    }
    public void agregarAntecedente(){
        System.out.println("Digite Documento de Persona: ");
        System.out.println("Digite codigo de Antecedente: ");
        codigo = sc.nextLine();
        System.out.println("Digite Fecha :");
        fecha=sc.nextLine();
        System.out.println("Digite Descripcion :");
        descripcion = sc.nextLine();
        System.out.println("Digite Estado P-N :");
        estado = sc.nextLine();
        if(!(estado.equalsIgnoreCase("s"))||(!(estado.equalsIgnoreCase("n")))){
            System.out.println("Debe Ingresar estado Positivo o Negativo");   
            menu();
        }
        
    }   
    public void eliminarAntecedente(){
        System.out.println("Digite Documento de Persona: ");
        System.out.println("Digite codigo de Antecedente: ");
        codigo = sc.nextLine();
    
    }
    
}
