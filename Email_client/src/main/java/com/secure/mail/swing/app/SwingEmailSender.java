package com.secure.mail.swing.app;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.secure.mail.EmailClient;
import com.secure.mail.model.MailResponse;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SwingEmailSender extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel labelTo = new JLabel("To: ");
	private JLabel labelSubject = new JLabel("Subject: ");
	private JLabel labelFormat = new JLabel("Format: ");
	private JTextField fieldTo = new JTextField(30);
	private JTextField fieldSubject = new JTextField(30);
	private String labels[] = { "text/plain", "text/html" };
	private JComboBox fieldFormat = new JComboBox(labels);
	private JButton buttonSend = new JButton("SEND");
	private JTextArea textAreaMessage = new JTextArea(10, 30);
	private GridBagConstraints constraints = new GridBagConstraints();

	public SwingEmailSender() {
		super("Secure Email");

		// set up layout
		setLayout(new GridBagLayout());
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 5, 5, 5);

		setupForm();

		pack();
		setLocationRelativeTo(null); // center on screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Design form data
	 */
	private void setupForm() {

		constraints.gridx = 0;
		constraints.gridy = 0;
		add(labelTo, constraints);

		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		add(fieldTo, constraints);

		constraints.gridx = 0;
		constraints.gridy = 1;
		add(labelSubject, constraints);

		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		add(fieldSubject, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		add(labelFormat, constraints);

		constraints.gridx = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		add(fieldFormat, constraints);

		constraints.gridx = 2;
		constraints.gridy = 0;
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		buttonSend.setFont(new Font("Arial", Font.BOLD, 16));
		add(buttonSend, constraints);

		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				buttonSendActionPerformed(event);
			}
		});

		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridheight = 1;
		constraints.gridwidth = 3;

		constraints.gridy = 3;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;

		add(new JScrollPane(textAreaMessage), constraints);
	}

	/**
	 * Send action button
	 * 
	 * @param event
	 */
	private void buttonSendActionPerformed(ActionEvent event) {
		if (!validateFields()) {
			return;
		}

		String toAddress = fieldTo.getText();
		String subject = fieldSubject.getText();
		String message = textAreaMessage.getText();
		String format = fieldFormat.getSelectedItem().toString();

		try {

			MailResponse output = EmailClient.sendEmail(toAddress, subject, message, format);

			JOptionPane.showMessageDialog(this, output.getOutput(), "New Email Message",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error while sending the e-mail: " + ex.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Basic validation done, if required can be improved by adding more field
	 * validation
	 * 
	 * @return
	 */
	private boolean validateFields() {
		if (fieldTo.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter To address!", "Error", JOptionPane.ERROR_MESSAGE);
			fieldTo.requestFocus();
			return false;
		}

		if (fieldSubject.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter subject!", "Error", JOptionPane.ERROR_MESSAGE);
			fieldSubject.requestFocus();
			return false;
		}

		if (textAreaMessage.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please enter message!", "Error", JOptionPane.ERROR_MESSAGE);
			textAreaMessage.requestFocus();
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		// set look and feel to system dependent
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SwingEmailSender().setVisible(true);
			}
		});
	}
}