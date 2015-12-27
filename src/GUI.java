import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	Fetcher fetcher = new Fetcher();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 591, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topPanel = new JPanel();
		frame.getContentPane().add(topPanel, BorderLayout.NORTH);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		topPanel.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		topPanel.add(rdbtnNewRadioButton);
		
		JButton fetchBtn = new JButton("Fetch!");

		topPanel.add(fetchBtn);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		final JTextArea inputTxt = new JTextArea();
		inputTxt.setText("input");
		inputTxt.setMinimumSize(new Dimension(100, 0));
		splitPane.setLeftComponent(inputTxt);
		
		final JTextArea outputTxt = new JTextArea();
		outputTxt.setText("output");
		outputTxt.setMinimumSize(new Dimension(100, 0));
		splitPane.setRightComponent(outputTxt);
		
		fetchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputTxt.setText(fetcher.fetch(inputTxt.getText()));
			}
		});
	}

}
