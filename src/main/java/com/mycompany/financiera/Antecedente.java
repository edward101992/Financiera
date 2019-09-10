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
 *  Clase Antecedente Ingreso de informacion
 * @author Edward Ramos
 * @author Victor Preciado
 */
public class Antecedente implements Serializable{
     /**
     * variable codigo guarda codigo de antecedente
     * variable fecha guarda la fecha del antecedente
     * variable descripcion guarda descriocion del antecedente
     * variable persona guarda antecedentes
     */
    Scanner sc = new Scanner(System.in);
    private String codigo;
    private String fecha = "dd/MM/yyyy";
    private String descripcion;
    private String persona;
    private boolean repite;

    public boolean isRepite() {
        return repite;
    }

    public void setRepite(boolean repite) {
        this.repite = repite;
    }
    
     /**
     * get variable sc
     * @return sc
     */
    public Scanner getSc() {
        return sc;
    }
     /**
     * set variable sc
     * @param sc 
     */
    public void setSc(Scanner sc) {
        this.sc = sc;
    }
     /**
     * get variable codigo
     * @return codigo
     */
    public String getCodigo() {
        return codigo;
    }
     /**
     * set variable codigo
     * @param codigo 
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
     /**
     * get variable fecha
     * @return fecha
     */
    public String getFecha() {
        return fecha;
    }
     /**
     * set variable fecha
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
      /**
     * get variable descripcion
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }
     /**
    * set variable descripcion
    * @param descripcion 
    */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     /**
      * get variable persona
      * @return persona
      */
    
    public String getPersona() {
        return persona;
    }
     /**
     * set variable persona
     * @param persona 
     */
    public void setPersona(String persona) {
        this.persona = persona;
    }

     /**
     * Metodo menu da la opcion de agregar antecedente 
     * también vuelve a menu principal
     */
    public void menu() throws IOException{ 
        ficheroleer();
        Principal principal = new Principal();
        String elije="";
        System.out.println("**********   Antecedentes   *********");
        System.out.println("1. Agregar Antecedente");
        System.out.println("0. ATRAS");
        elije = sc.nextLine();
        switch(elije){
            case "1":
                agregarAntecedente();
                break;
            case "0":
                principal.menu();
                break;
            default:
                System.out.println("Opcion incorrecta");
                break;              
        }
    }
     /**
     * Metodo agregarAntecedente en el cual el usuario digita los datos
     * y compruba el registro
     */
    public void agregarAntecedente() throws IOException{
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
            if(Principal.listaantecedente.get(i).get(0).equals(codigo)){
               registrado=true;
             }
        }
        if(registrado){
            System.out.println("Antecedente ya esta registrado");
            menu();
        }else{
            verificarPersona();
        }         
    }   
      /**
     * Metodo agregarDatos en este metodo el antecedente
     * es agregado a la persona
     */
      
    public void verificarPersona() throws IOException{
        boolean registrado=false;
        for (int i=0;i<Principal.listapersona.size();i++) {
            if (Principal.listapersona.get(i).get(1).equals(persona)) {
                registrado = true;
            }
        }
        if(registrado){
            agregarDatos();
        }else{
             System.out.println("Usuario No registrado");
             menu();
        }
    }
       
    public void agregarDatos() throws IOException{
            int contador =0;
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
       /**
     * Metodo ficheroleer en el cual se crea el archivo
     * En el finally cerramos el fichero, para asegurarnos
     * que se cierra tanto si todo va bien como si salta 
     * una excepcion.
     * es agregado a la persona
     */
   public  void ficheroleer() {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      int contador = 0;
      Principal.listaantecedente.clear();
      try {
       
         archivo = new File ("Antecedente.txt");
         if(!archivo.exists()){
               archivo.createNewFile();
         }
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

      
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
            fichero = new FileWriter("Antecedente.txt");
            pw = new PrintWriter(fichero);
            
            for(int i=0;i<Principal.listaantecedente.size();i++){
                pw.println(Principal.listaantecedente.get(i).get(0));
                pw.println(Principal.listaantecedente.get(i).get(1));
                pw.println(Principal.listaantecedente.get(i).get(2));
                pw.println(Principal.listaantecedente.get(i).get(3)); 
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
     * Metodo ficherovaciar en este metodo el fichero 
     *quedara vacio y se creara un nuevo archivo
     */
    public void ficherovaciar(){
        File fichero = null;
        fichero = new File("Antecedente.txt");
        fichero.delete();
        try
        {
            fichero.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
}
