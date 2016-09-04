package com.ydq.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.ydq.udp.UDPClient;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JTextField jtf1, jtf2;
	private JLabel jl1, jl2, jl3, jl4, jl5, jl6;
	private JButton jb1;

	public MainFrame() {

		jl1 = new JLabel("目的IP：");
		jl1.setBounds(10, 10, 50, 30);
		jtf1 = new JTextField();
		jtf1.setBounds(10, 40, 150, 30);

		jl2 = new JLabel("目的端口：");
		jl2.setBounds(10, 90, 80, 30);
		jtf2 = new JTextField();
		jtf2.setBounds(10, 120, 90, 30);

		jb1 = new JButton("发送数据包");
		jb1.setBounds(150, 170, 100, 30);
		jb1.addActionListener(new jb1ActionListener());

		jl3 = new JLabel("已发送的数据包个数");
		jl3.setBounds(250, 10, 150, 30);
		jl4 = new JLabel("0");
		jl4.setBounds(250, 40, 50, 30);
		jl5 = new JLabel("丢失的数据包个数");
		jl5.setBounds(250, 90, 150, 30);
		jl6 = new JLabel("0");
		jl6.setBounds(250, 120, 50, 30);

		// 设置MainJFrame属性
		this.setTitle("UDP收发数据包");
		this.setSize(400, 300);
		this.setLocation(400, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);

		this.add(jl1);
		this.add(jtf1);
		this.add(jl2);
		this.add(jtf2);
		this.add(jb1);
		this.add(jl3);
		this.add(jl4);
		this.add(jl5);
		this.add(jl6);

		this.setVisible(true);
	}

	class jb1ActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				UDPClient uc = new UDPClient(jtf1.getText(),
						Integer.parseInt(jtf2.getText()));
				uc.send();
				jl4.setText(Integer.toString(uc.getSendCount()));
				jl6.setText(Integer.toString(uc.getLostCount()));

			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "输入格式错误");
				return;
			}

		}

	}

	public static void main(String[] args){
		new MainFrame();

	}
}
