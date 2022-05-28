package com.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.amazonviewer.db.IDBConnection;
import com.amazonviewer.model.Movie;
import static com.amazonviewer.db.DataBase.*;

public interface MovieDao extends IDBConnection{
	
	default Movie setMovieViewed(Movie movie) {
		try(Connection connetion = connectToDB()) {
			Statement statement = connetion.createStatement();
			String query = "INSERT INTO" + TVIEWED +
					"("+TVIEWED_ID_MATERIAL +", " +TVIEWED_ID_ELEMENT +", "+ TVIEWED_ID_USER+")"+
					"VALUES("+ID_TMATERIALS[0]+", "+movie.getId()+", "+TUSER_IDUSUARIO+")";
			
			if(statement.executeUpdate(query) > 0) {
				System.out.println("Se Marcó en Visto");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return movie;
	}
	
	default ArrayList<Movie> read(){
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		try(Connection connection = connectToDB()){
			String query = "SELECT * FROM " + TMOVIE ;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				Movie movie = new Movie(
						rs.getString(TMOVIE_TITLE),
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR),
						Integer.valueOf(rs.getString(TMOVIE_DURATION)),
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				//necesito Java 9
				//movie.setViewed(getMovieViewed(preparedStatement, connection,Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
			}
			
		}catch(SQLException e){
			
		}
		
		return movies;
	}
	
	//Necesito Java 9
	
	/*
	 * private boolean getMovieViewed(PreparedStatement preparedStatement,
	 * Connection connection, int id_movie) { boolean viewed = false;
	 * 
	 * String query = "SELECT * FROM " + TVIEWED + "WHERE " + TVIEWED_ID_MATERIAL +
	 * "= ?" + " AND " + TVIEWED_ID_ELEMENT + "= ?" + " AND " + TVIEWED_ID_USER +
	 * "= ?" ;
	 * 
	 * ResultSet rs = null;
	 * 
	 * try { preparedStatement = connection.prepareStatement(query);
	 * preparedStatement.setInt(1, ID_TMATERIALS[0]); preparedStatement.setInt(2,
	 * id_movie); preparedStatement.setInt(3, TUSER_IDUSUARIO);
	 * 
	 * rs = preparedStatement.executeQuery(); viewed = rs.next();
	 * 
	 * } catch (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * 
	 * return false; }
	 */
	 


}
