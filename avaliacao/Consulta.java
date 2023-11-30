
package com.mycompany.avaliacao;



import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Consulta {
    private Paciente paciente;
    private LocalDate dataAtendimento;
    private String localAtendimento;
    protected double valor;

    public Consulta(Paciente paciente, String dataAtendimento, String localAtendimento, double valor) throws EValorInvalidoExcepƟon {
        this.paciente = paciente;
        this.localAtendimento = localAtendimento;
        try {
            this.dataAtendimento = LocalDate.parse(dataAtendimento);
        } catch (DateTimeParseException e) {
            throw new EValorInvalidoExcepƟon("Data de atendimento inválida");
        }
        if (valor < 0) {
            throw new EValorInvalidoExcepƟon("Valor inválido");
        }
        this.valor = valor;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }
    public String getLocalAtendimento() {
        return localAtendimento;
    }
    public double getValor() {
        return valor;
    }
}
 

