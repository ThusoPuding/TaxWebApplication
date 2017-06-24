/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.labournet.servlet;

import za.ac.labournet.staticvalues.StaticValues;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author PUDING
 * 
 * 
 * 
 * This servlet class is used to send and receive values from the servers and HTML files,
   this class is the connection between the JSP files and the server.
 */
public class UserServlet extends   HttpServlet {

    /* This Method Serves as the connection between the the interfaces and the server */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /*Here we getting the button value using the button name in the HTML files */
        String selection = request.getParameter("decision");
        

        double annualTax, monthlyTax, annualPayAfterTax, monthlyPayAfterTax, taxTreshold, medAidMonthly, medAidAnnually;
        double annualPayBeforeTax, monthlyPayBeforeTax, netCashPayAnually, netCashPayMonthly;
        
        DecimalFormat df = new DecimalFormat("#.##");
        try {
              
            if (selection.equalsIgnoreCase("CALCULATE")) {

                /* Here we getting the entered values from the Html file*/
                int taxYear = Integer.parseInt(request.getParameter("taxyear"));
                String period = request.getParameter("salary");
                int age = Integer.parseInt(request.getParameter("age"));
                double totalEarnings = Double.parseDouble(request.getParameter("totalearnings"));
                int numberOfmembers = Integer.parseInt(request.getParameter("members"));

                if (taxYear == 2017) {

                    /*Calculate PAYE before tax*/
                    if(("Monthly").equals(period)){
                        annualPayBeforeTax = totalEarnings * 12;
                        monthlyPayBeforeTax = totalEarnings;
                    }else{
                        annualPayBeforeTax = totalEarnings;
                        monthlyPayBeforeTax = totalEarnings/12;
                    }
                    
                    

                    /*Determining annual payable tax*/
                    taxTreshold = StaticValues.TAX_TRESHOLD_2017(age);
                    if (annualPayBeforeTax < taxTreshold) {
                        annualTax = 0;
                        monthlyTax = annualTax / 12;
                    } else {
                        annualTax = (StaticValues.determinePayableTax2017(annualPayBeforeTax, age));
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
                    
                    
                    /*Here we are sending these values to the taxReport.jsp file*/
                    request.setAttribute("annualPay", annualPayBeforeTax);
                    request.setAttribute("monthlyPay", monthlyPayBeforeTax);
                    
                    request.setAttribute("annualTax", annualTax);
                    request.setAttribute("monthlyTax", monthlyTax);
                    
                    request.setAttribute("annualPayAfter", annualPayAfterTax);
                    request.setAttribute("monthlyPayAfter", monthlyPayAfterTax);
                    
                    request.setAttribute("netCashMonthly", netCashPayMonthly);
                    request.setAttribute("netCashAnnually", netCashPayAnually);
                    
                    /*This open up the taxReport.jsp file to display the calculated values*/
                    request.getRequestDispatcher("taxReport.jsp").forward(request, response);

                } else if (taxYear == 2018) {

                    /*Calculate PAYE before tax*/
                 if(("Monthly").equals(period)){
                        annualPayBeforeTax = totalEarnings * 12;
                        monthlyPayBeforeTax = totalEarnings;
                    }else{
                        annualPayBeforeTax = totalEarnings;
                        monthlyPayBeforeTax = totalEarnings/12;
                    }
                 
                    /*Determining annual payable tax*/
                    taxTreshold = StaticValues.TAX_TRESHOLD_2018(age);
                    if (annualPayBeforeTax < taxTreshold) {
                        annualTax = 0;
                        monthlyTax = annualTax / 12;
                    } else {
                        annualTax = (StaticValues.determinePayableTax2018(annualPayBeforeTax, age));
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
                    
                    
                    /*This open up the taxReport.jsp file to display the calculated values*/
                    request.getRequestDispatcher("taxReport.jsp").forward(request, response);

                }

            } else if (selection.equalsIgnoreCase("RESET")) {

                request.getRequestDispatcher("taxCalculator.html").forward(request, response);
                
            }

        } catch (Exception e) {
            response.getWriter().println(e.getMessage());
            
        }

    }

}
