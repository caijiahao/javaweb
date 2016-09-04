package com.ydq.udp;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.ydq.util.UDPUtils;

public class UDPServer implements Runnable{

	private static final String SAVE_FILE_PATH = "G:/1.rar";

	public void receive(){

		byte[] buf = new byte[UDPUtils.BUFFER_SIZE];
		// 鎺ユ敹鏁版嵁鐨凞atagramPacket
		DatagramPacket dpk = null;
		// 鍙戦�佹暟鎹殑DatagramPacket
		DatagramPacket dpk1 = null;
		// 寤虹珛DatagramSocket
		DatagramSocket dsk = null;
		// 杈撳嚭娴�
		BufferedOutputStream bos = null;
		boolean flag = true;
		try {
			// 鎺ユ敹鏁版嵁鐨凞atagramPacket
			dpk = new DatagramPacket(buf, buf.length);
			// 寤虹珛DatagramSocket
			dsk = new DatagramSocket(UDPUtils.PORT + 1,
					InetAddress.getByName("localhost"));
			// 杈撳嚭娴�
			bos = new BufferedOutputStream(new FileOutputStream(
					SAVE_FILE_PATH));
			System.out.println("wait client ....");
			while (flag) {
				
				// 接受数据包
				dsk.receive(dpk);
				System.out.println(new String(buf  
	                    , 0 , dpk.getLength()));  
				
				int flushSize = 0;
				// 鍒ゆ柇鏄惁鏄彂閫佺浼犳潵鐨勯��鍑轰俊鍙�
				if (UDPUtils.isEqualsByteArray(UDPUtils.exitData, buf,
						dpk.getLength())) {
					System.out.println("server exit ...");
					// 鍚戝彂閫佺鍙戝嚭鍝嶅簲閫�鍑轰俊鍙�
					dpk1 = new DatagramPacket(UDPUtils.exitData,
							UDPUtils.exitData.length, dpk.getAddress(),
							dpk.getPort());
					dsk.send(dpk1);
					flag = false;
				} else {
					// 鑻ヤ笉鏄��鍑轰俊鍙峰垯鍐欏叆鏂囦欢
					bos.write(buf, 0, dpk.getLength());
			
					if (++flushSize % 1000 == 0) {
						flushSize = 0;
						bos.flush();
					}
					// 鍚戝彂閫佺鍙戝嚭鎺ユ敹鎴愬姛淇″彿
					dpk1 = new DatagramPacket(UDPUtils.successData,
							UDPUtils.successData.length, dpk.getAddress(),
							dpk.getPort());
					dsk.send(dpk1);
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					// 鏈�鍚庝竴娆lush
					bos.flush();
					// 鍏抽棴娴�
					bos.close();
				}
				if (dsk != null)
					dsk.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		UDPServer us = new UDPServer();
		//Thread th = new Thread();
		(new Thread(new UDPServer())).start();  
			//us.receive();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		receive();
		}
	}
}
