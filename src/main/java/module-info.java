module com.tesla {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires java.logging;
    requires org.mongodb.driver.core;

    opens com.tesla.controllers to javafx.fxml;
    opens com.tesla.models to javafx.base;
    exports com.tesla;
}
