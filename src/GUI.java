import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.Component;

public class GUI {

	Fetcher fetcher = new Fetcher();
	private JFrame frmBatchUrlRetriever;
	Singleton stats = new Singleton();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmBatchUrlRetriever.setVisible(true);
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
		frmBatchUrlRetriever = new JFrame();
		frmBatchUrlRetriever.setTitle("Batch URL Retriever - Youtube");
		frmBatchUrlRetriever.setBounds(100, 100, 591, 448);
		frmBatchUrlRetriever.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel topPanel = new JPanel();
		frmBatchUrlRetriever.getContentPane().add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));

		JButton fetchBtn = new JButton("Fetch!");
		fetchBtn.setFont(new Font("Tahoma", Font.PLAIN, 20));

		topPanel.add(fetchBtn);

		JPanel panel = new JPanel();
		frmBatchUrlRetriever.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane, BorderLayout.CENTER);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(300, 300));
		splitPane.setLeftComponent(scrollPane);

		final JTextArea inputTxt = new JTextArea();
		scrollPane.setViewportView(inputTxt);
		inputTxt.setText("input");
		inputTxt.setMinimumSize(new Dimension(300, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		splitPane.setRightComponent(scrollPane_1);

		final JTextArea outputTxt = new JTextArea();
		scrollPane_1.setViewportView(outputTxt);
		outputTxt.setText("output");
		outputTxt.setMinimumSize(new Dimension(100, 0));

		JMenuBar menuBar = new JMenuBar();
		frmBatchUrlRetriever.setJMenuBar(menuBar);

		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Settings settings = new Settings();
			}
		});
		menuBar.add(mntmSettings);

		JMenuItem mntmStats = new JMenuItem("Stats");
		mntmStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stats.getStats();
				//StatsGUI stats = new StatsGUI();
			}
		});
		menuBar.add(mntmStats);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About about = new About();
			}
		});
		menuBar.add(mntmAbout);

		fetchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				outputTxt.setText(fetcher.fetch(inputTxt.getText()));
			}
		});
	}
}
