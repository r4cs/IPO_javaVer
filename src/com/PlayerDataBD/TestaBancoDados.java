package com.PlayerDataBD;

import java.util.List;
import java.util.Scanner;


public class TestaBancoDados {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        PlayerManagerDB pm = new PlayerManagerDB();
//        pm.deletePlayerInfoTable();
        pm.createPlayerInfoTable();


        System.out.println("Insira seu nickname: ");
        String nick = input.nextLine();

        System.out.println("Insira seu email: ");
        String email = input.nextLine();

        System.out.println("Insira seu cep: ");
        String cep = input.nextLine();

        pm.create(new PlayerInfo(nick, email, cep));

        List<PlayerInfo> playerInfoList = pm.read();
        for (PlayerInfo pi : playerInfoList) {
            System.out.println(pi.toString());
        }

    }}