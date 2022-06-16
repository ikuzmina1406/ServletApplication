package ua.goIt.servlets;

import ua.goIt.dao.CustomersDao;
import ua.goIt.model.Companies;
import ua.goIt.model.Customers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/customers/*")
public class CustomerServlet extends HttpServlet {
    private final CustomersDao customersDao = new CustomersDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createCustomer")) {
            req.getRequestDispatcher("/WEB-INF/views/customersViews/create.jsp").forward(req, resp);
            return;

        } else if (requestURI.contains("/updateCustomer")) {
            req.setAttribute("updateId", req.getParameter("updateId"));
            req.getRequestDispatcher("/WEB-INF/views/customersViews/update.jsp").forward(req, resp);
            return;
        }

        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Companies companies = new Companies();
            companies.setId((int) Long.parseLong(deleteId));
            customersDao.delete(companies.getId());
            resp.sendRedirect("/customers");
            return;

        }
        req.setAttribute("customers", customersDao.read());
        req.getRequestDispatcher("/WEB-INF/views/customersViews/read.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createCustomer")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String state_code = req.getParameter("state_code");
            String country = req.getParameter("country");
            String birthday = req.getParameter("birthday");
            String sex = req.getParameter("sex");
            String info = req.getParameter("info");
            if (id == null || id.matches("\\W+") || name == null || country == null || name.equals("") || country.equals("")
                    || name.matches("\\d+ | \\d") || country.matches("\\d+ | \\d")
                    || state_code == null || state_code.matches("\\W+") || state_code.equals("")
                    || info == null || info.matches("\\d+") || info.equals("") || birthday == null || birthday.matches("\\d{4}-\\d{2}-\\d{2}") || birthday.equals("")
                    || sex == null || sex.equals("") || !sex.equals("man") && !sex.equals("woman") || info == null || info.matches("\\d+") || info.equals("")) {

            }
            Customers customers = new Customers(Long.parseLong(id), name, Long.valueOf(state_code), country, Date.valueOf(birthday), sex, info);
            customersDao.create(customers);
            req.getSession().setAttribute("customers", customers);
            resp.sendRedirect("/customers");

        } else if (requestURI.contains("/updateCustomer")) {
            String name = req.getParameter("name");
            String state_code = req.getParameter("state_code");
            String country = req.getParameter("country");
            String birthday = req.getParameter("birthday");
            String sex = req.getParameter("sex");
            String info = req.getParameter("info");
            Customers customers = new Customers(Long.parseLong(req.getParameter("updateId")), name, Long.valueOf(state_code), country, Date.valueOf(birthday), sex, info);
            if (name == null || country == null || name.equals("") || country.equals("")
                    || name.matches("\\d+ | \\d") || country.matches("\\d+ | \\d")
                    || state_code == null || state_code.matches("\\W+") || state_code.equals("")
                    || info == null || info.matches("\\d+") || info.equals("") || birthday == null || birthday.matches("\\d{4}-\\d{2}-\\d{2}") || birthday.equals("")
                    || sex == null || sex.equals("") || !sex.equals("man") && !sex.equals("woman") || info == null || info.matches("\\d+") || info.equals("")) {
                resp.sendRedirect("/customers/updateCustomer");
                return;

            }

            customersDao.update(customers);
            req.getSession().setAttribute("customers", customers);
            resp.sendRedirect("/customers");
        }


    }
}