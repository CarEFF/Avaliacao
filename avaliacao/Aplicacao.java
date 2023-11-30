
package com.mycompany.avaliacao;



import java.util.Scanner;

public class Aplicacao{
    
    public static void main(String[] args){
        
         try{
            Clinica clinica = new Clinica("Senai-Med", "Dendezeiros, 88, Bonfim", "123.456.7890-1234", 80.0, 120.0);
            Scanner scanner = new Scanner(System.in);
           
            while (true){
                System.out.println("Digite uma das opções:");
                System.out.println("a: Realizar um atendimento");
                System.out.println("b: Consultar a media de valor dos atendimentos realizados");
                System.out.println("c: Alterar valor da consulta simples ou o adicional");
                String opcao = scanner.nextLine();
                
                switch(opcao){
                    case "a":
                        System.out.println("Digite tipo de consulta simples ou checkup");
                        String tipoConsulta = scanner.nextLine();
                         System.out.println("Digite dados do paciente CPF, nome, data de nascimento, plano de saúde");
                        String[] dadosPaciente = scanner.nextLine().split(",");
                       
                        Paciente paciente = new Paciente(dadosPaciente[0], dadosPaciente[1], dadosPaciente[2], dadosPaciente[3]);
                        double valorAtendimento = clinica.realizarAtendimento(tipoConsulta, paciente);
                      
                        System.out.println("Atendimento realizado. Valor" + valorAtendimento);
                        break;
                    case "b":
                        double mediaValorAtendimentos = clinica.getValorTotal() / clinica.getAtendimentos().hashCode();
                        System.out.println("Média do valor dos atendimentos feitos" + mediaValorAtendimentos);
                        break;
                    case "c":
                         System.out.println("Digite novo valor da consulta simples");
                        double novoValorConsultaSimples = Double.parseDouble(scanner.nextLine());
                        clinica.setValorConsultaSimples(novoValorConsultaSimples);
                          System.out.println("Digite novo valor adicional para exames");
                        double novoValorAdicional = Double.parseDouble(scanner.nextLine());
                        clinica.setValorAdicional(novoValorAdicional);
                         System.out.println("Valores atualizados com sucesso!!!!!.");
                        break;
                    default:
                         System.out.println("Opção inválida.");
                }
            }
         } catch (EValorInvalidoExcepƟon | EAtendimentoNaoRegistradoExcepƟon e) {
            System.out.println(e.getMessage());
        }
    }
}

        
        
        
        
        
    

