package Lessons;

import android.graphics.drawable.Drawable;

import com.financelingo.financelingo.R;

import java.util.HashMap;

public class BudgetingReadings {

    //Budgeting readings to be outputted to budgetingReading.xml
    public String[] readings = {
            "It’s recommended that your income is spent according to the 50/30/20 rule",
            "50% Expenses: necessary payments and purchases that you can’t avoid such as your mortgage, phone payment, rent, car payments, food, tuition, insurance, utilities",
            "30% Savings: money that isn’t spent but rather put aside for an emergency fund, investments (stocks, real estate, 401k, IRA), paying off debt ",
            "20% Fun: the remainder of your income that goes towards non-essential things that you want such as monthly subscriptions (Netflix, Spotify, etc), travel, dining out, shopping\n"
    };

    //Rule name array for 50/30/20
    public String[] rules = {"50/30/20 Rule", "50% Rule", "30% Rule", "20% Rule"};

    //array of drawables to flip through
    public int [] imageList = {R.drawable.budget, R.drawable.expenses, R.drawable.pig, R.drawable.fun};

    //Definitions of budgeting terms to be outputted upon hover of a key string
    public void definitions() {
        HashMap<String, String> defDictionary = new HashMap<String, String>();
        defDictionary.put("Post-tax income", "the amount of money you have after paying federal and state income taxes");
        defDictionary.put("Mortgage", "monthly payments for a home that has not been completely paid off yet that you will own once paid off");
        defDictionary.put("Rent", "monthly payments to a renter for the use of property, land owned by the renter");
        defDictionary.put("Tuition", "monthly or annual fees for attending an educational institution (private high school, college, trade school");
        defDictionary.put("Insurance", "payment to a company that promises to give you money when you are injured, die, or lose/damage property");
        defDictionary.put("Utilities", "payment to a company for the use of electricity, water, garbage disposal, internet, etc.");
        defDictionary.put("Emergency fund", "money put aside for use in the case of emergencies such as natural and economic disasters and unemployment");
        defDictionary.put("Investments", "money spent on items or assets in order to hopefully make more money (more on investments can be found in our investments module");
        defDictionary.put("Debt", "money owed to a lender for the repayment of loans (more on debt and loans can be found in our debts module)");
    }

    //return reading based on index
    public String getReading(int num){
        String reading = readings[num];
        return reading;
    }

    //return rule based on index
    public String getRule(int num){
        String rule = rules[num];
        return rule;
    }

}
