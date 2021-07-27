import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Fahrenheit_Celsius extends JFrame {

	private JLayeredPane Umrechner;
	private JTextField jTFFahrenheit;
	private JLabel jLCelcius;
	private JTextField jTFCelsius;
	private JButton jBtnUmrechnen;
	private final Action action = new SwingAction();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fahrenheit_Celsius frame = new Fahrenheit_Celsius();
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
	public Fahrenheit_Celsius() {
		setFont(new Font("Dialog", Font.PLAIN, 16));
		setTitle("Umrechnen Fahrenheit Celsius");
		setForeground(Color.RED);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\nicop_65porim\\Pictures\\thumb2-4k-dbs-ultra-instinct-goku-in-fire-artwork-dbs-characters.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 147);
		Umrechner = new JLayeredPane();
		Umrechner.setForeground(Color.ORANGE);
		Umrechner.setBackground(Color.ORANGE);
		Umrechner.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Umrechner);
		Umrechner.setLayout(null);
		
		
		// Fahrenheits Label
		JLabel jLFahrenheit = new JLabel("Grad Fahrenheit");
		jLFahrenheit.setBounds(5, 6, 212, 14);
		jLFahrenheit.setVerticalAlignment(SwingConstants.TOP);
		jLFahrenheit.setBackground(new Color(240, 240, 240));
		jLFahrenheit.setHorizontalAlignment(SwingConstants.LEFT);
		Umrechner.add(jLFahrenheit);
		
		jLCelcius = new JLabel("Grad Celcius");
		jLCelcius.setBounds(5, 66, 212, 14);
		jLCelcius.setVerticalAlignment(SwingConstants.TOP);
		jLCelcius.setHorizontalAlignment(SwingConstants.LEFT);
		Umrechner.add(jLCelcius);
		
		jTFFahrenheit = new JTextField();
		jTFFahrenheit.addKeyListener(new KeyAdapter() {
			public void jTFFahrenheitKeyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					}
			}});
		
		jTFFahrenheit.setBounds(5, 21, 212, 20);
		Umrechner.add(jTFFahrenheit);
		jTFFahrenheit.setColumns(10);
		jTFCelsius = new JTextField();
		jTFCelsius.setEditable(false);
		jTFCelsius.setBounds(5, 80, 212, 20);
		Umrechner.add(jTFCelsius);
		jTFCelsius.setColumns(10);

		
		
		JButton jBtnEnde = new JButton("Ende");
		jBtnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jBtnEnde.setBounds(227, 79, 88, 23);
		Umrechner.add(jBtnEnde);
		
		jBtnUmrechnen = new JButton("Umrechnen");
		jBtnUmrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tf, tc;
				tf = Double.parseDouble(jTFFahrenheit.getText());
				tc = (tf - 32) * 5/9;
				DecimalFormat f =new DecimalFormat("#0.00"); // Nachkommata 
				jTFCelsius.setText(f.format(tc));
				jTFFahrenheit.requestFocus();
				jTFFahrenheit.selectAll();
			}
		});
		jBtnUmrechnen.setAction(action);
		jBtnUmrechnen.setBounds(227, 20, 88, 23);
		Umrechner.add(jBtnUmrechnen);
	}
	 // Kommentierung des Fensters
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Umrechnen");
			putValue(SHORT_DESCRIPTION, "Rechnet Fahrenheit in Celsius um");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
