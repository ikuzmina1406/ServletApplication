package ua.goIt.servlets;

import ua.goIt.dao.ProjectsDao;
import ua.goIt.model.Projects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet("/projects/*")
public class ProjectServlet extends HttpServlet {
    private final ProjectsDao projectsDao = new ProjectsDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createProject")) {
            req.getRequestDispatcher("/WEB-INF/views/projectsViews/create.jsp").forward(req, resp);
            return;
        } else if (requestURI.contains("/updateProject")) {
            req.setAttribute("updateId", req.getParameter("updateId"));
            req.getRequestDispatcher("/WEB-INF/views/projectsViews/update.jsp").forward(req, resp);
            return;
        }
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Projects projects = new Projects();
            projects.setId(Long.parseLong(deleteId));
            projectsDao.delete(projects.getId());
            resp.sendRedirect("/projects");

        } else {
            req.setAttribute("projects", projectsDao.read());
            req.getRequestDispatcher("/WEB-INF/views/projectsViews/read.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createProject")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String info = req.getParameter("info");
            String status = req.getParameter("status");
            String cost = req.getParameter("cost");
            String date_creation = req.getParameter("date_creation");
            if (id == null || id.matches("\\W+") || name == null || name.matches("\\d+") || name.equals("")
                    || info == null || info.matches("\\d+") || info.equals("") || !status.matches("\\d") || !status.equals("1") && !status.equals("0")
                    || !cost.matches("\\d{3,8}") || !date_creation.matches("\\d{4}-\\d{2}-\\d{2}")) {
                resp.sendRedirect("/projects/createProject");
                return;

            }
            Projects projects = new Projects(Long.parseLong(id), name, info, Integer.parseInt(status), BigDecimal.valueOf(Double.parseDouble(cost)), Date.valueOf(date_creation));
            projectsDao.create(projects);
            req.getSession().setAttribute("projects", projects);
            resp.sendRedirect("/projects");

        } else if (requestURI.contains("/updateProject")) {
            String name = req.getParameter("name");
            String info = req.getParameter("info");
            String status = req.getParameter("status");
            String cost = req.getParameter("cost");
            String date_creation = req.getParameter("date_creation");
            if (name == null || name.matches("\\d+") || name.equals("")
                    || info == null || info.matches("\\d+") || info.equals("") || !status.matches("\\d") || !status.equals("1") && !status.equals("0")
                    || !cost.matches("\\d{3,8}") || !date_creation.matches("\\d{4}-\\d{2}-\\d{2}")) {
                resp.sendRedirect("/projects/updateProject");
                return;

            }
            Projects projects = new Projects(Long.parseLong(req.getParameter("updateId")), name, info, Integer.parseInt(status), BigDecimal.valueOf(Double.parseDouble(cost)), Date.valueOf(date_creation));
            projectsDao.update(projects);
            req.getSession().setAttribute("projects", projects);
            resp.sendRedirect("/projects");
        }
    }
}