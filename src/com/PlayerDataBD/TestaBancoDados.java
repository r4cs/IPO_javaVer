package com.PlayerDataBD;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class TestaBancoDados {

    public TestaBancoDados(){}

    public static PlayerInfo getNewPlayerInfo() throws IOException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Insira seu nickname: ");
        String nick = userInput.nextLine();

        System.out.println("Insira seu email: ");
        String email = userInput.nextLine();

        System.out.println("Insira seu cep: ");
        String cep = userInput.nextLine();
        return new PlayerInfo(nick, email, cep);
    }

    public static void main(String[] args) throws Exception {
        PlayerManagerDB pm = new PlayerManagerDB();
        pm.deletePlayerInfoTable();
        pm.createPlayerInfoTable();

        int opcao = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Criar");
            System.out.println("2 - Ler");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("0 - Sair");

            try {
                opcao = input.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Opção create() selecionada.");
                        PlayerInfo player_crte = getNewPlayerInfo();
                        pm.create(player_crte);
                        break;
                    case 2:
                        System.out.println("Opção read() selecionada.");
                        List<PlayerInfo> playerInfoList = pm.read();
                        for (PlayerInfo pi : playerInfoList) {
                            System.out.println(pi.toString());
                        }
                        break;
                    case 3:
                        System.out.println("Opção update() selecionada.");
                        PlayerInfo player_updt = getNewPlayerInfo();
                        pm.update(player_updt);
                    break;
                    case 4:
                        System.out.println("Opção delete() selecionada.");
                        PlayerInfo playerDel = getNewPlayerInfo();
                        pm.delete(playerDel.getNickname());
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.");
                input.nextLine(); // Limpa o buffer
            }

        } while (opcao != 0);

        input.close();

    }
}