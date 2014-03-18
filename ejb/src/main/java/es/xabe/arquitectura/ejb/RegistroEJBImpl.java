package es.xabe.arquitectura.ejb;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

import es.xabe.arquitectura.model.Acta;
import es.xabe.arquitectura.service.RegistroService;

@Stateless(mappedName = "registroEJB")
@Remote(RegistroEJB.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class RegistroEJBImpl implements RegistroEJB {
	
	@Autowired
	private RegistroService registroService;

	@Override
	public Acta getestado(String value) {
		Acta acta = new Acta();
		acta.setNombre(value);
		return acta;
	}
	
	
	@Override
	public List<Acta> getestados() {
		return registroService.getActas();
	}
	
	
}
