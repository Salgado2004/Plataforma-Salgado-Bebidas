package br.com.Tarefa_Final_segundo_ano.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.Tarefa_Final_segundo_ano.metodos.BancoDados;
import br.com.Tarefa_Final_segundo_ano.metodos.Conexão;
import br.com.Tarefa_Final_segundo_ano.objetos.Produto;
import br.com.Tarefa_Final_segundo_ano.objetos.Venda;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ControleFluxo extends JFrame {

	String funcionario;
	String produto;
	int quantidade;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleFluxo frame = new ControleFluxo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Conexão conexao = new Conexão();
	Connection conn;
	BancoDados bd = new BancoDados();
	JList estoqueProduto = new JList();
	JList dataVenda = new JList();
	JList dataCompra = new JList();
	DefaultListModel model = new DefaultListModel();
	DefaultListModel model2 = new DefaultListModel();
	private JTextField idProdutoV;
	private JTextField qtdV;
	private JTextField idFuncionarioV;
	private JTextField idProdutoC;
	private JTextField qtdC;
	private JTextField idFuncionarioC;

	/**
	 * Create the frame.
	 */
	public ControleFluxo() {
		setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		setTitle("Controle de Fluxo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 248, 220));
		tabbedPane.setBounds(10, 47, 414, 214);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 0, 0));
		panel.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Estoque", null, panel, null);
		tabbedPane.setForegroundAt(0, new Color(128, 0, 0));
		panel.setLayout(null);

		JScrollPane painelScroll = new JScrollPane(estoqueProduto);
		painelScroll.setSize(389, 127);
		painelScroll.setLocation(10, 35);
		panel.add(painelScroll);
		estoqueProduto.setVisibleRowCount(10);
		estoqueProduto.setFont(new Font("Bahnschrift", Font.PLAIN, 10));
		estoqueProduto.setBounds(0, 11, 430, 195);

		JButton btnNewButton_1 = new JButton("Ver detalhes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetalhesProduto frame = new DetalhesProduto();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(Color.YELLOW);
		btnNewButton_1.setForeground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnNewButton_1.setBounds(148, 163, 130, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_4 = new JButton("Atualizar estoque");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeAllElements();
				estoqueProduto.setModel(model);
				ArrayList<Produto> estoque = new ArrayList<Produto>();
				try {
					conn = conexao.conectar();
					estoque.addAll(bd.Estoque(conn, "produto"));
					for (Produto produto : estoque) {
						estoqueProduto.setModel(model);
						model.addElement(produto.toString());
					}
					conexao.desconectar(conn);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBackground(new Color(255, 248, 220));
		btnNewButton_4.setForeground(new Color(128, 0, 0));
		btnNewButton_4.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnNewButton_4.setBounds(245, 11, 154, 23);
		panel.add(btnNewButton_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Venda", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Cadastrar nova venda");
		lblNewLabel_1.setBackground(new Color(128, 0, 0));
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 11, 134, 16);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Id do Produto");
		lblNewLabel_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(20, 38, 92, 14);
		panel_1.add(lblNewLabel_2);

		idProdutoV = new JTextField();
		idProdutoV.setBounds(30, 63, 86, 20);
		panel_1.add(idProdutoV);
		idProdutoV.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Quantidade");
		lblNewLabel_2_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(20, 94, 92, 14);
		panel_1.add(lblNewLabel_2_1);

		qtdV = new JTextField();
		qtdV.setColumns(10);
		qtdV.setBounds(30, 119, 86, 20);
		panel_1.add(qtdV);

		JLabel lblNewLabel_2_2 = new JLabel("Data da venda");
		lblNewLabel_2_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(148, 38, 92, 14);
		panel_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Id de Funcion\u00E1rio");
		lblNewLabel_2_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(148, 94, 98, 14);
		panel_1.add(lblNewLabel_2_3);

		idFuncionarioV = new JTextField();
		idFuncionarioV.setColumns(10);
		idFuncionarioV.setBounds(148, 119, 98, 20);
		panel_1.add(idFuncionarioV);

		JButton btnNewButton_3 = new JButton("Cadastrar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario = idFuncionarioV.getText();
				produto = idProdutoV.getText();
				String dia = dataVenda.getSelectedValue().toString();
				quantidade = Integer.parseInt(qtdV.getText());
				try {
					conn = conexao.conectar();
					bd.defineLucro(conn, produto);
					String sql = "venda (quantidade, idProduto, lucro, diaVenda, idFuncionario)";
					String data = "('" + quantidade + "','" + produto + "','" + bd.getLucro() * quantidade + "','" + dia
							+ "','" + funcionario + "')";
					bd.insereDados(conn, sql, data);
					if (bd.getRetorno() > 0) {
						bd.atualizavendaEstoque(conn, quantidade, produto);
					}
					conexao.desconectar(conn);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBackground(new Color(128, 0, 0));
		btnNewButton_3.setForeground(Color.YELLOW);
		btnNewButton_3.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnNewButton_3.setBounds(290, 62, 98, 23);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_3_1 = new JButton("Limpar");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idProdutoV.setText("");
				qtdV.setText("");
				idFuncionarioV.setText("");
			}
		});
		btnNewButton_3_1.setForeground(Color.YELLOW);
		btnNewButton_3_1.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnNewButton_3_1.setBackground(new Color(128, 0, 0));
		btnNewButton_3_1.setBounds(290, 118, 98, 23);
		panel_1.add(btnNewButton_3_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(148, 63, 98, 23);
		panel_1.add(scrollPane);

		dataVenda.setVisibleRowCount(1);
		dataVenda.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		scrollPane.setViewportView(dataVenda);
		tabbedPane.setBackgroundAt(1, new Color(128, 0, 0));
		tabbedPane.setForegroundAt(1, Color.YELLOW);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 248, 220));
		tabbedPane.addTab("Compra", null, panel_2, null);
		tabbedPane.setForegroundAt(2, Color.YELLOW);
		tabbedPane.setBackgroundAt(2, new Color(128, 0, 0));
		panel_2.setLayout(null);

		JLabel lblCompra = new JLabel("Cadastrar nova compra");
		lblCompra.setBackground(new Color(128, 0, 0));
		lblCompra.setForeground(new Color(128, 0, 0));
		lblCompra.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		lblCompra.setBounds(10, 6, 137, 16);
		panel_2.add(lblCompra);

		JLabel lblidProduto = new JLabel("Id do Produto");
		lblidProduto.setForeground(new Color(128, 0, 0));
		lblidProduto.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblidProduto.setBounds(10, 34, 71, 15);
		panel_2.add(lblidProduto);

		idProdutoC = new JTextField();
		idProdutoC.setBounds(10, 54, 86, 20);
		panel_2.add(idProdutoC);
		idProdutoC.setColumns(10);

		JLabel lblQtd = new JLabel("Quantidade");
		lblQtd.setForeground(new Color(128, 0, 0));
		lblQtd.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblQtd.setBounds(10, 106, 59, 15);
		panel_2.add(lblQtd);

		qtdC = new JTextField();
		qtdC.setColumns(10);
		qtdC.setBounds(10, 137, 86, 20);
		panel_2.add(qtdC);

		JLabel lblDia = new JLabel("Data da compra");
		lblDia.setForeground(new Color(128, 0, 0));
		lblDia.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblDia.setBounds(124, 33, 83, 15);
		panel_2.add(lblDia);

		JLabel lblFuncionario = new JLabel("Id de Funcion\u00E1rio");
		lblFuncionario.setForeground(new Color(128, 0, 0));
		lblFuncionario.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblFuncionario.setBounds(124, 106, 92, 15);
		panel_2.add(lblFuncionario);

		idFuncionarioC = new JTextField();
		idFuncionarioC.setColumns(10);
		idFuncionarioC.setBounds(124, 137, 86, 20);
		panel_2.add(idFuncionarioC);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario = idFuncionarioC.getText();
				produto = idProdutoC.getText();
				String dia = dataCompra.getSelectedValue().toString();
				quantidade = Integer.parseInt(qtdC.getText());
				try {
					conn = conexao.conectar();
					String sql = "compra (quantidade, idProduto, diaCompra, idFuncionario)";
					String data = "('" + quantidade + "','" + produto + "','" + dia + "','" + funcionario + "')";
					bd.insereDados(conn, sql, data);
					if (bd.getRetorno() > 0) {
						bd.atualizacompraEstoque(conn, quantidade, produto);
					}
					conexao.desconectar(conn);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadastrar.setBackground(new Color(128, 0, 0));
		btnCadastrar.setForeground(Color.YELLOW);
		btnCadastrar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnCadastrar.setBounds(290, 62, 98, 23);
		panel_2.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idProdutoC.setText("");
				qtdC.setText("");
				idFuncionarioC.setText("");
			}
		});
		btnLimpar.setForeground(Color.YELLOW);
		btnLimpar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnLimpar.setBackground(new Color(128, 0, 0));
		btnLimpar.setBounds(290, 118, 98, 23);
		panel_2.add(btnLimpar);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(124, 55, 86, 18);
		panel_2.add(scrollPane2);

		dataCompra.setVisibleRowCount(1);
		dataCompra.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		scrollPane2.setViewportView(dataCompra);
		tabbedPane.setBackgroundAt(1, new Color(128, 0, 0));
		tabbedPane.setForegroundAt(1, Color.YELLOW);

		JLabel lblNewLabel = new JLabel("Acesso de Funcion\u00E1rio");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 169, 25);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Sair");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String resp = JOptionPane
						.showInputDialog("Certeza que deseja sair?\nQualquer processo não salvo será perdido");
				if (resp.equalsIgnoreCase("sim")) {
					Home frame = new Home();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBounds(335, 14, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Info ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"O acesso de funcionário permite ao usuário \nver o estoque e cadastrar novas vendas e compras");
			}
		});
		btnNewButton_2.setBackground(new Color(255, 248, 220));
		btnNewButton_2.setForeground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnNewButton_2.setBounds(165, 11, 64, 25);
		contentPane.add(btnNewButton_2);

		ArrayList<Produto> estoque = new ArrayList<Produto>();
		try {
			conn = conexao.conectar();
			estoque.addAll(bd.Estoque(conn, "produto"));
			for (Produto produto : estoque) {
				estoqueProduto.setModel(model);
				model.addElement(produto.toString());
			}
			conexao.desconectar(conn);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		ArrayList<Venda> data = new ArrayList<Venda>();

		for (int mes = 3; mes <= 5; mes++) {
			for (int dia = 1; dia <= 31; dia++) {
				if (mes == 4 && dia == 31) {
					mes++;
					dia = 1;
				}
				dataVenda.setModel(model2);
				dataCompra.setModel(model2);
				model2.addElement("2021-" + mes + "-" + dia);
			}
		}
	}
}
