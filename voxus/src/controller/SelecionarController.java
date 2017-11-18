package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TaskDAO;
import entidades.Task;

/**
 * Servlet implementation class SelecionarController
 */
@WebServlet("/selecionar")
public class SelecionarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<Task> tasks;   
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelecionarController() {
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
		request.getRequestDispatcher("/selecionar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int taskSelecionada = Integer.parseInt(request.getParameter("tasks"));
		String nomeTask;
		if(tasks != null) {
			nomeTask = tasks.get(taskSelecionada).getTitulo();
			HttpSession session = request.getSession(false);
			session.setAttribute("nomeTask", nomeTask);
			response.sendRedirect("/voxus/editar");
//			request.getRequestDispatcher("/editar").forward(request, response);
		}
	}

}
