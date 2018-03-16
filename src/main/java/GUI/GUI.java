package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class GUI {
	private JFrame GUI;
	private JFrame otimizacao;
	private JFrame duvidas;

	public void CrearGUI() {
		GUI = new JFrame("The Good Boy");
		otimizacao = new JFrame("Solve");
		duvidas = new JFrame("FAQ");
		
		GUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		otimizacao.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		duvidas.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		GUI.setLayout(new BorderLayout());
		otimizacao.setLayout(new GridLayout(6, 1));
		JButton otimizar = new JButton("solve");
		
		otimizar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				createSolveWindow();
			}
		});
		
		GUI.add(otimizar, BorderLayout.EAST);
		
		JMenuBar duvidas = new JMenuBar();
		
		JMenu help = new JMenu("Help!");
		
		help.getAccessibleContext().setAccessibleDescription("Ola");
		duvidas.add(help);
		
		JMenuItem faq = new JMenuItem("FAQ");
		help.add(faq);
		JMenuItem email = new JMenuItem("Send a help E-Mail");
		help.add(email);
		GUI.add(duvidas, BorderLayout.NORTH);
		JButton Ler = new JButton("Read saved report");
		GUI.add(Ler, BorderLayout.WEST);
		JLabel front = new JLabel();
		ImageIcon icon = new ImageIcon("good-boy.jpg");
		front.setIcon(icon);
		GUI.add(front, BorderLayout.CENTER);
	}

	public void open() {
		GUI.setVisible(true);
		GUI.pack();
	}

	public static void main(String[] arg0) {
		GUI gui = new GUI();
		gui.CrearGUI();
		gui.open();
	}

	public void createSolveWindow() {
		JPanel nome = new JPanel();
		JPanel nome1 = new JPanel();
		JPanel nome2 = new JPanel();
		nome.setLayout(new GridLayout(2, 1));
		JLabel nome_problema = new JLabel("Issue name");
		JLabel nome_email = new JLabel("E-mail");
		JTextField indic_nome = new JTextField();
		JTextField indic_email = new JTextField();
		indic_nome.setPreferredSize(new Dimension(200, 20));
		indic_email.setPreferredSize(new Dimension(200, 20));
		nome1.add(nome_problema);
		nome1.add(indic_nome);
		nome2.add(nome_email);
		nome2.add(indic_email);
		nome.add(nome1);
		nome.add(nome2);

		/*
		 * JPanel email=new JPanel(); email.add(nome_email); email.add(indic_email);
		 */

		JPanel nvar = new JPanel();
		JLabel n_var = new JLabel("number of variables to compute");
		JComboBox var = new JComboBox();
		nvar.add(n_var);
		nvar.add(var);

		JPanel table = new JPanel();
		DefaultTableModel model = new DefaultTableModel();
		JTable var_table = new JTable(model);
		JScrollPane scroll = new JScrollPane(var_table);
		for (int i = 0; i < 20; i++) {
			String[] ex = { "a", "b", "c" };
			model.addRow(ex);
		}
		table.add(scroll);

		JPanel time = new JPanel();
		final JSlider set_time = new JSlider(JSlider.HORIZONTAL, 0, 180, 90);
		set_time.setMinorTickSpacing(1);
		set_time.setMajorTickSpacing(30);
		set_time.setPaintTicks(true);
		final JLabel value = new JLabel();
		int valor = set_time.getValue();
		value.setText(Integer.toString(valor));
		set_time.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				value.setText(Integer.toString(set_time.getValue()));
			}
		});
		time.add(set_time);
		time.add(value);

		JButton start = new JButton("Start solving");

		otimizacao.add(nome);
		// otimizacao.add(email);
		otimizacao.add(nvar);
		otimizacao.add(table);
		otimizacao.add(time);
		otimizacao.add(start);
		otimizacao.setVisible(true);
		otimizacao.pack();
	}
}
