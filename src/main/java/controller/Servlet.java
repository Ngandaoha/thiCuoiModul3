package controller;

import model.LoaiMatBang;
import service.DAO;
import service.IDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="Servlet" ,urlPatterns = {"/", "/home"})
public class Servlet extends HttpServlet {

    private DAO mainService;

    public void init(){
        mainService = new DAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("list", mainService.findAll());
        request.setAttribute("loaiMatBangs", mainService.findAllLoaiMatBang());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("loaiMatBang"));
        System.out.println(id);

        if(id == 0){
            request.setAttribute("list", mainService.findAll());
            request.setAttribute("loaiMatBangs", mainService.findAllLoaiMatBang());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
        request.setAttribute("list", mainService.Search(id));
        request.setAttribute("loaiMatBangs", mainService.findAllLoaiMatBang());
        request.getRequestDispatcher("list.jsp").forward(request, response);
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    }
}
