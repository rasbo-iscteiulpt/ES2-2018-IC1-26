package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

				JLabel label = new JLabel("Send an email to Admin");
				emails.add(label, BorderLayout.NORTH);

				final JTextArea write = new JTextArea();
				emails.add(write, BorderLayout.CENTER);

				JButton sendButton = new JButton("Send");
				emails.add(sendButton, BorderLayout.SOUTH);

				sendButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						System.out.println("Email com sucesso");
						SenderMail sendMail = new SenderMail("rubenfederer@gmail.com", write.getText());
						sendMail.sendNow();

					}
				});
			}
		});

		principal.add(duvidas, BorderLayout.NORTH);
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
