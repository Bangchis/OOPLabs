package hust.soict.program.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Load giao diện từ file FXML
        Parent root = FXMLLoader.load(getClass()
                .getResource("/hust/soict/program/javafx/Painter.fxml"));

        // Tạo Scene với giao diện đã load
        Scene scene = new Scene(root);

        // Cấu hình Stage (cửa sổ chính)
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Khởi chạy JavaFX
    }
}

