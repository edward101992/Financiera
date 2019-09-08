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
       
        Principal princ = new Principal();
        String elije ="";
        System.out.println("1. Agregar Tipo Antecedente");
        System.out.println("2. Atras");
        elije = sc.nextLine();
        switch(elije){
            case "1":
                menu();
                break;
            case "2":
                princ.menu();
                break;
            default:
                System.out.println("Opcion invalida");
                break;
        }
    }
    
    public void menu() throws IOException{  
        ficheroleer();
        int contador= 0;
        System.out.println("**********   Tipo Antecedentes   *********");
        System.out.println("Digite codigo Antecedente");
        codigoantecedente = sc.nextLine();
        System.out.println("Digite Descripcion Tipo antecedente: ");
        descripcion = sc.nextLine();
        System.out.println("Digite nombre Caracteristico Tipo antecedente: ");
        nomcaracteristico=sc.nextLine();

        contador = (Principal.listatipo.size());
        ficherovaciar();
        Principal.listatipo.add(new ArrayList<String>());
        Principal.listatipo.get(contador).add(codigoantecedente);
        Principal.listatipo.get(contador).add(descripcion);
        Principal.listatipo.get(contador).add(nomcaracteristico);;
        System.out.println("Tipo de Antecedente agregado");
        ficheroescribir();
        subMenu();

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
             for(int i=0;i<3; i++){
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
