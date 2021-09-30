import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.ImageFactory;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTextField;
import javax.swing.TransferHandler;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Test3 extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton button_0;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;
	private JButton button_16;
	private JButton button_17;
	private JButton button_18;
	private JButton button_19;
	private JButton button_20;
	private JButton button_21;
	private JButton button_22;
	private JButton button_23;
	private JButton button_24;
	private JButton button_25;
	private JButton button_26;
	private JButton button_27;
	private JButton button_28;
	private JButton button_29;
	private JButton button_30;
	private JButton button_31;
	private JButton button_32;
	private JButton button_33;
	private JButton button_34;
	private JButton button_35;
	private JButton button_36;
	private JButton btnC1;
	private JButton btnC2;
	private JButton btnC3;
	private JButton btnDocena_1;
	private JButton btnDocena_2;
	private JButton btnDocena_3;
	private JButton button_1_18;
	private JButton btnPar;
	private JButton btnRojo;
	private JButton btnNegro;
	private JButton btnImpar;
	private JButton button_19_36;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test3 frame = new Test3();
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
	public Test3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 884, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel());
	
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();

			gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
					0, 0, 0, 0 };
			gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_button_3 = new GridBagConstraints();
			gbc_button_3.fill = GridBagConstraints.BOTH;
			gbc_button_3.insets = new Insets(0, 0, 5, 5);
			gbc_button_3.gridx = 2;
			gbc_button_3.gridy = 1;
			gbc_button_3.weightx = 1.0;
			gbc_button_3.weighty = 1.0;
			panel.add(getButton_3(), gbc_button_3);
			GridBagConstraints gbc_button_6 = new GridBagConstraints();
			gbc_button_6.fill = GridBagConstraints.BOTH;
			gbc_button_6.insets = new Insets(0, 0, 5, 5);
			gbc_button_6.gridx = 3;
			gbc_button_6.gridy = 1;
			gbc_button_6.weightx = 1.0;
			gbc_button_6.weighty = 1.0;
			panel.add(getButton_6(), gbc_button_6);
			GridBagConstraints gbc_button_9 = new GridBagConstraints();
			gbc_button_9.fill = GridBagConstraints.BOTH;
			gbc_button_9.insets = new Insets(0, 0, 5, 5);
			gbc_button_9.gridx = 4;
			gbc_button_9.gridy = 1;
			gbc_button_9.weightx = 1.0;
			gbc_button_9.weighty = 1.0;
			panel.add(getButton_9(), gbc_button_9);
			GridBagConstraints gbc_button_12 = new GridBagConstraints();
			gbc_button_12.fill = GridBagConstraints.BOTH;
			gbc_button_12.insets = new Insets(0, 0, 5, 5);
			gbc_button_12.gridx = 5;
			gbc_button_12.gridy = 1;
			gbc_button_12.weightx = 1.0;
			gbc_button_12.weighty = 1.0;
			panel.add(getButton_12(), gbc_button_12);
			GridBagConstraints gbc_button_15 = new GridBagConstraints();
			gbc_button_15.fill = GridBagConstraints.BOTH;
			gbc_button_15.insets = new Insets(0, 0, 5, 5);
			gbc_button_15.gridx = 6;
			gbc_button_15.gridy = 1;
			gbc_button_15.weightx = 1.0;
			gbc_button_15.weighty = 1.0;
			panel.add(getButton_15(), gbc_button_15);
			GridBagConstraints gbc_button_18 = new GridBagConstraints();
			gbc_button_18.fill = GridBagConstraints.BOTH;
			gbc_button_18.insets = new Insets(0, 0, 5, 5);
			gbc_button_18.gridx = 7;
			gbc_button_18.gridy = 1;
			gbc_button_18.weightx = 1.0;
			gbc_button_18.weighty = 1.0;
			panel.add(getButton_18(), gbc_button_18);
			GridBagConstraints gbc_button_21 = new GridBagConstraints();
			gbc_button_21.fill = GridBagConstraints.BOTH;
			gbc_button_21.insets = new Insets(0, 0, 5, 5);
			gbc_button_21.gridx = 8;
			gbc_button_21.gridy = 1;
			gbc_button_21.weightx = 1.0;
			gbc_button_21.weighty = 1.0;
			panel.add(getButton_21(), gbc_button_21);
			GridBagConstraints gbc_button_24 = new GridBagConstraints();
			gbc_button_24.fill = GridBagConstraints.BOTH;
			gbc_button_24.insets = new Insets(0, 0, 5, 5);
			gbc_button_24.gridx = 9;
			gbc_button_24.gridy = 1;
			gbc_button_24.weightx = 1.0;
			gbc_button_24.weighty = 1.0;
			panel.add(getButton_24(), gbc_button_24);
			GridBagConstraints gbc_button_27 = new GridBagConstraints();
			gbc_button_27.fill = GridBagConstraints.BOTH;
			gbc_button_27.insets = new Insets(0, 0, 5, 5);
			gbc_button_27.gridx = 10;
			gbc_button_27.gridy = 1;
			gbc_button_27.weightx = 1.0;
			gbc_button_27.weighty = 1.0;
			panel.add(getButton_27(), gbc_button_27);
			GridBagConstraints gbc_button_30 = new GridBagConstraints();
			gbc_button_30.fill = GridBagConstraints.BOTH;
			gbc_button_30.insets = new Insets(0, 0, 5, 5);
			gbc_button_30.gridx = 11;
			gbc_button_30.gridy = 1;
			gbc_button_30.weightx = 1.0;
			gbc_button_30.weighty = 1.0;
			panel.add(getButton_30(), gbc_button_30);
			GridBagConstraints gbc_button_33 = new GridBagConstraints();
			gbc_button_33.fill = GridBagConstraints.BOTH;
			gbc_button_33.insets = new Insets(0, 0, 5, 5);
			gbc_button_33.gridx = 12;
			gbc_button_33.gridy = 1;
			gbc_button_33.weightx = 1.0;
			gbc_button_33.weighty = 1.0;
			panel.add(getButton_33(), gbc_button_33);
			GridBagConstraints gbc_button_36 = new GridBagConstraints();
			gbc_button_36.fill = GridBagConstraints.BOTH;
			gbc_button_36.insets = new Insets(0, 0, 5, 5);
			gbc_button_36.gridx = 13;
			gbc_button_36.gridy = 1;
			gbc_button_36.weightx = 1.0;
			gbc_button_36.weighty = 1.0;
			panel.add(getButton_36(), gbc_button_36);
			GridBagConstraints gbc_btnC1 = new GridBagConstraints();
			gbc_btnC1.fill = GridBagConstraints.BOTH;
			gbc_btnC1.insets = new Insets(0, 0, 5, 0);
			gbc_btnC1.gridx = 14;
			gbc_btnC1.gridy = 1;
			gbc_btnC1.weightx = 1.0;
			gbc_btnC1.weighty = 1.0;
			panel.add(getBtnC1(), gbc_btnC1);
			GridBagConstraints gbc_button_0 = new GridBagConstraints();
			gbc_button_0.fill = GridBagConstraints.BOTH;
			gbc_button_0.gridheight = 3;
			gbc_button_0.insets = new Insets(0, 0, 5, 5);
			gbc_button_0.gridx = 1;
			gbc_button_0.gridy = 1;
			gbc_button_0.weightx = 1.0;
			gbc_button_0.weighty = 1.0;
			panel.add(getButton_0(), gbc_button_0);
			GridBagConstraints gbc_button_2 = new GridBagConstraints();
			gbc_button_2.fill = GridBagConstraints.BOTH;
			gbc_button_2.insets = new Insets(0, 0, 5, 5);
			gbc_button_2.gridx = 2;
			gbc_button_2.gridy = 2;
			gbc_button_2.weightx = 1.0;
			gbc_button_2.weighty = 1.0;
			panel.add(getButton_2(), gbc_button_2);
			GridBagConstraints gbc_button_5 = new GridBagConstraints();
			gbc_button_5.fill = GridBagConstraints.BOTH;
			gbc_button_5.insets = new Insets(0, 0, 5, 5);
			gbc_button_5.gridx = 3;
			gbc_button_5.gridy = 2;
			gbc_button_5.weightx = 1.0;
			gbc_button_5.weighty = 1.0;
			panel.add(getButton_5(), gbc_button_5);
			GridBagConstraints gbc_button_8 = new GridBagConstraints();
			gbc_button_8.fill = GridBagConstraints.BOTH;
			gbc_button_8.insets = new Insets(0, 0, 5, 5);
			gbc_button_8.gridx = 4;
			gbc_button_8.gridy = 2;
			gbc_button_8.weightx = 1.0;
			gbc_button_8.weighty = 1.0;
			panel.add(getButton_8(), gbc_button_8);
			GridBagConstraints gbc_button_11 = new GridBagConstraints();
			gbc_button_11.fill = GridBagConstraints.BOTH;
			gbc_button_11.insets = new Insets(0, 0, 5, 5);
			gbc_button_11.gridx = 5;
			gbc_button_11.gridy = 2;
			gbc_button_11.weightx = 1.0;
			gbc_button_11.weighty = 1.0;
			panel.add(getButton_11(), gbc_button_11);
			GridBagConstraints gbc_button_14 = new GridBagConstraints();
			gbc_button_14.fill = GridBagConstraints.BOTH;
			gbc_button_14.insets = new Insets(0, 0, 5, 5);
			gbc_button_14.gridx = 6;
			gbc_button_14.gridy = 2;
			gbc_button_14.weightx = 1.0;
			gbc_button_14.weighty = 1.0;
			panel.add(getButton_14(), gbc_button_14);
			GridBagConstraints gbc_button_17 = new GridBagConstraints();
			gbc_button_17.fill = GridBagConstraints.BOTH;
			gbc_button_17.insets = new Insets(0, 0, 5, 5);
			gbc_button_17.gridx = 7;
			gbc_button_17.gridy = 2;
			gbc_button_17.weightx = 1.0;
			gbc_button_17.weighty = 1.0;
			panel.add(getButton_17(), gbc_button_17);
			GridBagConstraints gbc_button_20 = new GridBagConstraints();
			gbc_button_20.fill = GridBagConstraints.BOTH;
			gbc_button_20.insets = new Insets(0, 0, 5, 5);
			gbc_button_20.gridx = 8;
			gbc_button_20.gridy = 2;
			gbc_button_20.weightx = 1.0;
			gbc_button_20.weighty = 1.0;
			panel.add(getButton_20(), gbc_button_20);
			GridBagConstraints gbc_button_23 = new GridBagConstraints();
			gbc_button_23.fill = GridBagConstraints.BOTH;
			gbc_button_23.insets = new Insets(0, 0, 5, 5);
			gbc_button_23.gridx = 9;
			gbc_button_23.gridy = 2;
			gbc_button_23.weightx = 1.0;
			gbc_button_23.weighty = 1.0;
			panel.add(getButton_23(), gbc_button_23);
			GridBagConstraints gbc_button_26 = new GridBagConstraints();
			gbc_button_26.fill = GridBagConstraints.BOTH;
			gbc_button_26.insets = new Insets(0, 0, 5, 5);
			gbc_button_26.gridx = 10;
			gbc_button_26.gridy = 2;
			gbc_button_26.weightx = 1.0;
			gbc_button_26.weighty = 1.0;
			panel.add(getButton_26(), gbc_button_26);
			GridBagConstraints gbc_button_29 = new GridBagConstraints();
			gbc_button_29.fill = GridBagConstraints.BOTH;
			gbc_button_29.insets = new Insets(0, 0, 5, 5);
			gbc_button_29.gridx = 11;
			gbc_button_29.gridy = 2;
			gbc_button_29.weightx = 1.0;
			gbc_button_29.weighty = 1.0;
			panel.add(getButton_29(), gbc_button_29);
			GridBagConstraints gbc_button_32 = new GridBagConstraints();
			gbc_button_32.fill = GridBagConstraints.BOTH;
			gbc_button_32.insets = new Insets(0, 0, 5, 5);
			gbc_button_32.gridx = 12;
			gbc_button_32.gridy = 2;
			gbc_button_32.weightx = 1.0;
			gbc_button_32.weighty = 1.0;
			panel.add(getButton_32(), gbc_button_32);
			GridBagConstraints gbc_button_35 = new GridBagConstraints();
			gbc_button_35.fill = GridBagConstraints.BOTH;
			gbc_button_35.insets = new Insets(0, 0, 5, 5);
			gbc_button_35.gridx = 13;
			gbc_button_35.gridy = 2;
			gbc_button_35.weightx = 1.0;
			gbc_button_35.weighty = 1.0;
			panel.add(getButton_35(), gbc_button_35);
			GridBagConstraints gbc_btnC2 = new GridBagConstraints();
			gbc_btnC2.fill = GridBagConstraints.BOTH;
			gbc_btnC2.insets = new Insets(0, 0, 5, 0);
			gbc_btnC2.gridx = 14;
			gbc_btnC2.gridy = 2;
			gbc_btnC2.weightx = 1.0;
			gbc_btnC2.weighty = 1.0;
			panel.add(getBtnC2(), gbc_btnC2);
			GridBagConstraints gbc_button_1 = new GridBagConstraints();
			gbc_button_1.fill = GridBagConstraints.BOTH;
			gbc_button_1.insets = new Insets(0, 0, 5, 5);
			gbc_button_1.gridx = 2;
			gbc_button_1.gridy = 3;
			gbc_button_1.weightx = 1.0;
			gbc_button_1.weighty = 1.0;
			panel.add(getButton_1(), gbc_button_1);
			GridBagConstraints gbc_button_4 = new GridBagConstraints();
			gbc_button_4.fill = GridBagConstraints.BOTH;
			gbc_button_4.insets = new Insets(0, 0, 5, 5);
			gbc_button_4.gridx = 3;
			gbc_button_4.gridy = 3;
			gbc_button_4.weightx = 1.0;
			gbc_button_4.weighty = 1.0;
			panel.add(getButton_4(), gbc_button_4);
			GridBagConstraints gbc_button_7 = new GridBagConstraints();
			gbc_button_7.fill = GridBagConstraints.BOTH;
			gbc_button_7.insets = new Insets(0, 0, 5, 5);
			gbc_button_7.gridx = 4;
			gbc_button_7.gridy = 3;
			gbc_button_7.weightx = 1.0;
			gbc_button_7.weighty = 1.0;
			panel.add(getButton_7(), gbc_button_7);
			GridBagConstraints gbc_button_10 = new GridBagConstraints();
			gbc_button_10.fill = GridBagConstraints.BOTH;
			gbc_button_10.insets = new Insets(0, 0, 5, 5);
			gbc_button_10.gridx = 5;
			gbc_button_10.gridy = 3;
			gbc_button_10.weightx = 1.0;
			gbc_button_10.weighty = 1.0;
			panel.add(getButton_10(), gbc_button_10);
			GridBagConstraints gbc_button_13 = new GridBagConstraints();
			gbc_button_13.fill = GridBagConstraints.BOTH;
			gbc_button_13.insets = new Insets(0, 0, 5, 5);
			gbc_button_13.gridx = 6;
			gbc_button_13.gridy = 3;
			gbc_button_13.weightx = 1.0;
			gbc_button_13.weighty = 1.0;
			panel.add(getButton_13(), gbc_button_13);
			GridBagConstraints gbc_button_16 = new GridBagConstraints();
			gbc_button_16.fill = GridBagConstraints.BOTH;
			gbc_button_16.insets = new Insets(0, 0, 5, 5);
			gbc_button_16.gridx = 7;
			gbc_button_16.gridy = 3;
			gbc_button_16.weightx = 1.0;
			gbc_button_16.weighty = 1.0;
			panel.add(getButton_16(), gbc_button_16);
			GridBagConstraints gbc_button_19 = new GridBagConstraints();
			gbc_button_19.fill = GridBagConstraints.BOTH;
			gbc_button_19.insets = new Insets(0, 0, 5, 5);
			gbc_button_19.gridx = 8;
			gbc_button_19.gridy = 3;
			gbc_button_19.weightx = 1.0;
			gbc_button_19.weighty = 1.0;
			panel.add(getButton_19(), gbc_button_19);
			GridBagConstraints gbc_button_22 = new GridBagConstraints();
			gbc_button_22.fill = GridBagConstraints.BOTH;
			gbc_button_22.insets = new Insets(0, 0, 5, 5);
			gbc_button_22.gridx = 9;
			gbc_button_22.gridy = 3;
			gbc_button_22.weightx = 1.0;
			gbc_button_22.weighty = 1.0;
			panel.add(getButton_22(), gbc_button_22);
			GridBagConstraints gbc_button_25 = new GridBagConstraints();
			gbc_button_25.fill = GridBagConstraints.BOTH;
			gbc_button_25.insets = new Insets(0, 0, 5, 5);
			gbc_button_25.gridx = 10;
			gbc_button_25.gridy = 3;
			gbc_button_25.weightx = 1.0;
			gbc_button_25.weighty = 1.0;
			panel.add(getButton_25(), gbc_button_25);
			GridBagConstraints gbc_button_28 = new GridBagConstraints();
			gbc_button_28.fill = GridBagConstraints.BOTH;
			gbc_button_28.insets = new Insets(0, 0, 5, 5);
			gbc_button_28.gridx = 11;
			gbc_button_28.gridy = 3;
			gbc_button_28.weightx = 1.0;
			gbc_button_28.weighty = 1.0;
			panel.add(getButton_28(), gbc_button_28);
			GridBagConstraints gbc_button_31 = new GridBagConstraints();
			gbc_button_31.fill = GridBagConstraints.BOTH;
			gbc_button_31.insets = new Insets(0, 0, 5, 5);
			gbc_button_31.gridx = 12;
			gbc_button_31.gridy = 3;
			gbc_button_31.weightx = 1.0;
			gbc_button_31.weighty = 1.0;
			panel.add(getButton_31(), gbc_button_31);
			GridBagConstraints gbc_button_34 = new GridBagConstraints();
			gbc_button_34.fill = GridBagConstraints.BOTH;
			gbc_button_34.insets = new Insets(0, 0, 5, 5);
			gbc_button_34.gridx = 13;
			gbc_button_34.gridy = 3;
			gbc_button_34.weightx = 1.0;
			gbc_button_34.weighty = 1.0;
			panel.add(getButton_34(), gbc_button_34);
			GridBagConstraints gbc_btnC3 = new GridBagConstraints();
			gbc_btnC3.fill = GridBagConstraints.BOTH;
			gbc_btnC3.insets = new Insets(0, 0, 5, 0);
			gbc_btnC3.gridx = 14;
			gbc_btnC3.gridy = 3;
			gbc_btnC3.weightx = 1.0;
			gbc_btnC3.weighty = 1.0;
			panel.add(getBtnC3(), gbc_btnC3);
			GridBagConstraints gbc_btnDocena_1 = new GridBagConstraints();
			gbc_btnDocena_1.fill = GridBagConstraints.BOTH;
			gbc_btnDocena_1.gridwidth = 4;
			gbc_btnDocena_1.insets = new Insets(0, 0, 5, 5);
			gbc_btnDocena_1.gridx = 2;
			gbc_btnDocena_1.gridy = 4;
			gbc_btnDocena_1.weightx = 1.0;
			gbc_btnDocena_1.weighty = 1.0;
			panel.add(getBtnDocena_1(), gbc_btnDocena_1);
			GridBagConstraints gbc_btnDocena_2 = new GridBagConstraints();
			gbc_btnDocena_2.fill = GridBagConstraints.BOTH;
			gbc_btnDocena_2.gridwidth = 4;
			gbc_btnDocena_2.insets = new Insets(0, 0, 5, 5);
			gbc_btnDocena_2.gridx = 6;
			gbc_btnDocena_2.gridy = 4;
			gbc_btnDocena_2.weightx = 1.0;
			gbc_btnDocena_2.weighty = 1.0;
			panel.add(getBtnDocena_2(), gbc_btnDocena_2);
			GridBagConstraints gbc_btnDocena_3 = new GridBagConstraints();
			gbc_btnDocena_3.fill = GridBagConstraints.BOTH;
			gbc_btnDocena_3.gridwidth = 4;
			gbc_btnDocena_3.insets = new Insets(0, 0, 5, 5);
			gbc_btnDocena_3.gridx = 10;
			gbc_btnDocena_3.gridy = 4;
			gbc_btnDocena_3.weightx = 1.0;
			gbc_btnDocena_3.weighty = 1.0;
			panel.add(getBtnDocena_3(), gbc_btnDocena_3);
			GridBagConstraints gbc_button_1_18 = new GridBagConstraints();
			gbc_button_1_18.fill = GridBagConstraints.BOTH;
			gbc_button_1_18.gridwidth = 2;
			gbc_button_1_18.insets = new Insets(0, 0, 0, 5);
			gbc_button_1_18.gridx = 2;
			gbc_button_1_18.gridy = 5;
			gbc_button_1_18.weightx = 1.0;
			gbc_button_1_18.weighty = 1.0;
			panel.add(getButton_1_18(), gbc_button_1_18);
			GridBagConstraints gbc_btnPar = new GridBagConstraints();
			gbc_btnPar.fill = GridBagConstraints.BOTH;
			gbc_btnPar.gridwidth = 2;
			gbc_btnPar.insets = new Insets(0, 0, 0, 5);
			gbc_btnPar.gridx = 4;
			gbc_btnPar.gridy = 5;
			gbc_btnPar.weightx = 1.0;
			gbc_btnPar.weighty = 1.0;
			panel.add(getBtnPar(), gbc_btnPar);
			GridBagConstraints gbc_btnRojo = new GridBagConstraints();
			gbc_btnRojo.fill = GridBagConstraints.BOTH;
			gbc_btnRojo.gridwidth = 2;
			gbc_btnRojo.insets = new Insets(0, 0, 0, 5);
			gbc_btnRojo.gridx = 6;
			gbc_btnRojo.gridy = 5;
			gbc_btnRojo.weightx = 1.0;
			gbc_btnRojo.weighty = 1.0;
			panel.add(getBtnRojo(), gbc_btnRojo);
			GridBagConstraints gbc_btnNegro = new GridBagConstraints();
			gbc_btnNegro.fill = GridBagConstraints.BOTH;
			gbc_btnNegro.gridwidth = 2;
			gbc_btnNegro.insets = new Insets(0, 0, 0, 5);
			gbc_btnNegro.gridx = 8;
			gbc_btnNegro.gridy = 5;
			gbc_btnNegro.weightx = 1.0;
			gbc_btnNegro.weighty = 1.0;
			panel.add(getBtnNegro(), gbc_btnNegro);
			GridBagConstraints gbc_btnImpar = new GridBagConstraints();
			gbc_btnImpar.fill = GridBagConstraints.BOTH;
			gbc_btnImpar.gridwidth = 2;
			gbc_btnImpar.insets = new Insets(0, 0, 0, 5);
			gbc_btnImpar.gridx = 10;
			gbc_btnImpar.gridy = 5;
			gbc_btnImpar.weightx = 1.0;
			gbc_btnImpar.weighty = 1.0;
			panel.add(getBtnImpar(), gbc_btnImpar);
			GridBagConstraints gbc_button_19_36 = new GridBagConstraints();
			gbc_button_19_36.fill = GridBagConstraints.BOTH;
			gbc_button_19_36.gridwidth = 2;
			gbc_button_19_36.insets = new Insets(0, 0, 0, 5);
			gbc_button_19_36.gridx = 12;
			gbc_button_19_36.gridy = 5;
			gbc_button_19_36.weightx = 1.0;
			gbc_btnDocena_1.weighty = 1.0;
			panel.add(getButton_19_36(), gbc_button_19_36);
		}
		return panel;
	}

		private JButton getButton_0() {
			if (button_0 == null) {
				button_0 = new JButton("0");
				button_0.setBackground(Color.LIGHT_GRAY);
				button_0.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_0.setName("0"); //para reiniciar el texto al retirarse
				button_0.setPreferredSize(new Dimension(33, 60));
				button_0.setEnabled(false);
				button_0.setActionCommand("0"); //para usar en la logica
				button_0.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_0;
		}

		private JButton getButton_1() {
			if (button_1 == null) {
				button_1 = new JButton("1");
				button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_1.setName("1");
				button_1.setBackground(new Color(255, 0, 0));
				// para que no se vuelvan tan locos con la imagen
				//button_1.setPreferredSize(new Dimension(33, 60));
				button_1.setEnabled(false);
				button_1.setActionCommand("1");
				button_1.setForeground(Color.white);
				button_1.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_1;
		}

		private JButton getButton_2() {
			if (button_2 == null) {
				button_2 = new JButton("2");
				button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_2.setName("2");
				button_2.setBackground(new Color(0, 0, 0));
				//button_2.setPreferredSize(new Dimension(33, 60));
				button_2.setEnabled(false);
				button_2.setActionCommand("2");
				button_2.setForeground(Color.white);
				button_2.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_2;
		}

		private JButton getButton_3() {
			if (button_3 == null) {
				button_3 = new JButton("3");
				button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_3.setName("3");
				button_3.setBackground(new Color(255, 0, 0));
				//button_3.setPreferredSize(new Dimension(33, 60));
				button_3.setEnabled(false);
				button_3.setActionCommand("3");
				button_3.setForeground(Color.white);
				button_3.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_3;
		}

		private JButton getButton_4() {
			if (button_4 == null) {
				button_4 = new JButton("4");
				button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_4.setName("4");
				button_4.setBackground(new Color(0, 0, 0));
				//button_4.setPreferredSize(new Dimension(33, 60));
				button_4.setEnabled(false);
				button_4.setActionCommand("4");
				button_4.setForeground(Color.white);
				button_4.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_4;
		}

		private JButton getButton_5() {
			if (button_5 == null) {
				button_5 = new JButton("5");
				button_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_5.setName("5");
				button_5.setBackground(new Color(255, 0, 0));
				//button_5.setPreferredSize(new Dimension(33, 60));
				button_5.setEnabled(false);
				button_5.setActionCommand("5");
				button_5.setForeground(Color.white);
				button_5.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_5;
		}

		private JButton getButton_6() {
			if (button_6 == null) {
				button_6 = new JButton("6");
				button_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_6.setName("6");
				button_6.setBackground(new Color(0, 0, 0));
				//button_6.setPreferredSize(new Dimension(33, 60));
				button_6.setEnabled(false);
				button_6.setActionCommand("6");
				button_6.setForeground(Color.white);
				button_6.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_6;
		}

		private JButton getButton_7() {
			if (button_7 == null) {
				button_7 = new JButton("7");
				button_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_7.setName("7");
				button_7.setBackground(new Color(255, 0, 0));
				//button_7.setPreferredSize(new Dimension(33, 60));
				button_7.setEnabled(false);
				button_7.setActionCommand("7");
				button_7.setForeground(Color.white);
				button_7.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_7;
		}

		private JButton getButton_8() {
			if (button_8 == null) {
				button_8 = new JButton("8");
				button_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_8.setName("8");
				button_8.setBackground(new Color(0, 0, 0));
				//button_8.setPreferredSize(new Dimension(33, 60));
				button_8.setEnabled(false);
				button_8.setActionCommand("8");
				button_8.setForeground(Color.white);
				button_8.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_8;
		}

		private JButton getButton_9() {
			if (button_9 == null) {
				button_9 = new JButton("9");
				button_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_9.setName("9");
				button_9.setBackground(new Color(255, 0, 0));
				//button_9.setPreferredSize(new Dimension(33, 60));
				button_9.setEnabled(false);
				button_9.setActionCommand("9");
				button_9.setForeground(Color.white);
				button_9.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_9;
		}

		private JButton getButton_10() {
			if (button_10 == null) {
				button_10 = new JButton("10");
				button_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_10.setName("10");
				button_10.setBackground(new Color(0, 0, 0));
				//button_10.setPreferredSize(new Dimension(33, 60));
				button_10.setEnabled(false);
				button_10.setActionCommand("10");
				button_10.setForeground(Color.white);
				button_10.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_10;
		}

		private JButton getButton_11() {
			if (button_11 == null) {
				button_11 = new JButton("11");
				button_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_11.setName("11");
				button_11.setBackground(new Color(0, 0, 0));
				//button_11.setPreferredSize(new Dimension(33, 60));
				button_11.setEnabled(false);
				button_11.setActionCommand("11");
				button_11.setForeground(Color.white);
				button_11.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_11;
		}

		private JButton getButton_12() {
			if (button_12 == null) {
				button_12 = new JButton("12");
				button_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_12.setName("12");
				button_12.setBackground(new Color(255, 0, 0));
				//button_12.setPreferredSize(new Dimension(33, 60));
				button_12.setEnabled(false);
				button_12.setActionCommand("12");
				button_12.setForeground(Color.white);
				button_12.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_12;
		}

		private JButton getButton_13() {
			if (button_13 == null) {
				button_13 = new JButton("13");
				button_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_13.setName("13");
				button_13.setBackground(new Color(0, 0, 0));
				//button_13.setPreferredSize(new Dimension(33, 60));
				button_13.setEnabled(false);
				button_13.setActionCommand("13");
				button_13.setForeground(Color.white);
				button_13.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_13;
		}

		private JButton getButton_14() {
			if (button_14 == null) {
				button_14 = new JButton("14");
				button_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_14.setName("14");
				button_14.setBackground(new Color(255, 0, 0));
				//button_14.setPreferredSize(new Dimension(33, 60));
				button_14.setEnabled(false);
				button_14.setActionCommand("14");
				button_14.setForeground(Color.white);
				button_14.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_14;
		}

		private JButton getButton_15() {
			if (button_15 == null) {
				button_15 = new JButton("15");
				button_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_15.setName("15");
				button_15.setBackground(new Color(0, 0, 0));
				//button_15.setPreferredSize(new Dimension(33, 60));
				button_15.setEnabled(false);
				button_15.setActionCommand("15");
				button_15.setForeground(Color.white);
				button_15.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_15;
		}

		private JButton getButton_16() {
			if (button_16 == null) {
				button_16 = new JButton("16");
				button_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_16.setName("16");
				button_16.setBackground(new Color(255, 0, 0));
				//button_16.setPreferredSize(new Dimension(33, 60));
				button_16.setEnabled(false);
				button_16.setActionCommand("16");
				button_16.setForeground(Color.white);
				button_16.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_16;
		}

		private JButton getButton_17() {
			if (button_17 == null) {
				button_17 = new JButton("17");
				button_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_17.setName("17");
				button_17.setBackground(new Color(0, 0, 0));
				//button_17.setPreferredSize(new Dimension(33, 60));
				button_17.setEnabled(false);
				button_17.setActionCommand("17");
				button_17.setForeground(Color.white);
				button_17.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_17;
		}

		private JButton getButton_18() {
			if (button_18 == null) {
				button_18 = new JButton("18");
				button_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_18.setName("18");
				button_18.setBackground(new Color(255, 0, 0));
				//button_18.setPreferredSize(new Dimension(33, 60));
				button_18.setEnabled(false);
				button_18.setActionCommand("18");
				button_18.setForeground(Color.white);
				button_18.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_18;
		}

		private JButton getButton_19() {
			if (button_19 == null) {
				button_19 = new JButton("19");
				button_19.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_19.setName("19");
				button_19.setBackground(new Color(255, 0, 0));
				//button_19.setPreferredSize(new Dimension(33, 60));
				button_19.setEnabled(false);
				button_19.setActionCommand("19");
				button_19.setForeground(Color.white);
				button_19.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_19;
		}

		private JButton getButton_20() {
			if (button_20 == null) {
				button_20 = new JButton("20");
				button_20.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_20.setName("20");
				button_20.setBackground(new Color(0, 0, 0));
				//button_20.setPreferredSize(new Dimension(33, 60));
				button_20.setEnabled(false);
				button_20.setActionCommand("20");
				button_20.setForeground(Color.white);
				button_20.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_20;
		}

		private JButton getButton_21() {
			if (button_21 == null) {
				button_21 = new JButton("21");
				button_21.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_21.setName("21");
				button_21.setBackground(new Color(255, 0, 0));
				//button_21.setPreferredSize(new Dimension(33, 60));
				button_21.setEnabled(false);
				button_21.setActionCommand("21");			
				button_21.setForeground(Color.white);
				button_21.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_21;
		}

		private JButton getButton_22() {
			if (button_22 == null) {
				button_22 = new JButton("22");
				button_22.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_22.setName("22");
				button_22.setBackground(new Color(0, 0, 0));
				//button_22.setPreferredSize(new Dimension(33, 60));
				button_22.setEnabled(false);
				button_22.setActionCommand("22");
				button_22.setForeground(Color.white);
				button_22.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_22;
		}

		private JButton getButton_23() {
			if (button_23 == null) {
				button_23 = new JButton("23");
				button_23.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_23.setName("23");
				button_23.setBackground(new Color(255, 0, 0));
				//button_23.setPreferredSize(new Dimension(33, 60));
				button_23.setEnabled(false);
				button_23.setActionCommand("23");
				button_23.setForeground(Color.white);
				button_23.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_23;
		}

		private JButton getButton_24() {
			if (button_24 == null) {
				button_24 = new JButton("24");
				button_24.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_24.setName("24");
				button_24.setBackground(new Color(0, 0, 0));
				//button_24.setPreferredSize(new Dimension(33, 60));
				button_24.setEnabled(false);
				button_24.setActionCommand("24");
				button_24.setForeground(Color.white);
				button_24.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_24;
		}

		private JButton getButton_25() {
			if (button_25 == null) {
				button_25 = new JButton("25");
				button_25.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_25.setName("25");
				button_25.setBackground(new Color(255, 0, 0));
				//button_25.setPreferredSize(new Dimension(33, 60));
				button_25.setEnabled(false);
				button_25.setActionCommand("25");
				button_25.setForeground(Color.white);
				button_25.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_25;
		}

		private JButton getButton_26() {
			if (button_26 == null) {
				button_26 = new JButton("26");
				button_26.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_26.setName("26");
				button_26.setBackground(new Color(0, 0, 0));
				//button_26.setPreferredSize(new Dimension(33, 60));
				button_26.setEnabled(false);
				button_26.setActionCommand("26");
				button_26.setForeground(Color.white);
				button_26.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_26;
		}

		private JButton getButton_27() {
			if (button_27 == null) {
				button_27 = new JButton("27");
				button_27.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_27.setName("27");
				button_27.setBackground(new Color(255, 0, 0));
				//button_27.setPreferredSize(new Dimension(33, 60));
				button_27.setEnabled(false);
				button_27.setActionCommand("27");
				button_27.setForeground(Color.white);
				button_27.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_27;
		}

		private JButton getButton_28() {
			if (button_28 == null) {
				button_28 = new JButton("28");
				button_28.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_28.setName("28");
				button_28.setBackground(new Color(0, 0, 0));
				//button_28.setPreferredSize(new Dimension(33, 60));
				button_28.setEnabled(false);
				button_28.setActionCommand("28");
				button_28.setForeground(Color.white);
				button_28.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_28;
		}

		private JButton getButton_29() {
			if (button_29 == null) {
				button_29 = new JButton("29");
				button_29.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_29.setName("29");
				button_29.setBackground(new Color(0, 0, 0));
				//button_29.setPreferredSize(new Dimension(33, 60));
				button_29.setEnabled(false);
				button_29.setActionCommand("29");
				button_29.setForeground(Color.white);
				button_29.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_29;
		}

		private JButton getButton_30() {
			if (button_30 == null) {
				button_30 = new JButton("30");
				button_30.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_30.setName("30");
				button_30.setBackground(new Color(255, 0, 0));
				//button_30.setPreferredSize(new Dimension(33, 60));
				button_30.setEnabled(false);
				button_30.setActionCommand("30");
				button_30.setForeground(Color.white);
				button_30.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_30;
		}

		private JButton getButton_31() {
			if (button_31 == null) {
				button_31 = new JButton("31");
				button_31.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_31.setName("31");
				button_31.setBackground(new Color(0, 0, 0));
				//button_31.setPreferredSize(new Dimension(33, 60));
				button_31.setEnabled(false);
				button_31.setActionCommand("31");
				button_31.setForeground(Color.white);
				button_31.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_31;
		}

		private JButton getButton_32() {
			if (button_32 == null) {
				button_32 = new JButton("32");
				button_32.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_32.setName("32");
				button_32.setBackground(new Color(255, 0, 0));
				//button_32.setPreferredSize(new Dimension(33, 60));
				button_32.setEnabled(false);
				button_32.setActionCommand("32");
				button_32.setForeground(Color.white);
				button_32.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_32;
		}

		private JButton getButton_33() {
			if (button_33 == null) {
				button_33 = new JButton("33");
				button_33.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_33.setName("33");
				button_33.setBackground(new Color(0, 0, 0));
				//button_33.setPreferredSize(new Dimension(33, 60));
				button_33.setEnabled(false);
				button_33.setActionCommand("33");
				button_33.setForeground(Color.white);
				button_33.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_33;
		}

		private JButton getButton_34() {
			if (button_34 == null) {
				button_34 = new JButton("34");
				button_34.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_34.setName("34");
				button_34.setBackground(new Color(255, 0, 0));
				//button_34.setPreferredSize(new Dimension(33, 60));
				button_34.setEnabled(false);
				button_34.setActionCommand("34");
				button_34.setForeground(Color.white);
				button_34.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_34;
		}

		private JButton getButton_35() {
			if (button_35 == null) {
				button_35 = new JButton("35");
				button_35.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_35.setName("35");
				button_35.setBackground(new Color(0, 0, 0));
				//button_35.setPreferredSize(new Dimension(33, 60));
				button_35.setEnabled(false);
				button_35.setActionCommand("35");
				button_35.setForeground(Color.white);
				button_35.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_35;
		}

		private JButton getButton_36() {
			if (button_36 == null) {
				button_36 = new JButton("36");
				button_36.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_36.setName("36");
				button_36.setBackground(new Color(255, 0, 0));
				//button_36.setPreferredSize(new Dimension(33, 60));
				button_36.setEnabled(false);
				button_36.setActionCommand("36");
				button_36.setForeground(Color.white);
				button_36.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_36;
		}

		private JButton getBtnC1() {
			if (btnC1 == null) {
				btnC1 = new JButton("C1");
				btnC1.setBackground(Color.LIGHT_GRAY);
				btnC1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnC1.setName("C1");
				btnC1.setEnabled(false);
				btnC1.setActionCommand("C1");
				btnC1.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnC1;
		}

		private JButton getBtnC2() {
			if (btnC2 == null) {
				btnC2 = new JButton("C2");
				btnC2.setBackground(Color.LIGHT_GRAY);
				btnC2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnC2.setName("C2");
				btnC2.setEnabled(false);
				btnC2.setActionCommand("C2");
				btnC2.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnC2;
		}

		private JButton getBtnC3() {
			if (btnC3 == null) {
				btnC3 = new JButton("C3");
				btnC3.setBackground(Color.LIGHT_GRAY);
				btnC3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnC3.setName("C3");
				btnC3.setEnabled(false);
				btnC3.setActionCommand("C3");
				btnC3.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnC3;
		}

		private JButton getBtnDocena_1() {
			if (btnDocena_1 == null) {
				btnDocena_1 = new JButton("DOC1");
				btnDocena_1.setBackground(Color.LIGHT_GRAY);
				btnDocena_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnDocena_1.setName("DOC1");
				btnDocena_1.setEnabled(false);
				btnDocena_1.setActionCommand("DOC1");
				btnDocena_1.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnDocena_1;
		}

		private JButton getBtnDocena_2() {
			if (btnDocena_2 == null) {
				btnDocena_2 = new JButton("DOC2");
				btnDocena_2.setBackground(Color.LIGHT_GRAY);
				btnDocena_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnDocena_2.setName("DOC2");
				btnDocena_2.setEnabled(false);
				btnDocena_2.setActionCommand("DOC2");
				btnDocena_2.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnDocena_2;
		}

		private JButton getBtnDocena_3() {
			if (btnDocena_3 == null) {
				btnDocena_3 = new JButton("DOC3");
				btnDocena_3.setBackground(Color.LIGHT_GRAY);
				btnDocena_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnDocena_3.setName("DOC3");
				btnDocena_3.setEnabled(false);
				btnDocena_3.setActionCommand("DOC3");
				btnDocena_3.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnDocena_3;
		}

		private JButton getButton_1_18() {
			if (button_1_18 == null) {
				button_1_18 = new JButton("Fallo");
				button_1_18.setBackground(Color.LIGHT_GRAY);
				button_1_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_1_18.setName("Fallo");
				button_1_18.setEnabled(false);
				button_1_18.setActionCommand("FAIL");
				button_1_18.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_1_18;
		}

		private JButton getBtnPar() {
			if (btnPar == null) {
				btnPar = new JButton("Par");
				btnPar.setBackground(Color.LIGHT_GRAY);
				btnPar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnPar.setName("Par");
				btnPar.setEnabled(false);
				btnPar.setActionCommand("EVEN");
				btnPar.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnPar;
		}

		private JButton getBtnRojo() {
			if (btnRojo == null) {
				btnRojo = new JButton("Rojo");
				btnRojo.setBackground(Color.LIGHT_GRAY);
				btnRojo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnRojo.setName("Rojo");
				btnRojo.setEnabled(false);
				btnRojo.setActionCommand("RED");
				btnRojo.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnRojo;
		}

		private JButton getBtnNegro() {
			if (btnNegro == null) {
				btnNegro = new JButton("Negro");
				btnNegro.setBackground(Color.LIGHT_GRAY);
				btnNegro.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnNegro.setName("Negro");
				btnNegro.setEnabled(false);
				btnNegro.setActionCommand("BLACK");
				btnNegro.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnNegro;
		}

		private JButton getBtnImpar() {
			if (btnImpar == null) {
				btnImpar = new JButton("Impar");
				btnImpar.setBackground(Color.LIGHT_GRAY);
				btnImpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				btnImpar.setName("Impar");
				btnImpar.setEnabled(false);
				btnImpar.setActionCommand("ODD");
				btnImpar.setTransferHandler(new TransferHandler("foreground"));
			}
			return btnImpar;
		}

		private JButton getButton_19_36() {
			if (button_19_36 == null) {
				button_19_36 = new JButton("Paso");
				button_19_36.setBackground(Color.LIGHT_GRAY);
				button_19_36.setFont(new Font("Tahoma", Font.PLAIN, 12));
				button_19_36.setName("Paso");
				button_19_36.setEnabled(false);
				button_19_36.setActionCommand("PASS");
				button_19_36.setTransferHandler(new TransferHandler("foreground"));
			}
			return button_19_36;
		}
	}
