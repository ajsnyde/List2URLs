import java.awt.BorderLayout;
import java.awt.Image;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public About() {
		setBounds(100, 100, 220, 299);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JLabel lblCreatedByAddison = new JLabel("\r\nCreated by Addison Snyder");
			lblCreatedByAddison.setVerticalTextPosition(SwingConstants.TOP);
			lblCreatedByAddison.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreatedByAddison.setVerticalTextPosition(JLabel.BOTTOM);
			lblCreatedByAddison.setHorizontalTextPosition(JLabel.CENTER);
			ImageIcon icon = new ImageIcon(getClass().getResource("/american-alligator.jpg"));
			Image icon2 = icon.getImage().getScaledInstance(183, 132, Image.SCALE_DEFAULT);
			lblCreatedByAddison.setIcon(new ImageIcon(icon2));			
			contentPanel.add(lblCreatedByAddison);
		}
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
