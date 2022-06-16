package ua.goIt.servlets;

import ua.goIt.dao.DevelopersDao;
import ua.goIt.model.Developers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet("/developers/*")
public class DeveloperServlet extends HttpServlet {
    private final DevelopersDao developersDao = new DevelopersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createDeveloper")) {
            req.getRequestDispatcher("/WEB-INF/views/developersViews/create.jsp").forward(req, resp);
            return;

        } else if (requestURI.contains("/updateDeveloper")) {
            req.setAttribute("updateId", req.getParameter("updateId"));
            req.getRequestDispatcher("/WEB-INF/views/developersViews/update.jsp").forward(req, resp);
            return;
        }

        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Developers developers = new Developers();
            developers.setId(Long.parseLong(deleteId));
            developersDao.delete(developers.getId());
            resp.sendRedirect("/developers");

        } else {
            req.setAttribute("developers", developersDao.read());
            req.getRequestDispatcher("/WEB-INF/views/developersViews/read.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createDeveloper")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String first_name = req.getParameter("first_name");
            String last_name = req.getParameter("last_name");
            String age = req.getParameter("age");
            String birthday = req.getParameter("birthday");
            String sex = req.getParameter("sex");
            String state_code = req.getParameter("state_code");
            String country = req.getParameter("country");
            String address = req.getParameter("address");
            String status = req.getParameter("status");
            String salary = req.getParameter("salary");
            if (id == null || id.matches("\\d+") || name == null || name.matches("\\w+") || name.equals("") ||  first_name == null || first_name.matches("\\\\w+\"") || first_name.equals("")
                    ||  last_name.matches("\\w+")  || age.matches("\\W+")
                    ||  birthday == null || birthday.matches("\\d{4}-\\d{2}-\\d{2}") || birthday.equals("")
                    || sex == null || sex.equals("") || !sex.equals("man") && !sex.equals("woman") || state_code == null || state_code.matches("\\W+") || state_code.equals("")
                    || country == null || country.matches("\\w+") || country.equals("") || address.matches("\\w\\s")
                    || !status.matches("\\d") || !status.equals("1") && !status.equals("0")|| !salary.matches("\\d{1,6}")) {
                resp.sendRedirect("/developers/createDeveloper");
                return;

            }
            Developers developers = new Developers(Long.parseLong(id), name, first_name, last_name, Integer.parseInt(age), Date.valueOf(birthday) ,sex, Long.valueOf(state_code), country, address, Integer.parseInt(status), BigDecimal.valueOf(Double.parseDouble(salary)));
            developersDao.create(developers);
            req.getSession().setAttribute("developers", developers);
            resp.sendRedirect("/developers");

        } else if (requestURI.contains("/updateDevelopers")) {
            String name = req.getParameter("name");
            String first_name = req.getParameter("first_name");
            String last_name = req.getParameter("last_name");
            String age = req.getParameter("age");
            String birthday = req.getParameter("birthday");
            String sex = req.getParameter("sex");
            String state_code = req.getParameter("state_code");
            String country = req.getParameter("country");
            String address = req.getParameter("address");
            String status = req.getParameter("status");
            String salary = req.getParameter("salary");
            if (name == null || name.matches("\\w+") || name.equals("") ||  first_name == null || first_name.matches("\\\\w+\"") || first_name.equals("")
                    ||  last_name.matches("\\w+")  || age.matches("\\W+")
                    ||  birthday == null || birthday.matches("%tY %tm %td,date,date,date") || birthday.equals("")
                    || sex == null || sex.equals("") || !sex.equals("man") && !sex.equals("woman") || state_code == null || state_code.matches("\\W+") || state_code.equals("")
                    || country == null || country.matches("\\w+") || country.equals("") || address.matches("\\w\\s")
                    || !status.matches("\\d") || !status.equals("1") && !status.equals("0")|| !salary.matches("\\d{1,6}")) {
                resp.sendRedirect("/developers/updateDeveloper");
                return;
            }
            Developers developer = new Developers(Long.parseLong(req.getParameter("updateId")),
                    name, first_name, last_name, Integer.parseInt(age), Date.valueOf(birthday) ,sex, Long.valueOf(state_code), country, address, Integer.parseInt(status), BigDecimal.valueOf(Double.parseDouble(salary)));
            developersDao.update(developer);
            req.getSession().setAttribute("developers", developer);
            resp.sendRedirect("/developers");
        }
    }
}
