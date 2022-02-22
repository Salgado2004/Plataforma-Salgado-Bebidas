package br.com.Tarefa_Final_segundo_ano.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.Tarefa_Final_segundo_ano.metodos.BancoDados;
import br.com.Tarefa_Final_segundo_ano.metodos.Conexão;
import br.com.Tarefa_Final_segundo_ano.objetos.Funcionario;

import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField cpf;
	private JTextField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setForeground(new Color(128, 0, 0));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home frame = new Home();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnNewButton.setBounds(335, 13, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Login? Por que?");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Por que tem uma tela de login?\nEsse botão foi criado imaginando que um sistema de gerenciamento\nseria acessado por muitos funcionários de funções diferentes.\nAssim com o login é possível controlar o nível de funcionário que irá\nacessar determinadas funções. :)");
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 248, 220));
		btnNewButton_1.setBounds(10, 15, 194, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel.setBounds(204, 49, 43, 23);
		contentPane.add(lblNewLabel);

		cpf = new JTextField();
		cpf.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		cpf.setBounds(160, 83, 113, 23);
		contentPane.add(cpf);
		cpf.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(128, 0, 0));
		lblSenha.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblSenha.setBounds(204, 117, 43, 23);
		contentPane.add(lblSenha);

		senha = new JTextField();
		senha.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		senha.setColumns(10);
		senha.setBounds(160, 157, 113, 23);
		contentPane.add(senha);

		JButton btnNewButton_2 = new JButton("Entrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexão conexao = new Conexão();
				Connection conn;
				BancoDados bd = new BancoDados();
				long cpfFuncionario = Long.parseLong(cpf.getText());
				String senhaFuncionario = senha.getText();
				Funcionario ff = new Funcionario(cpfFuncionario, senhaFuncionario);
				try {
					conn = conexao.conectar();
					bd.funcionarioLogin(conn, "cpfFuncionario = '" + ff.getCpfFuncionario() + "'",
							ff.getCpfFuncionario(), ff.getSenha());
					ff.setNomeFuncionario(bd.getNome());
					ff.setFuncao(bd.getFuncao());
					if (!ff.getNomeFuncionario().equals(null)) {
						if (ff.getFuncao().equalsIgnoreCase("gerente")) {
							AreaGerente frame = new AreaGerente();
							frame.setVisible(true);
							dispose();
						} else {
							ControleFluxo frame = new ControleFluxo();
							frame.setVisible(true);
							dispose();
						}
					}
					conexao.desconectar(conn);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(128, 0, 0));
		btnNewButton_2.setForeground(Color.YELLOW);
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnNewButton_2.setBounds(172, 205, 101, 23);
		contentPane.add(btnNewButton_2);
	}
}
