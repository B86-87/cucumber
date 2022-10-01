package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;

public class DBStepDefs {

    @Given("user connects to the application database")
    public void user_connects_to_the_application_database(){

        DBUtils.createConnection();
    }

    @Given("user gets the column {string} from table {string}")
    public void user_gets_the_column_from_table(String column, String table) {
//        String query = "SELECT * FROM tp_customer"; // HARD CODED
//        Writing query
        String query =   "SELECT "+column+" FROM "+table;
//        Executing the query
        DBUtils.executeQuery(query);

    }

    @Given("user reads all of the column {string} data")
    public void user_reads_all_of_the_column_data(String column) throws Exception {
//        next() -> going to the NEXT row
        DBUtils.getResultset().next();
//        I am on the 1st column
//        getObject(column) -> returns the data on that column
        Object column1 = DBUtils.getResultset().getObject(column);
        System.out.println(column1);


//       Going to the next line
        DBUtils.getResultset().next();
        Object column2= DBUtils.getResultset().getObject(column);
        System.out.println(column2);



//        Going to the next row
        DBUtils.getResultset().next();
        String column3=DBUtils.getResultset().getString(column);
        System.out.println(column3);

        int count=3;
//        printing ALL SSN using a loop -> DBUtils.getResultset().next() returns true if there is a next element
        while (DBUtils.getResultset().next()){
            count++;
//            getting the data in the current row
            Object currentRowData = DBUtils.getResultset().getObject(column);
//            printing current row data
            System.out.println(currentRowData);


        }
//        Printing the row count
        System.out.println("There are "+count+" row!");
//      Or we can uer DBUtil method to get the row count
        System.out.println("Row Count "+ DBUtils.getRowCount());

    }

    @Then("user close the connection")
    public void user_close_the_connection() {
        DBUtils.closeConnection();
    }

    @Then("verify table {string} and column {string} contains data {string}")
    public void verify_table_and_column_contains_data(String table, String column, String data) {
        //query to get the table data
        String query = "SELECT * FROM "+table;

        //reusable util method to get ALL COLUMN DATA IN THAT TABLE
        List<Object> allColumnData = DBUtils.getColumnData(query,column);
        System.out.println(allColumnData);

        //Assert to see if column contains a specific data
        Assert.assertTrue(allColumnData.contains(data));
    }

    @Then("verify the columns names from table {string} contains data {string}")
    public void verify_the_columns_names_from_table_contains_data(String table, String column) {
        String query = "SELECT * FROM "+table;
        List<String> columnNames = DBUtils.getColumnNames(query);
        Assert.assertTrue(columnNames.contains(column));
    }
}
