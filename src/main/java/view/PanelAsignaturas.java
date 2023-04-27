package view;

import javax.swing.JPanel;

import controller.ControllerAsignatura;
import model.Asignatura;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class PanelAsignaturas extends JPanel {
	JList listNoSeleccionadas;
	DefaultListModel<Asignatura> DefaultlistNoSeleccionadas;
	List<Asignatura> asignaturas = ControllerAsignatura.findAll();
	int indiceProximaAsignaturaParaAgregar;
	

	/**
	 * Create the panel.
	 */
	public PanelAsignaturas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
//		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0};
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Asignaturas no Seleccionadas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Asignaturas Seleccionadas");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnLast = new JButton(">>");
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnLast = new GridBagConstraints();
		gbc_btnLast.insets = new Insets(0, 0, 5, 5);
		gbc_btnLast.gridx = 1;
		gbc_btnLast.gridy = 1;
		add(btnLast, gbc_btnLast);
		
		JList listSeleccionadas = new JList();
		GridBagConstraints gbc_listSeleccionadas = new GridBagConstraints();
		gbc_listSeleccionadas.gridheight = 4;
		gbc_listSeleccionadas.insets = new Insets(0, 0, 5, 0);
		gbc_listSeleccionadas.fill = GridBagConstraints.BOTH;
		gbc_listSeleccionadas.gridx = 2;
		gbc_listSeleccionadas.gridy = 1;
		add(listSeleccionadas, gbc_listSeleccionadas);
		
		JButton btNext = new JButton(">");
		btNext.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btNext = new GridBagConstraints();
		gbc_btNext.insets = new Insets(0, 0, 5, 5);
		gbc_btNext.gridx = 1;
		gbc_btNext.gridy = 2;
		add(btNext, gbc_btNext);
		
		JButton btnPrevious = new JButton("<");
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnPrevious = new GridBagConstraints();
		gbc_btnPrevious.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrevious.gridx = 1;
		gbc_btnPrevious.gridy = 3;
		add(btnPrevious, gbc_btnPrevious);
		
		JButton btnFirst = new JButton("<<");
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnFirst = new GridBagConstraints();
		gbc_btnFirst.insets = new Insets(0, 0, 5, 5);
		gbc_btnFirst.gridx = 1;
		gbc_btnFirst.gridy = 4;
		add(btnFirst, gbc_btnFirst);
		
		listNoSeleccionadas = new JList<Asignatura>(this.getDefaultListModel()) ; 
		GridBagConstraints gbc_listNoSeleccionadas = new GridBagConstraints();
		gbc_listNoSeleccionadas.gridheight = 4;
		gbc_listNoSeleccionadas.insets = new Insets(0, 0, 0, 5);
		gbc_listNoSeleccionadas.fill = GridBagConstraints.BOTH;
		gbc_listNoSeleccionadas.gridx = 0;
		gbc_listNoSeleccionadas.gridy = 1;
		add(listNoSeleccionadas, gbc_listNoSeleccionadas);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 5;
		add(btnSave, gbc_btnSave);

	}
	
	public DefaultListModel<Asignatura> getDefaultListModel () {
		this.DefaultlistNoSeleccionadas = new DefaultListModel<Asignatura>();
		return this.DefaultlistNoSeleccionadas;
	}
	
	public void agregarTodasAsignaturas() {
		for (int i = 0; i < asignaturas.size(); i++) {
			this.DefaultlistNoSeleccionadas.addElement(this.asignaturas.get(i));
		}
		indiceProximaAsignaturaParaAgregar = asignaturas.size();
	}
	

}
