package ua.goIt.servlets;


import ua.goIt.dao.CompaniesDao;
import ua.goIt.model.Companies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/companies/*")
public class CompanyServlet extends HttpServlet {
    private final CompaniesDao companiesDao = new CompaniesDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createCompany")) {
            req.getRequestDispatcher("/WEB-INF/views/companiesViews/create.jsp").forward(req, resp);
            return;
        } else if (requestURI.contains("/updateCompany")) {
            req.setAttribute("updateId", req.getParameter("updateId"));
            req.getRequestDispatcher("/WEB-INF/views/companiesViews/update.jsp").forward(req, resp);
            return;


        }
        String deleteId = req.getParameter("deleteId");
        if (deleteId != null) {
            Companies companies = new Companies();
            companies.setId((int) Long.parseLong(deleteId));
            companiesDao.delete(companies.getId());
            resp.sendRedirect("/companies");
            return;
        }

        req.setAttribute("companies", companiesDao.read());
        req.getRequestDispatcher("/WEB-INF/views/companiesViews/read.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        if (requestURI.contains("/createCompany")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String state_code = req.getParameter("state_code");
            String country = req.getParameter("country");
            String info = req.getParameter("info");
            if (id == null || id.matches("\\W+") || name == null || country == null || name.equals("") || country.equals("")
                    || name.matches("\\d+") || country.matches("\\d+") || state_code == null || state_code.matches("\\W+") || state_code.equals("")
                    || info == null || info.matches("\\d+") || info.equals(""))
            {
                resp.sendRedirect("/companies/createCompany");
            }
            Companies companies = new Companies(Long.parseLong(id), name, Long.valueOf(state_code), country, info);

            companiesDao.create(companies);
            req.getSession().setAttribute("companies", companies);
            resp.sendRedirect("/companies");

        } else if (requestURI.contains("/updateCompany")) {
            String name = req.getParameter("name");
            String state_code = req.getParameter("state_code");
            String country = req.getParameter("country");
            String info = req.getParameter("info");
            if (name == null || country == null || name.equals("") || country.equals("")
                    || name.matches("\\d+") || country.matches("\\d+") || state_code == null || state_code.matches("\\W+") || state_code.equals("")
                    || info == null || info.matches("\\d+") || info.equals("")) {
                resp.sendRedirect("/companies/createCompany");
                return;

            }
            Companies companies = new Companies(Long.parseLong(req.getParameter("updateId")), name, Long.valueOf(state_code), country, info);
            companiesDao.update(companies);
            req.getSession().setAttribute("companies", companies);
            resp.sendRedirect("/companies");
        }
    }

}