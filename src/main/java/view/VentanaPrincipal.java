package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerAsignatura;
import controller.ControllerDocente;
import model.Asignatura;
import model.Docente;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField jtfBuscar;
	private PanelAsignaturas panelAsignaturas;
	JComboBox jcbProfesores;
	String texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Docentes Y Asignaturas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		jtfBuscar = new JTextField();
		GridBagConstraints gbc_jtfBuscar = new GridBagConstraints();
		gbc_jtfBuscar.insets = new Insets(0, 0, 5, 5);
		gbc_jtfBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfBuscar.gridx = 0;
		gbc_jtfBuscar.gridy = 1;
		contentPane.add(jtfBuscar, gbc_jtfBuscar);
		jtfBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Filtrar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDocentes();
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnBuscar = new GridBagConstraints();
		gbc_btnBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscar.gridx = 1;
		gbc_btnBuscar.gridy = 1;
		contentPane.add(btnBuscar, gbc_btnBuscar);
		
		jcbProfesores = new JComboBox();
		GridBagConstraints gbc_jcbProfesores = new GridBagConstraints();
		gbc_jcbProfesores.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesores.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesores.gridx = 0;
		gbc_jcbProfesores.gridy = 2;
		contentPane.add(jcbProfesores, gbc_jcbProfesores);
		
		JButton btnMaterias = new JButton("Cargar Materias");
		btnMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelAsignaturas panelAsignaturas2 = new PanelAsignaturas();
				panelAsignaturas2.agregarTodasAsignaturas();
			}
		});
		btnMaterias.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnMaterias = new GridBagConstraints();
		gbc_btnMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_btnMaterias.gridx = 1;
		gbc_btnMaterias.gridy = 2;
		contentPane.add(btnMaterias, gbc_btnMaterias);
		
		panelAsignaturas = new PanelAsignaturas();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panelAsignaturas, gbc_panel);
	}
	
	
	public void cargarDocentes() {
			this.jcbProfesores.removeAllItems();
			for (Docente d : ControllerDocente.findByName(jtfBuscar.getText())) {
				jcbProfesores.addItem(d);
			}
		
	}
	

}
