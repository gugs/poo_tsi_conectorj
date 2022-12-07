package org.agenda.tsi.app;

import javax.swing.SwingUtilities;

import org.agenda.tsi.gui.TelaAgenda;
import org.agenda.tsi.model.Agenda;
import org.agenda.tsi.persistencia.AgendaDAO;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				TelaAgenda t = new TelaAgenda();
				t.setVisible(true);
			}
		});
		
		
		//AgendaDAO.getInstance().adicionarItem(new Agenda(0, "Maria", "m@m", "81999999"));
	}

}
