/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import negocio.Psicologo;

/**
 *
 * @author andregoro
 */
public interface IPsicologoDAO {
    public void adiciona(Psicologo psicologo);
    public void altera(Psicologo psicologo);
    public void remove(int id);
    public  List<Psicologo> listarTodos();
    public Psicologo getByID(int id);
}
