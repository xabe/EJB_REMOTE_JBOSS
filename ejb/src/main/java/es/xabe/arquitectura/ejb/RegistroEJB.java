package es.xabe.arquitectura.ejb;

import java.util.List;

import es.xabe.arquitectura.model.Acta;

public interface RegistroEJB {
	
	 Acta getestado(String value);
	
	 List<Acta> getestados();
}
