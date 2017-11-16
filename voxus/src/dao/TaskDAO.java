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
	
	public Task getTaskPorNome(String nomeTask) {
		Task task = new Task();
		try {
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Task WHERE nome_task LIKE '%"+nomeTask+"%'");
			if(resultSet.next()) {
				task.setId(resultSet.getInt("id_task"));
				task.setTitulo(resultSet.getString("nome_task"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return task;
	}
	
	public void createTask(String nomeTask) {
		try{
			Connection conn = createConnection();
			Statement statement = conn.createStatement();

			statement.executeUpdate("INSERT INTO Task (Task.nome_task) VALUES ('"+nomeTask+"')");
			
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void editTask(String nomeTask, String novoNome) {
		try{
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Task WHERE nome_task LIKE '%"+nomeTask+"%'");
			int idTask;
			if(resultSet.next()) {
				idTask = resultSet.getInt("id_task");
				statement.executeUpdate("UPDATE Task SET nome_task='"+novoNome+"' WHERE id_task="+idTask);
			}
			
			conn.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteTask(String nomeTask) {
		try {
			Connection conn = createConnection();
			Statement statement = conn.createStatement();
			
			statement.executeUpdate("DELETE FROM Task WHERE nome_task LIKE '%"+nomeTask+"%'");
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
