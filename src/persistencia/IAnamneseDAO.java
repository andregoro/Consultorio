/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Anamnese;

/**
 *
 * @author andregoro
 */
public interface IAnamneseDAO {
    public void adiciona(Anamnese anamnese);
    public void altera(Anamnese anamnese);
    public void remove(int id);
    public  List<Anamnese> listarTodos();
    public Anamnese getByID(int id);
}
