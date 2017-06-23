package za.ac.labournet.servlet;

/**
 *
 * @author PUDING
 *
 * This Class serves as the storehouse for all the static values
 */
public class StaticValues {

    /* These are the static values for 2017 tax rebates(amount deducted from payable tax)*/
    public static final double PRIMARY_REBATE_2017 = 13500;
    public static final double SECONDARY_REBATE_2017 = 7407;
    public static final double TERTIARY_REBATE_2017 = 2466;

    /* These are the static values for 2018 tax rebates(amount deducted from payable tax)*/
    public static final double PRIMARY_REBATE_2018 = 13500;
    public static final double SECONDARY_REBATE_2018 = 13500;
    public static final double TERTIARY_REBATE_2018 = 13500;

    /* This is a static method that determines the Tax treshold for 2017*/
    public static double TAX_TRESHOLD_2017(int age) {

        double taxTreshold;

        if (age < 65) {
            taxTreshold = 75000;
        } else if (age < 75) {

            taxTreshold = 116150;

        } else {
            taxTreshold = 129850;
        }

        return taxTreshold;

    }

    /* This is a static method that determines the Tax treshold for 2018*/
    public static double TAX_TRESHOLD_2018(int age) {

        double taxTreshold;

        if (age > 75) {
            taxTreshold = 129850;
            
        } else if (age >65) {

            taxTreshold = 116150;

        } else {
            taxTreshold = 75000;
        }

        return taxTreshold;

    }

    /*This method determines the medical aid payments annually*/
    public static double determinePayableMedicalAid(int numberOfMembers, int yearOfTax) {

        double medAidAnnually = 0;

        if (yearOfTax == 2017) {

            if (numberOfMembers > 2) {
                medAidAnnually = ((286 * 2) + (192 * (numberOfMembers - 2))) * 12;
            } else {
                medAidAnnually = (286 * numberOfMembers) * 12;
            }

        }else{
            if (numberOfMembers > 2) {
                medAidAnnually = ((303 * 2) + (204 * (numberOfMembers - 2))) * 12;
            } else {
                medAidAnnually = (303 * numberOfMembers) * 12;
            }
        
        }
        
        return medAidAnnually;

    }

    /*This method determines the annual payable*/
    public static double determinePayableTax(double totalEarnings, int age) {
        
          double calcTax;
          double amountTobeDeducted;

                if (totalEarnings <= 188000) {

                    /*This is the amount that is subtracted from the initial amount(Anually) percentage rate will be calculated from*/
                    amountTobeDeducted = 0;

                    /*Here we are determining the tax rebates to be deducted depending on age*/
                    if (age >= 75) {
                        calcTax = ((((totalEarnings - amountTobeDeducted) * 0.18) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017) - StaticValues.TERTIARY_REBATE_2017;

                    } else if (age >= 65) {
                        calcTax = (((totalEarnings - amountTobeDeducted) * 0.18) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017;
                    } else {
                        calcTax = ((totalEarnings - amountTobeDeducted) * 0.18) - StaticValues.PRIMARY_REBATE_2017;
                    }

                } else if (totalEarnings <= 293600) {

                    /*This is the amount that is subtracted from the initial amount(Anually) percentage rate will be calculated from*/
                    amountTobeDeducted = 188000;

                    /*Here we are determining the tax rebates to be deducted depending on age*/
                    if (age >= 75) {
                        calcTax = (((((totalEarnings - amountTobeDeducted) * 0.26) + 61296) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017) - StaticValues.TERTIARY_REBATE_2017;

                    } else if (age >= 65) {
                        calcTax = ((((totalEarnings - amountTobeDeducted) * 0.26) + 61296) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017;
                    } else {
                        calcTax = (((totalEarnings - amountTobeDeducted) * 0.26) + 33840) - StaticValues.PRIMARY_REBATE_2017;
                    }

                } else if (totalEarnings <= 406400) {

                    /*This is the amount that is subtracted from the initial amount(Anually) percentage rate will be calculated from*/
                    amountTobeDeducted = 293600;

                    /*Here we are determining the tax rebates to be deducted depending on age*/
                    if (age >= 75) {
                        calcTax = (((((totalEarnings - amountTobeDeducted) * 0.31) + 61296) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017) - StaticValues.TERTIARY_REBATE_2017;

                    } else if (age >= 65) {
                        calcTax = ((((totalEarnings - amountTobeDeducted) * 0.31) + 61296) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017;
                    } else {
                        calcTax = (((totalEarnings - amountTobeDeducted) * 0.31) + 61296) - StaticValues.PRIMARY_REBATE_2017;
                    }

                } else if (totalEarnings <= 550100) {

                    /*This is the amount that is subtracted from the initial amount(Anually) percentage rate will be calculated from*/
                    amountTobeDeducted = 406400;

                    /*Here we are determining the tax rebates to be deducted depending on age*/
                    if (age >= 75) {
                        calcTax = (((((totalEarnings - amountTobeDeducted) * 0.36) + 96264) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017) - StaticValues.TERTIARY_REBATE_2017;

                    } else if (age >= 65) {
                        calcTax = ((((totalEarnings - amountTobeDeducted) * 0.36) + 96264) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017;
                    } else {
                        calcTax = (((totalEarnings - amountTobeDeducted) * 0.36) + 96264) - StaticValues.PRIMARY_REBATE_2017;
                    }

                } else if (totalEarnings <= 701300) {

                    /*This is the amount that is subtracted from the initial amount(Anually) percentage rate will be calculated from*/
                    amountTobeDeducted = 550100;

                    /*Here we are determining the tax rebates to be deducted depending on age*/
                    if (age >= 75) {
                        calcTax = (((((totalEarnings - amountTobeDeducted) * 0.39) + 147996) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017) - StaticValues.TERTIARY_REBATE_2017;

                    } else if (age >= 65) {
                        calcTax = ((((totalEarnings - amountTobeDeducted) * 0.39) + 147996) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017;
                    } else {
                        calcTax = (((totalEarnings - amountTobeDeducted) * 0.39) + 147996) - StaticValues.PRIMARY_REBATE_2017;
                    }

                } else {

                    /*This is the amount that is subtracted from the initial amount(Anually) percentage rate will be calculated from*/
                    amountTobeDeducted = 701300;

                    /*Here we are determining the tax rebates to be deducted depending on age*/
                    if (age >= 75) {
                        calcTax = (((((totalEarnings - amountTobeDeducted) * 0.41) + 206964) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017) - StaticValues.TERTIARY_REBATE_2017;

                    } else if (age >= 65) {
                        calcTax = ((((totalEarnings - amountTobeDeducted) * 0.41) + 206964) - StaticValues.PRIMARY_REBATE_2017) - StaticValues.SECONDARY_REBATE_2017;
                    } else {
                        calcTax = (((totalEarnings - amountTobeDeducted) * 0.41) + 206964) - StaticValues.PRIMARY_REBATE_2017;
                    }
                }

        return calcTax;
    }

}
