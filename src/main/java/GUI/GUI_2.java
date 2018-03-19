package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUI_2 {

	private JFrame principal;
	private String nomeProblema;

	public void criar_GUI() {
		principal = new JFrame(nomeProblema);
		principal.setLayout(new BorderLayout());
		principal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		helpMenu();
		painel_Sup();
	}

	public void helpMenu() {
		JMenuBar duvidas = new JMenuBar();
		duvidas.add(Box.createHorizontalGlue());

		JMenu help = new JMenu("Help");

		// help.getAccessibleContext().setAccessibleDescription("Ola");
		duvidas.add(help);

		JMenuItem faq = new JMenuItem("FAQ");
		help.add(faq);

		faq.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame FAQ = new JFrame("FAQ");
				FAQ.setVisible(true);
				FAQ.setSize(400, 500);

				JPanel questions = new JPanel();
				questions.setLayout(new GridLayout(10, 1));

				for (int i = 1; i <= 10; i++) {
					JLabel pergunta = new JLabel("Questão " + i);
					JLabel resposta = new JLabel("Resposta " + i);
					questions.add(pergunta);
					questions.add(resposta);
				}

				FAQ.add(questions);
			}
		});

		JMenuItem email = new JMenuItem("Send an e-mail");
		help.add(email);

		email.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame send = new JFrame("Send email");
				send.setVisible(true);
				send.setSize(600, 400);

				JPanel emails = new JPanel();
				emails.setLayout(new BorderLayout());
				send.add(emails);

				JPanel topo = new JPanel(new GridLayout(1, 2));
				JLabel label = new JLabel("Email");
				final JTextField mail_space = new JTextField();
				topo.add(label);
				topo.add(mail_space);
				emails.add(topo, BorderLayout.NORTH);

				JPanel center = new JPanel(new GridLayout(1, 2));
				final JTextArea write_Description = new JTextArea();
				write_Description.setLineWrap(true);
				JLabel description = new JLabel("Description");
				center.add(description);
				center.add(write_Description);
				emails.add(center, BorderLayout.CENTER);

				JButton sendButton = new JButton("Send");
				emails.add(sendButton, BorderLayout.SOUTH);

				sendButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						System.out.println("Email com sucesso");
						SenderMail sendMail = new SenderMail(mail_space.getText(), write_Description.getText());
						sendMail.sendNow();

					}
				});
			}
		});

		principal.add(duvidas, BorderLayout.NORTH);
	}
	
	public void painel_Sup() {
		JPanel superior_Panel = new JPanel(new GridLayout(2, 2));
		String[] algoritmos = { "AbYSS", "CellDE", "dMPOSO", "GDE3", "FastPGA", "IBEA", "MOCHC", "MOCell", "MOEA/D-DE", "pMOEA/D-DE", 
				"MOEA/D-DRA", "NSGA-II", "ssNSGA-II", "NSGAIIr", "pNSGA-II", "OMOPSO", "PAES", "SMPSO", "pSMPSO", "SMPSOhv", 
				"SPEA2"};

		JLabel name_Problem = new JLabel("Problem");
		JLabel description_Problem = new JLabel("Problem Description");
		JComboBox problems_List = new JComboBox(algoritmos);
		JTextArea description_Text = new JTextArea();
		description_Text.setLineWrap(true);
		
		superior_Panel.add(name_Problem);
		superior_Panel.add(problems_List);
		superior_Panel.add(description_Problem);
		superior_Panel.add(description_Text);
		principal.add(superior_Panel, BorderLayout.CENTER);
	}

	public void open() {
		principal.setVisible(true);
		principal.pack();
	}

	public static void main(String[] arg0) {
		GUI_2 gui = new GUI_2();
		gui.criar_GUI();
		gui.open();
	}
}
