package org.agenda.tsi.persistencia;

import org.agenda.exception.EmailNotFilledException;
import org.agenda.tsi.model.Agenda;

public interface IPersistencia {

	
	public void adicionarItem(Agenda a) throws EmailNotFilledException;
	
	public Agenda localizarItem(String email);
	
	public void removerItem(Agenda a);
	
	public void atualizarItem(Agenda a);
	
}
