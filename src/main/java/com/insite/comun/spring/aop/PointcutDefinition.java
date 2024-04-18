package com.insite.comun.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class PointcutDefinition {


/*
  @Pointcut("execution(* com.insite.*.dao.FooDao.*(..))")

  public void insert() {

  }*/
  
  
  @Before(value = "execution(* com.insite.*.dao.DAO*.actualizar*(..)) && "
  + "args(usuarioId,..)")

  public void beforeTransMethodExecution(JoinPoint jp, int usuarioId  ) {


	  System.out.println("Before method: " + jp.getSignature().getName()

			    + ". Class: " + jp.getTarget().getClass().getSimpleName());
	  System.out.println("userId :"+  usuarioId);

  }

  /*
  @Before(value = "execution(* com.insite.sin.dao.DAOEmpleado.actualizarEmpleado(..))")

  public void beforeTransMethodExecution2(JoinPoint jp  ) {


	  System.out.println("Before method: " + jp.getSignature().getName()

			    + ". Class: " + jp.getTarget().getClass().getSimpleName());
	 // System.out.println("userId :"+  usuarioId);

  } */
  
  
   
  
 // @Before(value = "execution(* com.insite.sin.dao.DAOEmpleado.guardarEmpleado(..))")
  //@Before(value = "execution(* com.insite.sin.service.SREmpleado.guardarEmpleado(..))")
  @Before(value = "execution(* com.insite.sin.dao.DAO*.guardar*(..))")  //funciona ok
  public void beforeTransMethodExecution2(JoinPoint jp /*, int usuarioId */ ) {


	  System.out.println("Before method: " + jp.getSignature().getName()

			    + ". Class: " + jp.getTarget().getClass().getSimpleName());
	 // System.out.println("userId :"+  usuarioId);

  }
  
  
  
 

}

 
