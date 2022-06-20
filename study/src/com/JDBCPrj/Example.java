package com.JDBCPrj;

public class Example {
    public static void main(String[] args) {
        DBManager dbm = new DBManager();

        dbm.getConnection("jdbc:oracle:thin:@localhost:1521:XE","C##TEST","oracle");

//        dbm.query("SELECT EMP_NAME as Name, job_id as JOB, salary as Salary, 12*salary+100 as \"Increased Ann_salary\", 12*(salary+100)as \"Increased Salary\" FROM Employees");
//        dbm.print(5);
        dbm.query1("EMP_NAME, job_id as JOB, salary as Salary, manager_id, HIRE_DATE","Employees","manager_id= 100","manager_id");
        dbm.print(5);

        dbm.close();
    }
}
// System.out.printf("%s %s%n", var1, var2);
//        dbm.select("JOBS", "JOB_ID","AD_VP", "JOB_TITLE", "Administration Vice President");