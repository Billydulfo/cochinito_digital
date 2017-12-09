/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jhon Nash
 */
public class AdminBD {
    private Connection conexion;
    private ResultSet resultados;//objeto que almacena una tabla o lista de una conculta de una base de  datos
    //recibe una o varial filas de una tabla 
    private String controladorBD;
    private String host;
    private String puerto;
    private String baseDatos;
    private String url;
    private String usuario;
    private String contraseña;
    private Alcancia alcancia;
    private Propietario propietario;
   
        
        
        
    public AdminBD(){
	  controladorBD= "org.postgresql.Driver";
	  host= "127.0.0.1";
	  puerto = "5432";
	  baseDatos="test";
	  url ="jdbc:postgresql://"+host+":"+puerto+"/"+baseDatos;
	  usuario="postgres";
	  contraseña="p057gr35";
	  resultados=null;
	  conexion =null;
	}
        
    public String conectate(){
        	String mensaje=null;
       		try{
    	  		 Class.forName(controladorBD); 
       
       		}catch(ClassNotFoundException cnfe){
       			mensaje="No se hallo el controlador de PostgreSQL";
       		}
       		try{
 	      		conexion=DriverManager.getConnection(url,usuario,contraseña);
       		}catch(SQLException sqe){
    	   		mensaje ="conexion Fallo"; 
     		}
      		return mensaje;
   	}
        
    public Alcancia consultaAlcancia(){
        String mensaje=null;
        Statement proposicion = null;
        ResultSet rs= null;
        alcancia = new Alcancia();
        propietario = new Propietario();
                        
        String ordenSQL=null;
                		
        mensaje = conectate();
        if(conexion != null){
            try {
                proposicion = conexion.createStatement();
                ordenSQL="SELECT * FROM alcancia";
                rs = proposicion.executeQuery(ordenSQL);
														
                while ( rs.next() ) {
                    //alcancia.setPropietario(rs.getString(""));
                    propietario.setNombre(rs.getString("propietario"));
                    alcancia.setFecha(rs.getString("fecha"));
                    alcancia.setNumCetavo(Integer.parseInt(rs.getString("centavos")));
                    alcancia.setNumPeso(Integer.parseInt(rs.getString("peso")));
                    alcancia.setNumDosPeos(Integer.parseInt(rs.getString("dos_pesos")));
                    alcancia.setNumCincoPesos(Integer.parseInt(rs.getString("cinco_pesos")));
                    alcancia.setNumDiezPesos(Integer.parseInt(rs.getString("diez_pesos")));
                     
		}
		rs.close();
		proposicion.close();
            }catch(SQLException sqle){
            //mensaje="fallo consulta";
            alcancia = null;
            sqle.printStackTrace();
            }finally{//para desconectarme
                try{
                    conexion.close();
                    }catch(SQLException sqle){
                        //mensaje="falla conexion";	
                        alcancia = null;
                    }
            } 
			 
        }else{
            alcancia = null;
        }
        alcancia.setPropietario(propietario);
        return alcancia;
    }   
 public String insertaAlcancia(Alcancia alcancia){
        String mensaje=null;
        String ordenSQL=null;
        Statement proposicion=null;
        String valores = null;
        //variables de alcancia
        int centavos= 0;
        int peso = 0;
        int dosPesos=0;
        int cincoPesos=0;
        int diezPesos=0;
        String fecha= null;
        String nombre= null;
        
        //buscamos guardar info de alcancia en la base de datos
        this.alcancia =alcancia;
        this.propietario = alcancia.getPropietario();
        centavos=alcancia.getNumCetavo();
        peso = alcancia.getNumPeso();
        dosPesos = alcancia.getNumDosPeos();
        cincoPesos = alcancia.getNumCincoPesos();
        diezPesos = alcancia.getNumDiezPesos();
        nombre = propietario.getNombre();
        fecha = alcancia.getFecha();
                                        ;
	mensaje = conectate();
	if(conexion != null){
            try{
                proposicion = conexion.createStatement();//sirve para conectarse
                        //sabe ir a la base de datos y ejecuta lo que le pidamos
                valores= "'"+nombre+"','"+fecha+"','"
                        +centavos+"','"+peso+"','"+dosPesos
                        +"','"+cincoPesos+"','"+diezPesos+"'";
                ordenSQL="INSERT INTO alcancias VALUES("+valores+") ";
                System.out.println(ordenSQL);
                proposicion.executeUpdate(ordenSQL);//para modificar la base
                            //de datos por eso no se necesita un result set
                proposicion.close();
            }catch(SQLException sqle){
                mensaje="fallo actualizacion";
                sqle.printStackTrace();
            }finally{
                try{
                    conexion.close();
                }catch(SQLException sqle){
                    mensaje="falla conexcion";
                }
            }
        }else{
            mensaje="fallo conexion";
	}
            return mensaje;
    }
 
 public String actualizaAlcancia(Alcancia alcancia){
        String mensaje=null;
        String ordenSQL=null;
        Statement proposicion=null;
        String valores = null;
        //variables de alcancia
        int centavos= 0;
        int peso = 0;
        int dosPesos=0;
        int cincoPesos=0;
        int diezPesos=0;
        String fecha= null;
        String nombre= null;
        
        //buscamos guardar info de alcancia en la base de datos
        this.alcancia =alcancia;
        this.propietario = alcancia.getPropietario();
        centavos=alcancia.getNumCetavo();
        peso = alcancia.getNumPeso();
        dosPesos = alcancia.getNumDosPeos();
        cincoPesos = alcancia.getNumCincoPesos();
        diezPesos = alcancia.getNumDiezPesos();
        nombre = propietario.getNombre();
        fecha = alcancia.getFecha();
                                        ;
	mensaje = conectate();
	if(conexion != null){
            try{
                proposicion = conexion.createStatement();//sirve para conectarse
                        //sabe ir a la base de datos y ejecuta lo que le pidamos
                ordenSQL="UPDATE alcancias SET centavos ='"+centavos+"',peso='"+peso+"',dos_pesos='"+dosPesos+"',cinco_pesos='"+cincoPesos+"',diez_pesos='"+diezPesos+"' WHERE propietario='"+nombre+"'";
                System.out.println(ordenSQL);
                proposicion.executeUpdate(ordenSQL);//para modificar la base
                            //de datos por eso no se necesita un result set
                proposicion.close();
            }catch(SQLException sqle){
                mensaje="fallo actualizacion";
                sqle.printStackTrace();
            }finally{
                try{
                    conexion.close();
                }catch(SQLException sqle){
                    mensaje="falla conexcion";
                }
            }
        }else{
            mensaje="fallo conexion";
	}
            return mensaje;
    }
 
}