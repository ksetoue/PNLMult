package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

public class MainWindow {

	private JFrame frmPnlMultivarivel;
	private JTextField txtFuncao;
	private JTextField txtNumVar;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmPnlMultivarivel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPnlMultivarivel = new JFrame();
		frmPnlMultivarivel.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Karol\\_github\\PNLMult\\images\\Function-512.png"));
		frmPnlMultivarivel.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		frmPnlMultivarivel.setResizable(false);
		frmPnlMultivarivel.setTitle("PNL Multivari\u00E1vel");
		frmPnlMultivarivel.getContentPane().setFont(new Font("Calibri Light", Font.PLAIN, 12));
		frmPnlMultivarivel.getContentPane().setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(112, 128, 144));
		panelPrincipal.setBounds(0, 0, 487, 291);
		frmPnlMultivarivel.getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblInitX = new JLabel("x :");
		lblInitX.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblInitX.setForeground(new Color(255, 255, 255));
		lblInitX.setBounds(293, 11, 29, 14);
		panelPrincipal.add(lblInitX);
		
		txtFuncao = new JTextField();
		txtFuncao.setToolTipText("Insira aqui a fun\u00E7\u00E3o");
		txtFuncao.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtFuncao.setBounds(67, 34, 171, 20);
		panelPrincipal.add(txtFuncao);
		txtFuncao.setColumns(10);
		
		JLabel labelFuncao = new JLabel("Fun\u00E7\u00E3o :");
		labelFuncao.setForeground(Color.WHITE);
		labelFuncao.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		labelFuncao.setBounds(10, 37, 58, 14);
		panelPrincipal.add(labelFuncao);
		
		JLabel labelNumVar = new JLabel("Num de Vari\u00E1veis :");
		labelNumVar.setForeground(Color.WHITE);
		labelNumVar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		labelNumVar.setBounds(10, 11, 130, 14);
		panelPrincipal.add(labelNumVar);
		
		txtNumVar = new JTextField();
		txtNumVar.setToolTipText("Insira aqui a fun\u00E7\u00E3o");
		txtNumVar.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		txtNumVar.setColumns(10);
		txtNumVar.setBounds(150, 8, 88, 20);
		panelPrincipal.add(txtNumVar);
		
		textField = new JTextField();
		textField.setToolTipText("Insira aqui a fun\u00E7\u00E3o");
		textField.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(30, 65, 88, 20);
		panelPrincipal.add(textField);
		
		JLabel lblE = new JLabel("E :");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblE.setBounds(10, 69, 29, 14);
		panelPrincipal.add(lblE);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(105, 105, 105), 2));
		table.setBounds(332, 12, 88, 140);
		panelPrincipal.add(table);
		frmPnlMultivarivel.setBounds(100, 100, 493, 320);
		frmPnlMultivarivel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
