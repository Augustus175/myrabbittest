package com.rabbitmq.myrabbit;

/**
 * Created by zhangzhibo-dell on 17-10-29.
 */
public class RPCMain {

    public static void main(String[] args) throws Exception {
        RPCClient rpcClient = new RPCClient();
        System.out.println(" [x] Requesting getMd5String(abc)");
        String response = rpcClient.call("abc");
        System.out.println(" [.] Got '" + response + "'");
        rpcClient.close();
    }
}
