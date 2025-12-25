package com.mycompany.hms;

import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.beans.property.*;


public class App extends Application {
private Admin admin=new Admin("admin","1234"); 
private Hospital hospital1=new Hospital();
private TableView<Patient> patientTable;
private TableView<Doctor> doctorTable;
private TableView<Appointment> appointmentTable;
public Scene loginPage(Stage stage){

    ImageView login = new ImageView(new Image(getClass().getResourceAsStream("/icons/LOGIN.png")));
    login.setFitHeight(200); 
    login.setPreserveRatio(true);

    HBox h4 = new HBox(login);
    h4.setAlignment(Pos.CENTER);

    ImageView img1 = new ImageView(new Image(getClass().getResourceAsStream("/icons/user.png")));
    img1.setFitHeight(28); img1.setFitWidth(28);

    TextField t1 = new TextField();
    t1.setPromptText("Username");
    t1.setStyle("-fx-background-radius:8; -fx-padding:8;");

    HBox h1 = new HBox(10, img1, t1);
    h1.setAlignment(Pos.CENTER);

    ImageView img2 = new ImageView(new Image(getClass().getResourceAsStream("/icons/key.png")));
    img2.setFitHeight(28); img2.setFitWidth(28);

    PasswordField p1 = new PasswordField();
    p1.setPromptText("Password");
    p1.setStyle("-fx-background-radius:8; -fx-padding:8;");

    HBox h2 = new HBox(10, img2, p1);
    h2.setAlignment(Pos.CENTER);

    Button b1 = new Button("Login");
    b1.setStyle("-fx-background-color:#2ECC71; -fx-text-fill:white; "
            + "-fx-font-weight:bold; -fx-background-radius:8; -fx-padding:8 20;");
    b1.setOnAction(u -> {
        if(t1.getText().equals(admin.getUsername()) && p1.getText().equals(admin.getPassword()))
            stage.setScene(dashBoard(stage));
        else
            System.out.println("Invalid Credentials!");
    });

    Button b2 = new Button("Cancel");
    b2.setStyle("-fx-background-color:#ECF0F1; -fx-text-fill:#2C3E50; "
            + "-fx-font-weight:bold; -fx-background-radius:8; -fx-padding:8 20;");
    b2.setOnAction(e -> { t1.clear(); p1.clear(); });

    HBox h3 = new HBox(15, b1, b2);
    h3.setAlignment(Pos.CENTER);

    VBox main = new VBox(15, h4, h1, h2, h3);
    main.setAlignment(Pos.CENTER);
    main.setPadding(new Insets(25));
    main.setStyle("-fx-background-color: white;-fx-background-radius: 15;"
            + "-fx-border-color: #E0E0E0;-fx-border-radius: 15;");

    return new Scene(main, 450, 500);
}

public TableView<Patient> createPatientTable() {
    patientTable = new TableView<>();

    TableColumn<Patient, String> colName = new TableColumn<>("Name");
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Patient, Integer> colAge = new TableColumn<>("Age");
    colAge.setCellValueFactory(new PropertyValueFactory<>("age"));

    TableColumn<Patient, String> colGender = new TableColumn<>("Gender");
    colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

    TableColumn<Patient, String> colCNIC = new TableColumn<>("CNIC");
    colCNIC.setCellValueFactory(new PropertyValueFactory<>("CNIC"));

    TableColumn<Patient, String> colDisease = new TableColumn<>("Disease");
    colDisease.setCellValueFactory(cell -> 
        new SimpleStringProperty(cell.getValue().metaData.disease)
    );

    TableColumn<Patient, String> colPhone = new TableColumn<>("Phone");
    colPhone.setCellValueFactory(cell -> 
        new SimpleStringProperty(cell.getValue().metaData.phone));

    TableColumn<Patient, Integer> colBillID = new TableColumn<>("BillID");
    colBillID.setCellValueFactory(cell ->
        new SimpleIntegerProperty(cell.getValue().getbillId()).asObject()
    );

    TableColumn<Patient, Integer> colServiceCharges = new TableColumn<>("Service Charges");
    colServiceCharges.setCellValueFactory(cell ->
        new SimpleIntegerProperty(cell.getValue().getserviceCharges()).asObject()
    );

    TableColumn<Patient, Integer> colMedicineCharges = new TableColumn<>("Medicine Charges");
    colMedicineCharges.setCellValueFactory(cell ->
        new SimpleIntegerProperty(cell.getValue().getmedicineCharges()).asObject()
    );

    TableColumn<Patient, Integer> colTotal = new TableColumn<>("Total");
    colTotal.setCellValueFactory(cell ->
        new SimpleIntegerProperty(cell.getValue().gettotal()).asObject()
    );
    
    patientTable.getColumns().addAll(
        colName, colAge, colGender, colCNIC, colDisease, colPhone,
        colBillID, colServiceCharges, colMedicineCharges, colTotal
    );
    
    patientTable.setItems(hospital1.patientRepo.getAll());
    patientTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    return patientTable;
}
public TableView<Doctor> createDoctorTable() {
    doctorTable = new TableView<>();

    TableColumn<Doctor, String> colName = new TableColumn<>("Name");
    colName.setCellValueFactory(new PropertyValueFactory<>("name"));

    TableColumn<Doctor, Integer> colAge = new TableColumn<>("Age");
    colAge.setCellValueFactory(new PropertyValueFactory<>("age"));

    TableColumn<Doctor, String> colGender = new TableColumn<>("Gender");
    colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

    TableColumn<Doctor, String> colCNIC = new TableColumn<>("CNIC");
    colCNIC.setCellValueFactory(new PropertyValueFactory<>("CNIC"));

    TableColumn<Doctor, String> colSpecialization = new TableColumn<>("Specialization");
    colSpecialization.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getspecialization()));

    TableColumn<Doctor, Integer> colSalary = new TableColumn<>("Salary");
    colSalary.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getsalary()).asObject());

    TableColumn<Doctor, Boolean> colAvailability = new TableColumn<>("Available");
    colAvailability.setCellValueFactory(cell -> new SimpleBooleanProperty(cell.getValue().getisAvailable()));

    doctorTable.getColumns().addAll(colName, colAge, colGender, colCNIC, colSpecialization, colSalary, colAvailability);

    doctorTable.setItems(hospital1.doctorRepo.getAll());
    doctorTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    return doctorTable;
}
public TableView<Appointment> createAppointmentTable() {
    appointmentTable = new TableView<>();

    TableColumn<Appointment, Integer> colID = new TableColumn<>("Appointment ID");
    colID.setCellValueFactory(cell ->
        new SimpleIntegerProperty(cell.getValue().appointmentID).asObject()
    );

    TableColumn<Appointment, String> colPatient = new TableColumn<>("Patient Name");
    colPatient.setCellValueFactory(cell ->
        new SimpleStringProperty(cell.getValue().patient.getName())
    );

    TableColumn<Appointment, String> colDoctor = new TableColumn<>("Doctor Name");
    colDoctor.setCellValueFactory(cell ->
        new SimpleStringProperty(cell.getValue().doctor.getName())
    );

    TableColumn<Appointment, String> colDate = new TableColumn<>("Date");
    colDate.setCellValueFactory(cell ->
        new SimpleStringProperty(cell.getValue().date)
    );

    appointmentTable.getColumns().addAll(colID, colPatient, colDoctor, colDate);

    appointmentTable.setItems(hospital1.appointmentRepo.getAll());
    appointmentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    return appointmentTable;
}

public Scene dashBoard(Stage stage){

    Button b1 = new Button("Home");
    Button b2 = new Button("Patient");
    Button b3 = new Button("Doctor");
    Button b4 = new Button("Appointment");
    Button b5 = new Button("Billing");
    Button b6 = new Button("Logout");
    Button[] buttons = {b1, b2, b3, b4, b5,b6};
    for(Button b : buttons){
        b.setPrefWidth(100);
        b.setStyle("-fx-background-color: #34495E; -fx-text-fill:white;");
    }
    VBox sideBar = new VBox(15);
    sideBar.setPadding(new Insets(20));
    sideBar.setAlignment(Pos.TOP_CENTER);
    sideBar.getChildren().addAll(b1, b2, b3, b4, b5,b6);
    sideBar.setStyle("-fx-background-color: #2C3E50;");

    ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("/icons/Logo.png")));
    logo.setFitHeight(150);
    logo.setPreserveRatio(true);

    Label l1 = new Label("Welcome to Hospital Management System!");
    l1.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #2C3E50;");

    Label l2 = new Label("Patient's Data:");
    l2.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2C3E50;");
    
    Label l3 = new Label("Doctor's Data:");
    l3.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2C3E50;");
    
    Label l4 = new Label("Appointments:");
    l4.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #2C3E50;");
    
    VBox v1 = new VBox(15);
    v1.setPadding(new Insets(20));
    v1.getChildren().addAll(logo,l1);
    VBox v2 = new VBox(15);
    v2.setPadding(new Insets(20));
    v2.getChildren().addAll(l2, createPatientTable(),l3,createDoctorTable(),l4,createAppointmentTable());
    ScrollPane sp1=new ScrollPane(v2);
    sp1.setFitToWidth(true);
    BorderPane bp1 = new BorderPane();
    bp1.setTop(v1);
    bp1.setLeft(sideBar);
    bp1.setCenter(sp1);

    b1.setOnAction(e->{bp1.setCenter(sp1);});
    b2.setOnAction(e->{
    ScrollPane sp2=new ScrollPane(patientPanel());
    sp2.setFitToWidth(true);
    bp1.setCenter(sp2);
    });
    b3.setOnAction(e->{
    ScrollPane sp3=new ScrollPane(doctorPanel());
    sp3.setFitToWidth(true);
    bp1.setCenter(sp3);
    });
    b4.setOnAction(e->{bp1.setCenter(appointmentPanel());});
    b5.setOnAction(e->{bp1.setCenter(billingPanel());});
    b6.setOnAction(e->{
        hospital1.patientRepo.saveToFile();
        hospital1.doctorRepo.saveToFile();
        hospital1.appointmentRepo.saveToFile();
        stage.setScene(loginPage(stage));
    
    });
    Scene scene = new Scene(bp1, 800, 620);
    return scene;
}
private VBox patientPanel() {

    Label title = new Label("Patient Management");
    title.setStyle("-fx-font-size:20; -fx-font-weight:bold; -fx-text-fill: #2C3E50;");

    TextField tfName    = new TextField(); tfName.setPromptText("Name");
    TextField tfAge     = new TextField(); tfAge.setPromptText("Age");
    TextField tfGender  = new TextField(); tfGender.setPromptText("Gender");
    TextField tfCNIC    = new TextField(); tfCNIC.setPromptText("CNIC");
    TextField tfPhone   = new TextField(); tfPhone.setPromptText("Phone");
    TextField tfDisease = new TextField(); tfDisease.setPromptText("Disease");
    TextField tfBillId = new TextField(); tfBillId.setPromptText("billId(Required only for Update/Delete)");
    
    String fieldStyle = "-fx-background-radius:8; -fx-padding:8;";
    tfName.setStyle(fieldStyle);
    tfAge.setStyle(fieldStyle);
    tfGender.setStyle(fieldStyle);
    tfCNIC.setStyle(fieldStyle);
    tfPhone.setStyle(fieldStyle);
    tfDisease.setStyle(fieldStyle);
    tfBillId.setStyle(fieldStyle);
    
    Button b1 = new Button("Add");
    Button b2 = new Button("Update");
    Button b3 = new Button("Delete");

    b1.setStyle("-fx-background-color:#2ECC71; -fx-text-fill:white; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:8 18;");
    b2.setStyle("-fx-background-color:#F1C40F; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:8 18;");
    b3.setStyle("-fx-background-color:#E74C3C; -fx-text-fill:white; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:8 18;");

    b1.setOnAction(e -> {
        try {
            hospital1.patientRepo.add(
                new Patient(tfName.getText(), Integer.parseInt(tfAge.getText()),
                tfGender.getText(), tfCNIC.getText(), tfDisease.getText(),
                tfPhone.getText(), new Bill())
            );
            tfName.clear(); tfAge.clear(); tfGender.clear();
            tfCNIC.clear(); tfPhone.clear(); tfDisease.clear();
            tfBillId.clear();
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Age!");
        }
    });

    b2.setOnAction(e -> {
        try {
            int billId = Integer.parseInt(tfBillId.getText());
            Patient p = hospital1.patientRepo.getById(billId);
            hospital1.patientRepo.update(
                new Patient(tfName.getText(), Integer.parseInt(tfAge.getText()),
                tfGender.getText(), tfCNIC.getText(), tfDisease.getText(),
                tfPhone.getText(),p.metaData.bill)
            );
            tfName.clear(); tfAge.clear(); tfGender.clear();
            tfCNIC.clear(); tfPhone.clear(); tfDisease.clear();
            tfBillId.clear();
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Age or BillId!");
        }
    });

    b3.setOnAction(e -> {
        try {
            int billId = Integer.parseInt(tfBillId.getText());
            Patient p = hospital1.patientRepo.getById(billId);
            hospital1.patientRepo.delete(
                new Patient(tfName.getText(), Integer.parseInt(tfAge.getText()),
                tfGender.getText(), tfCNIC.getText(), tfDisease.getText(),
                tfPhone.getText(),p.metaData.bill)
            );
            tfName.clear(); tfAge.clear(); tfGender.clear();
            tfCNIC.clear(); tfPhone.clear(); tfDisease.clear();
            tfBillId.clear();
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Age or BillId!");
        }
    });

    HBox actions = new HBox(15, b1, b2, b3);
    actions.setAlignment(Pos.CENTER);
    
    Label searchLabel = new Label("Search Patient by Bill ID");
    searchLabel.setStyle("-fx-font-weight:bold; -fx-text-fill:#34495E; -fx-font-size:14;");

    TextField tfSearch = new TextField();
    tfSearch.setPromptText("Enter Bill ID");
    tfSearch.setStyle(fieldStyle);

    Button btnSearch = new Button("Search");
    btnSearch.setStyle("-fx-background-color:#3498DB; -fx-text-fill:white; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:6 15;");

    Label lblResult = new Label();
    lblResult.setStyle("-fx-text-fill:#E67E22; -fx-font-weight:bold; -fx-font-size:14;");

    btnSearch.setOnAction(e -> {
        try {
            int billId = Integer.parseInt(tfSearch.getText());
            Patient p = hospital1.patientRepo.getById(billId); 
            if (p != null) {
                lblResult.setText(p.displayInfoString());
            } else {
                lblResult.setText("Patient not found!");
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Invalid Bill ID!");
        }
    });

    HBox searchBox = new HBox(10, tfSearch, btnSearch);
    searchBox.setAlignment(Pos.CENTER);

    VBox searchSection = new VBox(8, searchLabel, searchBox, lblResult);
    searchSection.setPadding(new Insets(15));
    searchSection.setStyle("-fx-background-color:#FDFEFE; -fx-background-radius:10; -fx-border-color:#D5D8DC; -fx-border-radius:10;");


    VBox panel = new VBox(12,
            title, tfName, tfAge, tfGender, tfCNIC, tfPhone, tfDisease,tfBillId, actions,searchSection);
    panel.setPadding(new Insets(25));
    panel.setStyle("-fx-background-color:white;-fx-background-radius:15;-fx-border-color:#E0E0E0;-fx-border-radius:15;");

    return panel;
}
private VBox doctorPanel() {

    Label title = new Label("Doctor Management");
    title.setStyle("-fx-font-size:20; -fx-font-weight:bold; -fx-text-fill: #2C3E50;");

    TextField tfName   = new TextField(); tfName.setPromptText("Name");
    TextField tfAge    = new TextField(); tfAge.setPromptText("Age");
    TextField tfGender = new TextField(); tfGender.setPromptText("Gender");
    TextField tfCNIC   = new TextField(); tfCNIC.setPromptText("CNIC");
    TextField tfSpec   = new TextField(); tfSpec.setPromptText("Specialization");
    TextField tfSalary = new TextField(); tfSalary.setPromptText("Salary");

    String fieldStyle = "-fx-background-radius:8; -fx-padding:8;";
    tfName.setStyle(fieldStyle);
    tfAge.setStyle(fieldStyle);
    tfGender.setStyle(fieldStyle);
    tfCNIC.setStyle(fieldStyle);
    tfSpec.setStyle(fieldStyle);
    tfSalary.setStyle(fieldStyle);

    Button b1 = new Button("Add");
    Button b2 = new Button("Update");
    Button b3 = new Button("Delete");

    b1.setStyle("-fx-background-color:#2ECC71; -fx-text-fill:white; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:8 18;");
    b2.setStyle("-fx-background-color:#F1C40F; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:8 18;");
    b3.setStyle("-fx-background-color:#E74C3C; -fx-text-fill:white; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:8 18;");

    b1.setOnAction(e -> {
        try {
            Person pe=new Doctor();
            pe.setName(tfName.getText());
            pe.setAge(Integer.parseInt(tfAge.getText()));
            pe.setGender(tfGender.getText());
            pe.setCNIC(tfCNIC.getText());
            Doctor d=(Doctor) pe;
            d.metaData.specialization=tfSpec.getText();
            d.metaData.salary=Integer.parseInt(tfSalary.getText());
            d.metaData.isAvailable=true;
            hospital1.doctorRepo.add(d);
            tfName.clear(); tfAge.clear(); tfGender.clear();
            tfCNIC.clear(); tfSpec.clear(); tfSalary.clear();
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Age or Salary!");
        }
    });

    b2.setOnAction(e -> {
        try {
            Person pe=new Doctor();
            pe.setName(tfName.getText());
            pe.setAge(Integer.parseInt(tfAge.getText()));
            pe.setGender(tfGender.getText());
            pe.setCNIC(tfCNIC.getText());
            Doctor d=(Doctor) pe;
            d.metaData.specialization=tfSpec.getText();
            d.metaData.salary=Integer.parseInt(tfSalary.getText());
            d.metaData.isAvailable=true;
            hospital1.doctorRepo.update(d);
            tfName.clear(); tfAge.clear(); tfGender.clear();
            tfCNIC.clear(); tfSpec.clear(); tfSalary.clear();
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Age or Salary!");
        }
    });
            
           

    b3.setOnAction(e -> {
        try {
            Person pe=new Doctor();
            pe.setName(tfName.getText());
            pe.setAge(Integer.parseInt(tfAge.getText()));
            pe.setGender(tfGender.getText());
            pe.setCNIC(tfCNIC.getText());
            Doctor d=(Doctor) pe;
            d.metaData.specialization=tfSpec.getText();
            d.metaData.salary=Integer.parseInt(tfSalary.getText());
            d.metaData.isAvailable=true;
            hospital1.doctorRepo.delete(d);
            tfName.clear(); tfAge.clear(); tfGender.clear();
            tfCNIC.clear(); tfSpec.clear(); tfSalary.clear();
        } catch (NumberFormatException ex) {
            System.out.println("Invalid Age or Salary!");
        }
    });

    HBox actions = new HBox(15, b1, b2, b3);
    actions.setAlignment(Pos.CENTER);
    
    Label searchLabel = new Label("Search Doctor by Row#");
    searchLabel.setStyle("-fx-font-weight:bold; -fx-text-fill:#34495E; -fx-font-size:14;");

    TextField tfSearch = new TextField();
    tfSearch.setPromptText("Enter Row#");
    tfSearch.setStyle(fieldStyle);

    Button btnSearch = new Button("Search");
    btnSearch.setStyle("-fx-background-color:#3498DB; -fx-text-fill:white; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:6 15;");

    Label lblResult = new Label();
    lblResult.setStyle("-fx-text-fill:#E67E22; -fx-font-weight:bold; -fx-font-size:14;");

    btnSearch.setOnAction(e -> {
        try {
            int Id = Integer.parseInt(tfSearch.getText());
            Doctor d = hospital1.doctorRepo.getById(Id); 
            if (d != null) {
                lblResult.setText(d.displayInfoString());
            } else {
                lblResult.setText("Doctor not found!");
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Invalid Info!");
        }
    });
    HBox searchBox = new HBox(10, tfSearch, btnSearch);
    searchBox.setAlignment(Pos.CENTER);

    VBox searchSection = new VBox(8, searchLabel, searchBox, lblResult);
    searchSection.setPadding(new Insets(15));
    searchSection.setStyle("-fx-background-color:#FDFEFE; -fx-background-radius:10; -fx-border-color:#D5D8DC; -fx-border-radius:10;");

    VBox panel = new VBox(12,
            title, tfName, tfAge, tfGender, tfCNIC, tfSpec, tfSalary, actions,searchSection);
    panel.setPadding(new Insets(25));
    panel.setStyle("-fx-background-color:white;-fx-background-radius:15;-fx-border-color:#E0E0E0;-fx-border-radius:15;");

    return panel;
}
private VBox appointmentPanel() {

    Label title = new Label("Appointment Management");
    title.setStyle("-fx-font-size:20; -fx-font-weight:bold; -fx-text-fill: #2C3E50;");
    
    ComboBox<Patient> cbPatient =new ComboBox<>(hospital1.patientRepo.getAll());
    cbPatient.setPromptText("Select Patient");
    cbPatient.setStyle("-fx-background-radius:8;");
    
    ComboBox<Doctor> cbDoctor =new ComboBox<>();
    for(Doctor d:hospital1.doctorRepo.getAll()){
    if(d.getisAvailable()){cbDoctor.getItems().addAll(d);}
    else{continue;}
    }
    cbDoctor.setPromptText("Select Doctor");
    cbDoctor.setStyle("-fx-background-radius:8;");
    
    DatePicker dpDate = new DatePicker();
    dpDate.setPromptText("Select Date");
    dpDate.setStyle("-fx-background-radius:8;");
    
    Button btnAdd = new Button("Add Appointment");

    btnAdd.setStyle("-fx-background-color:#2ECC71;-fx-text-fill:white;-fx-font-weight:bold;-fx-background-radius:8;-fx-padding:8 18;");
    

    btnAdd.setOnAction(e -> {
        try {
            Patient p = cbPatient.getValue();
            Doctor d = cbDoctor.getValue();
            String date = dpDate.getValue().toString();

            Appointment a = new Appointment(p, d, date);
            hospital1.appointmentRepo.add(a);
            d.metaData.isAvailable=false;
            doctorTable.refresh();
            appointmentTable.refresh();
            cbPatient.setValue(null);
            cbDoctor.setValue(null);
            dpDate.setValue(null);
        } catch (Exception ex) {
            System.out.println("Invalid appointment data!");
        }
    });
    
    HBox actions = new HBox(15, btnAdd);
    actions.setAlignment(Pos.CENTER);
    
    Label searchLabel = new Label("Search Appointment by ID");
    searchLabel.setStyle("-fx-font-weight:bold; -fx-text-fill:#34495E; -fx-font-size:14;");

    TextField tfSearch = new TextField();
    tfSearch.setPromptText("Enter ID");
    tfSearch.setStyle("-fx-background-radius:8; -fx-padding:8;");

    Button btnSearch = new Button("Search");
    btnSearch.setStyle("-fx-background-color:#3498DB; -fx-text-fill:white; -fx-font-weight:bold; -fx-background-radius:8; -fx-padding:6 15;");

    Label lblResult = new Label();
    lblResult.setStyle("-fx-text-fill:#E67E22; -fx-font-weight:bold; -fx-font-size:14;");

    btnSearch.setOnAction(e -> {
        try {
            int Id = Integer.parseInt(tfSearch.getText());
            Appointment a = hospital1.appointmentRepo.getById(Id); 
            if (a != null) {
                lblResult.setText(a.generateSlipString());
            } else {
                lblResult.setText("Appointment not found!");
            }
        } catch (NumberFormatException ex) {
            lblResult.setText("Invalid ID!");
        }
    });
    HBox searchBox = new HBox(10, tfSearch, btnSearch);
    searchBox.setAlignment(Pos.CENTER);

    VBox searchSection = new VBox(8, searchLabel, searchBox, lblResult);
    searchSection.setPadding(new Insets(15));
    searchSection.setStyle("-fx-background-color:#FDFEFE; -fx-background-radius:10; -fx-border-color:#D5D8DC; -fx-border-radius:10;");


    VBox panel = new VBox(12,title,cbPatient,cbDoctor,dpDate,actions,searchSection);
    panel.setPadding(new Insets(25));
    panel.setStyle("-fx-background-color:white;-fx-background-radius:15;-fx-border-color:#E0E0E0;-fx-border-radius:15;");

    return panel;
}
private VBox billingPanel() {

    ComboBox<Patient> cbPatient = new ComboBox<>(hospital1.patientRepo.getAll());
    cbPatient.setPromptText("Select Patient");
    cbPatient.setStyle("-fx-background-radius: 8;-fx-padding: 6;");

    TextField tfService = new TextField();
    tfService.setPromptText("Service Charges");
    tfService.setStyle("-fx-background-radius: 8;-fx-padding: 8;");

    TextField tfMedicine = new TextField();
    tfMedicine.setPromptText("Medicine Charges");
    tfMedicine.setStyle("-fx-background-radius: 8;-fx-padding: 8;");

    Label lblTotal = new Label("Total: 0");
    lblTotal.setStyle("-fx-font-size: 16px;-fx-font-weight: bold;-fx-text-fill: #2C3E50;-fx-padding: 10 0 10 0;");

    Button btnGenerate = new Button("Generate Bill");
    btnGenerate.setStyle("-fx-background-color: #2ECC71;-fx-text-fill: white;-fx-font-weight: bold;-fx-background-radius: 8;-fx-padding: 8 16 8 16;");

    Button btnClear = new Button("Clear");
    btnClear.setStyle("-fx-background-color: #ECF0F1;-fx-text-fill: #2C3E50;-fx-font-weight: bold;-fx-background-radius: 8;-fx-padding: 8 16 8 16;");

    HBox actions = new HBox(15);
    actions.setAlignment(Pos.CENTER);
    actions.getChildren().addAll(btnGenerate, btnClear);

    btnGenerate.setOnAction(e -> {
        Patient p = cbPatient.getValue();
        p.metaData.bill.serviceCharges = Integer.parseInt(tfService.getText());
        p.metaData.bill.medicineCharges = Integer.parseInt(tfMedicine.getText());
        p.metaData.bill.calculateTotal();
        lblTotal.setText("Total: " + p.metaData.bill.total);
        patientTable.refresh();
    });

    btnClear.setOnAction(e -> {
        cbPatient.setValue(null);
        tfService.clear();
        tfMedicine.clear();
        lblTotal.setText("Total: 0");
    });

    Label title = new Label("Billing & Payments");
    title.setStyle("-fx-font-size: 20px;-fx-font-weight: bold; -fx-text-fill: #2C3E50;");

    VBox billingForm = new VBox(12);
    billingForm.setPadding(new Insets(25));
    billingForm.setStyle("-fx-background-color: white;-fx-background-radius: 12;-fx-border-color: #E0E0E0;-fx-border-radius: 12;");

    billingForm.getChildren().addAll(title,new Label("Patient"),cbPatient,tfService,tfMedicine,lblTotal,actions);

    return billingForm;
}
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hospital Management System");
        stage.setScene(loginPage(stage));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}