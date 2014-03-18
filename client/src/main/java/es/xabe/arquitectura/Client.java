package es.xabe.arquitectura;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import es.xabe.arquitectura.ejb.RegistroEJB;
import es.xabe.arquitectura.model.Acta;

public class Client {
	private static Context context;

	public static void main(String args[]) throws Exception {
		try {
			RegistroEJB registroEJB = lookupRemoteStateless();
			System.out.println("EJB "+registroEJB.getestado("juan").getNombre());

			for (Acta acta : registroEJB.getestados()) {
				System.out.println(acta.getNombre());
			}
			context.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static RegistroEJB lookupRemoteStateless() throws NamingException {
		final Hashtable<String, Object> jndiProperties = new Hashtable<>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447");
		jndiProperties.put("org.jboss.ejb.client.scoped.context", true); 
		jndiProperties.put("jboss.naming.client.ejb.context", true);
		context = new InitialContext(jndiProperties);
		RegistroEJB ejb = (RegistroEJB) context.lookup("ejbremote-ear/ejbremote-ejb/RegistroEJBImpl!es.xabe.arquitectura.ejb.RegistroEJB");
		return ejb;
	}
}
