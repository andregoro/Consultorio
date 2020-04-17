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
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import negocio.Paciente;

/**
 *
 * @author andregoro
 */
public class PacienteDAO  implements IPacienteDAO{

    private Connection connection;

    public PacienteDAO() {
        this.connection =new ConFactory().getConnection();
    }
    
    
    @Override
    public void adiciona(Paciente paciente) {
        String sql="insert into paciente(nome,cpf,data_nascimento,sexo,endereco,telefone,foto,plano_saude,observacoes,data_cadastro) "+
                                  "value (?    ,?,       ?,         ?     ,?,      ?,       ?,        ?,             ?     ,    now())";
     try{
         PreparedStatement stmt=connection.prepareStatement(sql);
         stmt.setString(1, paciente.getNome());
         stmt.setString(2, paciente.getCpf());
         stmt.setDate(3,new Date(paciente.getData_nascimento().getTimeInMillis()));
         stmt.setString(4, paciente.getSexo());
         stmt.setString(5, paciente.getEndereco());
         stmt.setString(6, paciente.getTelefone());
         stmt.setString(7, paciente.getFoto());    
         stmt.setString(8, paciente.getPlano_saude());
         stmt.setString(9, paciente.getObservacoes());
         stmt.execute();
         stmt.close();
     }catch(SQLException e){
         throw new RuntimeException(e);
     }   
    }

    @Override
    public void altera(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paciente> listarTodos() {
        try{
            List<Paciente> pacientes=new ArrayList<Paciente>();
            PreparedStatement stmt =this.connection.prepareStatement("select * from paciente");
            ResultSet rs=stmt.executeQuery();
            
            while(rs.next()){
                Paciente paciente=new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                
                ///
                Calendar data=Calendar.getInstance();
                data.setTime(rs.getDate("data_nascimento"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setTelefone(rs.getString("telefone"));
                paciente.setFoto(rs.getString("foto"));
                paciente.setPlano_saude(rs.getString("plano_saude"));
                paciente.setObservacoes(rs.getString("observacoes"));
                data.setTime(rs.getDate("data_cadastro"));
                paciente.setData_cadastro(data);
                pacientes.add(paciente);
            }
            rs.close();
            stmt.close();
            return pacientes;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Paciente getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
