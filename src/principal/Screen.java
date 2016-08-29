package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.LexerException;
import exceptions.ParserException;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JCheckBox;
import javax.swing.JTextArea;

public class Screen {

	private JFrame frmMtodosProgramaoNo;
	private JTextField textFieldfuncao;
	private JCheckBox chckbxBissecao;
	public String textFunc;
	public String mostra;
	public String[] textResult = new String[6];
	private JButton btnCalcular;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldL;
	private JTextField textFieldEpso;
	double[] r;
	static boolean[] option = new boolean[6];
	private JTextField textFieldMaxIte;
	private JTextField textFieldDelta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen window = new Screen();
					window.frmMtodosProgramaoNo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Screen() {
		initialize();
		for(int i = 0; i < 6; i++){
			option[i] = false;
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmMtodosProgramaoNo = new JFrame();
		frmMtodosProgramaoNo.setTitle("Programa\u00E7\u00E3o N\u00E3o Linear - Monovari\u00E1vel");
		frmMtodosProgramaoNo.setResizable(false);
		frmMtodosProgramaoNo.setBounds(100, 100, 458, 397);
		frmMtodosProgramaoNo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMtodosProgramaoNo.getContentPane().setLayout(null);
		frmMtodosProgramaoNo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(290, 15, 0, 0);
		frmMtodosProgramaoNo.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblFuncao = new JLabel("Fun\u00E7\u00E3o : ");
		lblFuncao.setBounds(10, 15, 61, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblFuncao);
		
		textFieldfuncao = new JTextField();
		textFieldfuncao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textFieldfuncao.setText("x^2-(3*x)+2");
		textFieldfuncao.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldfuncao.setBounds(81, 12, 150, 20);
		frmMtodosProgramaoNo.getContentPane().add(textFieldfuncao);
		textFieldfuncao.setColumns(150);
		
		JLabel lblExemplo = new JLabel("ex: x^2+sin(pi)");
		lblExemplo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblExemplo.setForeground(Color.DARK_GRAY);
		lblExemplo.setBounds(241, 15, 83, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblExemplo);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setToolTipText("Calcula o x \u00F3timo usando os m\u00E9todos selecionados");
		btnCalcular.setBounds(334, 15, 82, 23);
		frmMtodosProgramaoNo.getContentPane().add(btnCalcular);
		
		JLabel lblMetSemDerivada = new JLabel("M\u00E9todos sem uso de derivadas:");
		lblMetSemDerivada.setBounds(10, 119, 191, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblMetSemDerivada);
		
		JLabel lblMetComUsoDerivadas = new JLabel("M\u00E9todos com uso de derivadas:");
		lblMetComUsoDerivadas.setBounds(10, 248, 191, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblMetComUsoDerivadas);
		
		JCheckBox chckbxBuscaUniforme = new JCheckBox("Busca Uniforme");
		chckbxBuscaUniforme.setToolTipText("M\u00E9todo da Busca Uniforme\r\n: consiste em percorrer a reta verificando somando delta ao valor do intervalo at\u00E9 que x seja maior ou igual a b");
		chckbxBuscaUniforme.setBounds(10, 140, 155, 23);
		frmMtodosProgramaoNo.getContentPane().add(chckbxBuscaUniforme);
		
		JCheckBox chckbxDicotomica = new JCheckBox("Busca Dicot\u00F4mica");
		chckbxDicotomica.setToolTipText("M\u00E9todo da busca dicot\u00F4mica: consiste em calcular x \u00F3timo levando em considera\u00E7\u00E3o a vizinhan\u00E7a no ponto ");
		chckbxDicotomica.setBounds(10, 166, 155, 23);
		frmMtodosProgramaoNo.getContentPane().add(chckbxDicotomica);
		
		JCheckBox chckbxSecAurea = new JCheckBox("Se\u00E7\u00E3o \u00C1urea");
		chckbxSecAurea.setToolTipText("M\u00E9todo da Se\u00E7\u00E3o \u00C1urea: consiste em encontrar o x \u00F3timo usando a raz\u00E3o \u00E1urea para percorrer a reta");
		chckbxSecAurea.setBounds(10, 192, 155, 23);
		frmMtodosProgramaoNo.getContentPane().add(chckbxSecAurea);
		
		JCheckBox chckbxFibonacci = new JCheckBox("Fibonacci");
		chckbxFibonacci.setToolTipText("M\u00E9todo de fibonacci: Semelhante \u00E0 se\u00E7\u00E3o \u00E1urea. No entanto, usa os n\u00FAmeros da sequ\u00EAncia de Fibonacci como par\u00E2metros");
		chckbxFibonacci.setBounds(10, 218, 97, 23);
		frmMtodosProgramaoNo.getContentPane().add(chckbxFibonacci);
		
		chckbxBissecao = new JCheckBox("M\u00E9todo da Bisse\u00E7\u00E3o");
		chckbxBissecao.setBounds(10, 269, 160, 23);
		frmMtodosProgramaoNo.getContentPane().add(chckbxBissecao);
		
		JCheckBox chckbxNewton = new JCheckBox("M\u00E9todo de Newton");
		chckbxNewton.setBounds(10, 295, 160, 23);
		frmMtodosProgramaoNo.getContentPane().add(chckbxNewton);
		
		JLabel lblA = new JLabel("a =");
		lblA.setBounds(10, 55, 27, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblA);
		
		JLabel lblB = new JLabel("b =");
		lblB.setBounds(10, 80, 27, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblB);
		
		JLabel lblL = new JLabel("l =");
		lblL.setBounds(146, 55, 30, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblL);
		
		JLabel lblEpsolon = new JLabel("eps =");
		lblEpsolon.setBounds(146, 80, 38, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblEpsolon);
		
		textFieldA = new JTextField();
		textFieldA.setBounds(37, 52, 86, 20);
		frmMtodosProgramaoNo.getContentPane().add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldB = new JTextField();
		textFieldB.setText("3");
		textFieldB.setBounds(37, 80, 86, 20);
		frmMtodosProgramaoNo.getContentPane().add(textFieldB);
		textFieldB.setColumns(10);
		
		textFieldL = new JTextField();
		textFieldL.setText("0.1");
		textFieldL.setBounds(190, 52, 86, 20);
		frmMtodosProgramaoNo.getContentPane().add(textFieldL);
		textFieldL.setColumns(10);
		
		textFieldEpso = new JTextField();
		textFieldEpso.setText("0.01");
		textFieldEpso.setBounds(190, 77, 86, 20);
		frmMtodosProgramaoNo.getContentPane().add(textFieldEpso);
		textFieldEpso.setColumns(10);
		
		textFieldA.setText("-1");
		
		JLabel lblMaximoDeIteraes = new JLabel("Max itera\u00E7\u00F5es: ");
		lblMaximoDeIteraes.setBounds(295, 55, 89, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblMaximoDeIteraes);
		
		textFieldMaxIte = new JTextField();
		textFieldMaxIte.setText("100");
		textFieldMaxIte.setBounds(394, 52, 38, 20);
		frmMtodosProgramaoNo.getContentPane().add(textFieldMaxIte);
		textFieldMaxIte.setColumns(10);
		
		JTextArea textAreaResultados = new JTextArea();
		textAreaResultados.setBounds(221, 139, 195, 203);
		frmMtodosProgramaoNo.getContentPane().add(textAreaResultados);
		textAreaResultados.setText("Resultados:");
		textAreaResultados.setBackground(Color.WHITE);
		textAreaResultados.setForeground(Color.DARK_GRAY);
		textAreaResultados.setEditable(false);
		textAreaResultados.setTabSize(7);
		textAreaResultados.setRows(2);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setToolTipText("Limpa todos os campos");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostra = "";
				textAreaResultados.setText("Resultados:\n" + mostra);
				textFieldA.setText("");
				textFieldB.setText("");
				textFieldEpso.setText("");
				textFieldfuncao.setText("");
				textFieldL.setText("");				
			}
		});
		btnLimpar.setBounds(10, 334, 89, 23);
		frmMtodosProgramaoNo.getContentPane().add(btnLimpar);
		
		JLabel lblNewLabelDelta = new JLabel("Delta =");
		lblNewLabelDelta.setBounds(305, 80, 46, 14);
		frmMtodosProgramaoNo.getContentPane().add(lblNewLabelDelta);
		
		textFieldDelta = new JTextField();
		textFieldDelta.setText("0.01");
		textFieldDelta.setBounds(363, 77, 68, 20);
		frmMtodosProgramaoNo.getContentPane().add(textFieldDelta);
		textFieldDelta.setColumns(10);
		
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//mostra = null; 
				MainClass.fc = textFieldfuncao.getText();	
				MainClass.a = Double.parseDouble(textFieldA.getText());
				MainClass.b = Double.parseDouble(textFieldB.getText());
				MainClass.l = Double.parseDouble(textFieldL.getText());
				MainClass.epso = Double.parseDouble(textFieldEpso.getText());
				MainClass.k = Integer.parseInt(textFieldMaxIte.getText());
				MainClass.delta = Double.parseDouble(textFieldDelta.getText());
				//System.out.println("fc = "+ MainClass.fc + "a = " + MainClass.a + "b = " + MainClass.b + "l = "+ MainClass.l + "epso = "+ MainClass.epso );
				
				if(MainClass.a > MainClass.b){
					double aux = MainClass.a;
					MainClass.a = MainClass.b;
					MainClass.b = aux;
				}
				
				if(chckbxBuscaUniforme.isSelected()){
					option[0] = true;
					textFieldDelta.setEditable(true);
				}
				else{
					option[0] = false;
					//textFieldDelta.setEditable(false);
				}
				if(chckbxDicotomica.isSelected())
					option[1] = true;
				else
					option[1] = false;
				if(chckbxSecAurea.isSelected())
					option[2] = true;
				else
					option[2] = false;
				if(chckbxFibonacci.isSelected())
					option[3] = true; 
				else
					option[3] = false;
				if(chckbxBissecao.isSelected())
					option[4] = true; 
				else
					option[4] = false;
				if(chckbxNewton.isSelected())
					option[5] = true; 
				else
					option[5] = false;
				
				
				try {
					r = MainClass.result();
				} catch (LexerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				NumberFormat nf = NumberFormat.getInstance(); // get instance
				nf.setMaximumFractionDigits(10); // set decimal places 
				for(int i = 0; i < 6; i++)
					textResult[i] = "";
				
				mostra = "";
				textAreaResultados.setText("Resultados:\n" + mostra);
				
				for(int i = 0; i < 6; i++){
					
					if(i == 0)
						textResult[i] = "Busca Uniforme = " + nf.format(r[i]);
					if(i == 1)
						textResult[i] = "Busca Dicotômica = " + nf.format(r[i]);
					if(i == 2)
						textResult[i] = "Seção Áurea = " + nf.format(r[i]);
					if(i == 3)
						textResult[i] = "Fibonacci = " + nf.format(r[i]);
					if(i == 4)
						textResult[i] = "Bisseção = " + nf.format(r[i]);
					if(i == 5)
						textResult[i] = "Newton = " + nf.format(r[i]);
				}
				
				for(int i = 0; i < 6; i++){
					if(option[i] == true){
						if(mostra != null)
							mostra = mostra + textResult[i] + "\n";
						else
							mostra = textResult[i] + "\n";
					}
				}
				textAreaResultados.setText("Resultados:\n" + mostra);
				
			}
		});
		
		
		
	}
	public static boolean[] sendOption(){
		return (option);
	}
}
