package br.com.Tarefa_Final_segundo_ano.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setForeground(new Color(128, 0, 0));
		setTitle("Salgado & Bebidas Saloon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Bem Vindo ao Salgado & Bebidas Saloon!");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(10, 11, 344, 38);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("O lugar perfeito para rir, comer e se divertir");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 60, 297, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("       _____");
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2.setBounds(20, 97, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("      |       |");
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_1.setBounds(20, 111, 46, 14);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_3 = new JLabel("     /        \\");
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_3.setBounds(20, 122, 46, 14);
		contentPane.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("   /             \\");
		lblNewLabel_2_4.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_4.setBounds(20, 136, 46, 14);
		contentPane.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("  |                | /\\");
		lblNewLabel_2_5.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_5.setBounds(20, 147, 64, 14);
		contentPane.add(lblNewLabel_2_5);

		JLabel lblNewLabel_2_6 = new JLabel("  |                /    \\");
		lblNewLabel_2_6.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_6.setBounds(20, 161, 82, 14);
		contentPane.add(lblNewLabel_2_6);

		JLabel lblNewLabel_2_7 = new JLabel("  |              /        \\");
		lblNewLabel_2_7.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_7.setBounds(20, 172, 64, 14);
		contentPane.add(lblNewLabel_2_7);

		JLabel lblNewLabel_2_8 = new JLabel("  |           /              \\");
		lblNewLabel_2_8.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_8.setBounds(20, 186, 82, 14);
		contentPane.add(lblNewLabel_2_8);

		JLabel lblNewLabel_2_9 = new JLabel("  |         /                  \\");
		lblNewLabel_2_9.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_9.setBounds(20, 197, 82, 14);
		contentPane.add(lblNewLabel_2_9);

		JLabel lblNewLabel_2_10 = new JLabel("  |       |                      |");
		lblNewLabel_2_10.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_10.setBounds(20, 211, 102, 14);
		contentPane.add(lblNewLabel_2_10);

		JLabel lblNewLabel_2_11 = new JLabel("   \\_____\\____________/");
		lblNewLabel_2_11.setFont(new Font("Bahnschrift", Font.PLAIN, 8));
		lblNewLabel_2_11.setBounds(20, 222, 102, 14);
		contentPane.add(lblNewLabel_2_11);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
		btnNewButton.setBounds(253, 186, 143, 34);
		contentPane.add(btnNewButton);
	}
}
