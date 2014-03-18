JBoss EJB Remoto
======================

Este ejemplo muestra como conectarse a un ejb remotamente que esta desplegando en un Jboss 6.1 EAP 

Ejecutar el ejemplo
-------------------
		
Contruimos el EAR que conteiene el ejb remoto

        mvn clean package install	
		
Despues desplegamos el ear en nuestro JBoss 6.1 EAP

		cp ear/target/ejbremote-ear.ear JBOSS_HOME/standalone/deployments

Por ultimo ejecutamos el cliente:

		cd client
		mvn clean package exec:exec