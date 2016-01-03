import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public About() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCreatedByAddison = new JLabel("Created by Addison Snyder");
			lblCreatedByAddison.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreatedByAddison.setBounds(102, 11, 177, 37);
			contentPanel.add(lblCreatedByAddison);
		}		
		{
			JLabel label = new JLabel("");
			label.setBounds(102, 11, 183, 208);
			ImageIcon icon = new ImageIcon("C:\\Users\\Dread\\Downloads\\american-alligator.jpg");
			Image icon2 = icon.getImage().getScaledInstance(183, 132, Image.SCALE_DEFAULT);
			label.setIcon(new ImageIcon(icon2));			
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

}
