import javax.swing.*;


public class BOGUI extends JFrame {
    public static int count =1;
    public final String BO_DBNAME = "BO"+this.count;


    BOGUI(){
        ManageData.createDb(BO_DBNAME);
        ManageData.createProductTable(BO_DBNAME);
        ManageData.sendOldDataToHO(BO_DBNAME);
        new BOinterface(BO_DBNAME);
        count = count+1;
    }

    public static void main(String[] args) {
        new BOGUI();
        new BOGUI();
    }
}