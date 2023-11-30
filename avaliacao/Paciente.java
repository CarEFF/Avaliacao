
package com.mycompany.avaliacao;



import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Paciente{
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String planoSaude;

    public Paciente(String cpf, String nome, String dataNascimento, String planoSaude) throws EValorInvalidoExcepƟon {
        this.cpf = cpf;
        this.nome = nome;
        try {
            this.dataNascimento = LocalDate.parse(dataNascimento);
        } catch (DateTimeParseException e) {
            throw new EValorInvalidoExcepƟon("Data de nascimento inválida");
        }
        this.planoSaude = planoSaude;
    }
    public String getCpf(){
        return cpf;
    }
    public String getNome(){
        return nome;
    }
    public LocalDate getDataNascimento(){
        return dataNascimento;
    }
    public String getPlanoSaude(){
        return planoSaude;
    }
}
    class EValorInvalidoExcepƟon extends Exception{
        public EValorInvalidoExcepƟon(String errorMessage){
            super(errorMessage);
    }
}


