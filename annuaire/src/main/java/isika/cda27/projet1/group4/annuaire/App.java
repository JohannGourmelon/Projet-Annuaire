package isika.cda27.projet1.group4.annuaire;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.List;

import isika.cda27.projet1.group4.annuaire.back.Annuaire;
import isika.cda27.projet1.group4.annuaire.back.BinaryFileManager;
import isika.cda27.projet1.group4.annuaire.back.BinarySearchTree;
import isika.cda27.projet1.group4.annuaire.back.Node;
import isika.cda27.projet1.group4.annuaire.back.Stagiaire;
import isika.cda27.projet1.group4.annuaire.front.AnnuaireDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	public AnnuaireDAO myDAO;
	public ObservableList<Stagiaire> myObservableArrayList;

	// methode dediée a l'initialisation
	@Override
	public void init() {
		myDAO = new AnnuaireDAO();
	}

	@Override
	public void start(Stage stage) {

		// Annuaire annuaire = new Annuaire();
		// annuaire.lireFichier("src/main/resources/test.txt");

		myObservableArrayList = FXCollections.observableArrayList(this.myDAO.getStagiaires());
//		System.out.println(myDAO);

		// on créé un nouvel arbre
		// BinarySearchTree searchTree = new BinarySearchTree();

		for (int i = 0; i < myDAO.getStagiaires().size(); i++) {
			System.out.println(myDAO.getStagiaires().get(i));
		}

//		ListView<Stagiaire> listView = new ListView<Stagiaire>();
//		List<Stagiaire> stagiaires = searchTree.affichage();
//
//		searchTree.deleteInTree(stagiaires.get(2));
//
//		searchTree.affichage();
//		
//		for (Stagiaire stag : stagiaires) {
//			listView.getItems().add(stag);
//		}
//
//		// test recherche d'un stagiaire par nom
//		Stagiaire test = new Stagiaire("ROIGNANT", "", "", "", 0);
//		System.out.println("\nTest du stagiaire à trouver sur " + test.getName());
//		List<Stagiaire> stagiairesSearched = searchTree.searchStagiaireInTree(test);
//		for (Stagiaire stag : stagiairesSearched) {
//			System.out.println(stag);
//		}

		// création du borderPane
		BorderPane borderPane = new BorderPane();

		// création de la Hbox header
		HBox hboxHeader = new HBox();
		borderPane.setTop(hboxHeader);

		// création du bouton connexion
		Button buttonConnexion = new Button("  Connexion  ");
		hboxHeader.getChildren().add(buttonConnexion);
		hboxHeader.setMargin(buttonConnexion, new Insets(10, 10, 20, 540));// Marges haut, droite, bas, gauche

		// Créer un TableView de stagiaires
		TableView<Stagiaire> tableView = new TableView<Stagiaire>(myObservableArrayList);// mettre la liste en argument

		// Créer les colonnes
		TableColumn<Stagiaire, String> nameColumn = new TableColumn<Stagiaire, String>(" Nom");
		nameColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("name"));
		nameColumn.setPrefWidth(128);

		TableColumn<Stagiaire, String> firstNameColumn = new TableColumn<Stagiaire, String>(" Prénom");
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("firstName"));
		firstNameColumn.setPrefWidth(128);

		TableColumn<Stagiaire, String> postalCodeColumn = new TableColumn<Stagiaire, String>(" Département");
		postalCodeColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("postalCode"));
		postalCodeColumn.setPrefWidth(128);

		TableColumn<Stagiaire, String> promoColumn = new TableColumn<Stagiaire, String>(" Promotion");
		promoColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
		promoColumn.setPrefWidth(128);

		TableColumn<Stagiaire, String> yearColumn = new TableColumn<Stagiaire, String>(" Année");
		yearColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("year"));
		yearColumn.setPrefWidth(128);

		// Ajouter les colonnes au TableView
		tableView.getColumns().addAll(nameColumn, firstNameColumn, postalCodeColumn, promoColumn, yearColumn);

		// Ajouter les stagiaires au TableView
		// tableView.getItems().addAll();

		// Ajouter le TableView au BorderPane
		borderPane.setCenter(tableView);

		// création de la Hbox Bottom
		HBox hboxBottom = new HBox();
		borderPane.setBottom(hboxBottom);

		// création du bouton connexion
		Button buttonImpression = new Button("Impression (pdf)");
		hboxBottom.getChildren().add(buttonImpression);
		hboxBottom.setMargin(buttonImpression, new Insets(20, 0, 20, 530));// Marges haut, droite, bas, gauche

		Scene scene = new Scene(borderPane, 640, 480);
		stage.setScene(scene);
		stage.show();

		// le bouton connexion permet de basculer vers une nouvelle scène
		buttonConnexion.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				BorderPane borderPane = new BorderPane();

				// création de la Hbox header
				HBox hboxHeader = new HBox();
				borderPane.setTop(hboxHeader);

				// création du bouton connexion
				Button buttonConnexion = new Button("  Connexion  ");
				hboxHeader.getChildren().add(buttonConnexion);
				hboxHeader.setMargin(buttonConnexion, new Insets(10, 10, 20, 540));// Marges haut, droite, bas, gauche

				// Créer un TableView de stagiaires
				TableView<Stagiaire> tableView = new TableView<Stagiaire>(myObservableArrayList);// mettre la liste en
																									// argument

				// Créer les colonnes
				TableColumn<Stagiaire, String> nameColumn = new TableColumn<Stagiaire, String>(" Nom");
				nameColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("name"));
				nameColumn.setPrefWidth(128);

				TableColumn<Stagiaire, String> firstNameColumn = new TableColumn<Stagiaire, String>(" Prénom");
				firstNameColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("firstName"));
				firstNameColumn.setPrefWidth(128);

				TableColumn<Stagiaire, String> postalCodeColumn = new TableColumn<Stagiaire, String>(" Département");
				postalCodeColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("postalCode"));
				postalCodeColumn.setPrefWidth(128);

				TableColumn<Stagiaire, String> promoColumn = new TableColumn<Stagiaire, String>(" Promotion");
				promoColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("promo"));
				promoColumn.setPrefWidth(128);

				TableColumn<Stagiaire, String> yearColumn = new TableColumn<Stagiaire, String>(" Année");
				yearColumn.setCellValueFactory(new PropertyValueFactory<Stagiaire, String>("year"));
				yearColumn.setPrefWidth(128);

				// Ajouter les colonnes au TableView
				tableView.getColumns().addAll(nameColumn, firstNameColumn, postalCodeColumn, promoColumn, yearColumn);

				// Ajouter les stagiaires au TableView
				// tableView.getItems().addAll();

				// Ajouter le TableView au BorderPane
				borderPane.setCenter(tableView);

				// création de la Hbox Bottom
				HBox hboxBottom = new HBox();
				borderPane.setBottom(hboxBottom);

				Button buttonUpdate = new Button(" Modifier ");
				hboxBottom.getChildren().add(buttonUpdate);
				hboxBottom.setMargin(buttonUpdate, new Insets(20, 0, 20, 80));// Marges haut, droite, bas, gauche

				Button buttonDelete = new Button(" Supprimer ");
				hboxBottom.getChildren().add(buttonDelete);
				hboxBottom.setMargin(buttonDelete, new Insets(20, 0, 20, 80));// Marges haut, droite, bas, gauche

				Button buttonAdd = new Button("  Ajouter ");
				hboxBottom.getChildren().add(buttonAdd);
				hboxBottom.setMargin(buttonAdd, new Insets(20, 0, 20, 80));// Marges haut, droite, bas, gauche

				// création du bouton connexion
				Button buttonImpression = new Button("Impression (pdf)");
				hboxBottom.getChildren().add(buttonImpression);
				hboxBottom.setMargin(buttonImpression, new Insets(20, 0, 20, 70));// Marges haut, droite, bas, gauche

				Scene secondeScene = new Scene(borderPane, 640, 480);
				stage.setScene(secondeScene);
				stage.show();

				buttonAdd.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						// création de la BorderPane pour 3 ème scène
						BorderPane addBorderPane = new BorderPane();

						// création de la Hbox header
						HBox hboxHeader = new HBox();
						addBorderPane.setTop(hboxHeader);

						// création du bouton connexion
						Button buttonConnexion = new Button("  Connexion  ");
						hboxHeader.getChildren().add(buttonConnexion);
						hboxHeader.setMargin(buttonConnexion, new Insets(10, 10, 20, 540));

						// création de la GridePane
						GridPane gridpane = new GridPane();
						addBorderPane.setCenter(gridpane);

						// organisation :
						gridpane.setVgap(20); // Espace vertical entre les lignes
						gridpane.setHgap(0); // Espace horizontal entre les colonnes

						// ajouter une marge intérieure sur tous les côtés du GridPane
						gridpane.setPadding(new Insets(80));

						// remplir la GridPane avec les labels et les textfields

						Label nameLabel = new Label(" Nom ");
						TextField nameTextfield = new TextField();
						gridpane.add(nameLabel, 0, 0); // (colonne/ligne)
						gridpane.add(nameTextfield, 1, 0);

						Label firstnameLabel = new Label(" Prénom ");
						TextField firstnameTextfield = new TextField();
						gridpane.add(firstnameLabel, 0, 1); // (colonne/ligne)
						gridpane.add(firstnameTextfield, 1, 1);

						Label postalCodeLabel = new Label(" Département ");
						TextField postalCodeTextfield = new TextField();
						gridpane.add(postalCodeLabel, 0, 2); // (colonne/ligne)
						gridpane.add(postalCodeTextfield, 1, 2);

						Label promoLabel = new Label(" Promotion ");
						TextField promoTextfield = new TextField();
						gridpane.add(promoLabel, 0, 3); // (colonne/ligne)
						gridpane.add(promoTextfield, 1, 3);

						Label yearLabel = new Label(" Année ");
						TextField yearTextfield = new TextField();
						gridpane.add(yearLabel, 0, 4); // (colonne/ligne)
						gridpane.add(yearTextfield, 1, 4);

						// création de la Hbox Bottom
						HBox hboxBottom = new HBox();
						addBorderPane.setBottom(hboxBottom);

						// création du bouton Annuler
						Button cancelButton = new Button(" Annuler ");
						hboxBottom.getChildren().add(cancelButton);
						hboxBottom.setMargin(cancelButton, new Insets(10, 0, 30, 10)); // Marges haut, droite, bas,
																						// gauche

						// création du bouton valider
						Button validateButton = new Button(" Valider ");
						hboxBottom.getChildren().add(validateButton);
						hboxBottom.setMargin(validateButton, new Insets(10, 0, 30, 490));

						Scene AddScene = new Scene(addBorderPane, 640, 480);
						stage.setScene(AddScene);
						stage.show();

						cancelButton.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
						// Revenir à la scène 02
						stage.setScene(secondeScene);

							}
						});

					}

				});
				buttonUpdate.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {

						BorderPane UpdateBorderPane = new BorderPane();

						// création de la Hbox header
						HBox hboxHeader = new HBox();
						UpdateBorderPane.setTop(hboxHeader);

						// création du bouton connexion
						Button buttonConnexion = new Button("  Connexion  ");
						hboxHeader.getChildren().add(buttonConnexion);
						hboxHeader.setMargin(buttonConnexion, new Insets(10, 10, 20, 540));

						// création de la GridePane
						GridPane gridpane = new GridPane();
						UpdateBorderPane.setCenter(gridpane);

						// organisation :
						gridpane.setVgap(20); // Espace vertical entre les lignes
						gridpane.setHgap(0); // Espace horizontal entre les colonnes

						// ajouter une marge intérieure sur tous les côtés du GridPane
						gridpane.setPadding(new Insets(80));

						// remplir la GridPane avec les labels et les textfields

						Label nameLabel = new Label(" Nom ");
						TextField nameTextfield = new TextField();
						gridpane.add(nameLabel, 0, 0); // (colonne/ligne)
						gridpane.add(nameTextfield, 1, 0);

						Label firstnameLabel = new Label(" Prénom ");
						TextField firstnameTextfield = new TextField();
						gridpane.add(firstnameLabel, 0, 1); // (colonne/ligne)
						gridpane.add(firstnameTextfield, 1, 1);

						Label postalCodeLabel = new Label(" Département ");
						TextField postalCodeTextfield = new TextField();
						gridpane.add(postalCodeLabel, 0, 2); // (colonne/ligne)
						gridpane.add(postalCodeTextfield, 1, 2);

						Label promoLabel = new Label(" Promotion ");
						TextField promoTextfield = new TextField();
						gridpane.add(promoLabel, 0, 3); // (colonne/ligne)
						gridpane.add(promoTextfield, 1, 3);

						Label yearLabel = new Label(" Année ");
						TextField yearTextfield = new TextField();
						gridpane.add(yearLabel, 0, 4); // (colonne/ligne)
						gridpane.add(yearTextfield, 1, 4);

						// création de la Hbox Bottom
						HBox hboxBottom = new HBox();
						UpdateBorderPane.setBottom(hboxBottom);

						// création du bouton Annuler
						Button cancelButton = new Button(" Annuler ");
						hboxBottom.getChildren().add(cancelButton);
						hboxBottom.setMargin(cancelButton, new Insets(10, 0, 30, 10));

						// création du bouton valider
						Button validateButton = new Button(" Valider ");
						hboxBottom.getChildren().add(validateButton);
						hboxBottom.setMargin(validateButton, new Insets(10, 0, 30, 490));

						Scene UpdateScene = new Scene(UpdateBorderPane, 640, 480);
						stage.setScene(UpdateScene);
						stage.show();

						cancelButton.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
						// Revenir à la scène 02
						stage.setScene(secondeScene);

							}
						});

					}
				});

			}
		});

	}

	public static void main(String[] args) {
		launch();
	}

}