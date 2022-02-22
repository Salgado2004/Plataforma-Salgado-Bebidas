package br.com.Tarefa_Final_segundo_ano.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.Tarefa_Final_segundo_ano.metodos.BancoDados;
import br.com.Tarefa_Final_segundo_ano.metodos.Conexão;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class DetalhesProduto extends JFrame {

	private JPanel contentPane;
	Conexão conexao = new Conexão();
	Connection conn;
	BancoDados bd = new BancoDados();
	private JTextField id;
	int idProduto;
	String nome;
	String marca;
	String tipo;
	float precoVenda;
	float precoCompra;
	String fornecedor;
	int qtd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetalhesProduto frame = new DetalhesProduto();
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
	public DetalhesProduto() {
		setTitle("Detalhes do Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Digite o Id do produto");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(10, 11, 161, 23);
		contentPane.add(lblNewLabel);

		id = new JTextField();
		id.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		id.setBounds(10, 42, 142, 23);
		contentPane.add(id);
		id.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login frame = new login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.YELLOW);
		btnVoltar.setBackground(new Color(128, 0, 0));
		btnVoltar.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		btnVoltar.setBounds(335, 13, 89, 23);
		contentPane.add(btnVoltar);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(128, 0, 0));
		lblNome.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblNome.setBounds(10, 91, 219, 14);
		contentPane.add(lblNome);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(128, 0, 0));
		lblMarca.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblMarca.setBounds(10, 129, 142, 14);
		contentPane.add(lblMarca);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(new Color(128, 0, 0));
		lblTipo.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblTipo.setBounds(10, 168, 142, 14);
		contentPane.add(lblTipo);

		JLabel lblVenda = new JLabel("Pre\u00E7o de venda:");
		lblVenda.setForeground(new Color(128, 0, 0));
		lblVenda.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblVenda.setBounds(239, 91, 185, 14);
		contentPane.add(lblVenda);

		JLabel lblCompra = new JLabel("Pre\u00E7o de compra:");
		lblCompra.setForeground(new Color(128, 0, 0));
		lblCompra.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblCompra.setBounds(239, 129, 185, 14);
		contentPane.add(lblCompra);

		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setForeground(new Color(128, 0, 0));
		lblFornecedor.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblFornecedor.setBounds(10, 203, 185, 14);
		contentPane.add(lblFornecedor);

		JLabel lblQtd = new JLabel("Quantidade dispon\u00EDvel:");
		lblQtd.setForeground(new Color(128, 0, 0));
		lblQtd.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		lblQtd.setBounds(239, 168, 185, 14);
		contentPane.add(lblQtd);

		JLabel lblAviso = new JLabel("");
		lblAviso.setForeground(new Color(255, 0, 0));
		lblAviso.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		lblAviso.setBounds(239, 203, 165, 14);
		contentPane.add(lblAviso);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idProduto = Integer.parseInt(id.getText());
				try {
					conn = conexao.conectar();
					bd.infoProduto(conn, idProduto);
					lblNome.setText("Nome: " + bd.getNome());
					lblMarca.setText("Marca: " + bd.getMarca());
					lblTipo.setText("Tipo: " + bd.getTipo());
					lblVenda.setText("Preço de venda: R$" + bd.getpVenda() + "0");
					lblCompra.setText("Preço de compra: R$" + bd.getpCompra() + "0");
					lblFornecedor.setText("Fornecedor: " + bd.getFornecedor());
					lblQtd.setText("Quantidade disponível: " + bd.getQtd());
					if (bd.getQtd() < 10) {
						lblAviso.setText("Estoque baixo, comprar mais!");
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBackground(new Color(128, 0, 0));
		btnBuscar.setForeground(Color.YELLOW);
		btnBuscar.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnBuscar.setBounds(162, 42, 89, 23);
		contentPane.add(btnBuscar);

		JButton btnNewButton = new JButton("Cadastrar novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroNovo frame = new CadastroNovo();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setForeground(Color.YELLOW);
		btnNewButton.setBounds(136, 227, 153, 23);
		contentPane.add(btnNewButton);
	}
}
