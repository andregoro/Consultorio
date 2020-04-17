/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Paciente;

/**
 *
 * @author andregoro
 */
public interface IPacienteDAO {
    public void adiciona(Paciente paciente);
    public void altera(Paciente paciente);
    public void remove(int id);
    public  List<Paciente> listarTodos();
    public Paciente getByID(int id);
}
