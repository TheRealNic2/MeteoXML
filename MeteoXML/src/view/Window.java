package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Window extends JFrame {

	private JPanel contentPane;
	
	private JPanel pnlCitta;
	private JPanel pnlMainInf;
	private JLabel lblLongitudine;
	private JLabel lblLongitudine2;
	private JLabel lblCitta;
	private JLabel lblID;
	private JLabel lblLatitudine2;
	private JLabel lblLatitudine;
	private JLabel lblTemperatura2;
	private JLabel lblTemperaturaMinima2;
	private JLabel lblTemperaturaMassima2;
	private JLabel lblUmidita2;
	private JLabel lblPressione2;
	private JLabel lblNomeVento2;
	private JLabel lblVelocitaVento2;
	private JLabel lblDirezioneVento2;
	private JLabel lblID2;
	private JPanel pnlInf;
	private JLabel lblTemperatura;
	private JLabel lblTemperaturaMinima;
	private JLabel lblTemperaturaMassima;
	private JLabel lblUmidita;
	private JLabel lblPressione;
	private JLabel lblVento;
	private JLabel lblNomeVento;
	private JLabel lblVelocitaVento;
	private JLabel lblDirezioneVento;
	private JButton btnNow;
	private JButton btn5Day;
	private JButton btnClear;
	private JTextField tfCitta;
	private JPanel pnlLastUpdate;
	private JLabel lblOra;
	private JLabel lblData;
	private JLabel lblData2;
	private JLabel lblOra2;
	private JPanel pnlMain;
	private JLabel lblBackground2;
	private JPanel pnlSigla;
	private JLabel lblBackground1;

	public Window() {
		setResizable(false);
		this.setFont(new Font("Times New Roman", Font.BOLD, 13));
		setTitle("Clima byBortolan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 415);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlMain = new JPanel();
		pnlMain.setBounds(0, 0, 606, 387);
		contentPane.add(pnlMain);
		pnlMain.setLayout(null);
		
		pnlMainInf = new JPanel();
		pnlMainInf.setBounds(192, 11, 176, 112);
		pnlMain.add(pnlMainInf);
		pnlMainInf.setBackground(new Color(204, 51, 51));
		pnlMainInf.setOpaque(false);
		pnlMainInf.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dati Principali", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 0)));
		pnlMainInf.setLayout(null);
		
		lblLongitudine = new JLabel("Longitudine");
		lblLongitudine.setForeground(new Color(255, 153, 0));
		lblLongitudine.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLongitudine.setBounds(10, 82, 77, 14);
		pnlMainInf.add(lblLongitudine);
		
		lblLongitudine2 = new JLabel("");
		lblLongitudine2.setForeground(new Color(255, 153, 0));
		lblLongitudine2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLongitudine2.setBounds(85, 82, 77, 14);
		pnlMainInf.add(lblLongitudine2);
		
		lblID = new JLabel("ID Citt\u00E0");
		lblID.setForeground(new Color(255, 153, 0));
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblID.setBounds(10, 32, 58, 14);
		pnlMainInf.add(lblID);
		
		lblLatitudine2 = new JLabel("");
		lblLatitudine2.setForeground(new Color(255, 153, 0));
		lblLatitudine2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLatitudine2.setBounds(85, 57, 77, 14);
		pnlMainInf.add(lblLatitudine2);
		
		lblLatitudine = new JLabel("Latitudine");
		lblLatitudine.setForeground(new Color(255, 153, 0));
		lblLatitudine.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblLatitudine.setBounds(10, 57, 77, 14);
		pnlMainInf.add(lblLatitudine);
		
		lblID2 = new JLabel("");
		lblID2.setForeground(new Color(255, 153, 0));
		lblID2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblID2.setBounds(85, 32, 81, 14);
		pnlMainInf.add(lblID2);
		
		pnlInf = new JPanel();
		pnlInf.setBounds(10, 134, 576, 165);
		pnlMain.add(pnlInf);
		pnlInf.setBackground(new Color(204, 51, 51));
		pnlInf.setOpaque(false);
		pnlInf.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Dati", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 0)));
		pnlInf.setLayout(null);
		
		lblTemperatura = new JLabel("Temperatura");
		lblTemperatura.setForeground(new Color(255, 153, 0));
		lblTemperatura.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTemperatura.setBounds(10, 37, 119, 14);
		pnlInf.add(lblTemperatura);
		
		lblTemperaturaMinima = new JLabel("Temperatura Min");
		lblTemperaturaMinima.setForeground(new Color(255, 153, 0));
		lblTemperaturaMinima.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTemperaturaMinima.setBounds(10, 62, 119, 14);
		pnlInf.add(lblTemperaturaMinima);
		
		lblTemperaturaMassima = new JLabel("Temperatura Max");
		lblTemperaturaMassima.setForeground(new Color(255, 153, 0));
		lblTemperaturaMassima.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTemperaturaMassima.setBounds(10, 87, 119, 14);
		pnlInf.add(lblTemperaturaMassima);
		
		lblTemperatura2 = new JLabel("");
		lblTemperatura2.setForeground(new Color(255, 153, 0));
		lblTemperatura2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTemperatura2.setBounds(139, 37, 115, 14);
		pnlInf.add(lblTemperatura2);
		
		lblTemperaturaMinima2 = new JLabel("");
		lblTemperaturaMinima2.setForeground(new Color(255, 153, 0));
		lblTemperaturaMinima2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTemperaturaMinima2.setBounds(139, 62, 115, 14);
		pnlInf.add(lblTemperaturaMinima2);
		
		lblTemperaturaMassima2 = new JLabel("");
		lblTemperaturaMassima2.setForeground(new Color(255, 153, 0));
		lblTemperaturaMassima2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTemperaturaMassima2.setBounds(139, 87, 115, 14);
		pnlInf.add(lblTemperaturaMassima2);
		
		lblUmidita = new JLabel("Umidit\u00E0");
		lblUmidita.setForeground(new Color(255, 153, 0));
		lblUmidita.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblUmidita.setBounds(10, 112, 119, 14);
		pnlInf.add(lblUmidita);
		
		lblPressione = new JLabel("Pressione");
		lblPressione.setForeground(new Color(255, 153, 0));
		lblPressione.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPressione.setBounds(10, 137, 119, 14);
		pnlInf.add(lblPressione);
		
		lblVento = new JLabel("Vento");
		lblVento.setForeground(new Color(255, 153, 0));
		lblVento.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblVento.setBounds(393, 37, 72, 14);
		pnlInf.add(lblVento);
		
		lblNomeVento = new JLabel("Nome");
		lblNomeVento.setForeground(new Color(255, 153, 0));
		lblNomeVento.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNomeVento.setBounds(300, 62, 83, 14);
		pnlInf.add(lblNomeVento);
		
		lblVelocitaVento = new JLabel("Velocit\u00E0");
		lblVelocitaVento.setForeground(new Color(255, 153, 0));
		lblVelocitaVento.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblVelocitaVento.setBounds(300, 87, 83, 14);
		pnlInf.add(lblVelocitaVento);
		
		lblDirezioneVento = new JLabel("Direzione");
		lblDirezioneVento.setForeground(new Color(255, 153, 0));
		lblDirezioneVento.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDirezioneVento.setBounds(300, 112, 83, 14);
		pnlInf.add(lblDirezioneVento);
		
		lblUmidita2 = new JLabel("");
		lblUmidita2.setForeground(new Color(255, 153, 0));
		lblUmidita2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblUmidita2.setBounds(139, 112, 115, 14);
		pnlInf.add(lblUmidita2);
		
		lblPressione2 = new JLabel("");
		lblPressione2.setForeground(new Color(255, 153, 0));
		lblPressione2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblPressione2.setBounds(139, 137, 115, 14);
		pnlInf.add(lblPressione2);
		
		lblNomeVento2 = new JLabel("");
		lblNomeVento2.setForeground(new Color(255, 153, 0));
		lblNomeVento2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNomeVento2.setBounds(393, 62, 153, 14);
		pnlInf.add(lblNomeVento2);
		
		lblVelocitaVento2 = new JLabel("");
		lblVelocitaVento2.setForeground(new Color(255, 153, 0));
		lblVelocitaVento2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblVelocitaVento2.setBounds(393, 87, 153, 14);
		pnlInf.add(lblVelocitaVento2);
		
		lblDirezioneVento2 = new JLabel("");
		lblDirezioneVento2.setForeground(new Color(255, 153, 0));
		lblDirezioneVento2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblDirezioneVento2.setBounds(393, 112, 153, 14);
		pnlInf.add(lblDirezioneVento2);
		
		btnNow = new JButton("Corrente");
		btnNow.setBounds(77, 328, 112, 23);
		pnlMain.add(btnNow);
		btnNow.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNow.setBackground(Color.WHITE);
		btnNow.setMnemonic('c');
		
		btn5Day = new JButton("Tra 5 Giorni");
		btn5Day.setBounds(247, 328, 112, 23);
		pnlMain.add(btn5Day);
		btn5Day.setMnemonic('t');
		btn5Day.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btn5Day.setBackground(Color.WHITE);
		
		btnClear = new JButton("Svuota Campi");
		btnClear.setBounds(417, 328, 112, 23);
		pnlMain.add(btnClear);
		btnClear.setMnemonic('s');
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnClear.setBackground(Color.WHITE);
		
		pnlLastUpdate = new JPanel();
		pnlLastUpdate.setBounds(385, 11, 200, 112);
		pnlMain.add(pnlLastUpdate);
		pnlLastUpdate.setBackground(new Color(204, 51, 51));
		pnlLastUpdate.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Aggiornamento Meteo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 0)));
		pnlLastUpdate.setOpaque(false);
		pnlLastUpdate.setLayout(null);
		
		lblOra = new JLabel("Ora");
		lblOra.setForeground(new Color(255, 153, 0));
		lblOra.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblOra.setBounds(10, 62, 58, 14);
		pnlLastUpdate.add(lblOra);
		
		lblData = new JLabel("Data");
		lblData.setForeground(new Color(255, 153, 0));
		lblData.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblData.setBounds(10, 37, 58, 14);
		pnlLastUpdate.add(lblData);
		
		lblData2 = new JLabel("");
		lblData2.setForeground(new Color(255, 153, 0));
		lblData2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblData2.setBounds(95, 37, 95, 14);
		pnlLastUpdate.add(lblData2);
		
		lblOra2 = new JLabel("");
		lblOra2.setForeground(new Color(255, 153, 0));
		lblOra2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblOra2.setBounds(95, 62, 95, 14);
		pnlLastUpdate.add(lblOra2);
		
		pnlCitta = new JPanel();
		pnlCitta.setBounds(10, 11, 156, 112);
		pnlMain.add(pnlCitta);
		pnlCitta.setBackground(new Color(204, 51, 51));
		pnlCitta.setOpaque(false);
		pnlCitta.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Seleziona Citt\u00E0", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 0)));
		pnlCitta.setLayout(null);
		
		lblCitta = new JLabel("Citt\u00E0");
		lblCitta.setForeground(new Color(255, 153, 0));
		lblCitta.setHorizontalAlignment(SwingConstants.CENTER);
		lblCitta.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCitta.setBounds(48, 36, 58, 14);
		pnlCitta.add(lblCitta);
		
		tfCitta = new JTextField();
		tfCitta.setForeground(new Color(255, 153, 0));
		tfCitta.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		tfCitta.setOpaque(false);
		tfCitta.setHorizontalAlignment(SwingConstants.CENTER);
		tfCitta.setBackground(new Color(255, 255, 255));
		tfCitta.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tfCitta.setBounds(10, 72, 136, 20);
		pnlCitta.add(tfCitta);
		
		lblBackground2 = new JLabel("");
		lblBackground2.setIcon(new ImageIcon(Window.class.getResource("/image/Background.jpg")));
		lblBackground2.setBounds(0, 0, 606, 387);
		pnlMain.add(lblBackground2);
		
		pnlSigla = new JPanel();
		pnlSigla.setBounds(0, 0, 606, 387);
		contentPane.add(pnlSigla);
		pnlSigla.setLayout(null);
		
		lblBackground1 = new JLabel("");
		lblBackground1.setBounds(0, 0, 606, 387);
		Image image = java.awt.Toolkit.getDefaultToolkit().getImage(Window.class.getResource("/image/TGcom.jpg"));
		image = image.getScaledInstance(610, 400, Image.SCALE_DEFAULT);
		ImageIcon icon = new ImageIcon(image);
		lblBackground1.setIcon(icon);
		pnlSigla.add(lblBackground1);
		
		pnlMain.setVisible(false);
	}

	public JPanel getPnlMain() {
		return pnlMain;
	}

	public JPanel getPnlSigla() {
		return pnlSigla;
	}

	public JLabel getLblLongitudine2() {
		return lblLongitudine2;
	}

	public JLabel getLblLatitudine2() {
		return lblLatitudine2;
	}

	public JLabel getLblTemperatura2() {
		return lblTemperatura2;
	}

	public JLabel getLblTemperaturaMinima2() {
		return lblTemperaturaMinima2;
	}

	public JLabel getLblTemperaturaMassima2() {
		return lblTemperaturaMassima2;
	}

	public JLabel getLblUmidita2() {
		return lblUmidita2;
	}

	public JLabel getLblPressione2() {
		return lblPressione2;
	}

	public JLabel getLblNomeVento2() {
		return lblNomeVento2;
	}

	public JLabel getLblVelocitaVento2() {
		return lblVelocitaVento2;
	}

	public JLabel getLblDirezioneVento2() {
		return lblDirezioneVento2;
	}

	public JLabel getLblData2() {
		return lblData2;
	}

	public JLabel getLblID2() {
		return lblID2;
	}

	public JButton getBtnNow() {
		return btnNow;
	}

	public JButton getBtn5Day() {
		return btn5Day;
	}

	public JButton getBtnClear() {
		return btnClear;
	}

	public JTextField getTfCitta() {
		return tfCitta;
	}

	public JLabel getLblOra2() {
		return lblOra2;
	}
}
