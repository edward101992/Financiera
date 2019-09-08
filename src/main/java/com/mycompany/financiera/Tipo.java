/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financiera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author SuperUs
 */
public class Tipo implements Serializable{
    Scanner sc = new Scanner(System.in);
    private String descripcion;
    private String nomcaracteristico;
    private String codigoantecedente;
    private String codigotipo;
    private String estado;

    
    public String getEstado() {
        return estado;
    }

    public String getCodigotipo() {
        return codigotipo;
    }

    public void setCodigotipo(String codigotipo) {
        this.codigotipo = codigotipo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Tipo() {
    }
    
    public String getCodigoantecedente() {
        return codigoantecedente;
    }

    public void setCodigoantecedente(String codigoantecedente) {
        this.codigoantecedente = codigoantecedente;
    }

    public Tipo(String descripcion, String nomcaracteristico, String codigoantecedente) {
        this.descripcion = descripcion;
        this.nomcaracteristico = nomcaracteristico;
        this.nomcaracteristico = codigoantecedente;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNomcaracteristico() {
        return nomcaracteristico;
    }

    public void setNomcaracteristico(String nomcaracteristico) {
        this.nomcaracteristico = nomcaracteristico;
    }
    
    public void subMenu() throws IOException{
        ficheroleer();
        Principal princ = new Principal();
        String elije ="";
        System.out.println("1. Agregar Tipo Antecedente");
        System.out.println("2. Eliminar Tipo Antecedente");
        System.out.println("0. Atras");
        elije = sc.nextLine();
        switch(elije){
            case "1":
                menu();
                break;
            case "2":
                eliminarAntecedente();
                break;
            case "0":
                princ.menu();
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
    
    public void menu() throws IOException{  
      
        int contador= 0;
        boolean registrado = false;
        System.out.println("**********   Tipo Antecedentes   *********");
        System.out.println("Digite codigo Antecedente");
        codigoantecedente = sc.nextLine();
        System.out.println("Digite codigo Tipo Antecedente");
        codigotipo = sc.nextLine();
        System.out.println("Digite Descripcion Tipo antecedente: ");
        descripcion = sc.nextLine();
        System.out.println("Digite nombre Caracteristico Tipo antecedente: ");
        nomcaracteristico=sc.nextLine();
        System.out.println("Digite Estado P-N :");
        estado = sc.nextLine();
        for(int i=0;i<Principal.listatipo.size();i++){
            if(Principal.listatipo.get(i).get(1).equals(codigotipo)){
               registrado=true;
             }
        }
        if(registrado){
            System.out.println("El tipo de antecedente ya esta registrado");
            menu();
        }else{
            if((estado.equalsIgnoreCase("p"))||((estado.equalsIgnoreCase("n")))){
            contador = (Principal.listatipo.size());
            ficherovaciar();
            Principal.listatipo.add(new ArrayList<String>());
            Principal.listatipo.get(contador).add(codigoantecedente);
            Principal.listatipo.get(contador).add(codigotipo);
            Principal.listatipo.get(contador).add(descripcion);
            Principal.listatipo.get(contador).add(nomcaracteristico);
            Principal.listatipo.get(contador).add(estado);
            System.out.println("Tipo de Antecedente agregado");
            ficheroescribir();
            subMenu();     
            }else{
            System.out.println("Debe Ingresar estado Positivo o Negativo");   
            subMenu();      
            }
        }    
    }
      
    public  void ficheroleer() {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      int contador = 0;
      Principal.listatipo.clear();
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\Users\\SuperUs\\Documents\\NetBeansProjects\\Financiera\\src\\main\\resources\\Tipo.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
             Principal.listatipo.add(new ArrayList<String>());
             for(int i=0;i<5; i++){
                Principal.listatipo.get(contador).add(linea);
                linea=br.readLine();
             }
             contador++;
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
 
    public void eliminarAntecedente() throws IOException{
        boolean encontro = false;
        System.out.println("Digite codigo tipo de antecedente");
        codigotipo = sc.nextLine();
        ArrayList<String> listmod = new ArrayList<String>();
               for(int i=0;i<Principal.listatipo.size();i++){ 
                     if(Principal.listatipo.get(i).get(1).equals(codigotipo)){
                        ficherovaciar();
                        listmod.add(""); 
                        listmod.add(""); 
                        listmod.add("");
                        listmod.add("");
                        listmod.add("");
                        Principal.listatipo.set(i, listmod);
                        encontro= true;
                         System.out.println("Entro al forrrr");
                        ficheroescribir();
                     }       
                }
        if(!encontro){
            System.out.println("Tipo de antecedente no Registrado"); 
        }            
        subMenu();
    }
    
    public void ficheroescribir(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("C:\\Users\\SuperUs\\Documents\\NetBeansProjects\\Financiera\\src\\main\\resources\\Tipo.txt");
            pw = new PrintWriter(fichero);
            
            for(int i=0;i<Principal.listatipo.size();i++){
                pw.println(Principal.listatipo.get(i).get(0));
                pw.println(Principal.listatipo.get(i).get(1));
                pw.println(Principal.listatipo.get(i).get(2));
                pw.println(Principal.listatipo.get(i).get(3));
                pw.println(Principal.listatipo.get(i).get(4));
                pw.println("."); 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
    
    public void ficherovaciar(){
        File fichero = null;
        fichero = new File("C:\\Users\\SuperUs\\Documents\\NetBeansProjects\\Financiera\\src\\main\\resources\\Tipo.txt");
        fichero.delete();
        try
        {
            fichero.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
