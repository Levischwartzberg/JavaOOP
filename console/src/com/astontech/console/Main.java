package com.astontech.console;

import com.astontech.bo.*;
import com.astontech.bo.interfaces.ContactInfo;
import com.astontech.dao.*;
import com.astontech.dao.mysql.*;
import com.astontech.dao.sqlserver.TestImpl;
import common.helpers.CharManipulate;
import common.helpers.MathHelper;
import common.helpers.StringHelper;
import org.apache.log4j.Logger;


import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;


public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here
//        LessonObjectsLAB();
//        LessonCollectionsLAB();
//        LessonStaticRefHash();
//        LessonHelpers();
//        InterfacesTest();
//        ReverseStringTest();
//        ComparableTest();
//        LoggerTest();
//        LessonDBConnection();
//        LessonExecQuery();
//        LessonGetStoredProc();
//        LessonDAO();
//        SQLServerTest();
//        EmployeeDAOTest();
//        VehicleDAOTest();
//        VehicleModelDAOTest();
//        VehicleMakeDAOTest();
//        LessonPersonInsert();
//        LessonPersonUpdate();
//        LessonPersonDelete();
//        VehicleMakeExecTest();
//        VehicleMakeUpdateTest();
//        VehicleMakeDeleteTest();
//        VehicleModelExecTests();
//        VehicleExecTests();
//        PhoneExecTests();
    }

    private static void Welcome() {
        System.out.println("Welcome to business objects!");
        System.out.println();
    }

    private static void LessonObjectsLAB() {
        Welcome();

        Person Belinda = new Person(1, "Ms.", "Belinda", null, "Blumenthal", new Date(System.currentTimeMillis()), "Belinda", false, "Female", new Date("8/8/1987"), "123456789");
        System.out.println(Belinda.getFirstName() + " " + Belinda.getLastName());
        Belinda.PrintPersonInfo();

        Employee BelindaEmp = new Employee(1, "Ms.", "Belinda", null, "Blumenthal", new Date(System.currentTimeMillis()), "Belinda", false, "Female", new Date("8/8/1987"), "123456789", 1, new Date("5/8/2010"), null, new Date(System.currentTimeMillis()));
        BelindaEmp.PrintEmployeeInfo();

//        Vehicle FordF150 = new Vehicle(1, "Ford", new Date(System.currentTimeMillis()), 1, "F150", 1, 2010, "123ABC", "Ag4345", "black", false, 19000, new Date("5/23/2013"),1);
//        FordF150.printVehicleInfo();

        Phone phone1 = new Phone(1, 1, 0, 0, 612, 1237654, 0);
        phone1.printPhoneNumber();

        Client client1 = new Client(1, "Bobbert Solutions", new Date(System.currentTimeMillis()));
        client1.printClientInfo();
    }

    public static void LessonCollectionsLAB() {
        Vehicle FordF150 = new Vehicle();
        VehicleModel F150 = new VehicleModel(1,"F150");
        VehicleMake Ford = new VehicleMake(1,"Ford",new Date(System.currentTimeMillis()));
        FordF150.setVehicleModel(F150);
        F150.setVehicleMake(Ford);
        FordF150.setColor("black");
        FordF150.setPurchaseDate(new Date(6/15/2015));
        FordF150.setYear(2012);
        FordF150.printInfo();

        Vehicle FordFocus = new Vehicle();
        VehicleModel Focus = new VehicleModel(2, "Focus");
        FordFocus.setVehicleModel(Focus);
        Focus.setVehicleMake(Ford);
        FordFocus.setColor("white");
        FordFocus.setYear(2016);
        FordFocus.printInfo();

        Vehicle HondaCRV = new Vehicle();
        VehicleModel CRV = new VehicleModel(3,"CRV");
        VehicleMake Honda = new VehicleMake(2,"Honda", new Date(System.currentTimeMillis()));
        HondaCRV.setVehicleModel(CRV);
        CRV.setVehicleMake(Honda);
        HondaCRV.setColor("blue");
        HondaCRV.setYear(2013);
        HondaCRV.printInfo();
        System.out.println(StringHelper.countLetters(HondaCRV.getVehicleModel().getVehicleModelName()));
    }

    public static void LessonStaticRefHash() {
        //Instance v.s. Static
        //An instance is synonymous with an occurrence. For example, in the world of OOP, objects may be created many times.
        //When an object is created, it is an instance of that object, i.e. the object has been instantiated.
        //A static class is meant to be called once; hence why the main method is static, it is only intended to be run once.
        //A variable might also be static if the intent is to keep it unchanged.
        // If static, a class member is also accessible without instantiating the class.

        //Reference v.s. Value Types
        //When objects are created, a reference to them is created, and attributes are obtained from that reference.
        //When primitive data types are created, a new reference is created, or more importantly, they are assigned a specific value.
        //Thus, when altering an object, the reference must be edited, whereas the specific variable must be edited to change a primitive type variable.
        //The following example illustrates this concept
        Person myPerson1 = new Person();
        myPerson1.setFirstName("Buddy");
        Person myPerson2 = myPerson1;

        System.out.println("Person1: " + myPerson1.getFirstName() + "      Person2: " + myPerson2.getFirstName() );
        //Person2 was assigned to the reference of Person since they are both person objects.
        //When we change the value of one, we change the value of both.
        myPerson2.setFirstName("Frank");
        System.out.println("Person1: " + myPerson1.getFirstName() + "      Person2: " + myPerson2.getFirstName() );

        //with ints and values
        int myInt1 = 5;
        int myInt2 = myInt1;

        System.out.println("Int 1: " + myInt1 + "   Int 2: " + myInt2);
        myInt2 = 6;
        System.out.println("Int 1: " + myInt1 + "   Int 2: " + myInt2);

        //HASH
        Hashtable<Integer, String> funnies = new Hashtable<>();
        funnies.put(1,"doorknob");
        funnies.put(2,"jugs");
        funnies.put(3,"elbows");
        funnies.put(4,"balls");

        for(Integer key : funnies.keySet()) {
            System.out.println("key: " + key + "    value: " + funnies.get(key));
        }

        HashMap<Integer, String> funnier = new HashMap<>();
        funnier.put(1, "knob");
        funnier.put(2, "johnson");
        funnier.put(3, "pecker");
        funnier.put(4, "wilson");

        for(Integer key : funnier.keySet()) {
            System.out.println("key: " + key + "    value: " + funnier.get(key));
        }

        HashSet<String> funniest = new HashSet<>();
        funniest.add("milkers");
        funniest.add("jugs");
        funniest.add("melons");
        funniest.add("knockers");

        for (String s : funniest) {
            System.out.println(s);
        }
    }

    public static void LessonHelpers() {
        System.out.println(MathHelper.Factorial(6));
        System.out.println(MathHelper.Exponentiate(4,3));
        System.out.println(MathHelper.CircleArea(3));
    }

    private static void InterfacesTest() {
        Phone myPhone = new Phone();
        myPhone.setPhoneNumber(1234567);
        myPhone.setPrimary(true);
        Interfaces(myPhone);
    }

    private static void Interfaces(ContactInfo ContactInfo) {
        System.out.println("Contact Info Type: " + ContactInfo.getClass().getSimpleName());
        System.out.println("Primary Contact?: " + ContactInfo.primaryContact());
    }

    private static void ReverseStringTest() {
        String myString = "Madam I'm Not Adam.";
        System.out.println(CharManipulate.ReverseString(myString));
    }

    private static void ComparableTest() {
        Person person1 = new Person();
        person1.setFirstName("Burt");
        person1.setLastName("Johnson");
        Person person2 = new Person();
        person2.setFirstName("Bubba");
        person2.setLastName("Johnson");
        System.out.println(person1.compareTo(person2));
    }

    private static void LoggerTest() {
        logger.debug("This is a DEBUG message :)");
    }

    private static Connection LessonDBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            logger.error("MySQL Driver not found!");
            return null;
        }
        logger.info("MySQL Driver Registered! :)");

        Connection connection = null;

        try {
            String dbHost = "localhost";
            String dbName = "astonengineer";
            String dbUser = "consoleUser";
            String dbPass = "MySQLpasscode123!";
            String useSSL = "false";
            String procBod = "true";
            connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":3306/" + dbName + "?useSSL=" + useSSL + "&noAccessToProcedureBodies=" + procBod, dbUser, dbPass);
        } catch (SQLException ex) {
            logger.error("Connection failed! " + ex);
            return null;
        }
        if (connection != null) {
            logger.info("Succesfully connected to mySQL database! :)");
            return connection;
        }
        else {
            logger.info("Connection Failed!");
            return null;
        }

    }

    private static void LessonExecQuery() {
        Connection conn = LessonDBConnection();
        try {
            Statement statment = conn.createStatement();
            String query = "select PersonId, FirstName, LastName from person;";

            ResultSet rs = statment.executeQuery(query);
            while(rs.next()) {
                int personId = rs.getInt(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                logger.info("ID: " + personId + "   First Name: " + firstName + "   Last Name: " + lastName);
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }

    private static void LessonGetStoredProc() {
        Connection conn = LessonDBConnection();
        try {
            String getPerson = "{call GetPerson(?,?)}";
            CallableStatement cStmt = conn.prepareCall(getPerson);

            cStmt.setInt(1,20);
            cStmt.setInt(2,1);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                logger.info(rs.getInt(1) + ": "+ rs.getString(3) + ": " + rs.getString(5));
            }
        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }
    }

    private static void LessonDAO() {
        //region Create Menu
        PersonDAO personDAO = new PersonDAOImplementation();
        List<Person> personList = personDAO.getPersonList();
        System.out.println("-----------------------------");

        for(Person person : personList) {
            System.out.println(person.getPersonId() + ") " + person.getFirstName() + " " + person.getLastName());
        }

        System.out.println("-----------------------------");
        //endregion


        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a person from the list by entering their ID.");
        String personId = scanner.nextLine();
        //endregion


        //region Get Person Details
        Person personDetail = personDAO.getPersonById(Integer.parseInt(personId));
        System.out.println("--------- Person Details ---------");
        System.out.println("Full Name: " + personDetail.getFirstName() + " " + personDetail.getLastName());
        System.out.println("DOB: " + personDetail.getBirthDate());
        System.out.println("SSN: " + personDetail.getSocialSecurityNumber());
        //endregion
    }

    public static void SQLServerTest() {
        TestImpl test = new TestImpl();
        test.getTestString(1);
    }

    private static void EmployeeDAOTest() {
        //region Create Menu
        EmployeeDAO employeeDAO = new EmployeeDAOImplementation();
        List<Employee> employeeList = employeeDAO.getEmployeeList();
        System.out.println("-----------------------------");

        for(Employee employee : employeeList) {
            System.out.println(employee.getEmployeeId() + "  " + employee.getPersonId());
        }

        System.out.println("-----------------------------");
        //endregion


        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select an employee from the list by entering their ID.");
        String personId = scanner.nextLine();
        //endregion


        //region Get Person Details
        Employee employeeDetail = employeeDAO.getEmployeeById(Integer.parseInt(personId));
        System.out.println("--------- Person Details ---------");
        System.out.println("Employee Id, Person Id: " + employeeDetail.getEmployeeId() + " " + employeeDetail.getPersonId());
        //endregion
    }

    private static void VehicleDAOTest() {
        //region Create Menu
        VehicleDAO vehicleDAO = new VehicleDAOImplementation();
        List<Vehicle> vehicleList = vehicleDAO.getVehicleList();
        System.out.println("-----------------------------");

        for(Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getVehicleId() + "  " + vehicle.getLicensePlate() + " " + vehicle.getVehicleModel().getVehicleModelName());
        }

        System.out.println("-----------------------------");
        //endregion


        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a vehicle from the list by entering its ID.");
        String vehicleId = scanner.nextLine();
        //endregion


        //region Get Vehicle Details
        Vehicle vehicleDetail = vehicleDAO.getVehicleById(Integer.parseInt(vehicleId));
        System.out.println("--------- Vehicle Details ---------");
        System.out.println("Vehicle Id: " + vehicleDetail.getVehicleId());
        System.out.println("Vehicle Model: " + vehicleDetail.getVehicleModel().getVehicleModelName());
        System.out.println("Vehicle Color: " + vehicleDetail.getColor());
        System.out.println("Vehicle Year: " + vehicleDetail.getYear());
        System.out.println("Vehicle License Plate: " + vehicleDetail.getLicensePlate());
        //endregion
    }

    private static void VehicleModelDAOTest() {
        //region Create Menu
        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImplementation();
        List<VehicleModel> vehicleModelList = vehicleModelDAO.getVehicleModelList();
        System.out.println("-----------------------------");

        for(VehicleModel vehicleModel : vehicleModelList) {
            System.out.println(vehicleModel.getVehicleModelId() + "  " + vehicleModel.getVehicleModelName() + " " + vehicleModel.getVehicleMake().getVehicleMakeName());
        }

        System.out.println("-----------------------------");
        //endregion


        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a vehicle model from the list by entering its ID.");
        String vehicleModelId = scanner.nextLine();
        //endregion


        //region Get Vehicle Details
        VehicleModel vehicleModelDetail = vehicleModelDAO.getVehicleModelById(Integer.parseInt(vehicleModelId));
        System.out.println("--------- Vehicle Model Details ---------");
        System.out.println("Vehicle Model Id: " + vehicleModelDetail.getVehicleModelId());
        System.out.println("Vehicle Model Name: " + vehicleModelDetail.getVehicleModelName());
        System.out.println("Vehicle Make Name: " + vehicleModelDetail.getVehicleMake().getVehicleMakeName());
        //endregion
    }

    private static void VehicleMakeDAOTest() {
        //region Create Menu
        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImplementation();
        List<VehicleMake> vehicleMakeList = vehicleMakeDAO.getVehicleMakeList();
        System.out.println("-----------------------------");

        for(VehicleMake vehicleMake : vehicleMakeList) {
            System.out.println(vehicleMake.getVehicleMakeId() + "  " + vehicleMake.getVehicleMakeName());
        }

        System.out.println("-----------------------------");
        //endregion


        //region Prompt User
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a vehicle make from the list by entering its ID.");
        String vehicleMakeId = scanner.nextLine();
        //endregion


        //region Get Vehicle Details
        VehicleMake vehicleMakeDetail = vehicleMakeDAO.getVehicleMakeById(Integer.parseInt(vehicleMakeId));
        System.out.println("--------- Vehicle Make Details ---------");
        System.out.println("Vehicle Make Id: " + vehicleMakeDetail.getVehicleMakeId());
        System.out.println("Vehicle Make Name: " + vehicleMakeDetail.getVehicleMakeName());
        //endregion
    }

    private static void LessonPersonInsert() {
        Person person = new Person();
        person.setTitle("Mr.");
        person.setFirstName("Richard");
        person.setMiddleName("");
        person.setLastName("Harder");
        person.setBirthDate(new Date(1987, 11, 24));
        person.setCreateDate(new Date(System.currentTimeMillis()));
        person.setDisplayFirstName("Dick");
        person.setIsDeleted(false);
        person.setGender("Male");
        person.setSocialSecurityNumber("xxx-xx-xxxx");

        PersonDAO personDAO = new PersonDAOImplementation();
        int id = personDAO.insertPerson(person);
        logger.info("New Person Record Inserted. ID = " + id);
    }

    private static void LessonPersonUpdate() {
        PersonDAO personDAO = new PersonDAOImplementation();
        Person person = personDAO.getPersonById(12);
        person.setMiddleName("Sach");

        personDAO.updatePerson(person);
    }

    private static void LessonPersonDelete() {
        PersonDAO personDAO = new PersonDAOImplementation();
        Person person = personDAO.getPersonById(12);

        personDAO.deletePerson(person.getPersonId());
    }

    private static void VehicleMakeExecTest() {
        VehicleMake vehicleMake = new VehicleMake();
        vehicleMake.setVehicleMakeName("Chevrolet");
        vehicleMake.setCreateDate(new Date(System.currentTimeMillis()));

        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImplementation();
        int id = vehicleMakeDAO.insertVehicleMake(vehicleMake);
        logger.info("New Vehicle Make Record Inserted. ID = " + id);
    }

    private static void VehicleMakeUpdateTest() {
        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImplementation();
        VehicleMake vehicleMake = vehicleMakeDAO.getVehicleMakeById(11);

        vehicleMake.setVehicleMakeName("DERP!");
        vehicleMakeDAO.updateVehicleMake(vehicleMake);
    }

    private static void VehicleMakeDeleteTest() {
        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImplementation();
        VehicleMake vehicleMake = vehicleMakeDAO.getVehicleMakeById(11);

        vehicleMakeDAO.deleteVehicleMake(vehicleMake.getVehicleMakeId());
    }

    private static void VehicleModelExecTests() {
        //region INSERT VEHICLE MODEL
//        VehicleMakeDAO vehicleMakeDAO = new VehicleMakeDAOImplementation();
//        VehicleMake vehicleMake = vehicleMakeDAO.getVehicleMakeById(12);
//
//        VehicleModel vehicleModel = new VehicleModel();
//        vehicleModel.setVehicleModelName("Dookie");
//        vehicleModel.setVehicleMake(vehicleMake);
//
//        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImplementation();
//        int id = vehicleModelDAO.insertVehicleModel(vehicleModel);
//        logger.info("New Vehicle Model Record Inserted. ID = " + id);
        //endregion

        //region UPDATE VEHICLE MODEL
//        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImplementation();
//        VehicleModel vehicleModel = vehicleModelDAO.getVehicleModelById(25);
//
//        vehicleModel.setVehicleModelName("Volt");
//        vehicleModelDAO.updateVehicleModel(vehicleModel);
        //endregion

        //region DELETE VEHICLE MODEL
//        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImplementation();
//        VehicleModel vehicleModel = vehicleModelDAO.getVehicleModelById(26);
//
//        vehicleModelDAO.deleteVehicleModel(vehicleModel.getVehicleModelId());
        //endregion
    }

    private static void VehicleExecTests() {
        //region INSERT VEHICLE
//        VehicleModelDAO vehicleModelDAO = new VehicleModelDAOImplementation();
//        VehicleModel vehicleModel = vehicleModelDAO.getVehicleModelById(25);
//
//        Vehicle vehicle = new Vehicle();
//        vehicle.setYear(2017);
//        vehicle.setLicensePlate("WRU666");
//        vehicle.setColor("Blue");
//        vehicle.setVIN("142637agsheyt");
//        vehicle.setPurchased(true);
//        vehicle.setPurchasePrice(18000);
//        vehicle.setPurchaseDate(new Date(2018,4,26));
//        vehicle.setVehicleModel(vehicleModel);
//
//        VehicleDAO vehicleDAO = new VehicleDAOImplementation();
//        int id = vehicleDAO.insertVehicle(vehicle);
//        logger.info("New Vehicle Record Inserted. ID = " + id);
        //endregion

        //region UPDATE VEHICLE MODEL
//        VehicleDAO vehicleDAO = new VehicleDAOImplementation();
//        Vehicle vehicle = vehicleDAO.getVehicleById(24);
//
//        vehicle.setVIN("ayyye58b839f8h0");
//        vehicleDAO.updateVehicle(vehicle);
        //endregion

        //region DELETE VEHICLE MODEL
//        VehicleDAO vehicleDAO = new VehicleDAOImplementation();
//        Vehicle vehicle = vehicleDAO.getVehicleById(23);
//
//        vehicleDAO.deleteVehicle(vehicle.getVehicleId());
        //endregion
    }

    private static void PhoneExecTests() {
        //region INSERT PHONE
//        EntityTypeDAO entityTypeDAO = new EntityTypeDAOImplementation();
//        EntityType entityType = entityTypeDAO.getEntityTypeById(10);
//
//        ClientDAO clientDAO = new ClientDAOImplementation();
//        Client client = clientDAO.getClientById(11);
//
//        PersonDAO personDAO = new PersonDAOImplementation();
//        Person person = personDAO.getPersonById(13);
//
//        Phone phone = new Phone();
//        phone.setEntityType(entityType);
//        phone.setClient(client);
//        phone.setPerson(person);
//        phone.setAreaCode(612);
//        phone.setPhoneNumber(1548672);
//        phone.setPhoneNumberPost(123);
//
//        PhoneDAO phoneDAO = new PhoneDAOImplementation();
//        int id = phoneDAO.insertPhone(phone);
//        logger.info("New Phone Inserted. ID = " + id);
        //endregion

        //region UPDATE PHONE
//        PhoneDAO phoneDAO = new PhoneDAOImplementation();
//        Phone phone = phoneDAO.getPhoneById(10);
//
//        phone.setAreaCode(651);
//        phoneDAO.updatePhone(phone);
        //endregion

        //region DELETE PHONE
//        PhoneDAO phoneDAO = new PhoneDAOImplementation();
//        Phone phone = phoneDAO.getPhoneById(9);
//
//        phoneDAO.deletePhone(phone.getPhoneId());
        //endregion
    }
}
