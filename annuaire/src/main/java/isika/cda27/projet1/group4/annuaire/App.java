package isika.cda27.projet1.group4.annuaire;

import java.util.List;

import isika.cda27.projet1.group4.annuaire.back.Annuaire;
import isika.cda27.projet1.group4.annuaire.back.BinarySearchTree;
import isika.cda27.projet1.group4.annuaire.back.Stagiaire;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage stage) {

		Annuaire annuaire = new Annuaire();
		annuaire.lireFichier("src/main/resources/test.txt");

		// on créé un nouvel arbre
		BinarySearchTree searchTree = new BinarySearchTree();

		//Reconstruire le fichier binaire depuis le fichier txt
//		for (int i = 0; i < annuaire.getStagiaires().size(); i++) {
//			searchTree.ajouter(annuaire.getStagiaires().get(i));
//		}

		ListView<Stagiaire> listView = new ListView<Stagiaire>();
		List<Stagiaire> stagiaires = searchTree.affichage();

		
		//searchTree.deleteInTree(stagiaires.get(3));
		searchTree.affichage();
		


		Scene scene = new Scene(new StackPane(listView), 640, 480);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch();
	}

}