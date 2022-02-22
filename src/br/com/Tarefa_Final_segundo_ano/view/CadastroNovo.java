package br.com.Tarefa_Final_segundo_ano.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.Tarefa_Final_segundo_ano.metodos.BancoDados;
import br.com.Tarefa_Final_segundo_ano.metodos.Conexão;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CadastroNovo extends JFrame {

	private JPanel contentPane;
	Conexão conexao = new Conexão();
	Connection conn;
	BancoDados bd = new BancoDados();
	private JTextField id;
	private JTextField tipo;
	private JTextField nome;
	private JTextField pCompra;
	private JTextField marca;
	private JTextField pVenda;
	private JTextField fornecedor;
	private JTextField qtd;
	private JTextField nomeFornecedor;
	private JTextField telefone;
	private JTextField cnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroNovo frame = new CadastroNovo();
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
	public CadastroNovo() {
		setTitle("Cadastrar novo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Novo produto", null, panel, null);
		tabbedPane.setForegroundAt(0, Color.YELLOW);
		tabbedPane.setBackgroundAt(0, new Color(128, 0, 0));
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Id do produto");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 82, 15);
		panel.add(lblNewLabel);

		id = new JTextField();
		id.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		id.setBounds(10, 33, 86, 20);
		panel.add(id);
		id.setColumns(10);

		tipo = new JTextField();
		tipo.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		tipo.setColumns(10);
		tipo.setBounds(10, 90, 86, 20);
		panel.add(tipo);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setForeground(new Color(128, 0, 0));
		lblTipo.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblTipo.setBounds(10, 68, 82, 15);
		panel.add(lblTipo);

		nome = new JTextField();
		nome.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		nome.setColumns(10);
		nome.setBounds(126, 33, 86, 20);
		panel.add(nome);

		JLabel lblNomeDoProduto = new JLabel("Nome");
		lblNomeDoProduto.setForeground(new Color(128, 0, 0));
		lblNomeDoProduto.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNomeDoProduto.setBounds(126, 11, 103, 15);
		panel.add(lblNomeDoProduto);

		pCompra = new JTextField();
		pCompra.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		pCompra.setColumns(10);
		pCompra.setBounds(126, 90, 86, 20);
		panel.add(pCompra);

		JLabel lblPreoDeCompra = new JLabel("Pre\u00E7o de compra");
		lblPreoDeCompra.setForeground(new Color(128, 0, 0));
		lblPreoDeCompra.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblPreoDeCompra.setBounds(126, 68, 103, 15);
		panel.add(lblPreoDeCompra);

		marca = new JTextField();
		marca.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		marca.setColumns(10);
		marca.setBounds(239, 33, 86, 20);
		panel.add(marca);

		JLabel lblMarcaDoProduto = new JLabel("Marca");
		lblMarcaDoProduto.setForeground(new Color(128, 0, 0));
		lblMarcaDoProduto.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblMarcaDoProduto.setBounds(239, 11, 82, 15);
		panel.add(lblMarcaDoProduto);

		pVenda = new JTextField();
		pVenda.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		pVenda.setColumns(10);
		pVenda.setBounds(239, 90, 86, 20);
		panel.add(pVenda);

		JLabel lblPreoDeVenda = new JLabel("Pre\u00E7o de venda");
		lblPreoDeVenda.setForeground(new Color(128, 0, 0));
		lblPreoDeVenda.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblPreoDeVenda.setBounds(239, 68, 82, 15);
		panel.add(lblPreoDeVenda);

		fornecedor = new JTextField();
		fornecedor.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		fornecedor.setColumns(10);
		fornecedor.setBounds(10, 143, 86, 20);
		panel.add(fornecedor);

		JLabel lblIdDoFornecedor = new JLabel("Id do fornecedor");
		lblIdDoFornecedor.setForeground(new Color(128, 0, 0));
		lblIdDoFornecedor.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblIdDoFornecedor.setBounds(10, 121, 106, 15);
		panel.add(lblIdDoFornecedor);

		qtd = new JTextField();
		qtd.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		qtd.setColumns(10);
		qtd.setBounds(126, 143, 86, 20);
		panel.add(qtd);

		JLabel lblQuantidadeInicial = new JLabel("Quantidade inicial");
		lblQuantidadeInicial.setForeground(new Color(128, 0, 0));
		lblQuantidadeInicial.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblQuantidadeInicial.setBounds(126, 121, 103, 15);
		panel.add(lblQuantidadeInicial);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conn = conexao.conectar();
					String tabela = "produto ";
					String dados = "('" + id.getText() + "','" + nome.getText() + "','" + marca.getText() + "','"
							+ tipo.getText() + "','" + pCompra.getText() + "','" + pVenda.getText() + "','"
							+ fornecedor.getText() + "','" + qtd.getText() + "')";
					bd.insereDados(conn, tabela, dados);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBackground(new Color(128, 0, 0));
		btnCadastrar.setForeground(Color.YELLOW);
		btnCadastrar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnCadastrar.setBounds(286, 121, 89, 23);
		panel.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				id.setText("");
				nome.setText("");
				marca.setText("");
				tipo.setText("");
				pCompra.setText("");
				pVenda.setText("");
				fornecedor.setText("");
				qtd.setText("");
			}
		});
		btnLimpar.setForeground(Color.YELLOW);
		btnLimpar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnLimpar.setBackground(new Color(128, 0, 0));
		btnLimpar.setBounds(286, 155, 89, 23);
		panel.add(btnLimpar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Novo fornecedor", null, panel_1, null);
		tabbedPane.setForegroundAt(1, new Color(128, 0, 0));
		tabbedPane.setBackgroundAt(1, Color.YELLOW);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setBounds(10, 34, 82, 14);
		panel_1.add(lblNewLabel_1);

		nomeFornecedor = new JTextField();
		nomeFornecedor.setBounds(69, 32, 86, 20);
		panel_1.add(nomeFornecedor);
		nomeFornecedor.setColumns(10);

		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(69, 82, 86, 20);
		panel_1.add(telefone);

		JLabel lblNewLabel_1_1 = new JLabel("Telefone");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 84, 82, 14);
		panel_1.add(lblNewLabel_1_1);

		cnpj = new JTextField();
		cnpj.setColumns(10);
		cnpj.setBounds(69, 133, 86, 20);
		panel_1.add(cnpj);

		JLabel lblNewLabel_1_2 = new JLabel("CNPJ");
		lblNewLabel_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 135, 82, 14);
		panel_1.add(lblNewLabel_1_2);

		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					conn = conexao.conectar();
					String tabela = " funcionario (nomeFuncionario, nascimento, cpfFuncionario, funcao, senhaFuncionario) ";
					String dados = "('" + nomeFornecedor.getText() + "','" + telefone.getText() + "','" + cnpj.getText()
							+ "')";
					bd.insereDados(conn, tabela, dados);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnNewButton.setBounds(267, 52, 89, 23);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nomeFornecedor.setText("");
				telefone.setText("");
				cnpj.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1.setForeground(Color.YELLOW);
		btnNewButton_1.setBounds(267, 109, 89, 23);
		panel_1.add(btnNewButton_1);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DetalhesProduto frame = new DetalhesProduto();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnVoltar.setBackground(new Color(128, 0, 0));
		btnVoltar.setForeground(Color.YELLOW);
		btnVoltar.setBounds(335, 0, 89, 23);
		contentPane.add(btnVoltar);
	}
}
