package poj;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * 为我们前面的客户端程序实现了一个回馈服务器。这个服务器程序非常简单，它将一直运行，反复接受连接请求，接收并返回字节信息。
 * 直到客户端关闭了连接，它才关闭客户端套接字。
 * **/

public class TCPEchoServer {
	private static final int BUFSIZE = 32; // Size of receive buffer  
    
    public static void main(String[] args) throws IOException {  
        if (args.length != 1) // Test for correct # of args  
            throw new IllegalArgumentException("Parameter(s): <Port>");  
        int servPort = Integer.parseInt(args[0]);  
        // Create a server socket to accept client connection requests  
        //ServerSocket里面封装了Socket和SocketAddress
        ServerSocket servSock = new ServerSocket(servPort);  
        int recvMsgSize; // Size of received message  
        byte[] receiveBuf = new byte[BUFSIZE]; // Receive buffer  
        while (true) { // Run forever, accepting and servicing connections  
            Socket clntSock = servSock.accept(); // Get client connection  
            SocketAddress clientAddress = clntSock.getRemoteSocketAddress();  
            System.out.println("Handling client at " + clientAddress);  
            InputStream in = clntSock.getInputStream();  
            OutputStream out = clntSock.getOutputStream();  
            // Receive until client closes connection, indicated by -1 return  
            while ((recvMsgSize = in.read(receiveBuf)) != -1) {  
                out.write(receiveBuf, 0, recvMsgSize);  
            }  
            clntSock.close(); // Close the socket. We are done with this client!  
        }  
        /* NOT REACHED */  
    }  
}
