/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Psicologo;

/**
 *
 * @author andregoro
 */
public class PsicologoDAO implements IPsicologoDAO {
        private Connection connection;

    public PsicologoDAO() {
        this.connection =new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Psicologo psicologo) {
                String sql="insert into Psicologo(nome,cpf,crp,telefone,login,senha) "+
                                  "value (?    ,?,       ?,         ?     ,?,      ?)";
     try{
         PreparedStatement stmt=connection.prepareStatement(sql);
         stmt.setString(1, psicologo.getNome());
         stmt.setString(2, psicologo.getCpf());
         stmt.setString(3, psicologo.getCrp());
         stmt.setString(4, psicologo.getTelefone());
         stmt.setString(5, psicologo.getLogin());
         stmt.setString(6, psicologo.getSenha());

         stmt.execute();
         stmt.close();
     }catch(SQLException e){
         throw new RuntimeException(e);
     }   
    }

    @Override
    public void altera(Psicologo psicologo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Psicologo> listarTodos() {
                try{
            List<Psicologo> psicologos=new ArrayList<Psicologo>();
            PreparedStatement stmt =this.connection.prepareStatement("select * from psicologo");
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Psicologo psicologo=new Psicologo();
                psicologo.setIdPsicologo(rs.getInt("idpsicologo"));
                psicologo.setNome(rs.getString("nome"));
                psicologo.setCpf(rs.getString("cpf"));
                
                psicologo.setCrp(rs.getString("crp"));
                psicologo.setTelefone(rs.getString("telefone"));
                psicologo.setLogin(rs.getString("login"));
                psicologo.setSenha(rs.getString("senha"));
             
                
                psicologos.add(psicologo);
            }
            rs.close();
            stmt.close();
            return psicologos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Psicologo getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
