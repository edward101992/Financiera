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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author SuperUs
 */
public class Antecedente implements Serializable{
    Scanner sc = new Scanner(System.in);
    private String codigo;
    private String fecha = "dd/MM/yyyy";
    private String descripcion;
    private String persona;

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

    
    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    
    public void menu() throws IOException{ 
        ficheroleer();
        Principal principal = new Principal();
        String elije="";
        System.out.println("**********   Antecedentes   *********");
        System.out.println("1. Agregar Antecedente");
        System.out.println("2. Eliminar Antecedente");
        System.out.println("3. ATRAS");
        elije = sc.nextLine();
        switch(elije){
            case "1":
                agregarAntecedente();
                break;
            case "2":
                //eliminarAntecedente();
                break;
            case "3":
                principal.menu();
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;
                
        }
    }
    public void agregarAntecedente() throws IOException{
        int contador = 0;
        boolean registrado = false;
        System.out.println("Digite Documento de Persona: ");
        persona = sc.nextLine();
        System.out.println("Digite codigo de Antecedente: ");
        codigo = sc.nextLine();
        System.out.println("Digite Fecha :");
        fecha=sc.nextLine();
        System.out.println("Digite Descripcion :");
        descripcion = sc.nextLine();
        for(int i=0;i<Principal.listaantecedente.size();i++){
            if(Principal.listaantecedente.get(i).get(1).equals(codigo)){
               registrado=true;
             }
        }
        if(registrado){
            System.out.println("Antecedente ya esta registrado");
            menu();
        }else{
            contador = (Principal.listaantecedente.size());
            ficherovaciar();
            Principal.listaantecedente.add(new ArrayList<String>());
            Principal.listaantecedente.get(contador).add(codigo);
            Principal.listaantecedente.get(contador).add(persona);
            Principal.listaantecedente.get(contador).add(fecha);
            Principal.listaantecedente.get(contador).add(descripcion);
            System.out.println("Antecedente Agregado a la persona: " + persona);
            ficheroescribir();
            menu();
        }         
    }   

    
   public  void ficheroleer() {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      int contador = 0;
      Principal.listaantecedente.clear();
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\Users\\SuperUs\\Documents\\NetBeansProjects\\Financiera\\src\\main\\resources\\Antecedente.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
             Principal.listaantecedente.add(new ArrayList<String>());
             for(int i=0;i<4; i++){
                Principal.listaantecedente.get(contador).add(linea);
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
            fichero = new FileWriter("C:\\Users\\SuperUs\\Documents\\NetBeansProjects\\Financiera\\src\\main\\resources\\Antecedente.txt");
            pw = new PrintWriter(fichero);
            
            for(int i=0;i<Principal.listaantecedente.size();i++){
                pw.println(Principal.listaantecedente.get(i).get(0));
                pw.println(Principal.listaantecedente.get(i).get(1));
                pw.println(Principal.listaantecedente.get(i).get(2));
                pw.println(Principal.listaantecedente.get(i).get(3)); 
           //     pw.println(Principal.listaantecedente.get(i).get(4));
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
        fichero = new File("C:\\Users\\SuperUs\\Documents\\NetBeansProjects\\Financiera\\src\\main\\resources\\Antecedente.txt");
        fichero.delete();
        try
        {
            fichero.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
