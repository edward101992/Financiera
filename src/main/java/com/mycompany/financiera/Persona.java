/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.financiera;
import java.io.BufferedReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;

/**
 *  Clase Persona esta clase implemta la clase interface
 *  y estan los datos de la persona
 * @author Edward Ramos
 * @author Victor Preciado
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
     /**
     * Metodo menu en este metodo se puede 
     * registrar la persona, editar 
     * y ver la información
     */
     public void menu() throws IOException{
    //    Antecedente antecedente = new Antecedente();
    //    Tipo tipo = new Tipo();
    //    antecedente.ficheroleer();
    //    tipo.ficheroleer();
        ficheroleer();
        Principal principal = new Principal();
        String elije="";
        System.out.println("**********   Persona   *********");
        System.out.println("1. Registrar Persona");
        System.out.println("2. Editar Persona");
        System.out.println("3. Reporte de Personas");
        System.out.println("4. Reporte por Persona");
        System.out.println("0. ATRAS");
        elije=sc.nextLine();     
           switch(elije){
            case "1":
                registrarPersona();
                break;
            case "2":
                editarPersona();
                break;
            case "3":
                listaPersona();
                break;
            case "4":
                reportePersona();
                break;
             case "0":
                principal.menu();
                break;
            default:
                System.out.println("Opcion Invalida");
                break;
        }
    }  
      /**
     * Metodo registrarPersona pide los datos de la persona
     */
    public void registrarPersona() throws IOException{
        int contador = 0; 
        boolean registrado = false;
        System.out.println("Registrar Personas");
        System.out.println("Digite nombre: ");
        nombre = sc.nextLine();
        System.out.println("Digite cedula: ");
        cedula= sc.nextLine();             
        System.out.println("Digite edad: ");
        edad = sc.nextLine();
        System.out.println("Digite Genero");
        genero = sc.nextLine();
        for(int i=0;i<Principal.listapersona.size();i++){
            if(Principal.listapersona.get(i).get(1).equals(cedula)){
               registrado=true;
             }
        }
        if(registrado){
            System.out.println("El usuario ya esta registrado");
            menu();
        }else{
            contador = (Principal.listapersona.size());
            ficherovaciar();
            Principal.listapersona.add(new ArrayList<String>());
            Principal.listapersona.get(contador).add(nombre);
            Principal.listapersona.get(contador).add(cedula);
            Principal.listapersona.get(contador).add(edad);
            Principal.listapersona.get(contador).add(genero);
            System.out.println("Usuario Agregado"); 
            ficheroescribir();
            menu();
        }
    }
     /**
     * Metodo editarPersona pide los datos sirve para 
     * cambiar los datos de la persona
     */
    public void editarPersona() throws IOException{
        boolean encontro = false;
        System.out.println("Digite Documento");
        cedula = sc.nextLine();
        ArrayList<String> listmod = new ArrayList<String>();
               for(int i=0;i<Principal.listapersona.size();i++){                
                     if(Principal.listapersona.get(i).get(1).equals(cedula)){
                        ficherovaciar();
                        System.out.println("Digite Nuevo Nombre");
                        nombre = sc.nextLine();
                        System.out.println("Digite Nueva Edad");
                        edad = sc.nextLine();
                        System.out.println("Digite Nuevo Genero");
                        genero = sc.nextLine();
                        listmod.add(nombre); 
                        listmod.add(Principal.listapersona.get(i).get(1));
                        listmod.add(edad);
                        listmod.add(genero);
                        Principal.listapersona.set(i, listmod);
                        encontro= true;
                        ficheroescribir();
                     }       
                }
        if(!encontro)
            System.out.println("Usuario no Registrado");        
        menu();
    }
      /**
     * Metodo listaPersona muestra los datos de la persona
     * registrados y modificados
     */
    
    public void reportePersona() throws IOException{
        System.out.println("Digite cedula de la persona: ");
        cedula = sc.nextLine();
        for(int i =0;i<Principal.listapersona.size();i++){
            if(Principal.listapersona.get(i).get(1).equals(cedula)){
                System.out.println("Nombre: " + Principal.listapersona.get(i).get(0));
                System.out.println("Cedula : " + Principal.listapersona.get(i).get(1));
                System.out.println("Edad : " + Principal.listapersona.get(i).get(2));
                System.out.println("Genero : " + Principal.listapersona.get(i).get(3)); 
                for(int j=0;j<Principal.listaantecedente.size();j++){
                if((Principal.listaantecedente.get(j).get(1).equals(Principal.listapersona.get(i).get(1)))){
                    System.out.println("****** Antecedente  " + (j+1) + "  Registrado");
                    System.out.println("Codigo Antecedente: " + Principal.listaantecedente.get(j).get(0)+ "  Fecha : " + Principal.listaantecedente.get(j).get(2) + "  Descripcion : " + Principal.listaantecedente.get(j).get(3));                    
                           for(int k=0;k<Principal.listatipo.size();k++){
                                if(Principal.listatipo.get(k).get(0).equals(Principal.listaantecedente.get(j).get(0))){
                                    System.out.println("*** Tipo Antecedente " + (k+1) + "  Registraddo");
                                    System.out.println("Codigo tipo Descripcion:  "+ Principal.listatipo.get(k).get(1) + "  Descripcion :" + Principal.listatipo.get(k).get(2) + "  Nombre Caracteristico :" + Principal.listatipo.get(k).get(3) + "  Estado : " + Principal.listatipo.get(k).get(4));
                                }
                            }
                     }
                }
            }
        }
        menu();
    }
    
    public void listaPersona() throws IOException{
        for(int i=0;i<Principal.listapersona.size();i++){
            System.out.println("Persona Numero  " + (i+1) + "  Registrada");
            System.out.println("Nombre : " + Principal.listapersona.get(i).get(0));
            System.out.println("Cedula : " + Principal.listapersona.get(i).get(1));
            System.out.println("Edad : " + Principal.listapersona.get(i).get(2));
            System.out.println("Genero : " + Principal.listapersona.get(i).get(3));        
            for(int j=0;j<Principal.listaantecedente.size();j++){
                if((Principal.listaantecedente.get(j).get(1).equals(Principal.listapersona.get(i).get(1)))){
                    System.out.println("****** Antecedente  " + (j+1) + "  Registrado");
                    System.out.println("Codigo Antecedente: " + Principal.listaantecedente.get(j).get(0)+ "  Fecha : " + Principal.listaantecedente.get(j).get(2) + "  Descripcion : " + Principal.listaantecedente.get(j).get(3));                    
                           for(int k=0;k<Principal.listatipo.size();k++){
                                if(Principal.listatipo.get(k).get(0).equals(Principal.listaantecedente.get(j).get(0))){
                                    System.out.println("*** Tipo Antecedente " + (k+1) + "  Registraddo");
                                    System.out.println("Codigo tipo Descripcion:  "+ Principal.listatipo.get(k).get(1) + "  Descripcion :" + Principal.listatipo.get(k).get(2) + "  Nombre Caracteristico :" + Principal.listatipo.get(k).get(3) + "  Estado : " + Principal.listatipo.get(k).get(4));
                                }
                            }
                }
            }
        }        
         menu();
    }   
      /**
     * Metodo ficheroleer abre el fichero y creacion de 
     * BufferedReader para poder
     * hacer una lectura comoda (disponer del metodo readLine()).
     */
    public  void ficheroleer() {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      int contador = 0;
      Principal.listapersona.clear();
      try {
         archivo = new File ("Persona.txt");
         if(!archivo.exists()){
               archivo.createNewFile();
           }
         
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
             Principal.listapersona.add(new ArrayList<String>());
             for(int i=0;i<4; i++){
                Principal.listapersona.get(contador).add(linea);
                linea=br.readLine();
             }
             contador++;
         }
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally se cierra el fichero
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
       /**
     * Metodo ficheroescribir vuelve a escribir los datos
     * en el fichero 
     */
    public void ficheroescribir(){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Persona.txt");
            pw = new PrintWriter(fichero);
            
            for(int i=0;i<Principal.listapersona.size();i++){
                pw.println(Principal.listapersona.get(i).get(0));
                pw.println(Principal.listapersona.get(i).get(1));
                pw.println(Principal.listapersona.get(i).get(2));
                pw.println(Principal.listapersona.get(i).get(3));  
                pw.println("."); 
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
          
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
        /**
     * Metodo ficherovaciar deja el fichero en blanco
     * elimina los datos
     */
    public void ficherovaciar(){
        File fichero = null;
        fichero = new File("Persona.txt");
        fichero.delete();
        try
        {
            fichero.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
}
