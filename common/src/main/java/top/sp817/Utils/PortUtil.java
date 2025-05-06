package top.sp817.Utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * 提供查看端口是否被占用的方法
 */
public class PortUtil {


	public static final String LOCALHOST = "127.0.0.1";
	public static final int PORT_MIN = 15000;
	public static final int PORT_MAX = 30000;


	public static void main(String[] args) {
		for (int i = 9000; i < 9005; i++) {
			System.out.println(isLoclePortUsing(LOCALHOST, i));
		}
	}


	public static int getLocalPort() {
		Random rand = new Random();
		while (true) {
			int port = PORT_MIN + rand.nextInt(PORT_MAX - PORT_MIN + 1);
			if (!isLoclePortUsing(LOCALHOST, port)) {
				return port;
			}
		}
	}


	/**
	 * 查看本机某端口是否被占用
	 * @param port  端口号
	 * @return  如果被占用则返回true，否则返回false
	 */
	public static boolean isLoclePortUsing(String host,int port){
		boolean flag = true;
		try{
			flag = isPortUsing(host, port);
		}catch (Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 根据IP和端口号，查询其是否被占用
	 * @param host  IP
	 * @param port  端口号
	 * @return  如果被占用，返回true；否则返回false
	 * @throws UnknownHostException    IP地址不通或错误，则会抛出此异常
	 */
	public static boolean isPortUsing(String host, int port) throws UnknownHostException {
		boolean flag = false;
		InetAddress theAddress = InetAddress.getByName(host);
		try{
			Socket socket = new Socket(theAddress, port);
			flag = true;
		} catch (IOException e) {
			//如果所测试端口号没有被占用，那么会抛出异常，这里利用这个机制来判断
			//所以，这里在捕获异常后，什么也不用做
		}
		return flag;
	}
}