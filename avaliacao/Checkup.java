
package com.mycompany.avaliacao;



public class Checkup extends Consulta{
    private double valorAdicional;

    public Checkup(Paciente paciente, String dataAtendimento, String localAtendimento, double valor, double valorAdicional) throws EValorInvalidoExcepƟon {
        super(paciente, dataAtendimento, localAtendimento, valor);
        if (valorAdicional < 0){
            throw new EValorInvalidoExcepƟon("Valor adicional inválido");
        }
        this.valorAdicional = valorAdicional;
    }
    public double getValorAdicional(){
        return valorAdicional;
    }
    @Override
    public double getValor(){
        double valorTotal = super.getValor() + valorAdicional;
        if (getPaciente().getPlanoSaude().equals("SenaiMed")){
            valorTotal -= valorAdicional * 0.18;
        }
        return valorTotal;
    }
}
 