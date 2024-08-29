package isika.cda27.projet1.group4.annuaire.front;

import java.util.List;

import isika.cda27.projet1.group4.annuaire.App;
import isika.cda27.projet1.group4.annuaire.back.Stagiaire;
import isika.cda27.projet1.group4.annuaire.back.StagiaireFilter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class FilteredSearch extends HBox {

	private TextField nameField;
	private TextField firstNameField;
	private TextField departmentField;
	private TextField promotionField;
	private TextField yearField;
	private Button toggleButton;
	private Button filterButton;
	private App app;

	public FilteredSearch(App app) {
		this.app = app;

		// Initialisation des champs de texte pour chaque critère
		nameField = new TextField();
		nameField.setPromptText("Nom");

		firstNameField = new TextField();
		firstNameField.setPromptText("Prénom...");

		departmentField = new TextField();
		departmentField.setPromptText("Département...");

		promotionField = new TextField();
		promotionField.setPromptText("Promotion...");

		yearField = new TextField();
		yearField.setPromptText("Année...");

		// Créer le bouton avec l'icône de recherche
		Image searchIcon = new Image(getClass().getResourceAsStream("/icons/__search-icon.png"));
		ImageView buttonImageView = new ImageView(searchIcon);
		buttonImageView.setFitHeight(20);
		buttonImageView.setFitWidth(20);
		toggleButton = new Button("", buttonImageView);

		// Créer le bouton pour accéder à la recherche avancée
		Image filterIcon = new Image(getClass().getResourceAsStream("/icons/__filterOff-icon.png"));
		ImageView filterImageView = new ImageView(filterIcon);
		filterImageView.setFitHeight(20);
		filterImageView.setFitWidth(20);
		filterButton = new Button("", filterImageView);

		// Ajouter les champs au HBox avec les boutons
		this.getChildren().addAll(nameField, firstNameField, departmentField, promotionField, yearField, toggleButton,
				filterButton);
		this.setSpacing(10);

		// Ajouter style css
		toggleButton.getStyleClass().add("button-search");
		filterButton.getStyleClass().add("button-search");

		// Gestion de l'action des boutons
		toggleButton.setOnAction(event -> {
			
			StagiaireFilter stagiairefilter = new StagiaireFilter(app.myDAO);

			String name = nameField.getText();
			String firstName = firstNameField.getText();
			String postalCode = departmentField.getText();
			String promo = promotionField.getText();
			String year = yearField.getText();

			List<Stagiaire> filteredStagiaires = stagiairefilter.filterStagiaires(name, firstName, postalCode, promo, year);
			app.myObservableArrayList.setAll(filteredStagiaires);
		});

		filterButton.setOnAction(event -> {

		});

	}

	public Button getToggleButton() {
		return toggleButton;
	}

	public Button getFilterButton() {
		return filterButton;
	}

}
