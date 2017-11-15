package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Task;

public class TaskDAO extends BaseDAO{
	private static final TaskDAO instance = new TaskDAO();

	public static TaskDAO getInstance() {
		return instance;
	}
	
	public ArrayList<Task> getAllTasks() {
		ArrayList<Task> tasks = new ArrayList<>();
		
		try{
			Connection conn = createConnection();
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery("SELECT * FROM Task ORDER BY nome_task");
			
			while (resultSet.next()){
				
				Task task = new Task();
				task.setTitulo(resultSet.getString("nome_task"));
				task.setId(resultSet.getInt("id_task"));
				
				tasks.add(task);
			}
			
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return tasks;
	}
}
