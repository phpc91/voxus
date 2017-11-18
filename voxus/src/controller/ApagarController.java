package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TaskDAO;
import entidades.Task;

/**
 * Servlet implementation class ApagarController
 */
@WebServlet("/apagar")
public class ApagarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Task> tasks;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApagarController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		tasks = TaskDAO.getInstance().getAllTasks();
		String[] nomesTasks = new String[tasks.size()];
		
		for(int i=0; i<nomesTasks.length; i++) {
			nomesTasks[i] = tasks.get(i).getTitulo();
		}
		
		request.setAttribute("nomesTasks", nomesTasks);
		request.getRequestDispatcher("/apagar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int taskSelecionada = Integer.parseInt(request.getParameter("tasks"));
		
		if(tasks != null) {
			String nomeTask = tasks.get(taskSelecionada).getTitulo();
			TaskDAO.getInstance().deleteTask(nomeTask);
			
			request.getRequestDispatcher("/sucesso.jsp").forward(request, response);
		}
		
	}

}
