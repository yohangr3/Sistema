
package sistema.empleadosDAL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author yohan
 */
public class conexion {
    String strConexionDB="jdbc:sqlite:C:\\Users\\yohan\\Documents\\sistema.s3db";
    Connection conn= null;

 
    public conexion() {
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(strConexionDB);
            System.out.println("Conexión establecida");
        }catch (Exception e){
            System.out.println("Error de conexión " + e);
        }
    }
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL){
        try{
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        }catch(SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarRegistros(String strSentenciaSQL){
        
        try{
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
    
}
