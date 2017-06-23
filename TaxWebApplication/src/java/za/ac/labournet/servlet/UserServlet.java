/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.labournet.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PUDING
 */
public class UserServlet extends   HttpServlet {

    /* comment here*/
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /* comment here */
        String selection = request.getParameter("decision");

        double annualTax, monthlyTax, annualPayAfterTax, monthlyPayAfterTax, taxTreshold, medAidMonthly, medAidAnnually;
        double annualPayBeforeTax, monthlyPayBeforeTax, netCashPayAnually, netCashPayMonthly;
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        try {
            if (selection.equalsIgnoreCase("CALCULATE")) {

                /* Here we getting the entered values from the Html file*/
                int taxYear = Integer.parseInt(request.getParameter("taxyear"));
                int age = Integer.parseInt(request.getParameter("age"));
                double totalEarnings = Double.parseDouble(request.getParameter("totalearnings"));
                int numberOfmembers = Integer.parseInt(request.getParameter("members"));

                if (taxYear == 2017) {

                    /*Calculate PAYE before tax*/
                    annualPayBeforeTax = totalEarnings;
                    monthlyPayBeforeTax = totalEarnings / 12;

                    /*Determining annual payable tax*/
                    taxTreshold = StaticValues.TAX_TRESHOLD_2017(age);
                    if (annualPayBeforeTax < taxTreshold) {
                        annualTax = 0;
                        monthlyTax = annualTax / 12;
                    } else {
                        annualTax = (StaticValues.determinePayableTax(totalEarnings, age));
                        monthlyTax = annualTax / 12;
                    }
                   
                    /*Determine PAYE Due - after tax*/
                    annualPayAfterTax = annualPayBeforeTax - annualTax;
                    monthlyPayAfterTax = monthlyPayBeforeTax - monthlyTax;

                    /*Determining payable medical aid annually*/
                    medAidAnnually = StaticValues.determinePayableMedicalAid(numberOfmembers, taxYear);
                    medAidMonthly = medAidAnnually / 12;

                    /*Net Cash Pay after PAYE Due*/
                    netCashPayAnually = annualPayAfterTax - medAidAnnually;
                    netCashPayMonthly = monthlyPayAfterTax - medAidMonthly;
                    
                    
                    
                    request.setAttribute("annualPay", annualPayBeforeTax);
                    request.setAttribute("monthlyPay", monthlyPayBeforeTax);
                    
                    request.setAttribute("annualTax", annualTax);
                    request.setAttribute("monthlyTax", monthlyTax);
                    
                    request.setAttribute("annualPayAfter", annualPayAfterTax);
                    request.setAttribute("monthlyPayAfter", monthlyPayAfterTax);
                    
                    request.setAttribute("netCashMonthly", netCashPayMonthly);
                    request.setAttribute("netCashAnnually", netCashPayAnually);
                    
                    request.getRequestDispatcher("taxReport.jsp").forward(request, response);

                } else if (taxYear == 2018) {

                    /*Calculate PAYE before tax*/
                    annualPayBeforeTax = totalEarnings;
                    monthlyPayBeforeTax = totalEarnings / 12;

                    /*Determining annual payable tax*/
                    taxTreshold = StaticValues.TAX_TRESHOLD_2018(age);
                    if (annualPayBeforeTax < taxTreshold) {
                        annualTax = 0;
                        monthlyTax = annualTax / 12;
                    } else {
                        annualTax = (StaticValues.determinePayableTax(totalEarnings, age));
                        monthlyTax = annualTax / 12;
                    }
                    
                    /*Determine PAYE Due - after tax*/
                    annualPayAfterTax =  annualPayBeforeTax - annualTax;
                    monthlyPayAfterTax = monthlyPayBeforeTax - monthlyTax;

                    /*Determining payable medical aid annually*/
                    medAidAnnually = StaticValues.determinePayableMedicalAid(numberOfmembers, taxYear);
                    medAidMonthly = medAidAnnually / 12;

                    /*Net Cash Pay after PAYE Due*/
                    netCashPayAnually = annualPayAfterTax - medAidAnnually;
                    netCashPayMonthly = monthlyPayAfterTax - medAidMonthly;
                    
                    /*Here we are tranfering these values into the taxReport.jsp file*/
                    request.setAttribute("annualPay", annualPayBeforeTax);
                    request.setAttribute("monthlyPay", monthlyPayBeforeTax);
                    
                    request.setAttribute("annualTax", annualTax);
                    request.setAttribute("monthlyTax", monthlyTax);
                    
                    request.setAttribute("annualPayAfter", annualPayAfterTax);
                    request.setAttribute("monthlyPayAfter", monthlyPayAfterTax);
                    
                    request.setAttribute("netCashMonthly", netCashPayMonthly);
                    request.setAttribute("netCashAnnually", netCashPayAnually);
                    
                    request.getRequestDispatcher("taxReport.jsp").forward(request, response);

                }

            } else if (selection.equalsIgnoreCase("RESET")) {

                request.getRequestDispatcher("taxCalculator.html").forward(request, response);
            }

        } catch (IOException | ServletException e) {
            response.getWriter().println(e.getMessage());
        }

    }

}
