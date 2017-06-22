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

        double calcTax, taxRebates, taxTreshold, medAidMonthly, medAidAnnually;
        double payeBeforeTax, taxCredits, PayeDue, netCashPayAnually, netCashPayMonthly;
        double monthlyPay, annualPay,percentage,calcTax2,calTax3,calcTax4,calcTax7;
        double amountTobeDeducted;
        double calctax5 = 0;

        try {
            if (selection.equalsIgnoreCase("CALCULATE")) {

                int taxyear = Integer.parseInt(request.getParameter("taxyear"));
                int age = Integer.parseInt(request.getParameter("age"));
                double totalEarnings = Double.parseDouble(request.getParameter("totalearnings"));
                int numberOfmembers = Integer.parseInt(request.getParameter("members"));

                if (taxyear == 2017) {

                    if (totalEarnings <= 188000) {

                        amountTobeDeducted = 0;
                        calcTax = (totalEarnings - amountTobeDeducted) *(18 / 100);
                        
                         

                    } else if (totalEarnings <= 293600) {
                        
                        amountTobeDeducted = 188000;
                        calcTax = (((((totalEarnings - amountTobeDeducted) *0.31) + 61296)- StaticValues.PRIMARY_REBATE_2017) -StaticValues.SECONDARY_REBATE_2017)/12;
                        calcTax = totalEarnings - amountTobeDeducted;
                        percentage = 26/100;
                        
                        calcTax2 = calcTax * percentage;
                        calTax3 = calcTax2 + 33840;
                        calcTax4 = calTax3 - (StaticValues.PRIMARY_REBATE_2017 + StaticValues.SECONDARY_REBATE_2017);
                        calctax5 = calcTax4/12;

                    } else if (totalEarnings <= 406400) {
                        
                        amountTobeDeducted = 293600;
                       
                        calcTax = (((((totalEarnings - amountTobeDeducted) *0.31) + 61296)- StaticValues.PRIMARY_REBATE_2017) -StaticValues.SECONDARY_REBATE_2017)/12;
                        
                    
                    } else if (totalEarnings <= 550100) {
                        
                        amountTobeDeducted = 406400;
            
                        calcTax = (((((totalEarnings - amountTobeDeducted) *(36 / 100)) + 96264)- StaticValues.PRIMARY_REBATE_2017) -StaticValues.SECONDARY_REBATE_2017)/12;
                        

                    } else if (totalEarnings <= 701300) {
                        
                        amountTobeDeducted = 550100;
                        
                        calcTax = (((((totalEarnings - amountTobeDeducted) *(39 / 100)) + 147996)- StaticValues.PRIMARY_REBATE_2017) -StaticValues.SECONDARY_REBATE_2017)/12;
                        
                    } else {
                            
                        amountTobeDeducted = 701300;
                       
                         calcTax = (((((totalEarnings - amountTobeDeducted) *(41 / 100)) + 206964)- StaticValues.PRIMARY_REBATE_2017) -StaticValues.SECONDARY_REBATE_2017)/12;
                    }

                 

                    /*determining the medical aid dependants per month*/
                    if (numberOfmembers > 2) {
                        medAidMonthly = ((286 * 2) + (192 * (numberOfmembers - 2)));
                    } else {
                        medAidMonthly = 286 * numberOfmembers;
                    }

                    /*output */
                    
                    
                    monthlyPay = totalEarnings / 12;
                    annualPay = totalEarnings;
                   
                    
                    taxTreshold = StaticValues.TAX_TRESHOLD_2017(age);
                    
                    if(annualPay < taxTreshold ){
                        PayeDue = annualPay;
                    
                    }else{
                        PayeDue = annualPay - calctax5;
                    }
                    
                    netCashPayAnually = PayeDue - (medAidMonthly *12);
                    
                    response.getWriter().println(annualPay + " -Anual Pay \n" 
                                                  +" \n"
                                                  + " "+
                                          calcTax + " - tax Credits \n" + PayeDue +" - paydue after Tax \n" + netCashPayAnually +"net cash " );

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
