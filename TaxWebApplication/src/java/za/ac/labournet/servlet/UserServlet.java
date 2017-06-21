/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.labournet.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PUDING
 */
public class UserServlet extends HttpServlet {

    /* comment here*/
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /* comment here */
        String selection = request.getParameter("decision");

        double taxrate, taxRebates, taxTresholds, medAidMonthly, medAidAnnually;
        double payeBeforeTax, taxCredits, PayDue, netCashPay;
        double monthlyPay, annualPay;

        try {
            if (selection.equalsIgnoreCase("CALCULATE")) {

                int taxyear = Integer.parseInt(request.getParameter("taxyear"));
                int age = Integer.parseInt(request.getParameter("age"));
                double totalEarnings = Double.parseDouble(request.getParameter("totalearnings"));
                int numberOfmembers = Integer.parseInt(request.getParameter("members"));

                if (taxyear == 2017) {

                    if (totalEarnings <= 188000) {

                        taxrate = totalEarnings * (18 / 100);

                    } else if (totalEarnings <= 293600) {

                        taxrate = totalEarnings * (26 / 100) + 33840;

                    } else if (totalEarnings <= 406400) {

                        taxrate = totalEarnings * (31 / 100) + 61296;

                    } else if (totalEarnings <= 550100) {

                        taxrate = totalEarnings * (36 / 100) + 96264;

                    } else if (totalEarnings <= 701300) {

                        taxrate = totalEarnings * (39 / 100) + 147996;
                    } else {
                        taxrate = totalEarnings * (41 / 100) + 206964;
                    }

                    /*determing the tax rebates which the user fall under*/
                    if (age < 65) {
                        taxRebates = 13500;
                        taxTresholds = 75000;
                    } else if (age < 75) {
                        taxRebates = 7407;
                        taxTresholds = 116150;
                    } else {

                        taxRebates = 2466;
                        taxTresholds = 129850;
                    }

                    /*determining the medical aid dependants per month*/
                    if (numberOfmembers > 2) {
                        medAidMonthly = ((286 * 2) + (192 * (numberOfmembers - 2)));
                    } else {
                        medAidMonthly = 286 * numberOfmembers;
                    }

                    /*output */
                    monthlyPay = totalEarnings / 12;
                    annualPay = totalEarnings * 12;

                    taxCredits = annualPay - taxrate;
                    PayDue = totalEarnings - taxCredits;
                    netCashPay = PayDue - medAidMonthly;

                } else if (taxyear == 2018) {

                }

            } else if (selection.equalsIgnoreCase("RESET")) {

                request.getRequestDispatcher("taxCalculator.html").forward(request, response);
            }

        } catch (IOException | ServletException e) {
            response.getWriter().println(e.getMessage());
        }

    }

}
