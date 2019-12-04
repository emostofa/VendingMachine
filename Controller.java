package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.scene.input.InputMethodEvent;


import java.util.Optional;

public class Controller {
    public int coin1 = 1;
    public int note2 = 2;
    public int note5 = 5;
    public int note10 = 10;
    public int note20 = 20;
    public int note50 = 50;
    public int note100 = 100;
    public int note500 = 500;
    public int counter1 = 0;
    public int counter2 = 0;
    public int counter5 = 0;
    public int counter10 = 0;
    public int counter20 = 0;
    public int counter50 = 0;
    public int counter100 = 0;
    public int counter500 = 0;
    public int money = 0, remainingMoney = 0;
    public int totalCost = 0, cost = 0, a;
    @FXML
    public Label balance;

    public void Operator(ActionEvent event) {

        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Operator Login");
        dialog.setHeaderText("Please enter your username & password");

// Set the icon (must be included in the project).
   dialog.setGraphic(new ImageView(this.getClass().getResource("access-512.png").toString()));
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

// Add a custom icon.
        stage.getIcons().add(new Image(this.getClass().getResource("access-512.png").toString()));

// Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();


        result.ifPresent(usernamePassword -> {
            System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
            if (username.getText().equals("Mazaman") && password.getText().equalsIgnoreCase("DMAZ")) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Success");
                alert.setContentText("Operator Mode on!");
                Stage stage2 = (Stage) alert.getDialogPane().getScene().getWindow();

// Add a custom icon.
                stage2.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));
                alert.showAndWait();
            } else {
                Alert fail = new Alert(Alert.AlertType.INFORMATION);
                fail.setHeaderText("failure");
                fail.setContentText("Incorrect username & password");
                fail.setGraphic(new ImageView(this.getClass().getResource("error-flat.png").toString()));
                Stage stage3 = (Stage) fail.getDialogPane().getScene().getWindow();

// Add a custom icon.
                stage3.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));
                fail.showAndWait();

            }
        });
    }

    public void InputMoney(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog("000");
        dialog.setTitle("Money Input");
        dialog.setHeaderText("Please input money");
        dialog.setContentText("Taka:");
        ButtonType tk1000 = new ButtonType("1000");
        ButtonType tk500 = new ButtonType("500");
        ButtonType tk100 = new ButtonType("100");
        ButtonType tk50 = new ButtonType("50");
        dialog.getDialogPane().getButtonTypes().addAll(tk1000,tk500,tk100,tk50);
        dialog.setGraphic(new ImageView(this.getClass().getResource("tk.png").toString()));
        Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();

// Add a custom icon.
        stage.getIcons().add(new Image(this.getClass().getResource("tk.png").toString()));

        Optional<String> result = dialog.showAndWait();

        if (!result.isPresent()) {
            Alert fail = new Alert(Alert.AlertType.INFORMATION);
            fail.setTitle("Error");
            fail.setHeaderText("Failure");
            fail.setContentText("You haven't entered money!! ");
            fail.setGraphic(new ImageView(this.getClass().getResource("error-flat.png").toString()));
            Stage stage2 = (Stage) fail.getDialogPane().getScene().getWindow();

// Add a custom icon.
            stage2.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));
            fail.showAndWait();
        }


        result.ifPresent(mon -> remainingMoney += Integer.parseInt(mon));
        //remainingMoney = money;
        balance.setText(String.valueOf(remainingMoney));



    }

    public void ItemCollect(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Enter your desired option");
        alert.setHeaderText("Do you want to continue or finish?");
        alert.setContentText("Please choose one!!");

        ButtonType buttonTypeOne = new ButtonType("Continue");
        ButtonType buttonTypeTwo = new ButtonType("Finish");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);
        alert.setGraphic(new ImageView(this.getClass().getResource("Cart.png").toString()));

        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

// Add a custom icon.
        stage.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {

        } else if (result.get() == buttonTypeTwo) {

            if (totalCost >= 500){
                Alert alert5 = new Alert(Alert.AlertType.INFORMATION);
                alert5.setTitle("Return");
                alert5.setHeaderText("Congratulations!!!");
                alert5.setContentText("You got 5% discount on spending 500+ tk!!!");
                remainingMoney += Math.ceil(totalCost*.05);
                balance.setText(String.valueOf(remainingMoney));
                alert5.setGraphic(new ImageView(this.getClass().getResource("tk.png").toString()));
                Stage stage3 = (Stage) alert5.getDialogPane().getScene().getWindow();

// Add a custom icon.
                stage3.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));
                alert5.showAndWait();
            }
            CoinGenerator();
            Alert alertr = new Alert(Alert.AlertType.INFORMATION);
            alertr.setTitle("Return");
            alertr.setHeaderText("You will get: (In Taka)");
            alertr.setContentText("500    100     50     20     10     5     2     1" +
                    "\n   " + counter500 + "         " + counter100 + "       " + counter50 + "\t" + counter20 + " \t" +
                    counter10 + "      " + counter5 + "     " + counter2 + "     " + counter1);
            System.out.println(counter100);
            alertr.setGraphic(new ImageView(this.getClass().getResource("tk.png").toString()));
            Stage stage2 = (Stage) alertr.getDialogPane().getScene().getWindow();

// Add a custom icon.
            stage2.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));

            alertr.showAndWait();

            money = 0;
            remainingMoney = 0;
            totalCost = 0;
            balance.setText(String.valueOf(remainingMoney));
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Thank You!!");
            alert2.setHeaderText("Thank you for shopping!!");
            alert2.setGraphic(new ImageView(this.getClass().getResource("ty.png").toString()));
            Stage stage3 = (Stage) alert2.getDialogPane().getScene().getWindow();

// Add a custom icon.
            stage3.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));
            alert2.showAndWait();
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }


    public void SelectItem1(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.A;
        totalCost += cost;
        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));

    }

    public void SelectItem2(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.B;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem3(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.C;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem4(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.D;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem5(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.E;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem6(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.F;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem7(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.G;
        totalCost += cost;
        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem8(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.H;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem9(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.I;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem10(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.J;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem11(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.K;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem12(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.L;
        totalCost += cost;
        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem13(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.M;
        totalCost += cost;
        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem14(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.N;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem15(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.O;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem16(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.P;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem17(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.Q;
        totalCost += cost;
        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem18(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.R;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem19(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.S;
        totalCost += cost;
        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }

    public void SelectItem20(ActionEvent event) {
        Pricing p = new Pricing();
        cost = p.T;
        totalCost += cost;

        ShowDialogOnUserInput(cost, remainingMoney);
        if ((cost <= remainingMoney)) {
            remainingMoney -= cost;
        }
        balance.setText(String.valueOf(remainingMoney));
    }


    public void ShowDialogOnUserInput(int cost, int remainingMoney) {
        if (cost > remainingMoney) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please input enough money!!");
            alert.setGraphic(new ImageView(this.getClass().getResource("error-flat.png").toString()));
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();

// Add a custom icon.
            stage.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));
            alert.showAndWait();
        } else {
            Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
            alert2.setTitle("Success");
            alert2.setHeaderText("Please Push \"PUSH to COLLECT\" button to collect the item and the change!!");
            alert2.setGraphic(new ImageView(this.getClass().getResource("Success.png").toString()));
            Stage stage = (Stage) alert2.getDialogPane().getScene().getWindow();

// Add a custom icon.
            stage.getIcons().add(new Image(this.getClass().getResource("info.png").toString()));


            alert2.showAndWait();
        }
    }


    public void CoinGenerator() {

        counter500 =0;
        counter100 =0;
        counter50 =0;
        counter20 =0;
        counter10 =0;
        counter5 =0;
        counter2 =0;
        counter1 =0;

        int mon = remainingMoney;
        if (mon / note500 > 0) {
            mon -= note500;
            counter500++;
        }
        if (mon / note100 == 1) {
            mon -= note100;
            counter100++;
        } else if (mon / 100 == 2) {
            mon -= note100 * 2;
            counter100 += 2;
        } else if (mon / 100 == 3) {
            mon -= note100 * 3;
            counter100 += 3;
        } else if (mon / 100 == 4) {
            mon -= note100 * 4;
            counter100 += 4;
        }
        if (mon / note50 > 0) {
            mon -= note50;
            counter50++;
        }
        if (mon / note20 == 1) {
            mon -= note20;
            counter20++;
        } else if (mon / note20 == 2) {
            mon -= note20 * 2;
            counter20 += 2;
        }
        if (mon / note10 > 0) {
            mon -= note10;
            counter10++;
            System.out.println(counter10+" c10");
        }

        if (mon / note5 > 0) {
            mon -= note5;
            counter5++;
        }
        if (mon / note2 == 1) {
            mon -= note2;
            counter2++;

        } else if (mon / note2 == 2) {
            mon -= note2;
            counter2 += 2;

        }
        if (mon / coin1 > 0) {
            mon -= coin1;
            counter1++;
        }
    }
}
