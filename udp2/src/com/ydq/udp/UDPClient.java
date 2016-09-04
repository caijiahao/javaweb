package com.ydq.udp;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

import com.ydq.util.UDPUtils;

public class UDPClient {

	private String SEND_FILE_PATH = "F:/1.rar";
	private String ipString;
	private int port;
	int sendCount = 0;
	int lostCount = 0;

	public UDPClient(String ipString, int port) {
		this.ipString = ipString;
		this.port = port;
	}

	public void send() {

		byte[] buf = new byte[UDPUtils.BUFFER_SIZE];
		byte[] receiveBuf = new byte[1024];

		RandomAccessFile accessFile = null;
		DatagramPacket dpk = null;
		DatagramSocket dsk = null;
		int readSize = -1;
		try {
			// 璇诲彇鏂囦欢
			accessFile = new RandomAccessFile(SEND_FILE_PATH, "r");
			// 瀹氫箟DatagramPacket璁惧畾鍙戦�佺殑鐩殑IP鍙婄鍙�
			dpk = new DatagramPacket(buf, buf.length,
					InetAddress.getByName(ipString), port);
			// 瀹氫箟DatagramSocket
			dsk = new DatagramSocket(UDPUtils.PORT,
					InetAddress.getByName("localhost"));
			// 璁剧疆瓒呮椂
			dsk.setSoTimeout(100000);
			// 寮�濮嬩紶杈撴枃浠�
			int i=0;
			while (i<2) {
				// 灏嗚鍏ョ紦鍐插尯鐨勬暟鎹缃埌dpk涓�
				buf = "funck".getBytes();
				dpk.setData(buf, 0, buf.length);
				// 鍙戦�佹暟鎹寘
				dsk.send(dpk);
				// 璁板綍鍙戦�佹暟鎹寘涓暟
				sendCount++;
				i++;
				// 绛夊緟鎺ユ敹绔繑鍥炵殑纭淇℃伅
				while (true) {
					// 璁剧疆鎺ユ敹杩斿洖鏁版嵁鐨勭紦鍐插尯涓簉eceiveBuf
					dpk.setData(receiveBuf, 0, receiveBuf.length);
					try {
						dsk.receive(dpk);
						// 纭鎺ユ敹绔繑鍥炵殑纭淇℃伅
						if (!UDPUtils.isEqualsByteArray(UDPUtils.successData,
								receiveBuf, dpk.getLength())) {
							// 濡傛灉涓嶆槸纭鎴愬姛鐨勪俊鎭垯閲嶅彂鏁版嵁鍖�
							System.out.println("闈炵‘璁ゆ帴鏀舵垚鍔熶俊鍙凤紝姝ｅ湪閲嶅彂鏁版嵁鍖�...");
							dpk.setData(buf, 0, readSize);
							dsk.send(dpk);
							sendCount++;
							lostCount++;
						} else {
							// 纭鎺ユ敹鎴愬姛锛屾竻绌虹紦鍐插尯
							receiveBuf = new byte[1024];
							break;
						}
					} catch (SocketTimeoutException e) {
						// 鎺ユ敹瓒呮椂鍒欓噸鍙戞暟鎹寘
						System.out.println("绛夊緟瓒呮椂锛屾鍦ㄩ噸鍙戞暟鎹寘...");
						dpk.setData(buf, 0, readSize);
						dsk.send(dpk);
						sendCount++;
						lostCount++;
					}

				}
			}

			// 鎵�鏈夋暟鎹彂閫佹垚鍔熷悗鍚戞帴鏀剁鍙戝嚭淇″彿
			//System.out.println("client send exit message ....");
			dpk.setData(UDPUtils.exitData, 0, UDPUtils.exitData.length);
			dsk.send(dpk);
			dpk.setData(receiveBuf, 0, receiveBuf.length);
			int count = 0;
			while (count < 5) {
				try {
					dsk.receive(dpk);
					// 鑻ユ病鏀跺埌鎺ユ敹绔殑纭淇℃伅鍒欓噸鍙戜俊鍙�
					if (!UDPUtils.isEqualsByteArray(UDPUtils.exitData,
							receiveBuf, dpk.getLength())) {
						System.out.println("client Resend exit message ....");
						dsk.send(dpk);
						count++;
					} else {
						// 纭鎺ユ敹鎴愬姛锛屾竻绌虹紦鍐插尯
						receiveBuf = new byte[1024];
						break;
					}
				} catch (SocketTimeoutException e) {
					// 濡傛灉鎺ユ敹瓒呮椂鍒欓噸鍙戜俊鍙�
					System.out.println("client Resend exit message ....");
					dsk.send(dpk);
					count++;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (accessFile != null)
					accessFile.close();
				if (dsk != null)
					dsk.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int getSendCount() {
		return sendCount;
	}

	public void setSendCount(int sendCount) {
		this.sendCount = sendCount;
	}

	public int getLostCount() {
		return lostCount;
	}

	public void setLostCount(int lostCount) {
		this.lostCount = lostCount;
	}
}
