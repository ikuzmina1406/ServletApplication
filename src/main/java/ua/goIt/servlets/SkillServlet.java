package ua.goIt.servlets;

import ua.goIt.dao.SkillsDao;
import ua.goIt.model.Projects;
import ua.goIt.model.Skills;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/skills/*")
public class SkillServlet extends HttpServlet {
    private final SkillsDao skillsDao = new SkillsDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createSkill")) {
            req.getRequestDispatcher("/WEB-INF/views/skillsViews/create.jsp").forward(req, resp);
            return;
        } else if (requestURI.contains("/updateSkill")) {
            req.setAttribute("updateId", req.getParameter("updateId"));
            req.getRequestDispatcher("/WEB-INF/views/skillsViews/update.jsp").forward(req, resp);
            return;
        }
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Projects projects = new Projects();
            projects.setId(Long.parseLong(deleteId));
            skillsDao.delete(projects.getId());
            resp.sendRedirect("/skills");
            return;
        }
        req.setAttribute("skills", skillsDao.read());
        req.getRequestDispatcher("/WEB-INF/views/skillsViews/read.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createSkill")) {
            String id = req.getParameter("id");
            String branch = req.getParameter("branch");
            String level = req.getParameter("level");
            if (id == null || id.matches("\\W+") || branch == null || branch.equals("")
                    || branch.matches("\\d+") || level == null || level.equals("") || level.matches("\\d+")) {
                resp.sendRedirect("/skills/createSkill");
                return;

            }
            Skills skills = new Skills(Long.parseLong(id), branch, level);

            skillsDao.create(skills);
            req.getSession().setAttribute("skills", skills);
            resp.sendRedirect("/skills");

        } else if (requestURI.contains("/updateSkill")) {
            String branch = req.getParameter("branch");
            String level = req.getParameter("level");
            if (branch == null || branch.equals("")
                    || branch.matches("\\d+") || level == null || level.equals("") || level.matches("\\d+")) {
                resp.sendRedirect("/skills/updateSkill");
                return;

            }
            Skills skills = new Skills((Long.parseLong(req.getParameter("updateId"))), branch, level);

            skillsDao.update(skills);
            req.getSession().setAttribute("skill", skills);
            resp.sendRedirect("/skills");
        }
    }
}