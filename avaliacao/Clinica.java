
package com.mycompany.avaliacao;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Clinica{
    private String nome;
    private String endereco;
    private String cnpj;
    protected double valorConsultaSimples;
    protected double valorAdicional;
    private List<Consulta> atendimentos;

    public Clinica(String nome, String endereco, String cnpj, double valorConsultaSimples, double valorAdicional) throws EValorInvalidoExcepƟon {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        if (valorConsultaSimples < 0 || valorAdicional < 0) {
            throw new EValorInvalidoExcepƟon("Valor inválido");
        }
        this.valorConsultaSimples = valorConsultaSimples;
        this.valorAdicional = valorAdicional;
        this.atendimentos = new ArrayList<>();
    }
    public String getNome(){
        return nome;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getCnpj(){
        return cnpj;
    }
    public double getValorConsultaSimples(){
        return valorConsultaSimples;
    }
    public void setValorConsultaSimples(double valorConsultaSimples) throws EValorInvalidoExcepƟon {
        if (valorConsultaSimples < 0){
            throw new EValorInvalidoExcepƟon("Valor inválido");
        }
        this.valorConsultaSimples = valorConsultaSimples;
    }
    public double getValorAdicional(){
        return valorAdicional;
    }
    public void setValorAdicional(double valorAdicional) throws EValorInvalidoExcepƟon {
        if (valorAdicional < 0){
            throw new EValorInvalidoExcepƟon("Valor inválido");
        }
        this.valorAdicional = valorAdicional;
    }
    public double getValorTotal(){
        return atendimentos.stream().mapToDouble(Consulta::getValor).sum();
    }

    public double realizarAtendimento(String tipoConsulta, Paciente paciente) throws EAtendimentoNaoRegistradoExcepƟon {
        Consulta consulta;
        try {
            if (tipoConsulta.equals("simples")){
                consulta = new Consulta(paciente, LocalDate.now().toString(), endereco, valorConsultaSimples);
            } else if (tipoConsulta.equals("check-up")){
                consulta = new Checkup(paciente, LocalDate.now().toString(), endereco, valorConsultaSimples, valorAdicional);
            } else {
                throw new EAtendimentoNaoRegistradoExcepƟon("Tipo de consulta inválido");
            }
            atendimentos.add(consulta);
            return consulta.getValor();
        } catch (EValorInvalidoExcepƟon e){
            throw new EAtendimentoNaoRegistradoExcepƟon("Não foi possível realizar o atendimento", e);
        }
    }
    Object getAtendimentos(){
        throw new UnsupportedOperationException(""); 
    }
}
    class EAtendimentoNaoRegistradoExcepƟon extends RuntimeException {
        public EAtendimentoNaoRegistradoExcepƟon(String errorMessage) {
            super(errorMessage);
    }
    public EAtendimentoNaoRegistradoExcepƟon(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}


