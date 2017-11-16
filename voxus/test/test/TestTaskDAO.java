package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import dao.TaskDAO;
import entidades.Task;

class TestTaskDAO {
	/*
	 * =========AVISO========= 
	 * O RESULTADO FINAL DESTES TESTES NÃO É CONFIÁVEL, POIS A ORDEM DE EXECUÇÃO AFETA O RESULTADO. 
	 * UTILIZEI ESTES TESTES APENAS PARA VALIDAR OS MÉTODOS CRIADOS NO DAO
	 * */
	TaskDAO dao = TaskDAO.getInstance();
	
	@Test
	void testGetAllTasks() {
		ArrayList<Task> todasTasks = dao.getAllTasks();
		assertTrue(todasTasks.size() == 3);
	}
	
	@Test
	void testGetTaskPorNome() {
		Task task1 = dao.getTaskPorNome("task1");
		
		assertTrue(task1.getId() == 1);
		assertTrue(task1.getTitulo() == "task1");
	}

	@Test
	void testCreateTask() {
		dao.createTask("TaskTeste");
		assertNotNull(dao.getTaskPorNome("TaskTeste"));
	}

	@Test
	void testEditTask() {
		Task task = dao.getTaskPorNome("TaskTeste");
		String nome = "novoNome";
		dao.editTask("TaskTeste", nome);
		
		assertTrue(dao.getTaskPorNome(nome).getId() == task.getId());
	}

	@Test
	void testDeleteTask() {
		dao.deleteTask("novoNome");
		int totalDeTasks = dao.getAllTasks().size();
		assertTrue(totalDeTasks == 3);
	}

}
