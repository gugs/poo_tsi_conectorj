package org.agenda.tsi.app;

import org.agenda.tsi.model.Agenda;
import org.agenda.tsi.persistencia.AgendaDAO;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		AgendaDAO.getInstance().adicionarItem(new Agenda(0, "Maria", "m@m", "81999999"));
	}

}
