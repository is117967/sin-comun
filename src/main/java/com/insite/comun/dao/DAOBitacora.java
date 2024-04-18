package com.insite.comun.dao;

 
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.insite.comun.model.Bitacora;
 

 

@Repository( "daoBitacora")
public class DAOBitacora {
	
	private SimpleJdbcCall procBitacoraAlt;
	 
	

	@Autowired
    public void setDataSource(DataSource dataSource) {
                
        this.procBitacoraAlt = new SimpleJdbcCall(dataSource)
                .withProcedureName("bitacora_alt");   
       
    }
    
   
    
    public int  guardar(Bitacora bitacora) {
   	 
    	if(bitacora==null ){
    		return 0;
    	}
    	 
    	if(bitacora.getBitacoraId() <=0){
    		this.insertar(bitacora);
    	} 
    	
        return bitacora.getBitacoraId();
    }
    
    
  	  
     
   
  
  protected int  insertar(Bitacora bitacora) {
	   	 
	  	if( bitacora==null    ){
	  		return 0;
	  	}
	 	   	
	  	MapSqlParameterSource parameters = new MapSqlParameterSource();
	               	       
	      parameters.addValue("usuario_id_in", bitacora.getUsuarioId() );
	      parameters.addValue("aplicacion_id_in", bitacora.getAplicacionId() );
	      parameters.addValue("accion_id_in", bitacora.getAccionId() );
	      	      	       	      
	      Map<String,Object> out= procBitacoraAlt.execute(parameters);
	      
	      int bitacoraId=(int)out.get("bitacora_id_out");
	      bitacora.setBitacoraId(bitacoraId);
	      
	            
	      return bitacoraId;
	  }



public SimpleJdbcCall getProcBitacoraAlt() {
	return procBitacoraAlt;
}



public void setProcBitacoraAlt(SimpleJdbcCall procBitacoraAlt) {
	this.procBitacoraAlt = procBitacoraAlt;
}
	  
	  
	   


  
  
  
  
      

}
