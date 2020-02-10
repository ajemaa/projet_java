
import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;


public class Methodes
{
  
    private java.sql.PreparedStatement st=null;
	private Connection con=null;
	public ResultSet resultat;
    public Methodes(){
   
    }
    
  
    public boolean CreerChamps(MonServeur ser)
    {
    	 ConnexionJDBC cone=new ConnexionJDBC();
    		con=cone.OuvreConnexion();
    	try
		{
			st=con.prepareStatement("insert into movie values(null,\""+ ser.getNomFilm() +"\","+ ser.getAnnee() +","+ ser.getRealisateur() +","+ ser.getPossede() +","+ ser.getEstVue() +","+ ser.getSociete() +",\""+ser.getResum()+"\");");
			st.executeUpdate();
			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
			return false;
	
		}
		return true;
    	
    }
    
    public void ActeurJoue(String idFilm, String idAct)
    {
    	 ConnexionJDBC cone=new ConnexionJDBC();
    		con=cone.OuvreConnexion();
    	try
		{
			st=con.prepareStatement("insert into joue values("+idFilm+","+idAct+",null);");
			st.executeUpdate();			
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
    	
    }
    
    public ResultSet SelectRealisateur(MonServeur ser){
    	
    	ConnexionJDBC cone=new ConnexionJDBC();
		con=cone.OuvreConnexion();

		java.sql.Statement st;
		try {
			st = con.createStatement();
			resultat = st.executeQuery("SELECT * FROM realisateur order by nom_realisateur");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //On récupère les MetaData

		return resultat;
    }
    
    public ResultSet SelectSociete(MonServeur ser){
    	
    	ConnexionJDBC cone=new ConnexionJDBC();
		con=cone.OuvreConnexion();

		java.sql.Statement st;
		try {
			st = con.createStatement();
			resultat = st.executeQuery("SELECT * FROM societe_produc order by nom_societe");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //On récupère les MetaData

		return resultat;
    }
    
    public ResultSet SelectActeur(MonServeur ser){
    	
    	ConnexionJDBC cone=new ConnexionJDBC();
		con=cone.OuvreConnexion();

		java.sql.Statement st;
		try {
			st = con.createStatement();
			resultat = st.executeQuery("SELECT * FROM acteur order by nom_acteur");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //On récupère les MetaData

		return resultat;
    }
    
    public ResultSet SelectAutoInc(MonServeur ser){
    	
    	ConnexionJDBC cone=new ConnexionJDBC();
		con=cone.OuvreConnexion();

		java.sql.Statement st;
		try {
			st = con.createStatement();
			resultat = st.executeQuery("show table status where name='movie'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //On récupère les MetaData

		return resultat;
    }
}


