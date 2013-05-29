package fr.jetoile.demo.breizhcamp.webapp;


import fr.jetoile.demo.breizhcamp.Calculator;
import fr.jetoile.demo.breizhcamp.CalculatorImpl1;
import fr.jetoile.demo.breizhcamp.CalculatorImpl2;
import fr.jetoile.demo.breizhcamp.MyNumber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="/resultServlet", urlPatterns="/result")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String impl = httpServletRequest.getParameter("select");
        String arg1 = httpServletRequest.getParameter("arg1");
        String arg2 = httpServletRequest.getParameter("arg2");

        Calculator calculator = null;
        int result = 0;

        switch (impl) {
            case "calculatorImpl1" :
                calculator = new CalculatorImpl1();
                result = calculator.plus(Integer.valueOf(arg1), Integer.valueOf(arg2));
                break;
            case "calculatorImpl2" :
                calculator = new CalculatorImpl2();
                MyNumber val1 = new MyNumber();
                val1.setNumber(Integer.valueOf(arg1));
                MyNumber val2 = new MyNumber();
                val2.setNumber(Integer.valueOf(arg2));

                result = calculator.plus(val1, val2).getNumber();
                break;
        }




        httpServletRequest.setAttribute("select", impl);
        httpServletRequest.setAttribute("result", result);

        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
