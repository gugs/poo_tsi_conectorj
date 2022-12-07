package org.agenda.tsi.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.agenda.exception.EmailNotFilledException;
import org.agenda.tsi.model.Agenda;
import org.agenda.tsi.persistencia.AgendaDAO;

public class TelaAgenda extends JFrame{

	private JMenuBar barraMenu;
	private JMenu menuAgenda;
	private JMenu menuSobre;
	private JMenuItem mItemNovo;
	private JMenuItem mItemSair;
	
	private JPanel panelForm;
	private JLabel lbNome;
	private JLabel lbEmail;
	private JLabel lbTelefone;
	
	private JTextField txfNome;
	private JTextField txfEmail;
	private JTextField txfTelefone;
	
	private JPanel panelBotoes;
	private JButton btnSalvar;
	private JButton btnFechar;
	
	public TelaAgenda() 
	{
		setTitle("Minha Agenda");
		setSize(340, 240);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		criarMenu();
		criarFormulario();
		carregarBotoes();
		
	}
	
	private void criarMenu() {
		barraMenu = new JMenuBar();
		menuAgenda = new JMenu("Agenda");
		menuSobre = new JMenu("Sobre");
		mItemNovo = new JMenuItem("Novo");
		mItemSair = new JMenuItem("Sair");
		
		barraMenu.add(menuAgenda);
		barraMenu.add(menuSobre);
		
		menuAgenda.add(mItemNovo);
		menuAgenda.add(mItemSair);
		
		getContentPane().add(barraMenu, BorderLayout.NORTH);
	}
	
	private void criarFormulario() {
		panelForm = new JPanel();
		lbNome = new JLabel("Nome: ");
		lbEmail = new JLabel("Email: ");
		lbTelefone = new JLabel("Telefone: ");
		
		txfNome = new JTextField(24);
		txfEmail = new JTextField(24);
		txfTelefone = new JTextField(15);
		
		panelForm.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		panelForm.add(lbNome);
		panelForm.add(txfNome);
		
		panelForm.add(lbEmail);
		panelForm.add(txfEmail);
		
		panelForm.add(lbTelefone);
		panelForm.add(txfTelefone);
		
		getContentPane().add(panelForm, BorderLayout.CENTER);
	}
	
	private void carregarBotoes() {
		panelBotoes = new JPanel();
		
		panelBotoes.setLayout(
				new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new SalvarAction());
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new FecharAction());
		
		panelBotoes.add(btnSalvar);
		panelBotoes.add(btnFechar);
		
		getContentPane().add(panelBotoes, 
				BorderLayout.SOUTH);
	}
	
	public void apagarCampos() {
		txfNome.setText("");
		txfEmail.setText("");
		txfTelefone.setText("");
	}
	
	private class SalvarAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			try {
				AgendaDAO.getInstance().adicionarItem(new Agenda(0, txfNome.getText(), txfEmail.getText(), txfTelefone.getText()));
				JOptionPane.showMessageDialog(null, "item inserido com sucesso");
				apagarCampos();
				
			} catch (EmailNotFilledException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
		}
		
	}
	
	private class FecharAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		
	}
}
