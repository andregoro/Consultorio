/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Calendar;

/**
 *
 * @author andregoro
 */
public class Sessao {
    public int idSessao,evolucao,idAnamnece;
   public Calendar data;
public String queixas_paciente,plano_tratamento,dignostico_final,resumo_sessao;
public boolean pago;

    public int getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(int idSessao) {
        this.idSessao = idSessao;
    }

    public int getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(int evolucao) {
        this.evolucao = evolucao;
    }

    public int getIdAnamnece() {
        return idAnamnece;
    }

    public void setIdAnamnece(int idAnamnece) {
        this.idAnamnece = idAnamnece;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getQueixas_paciente() {
        return queixas_paciente;
    }

    public void setQueixas_paciente(String queixas_paciente) {
        this.queixas_paciente = queixas_paciente;
    }

    public String getPlano_tratamento() {
        return plano_tratamento;
    }

    public void setPlano_tratamento(String plano_tratamento) {
        this.plano_tratamento = plano_tratamento;
    }

    public String getDignostico_final() {
        return dignostico_final;
    }

    public void setDignostico_final(String dignostico_final) {
        this.dignostico_final = dignostico_final;
    }

    public String getResumo_sessao() {
        return resumo_sessao;
    }

    public void setResumo_sessao(String resumo_sessao) {
        this.resumo_sessao = resumo_sessao;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }


}
