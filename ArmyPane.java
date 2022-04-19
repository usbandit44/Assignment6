/* Assignment #: 6
 Name: Arvin Edouard
 StudentID: 1222200512
 Lecture: Tuesday and Thursay 1:30 to 2:45
 Description: creates the army pane that allows the user to see their heros,
 select hero to be in their army, and see the stats of the army 
 */
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class ArmyPane extends BorderPane {
	// COMPLETED: contains a list of heroes
	ArrayList<Hero> heroList;
	
	// COMPLETED: Variables containing army Damage, Strength, and Charisma
	int totalDamage;
	int totalStrength;
	int totalCharisma;

	
	// DONE 5. a) "Declare" (Do not "initialize" them yet!!!)
	// ONE Label to display Army information
	// ONE VBox to contain CheckBoxes
	// ONE "Load Heroes/Clear Selection" Button
	// vvvvvv 5. a) vvvvvv (about 3 lines)
	Label armyInfo;
	VBox checkBoxes;
	Button button1;

	// ^^^^^^ 5. a) ^^^^^^

	public ArmyPane(ArrayList<Hero> heroList) {
		this.heroList = heroList;

		// DONE 5. a) Initialize the instance variables
		// This is where you use the "new" keyword
		// vvvvvv 5. a) vvvvvv (about 3 lines)
		armyInfo = new Label();
		checkBoxes = new VBox();
		button1 = new Button("Load Heroes/Clear Selection");

		// ^^^^^^ 5. a) ^^^^^^

		// DONE: 5. b) Bind "Load Heroes/Clear Selection" Button to its handler
		// vvvvvv 5. b) vvvvvv (1 line)
		button1.setOnAction(new LoadHeroesButtonHandler());
		// ^^^^^^ 5. b) ^^^^^^
		
		// DONE: 5. c) Organize components to their positions on BorderPane
		// Remeber that THIS class "is"/extends BorderPane, use BorderPane syntax to add components
		// vvvvvv 5. c) vvvvvv (1 line)
		this.setTop(armyInfo);
		this.setCenter(checkBoxes);
		this.setBottom(button1);

		// ^^^^^^ 5. c) ^^^^^^

	}
	
	private class LoadHeroesButtonHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			
			// DONE: 6. Clear the VBox (1 line)
			// vvvvvv 6. a) vvvvvv (1 line)
			checkBoxes.getChildren().clear();
			// ^^^^^^ 6. a) ^^^^^^

			
			
			// DONE: 6. b), c), d)  
			// vvvvvv 6. b), c), d) vvvvvv (about 5-8 lines)
			for(int i = 0; i < heroList.size(); i++){// loops through herolist
				CheckBox cb = new CheckBox(heroList.get(i).toString());//creaks a checkbox for exh hero hero
				cb.setOnAction(new CheckBoxHandler(heroList.get(i)));// binds each check boc to the handler
				checkBoxes.getChildren().add(cb);// adds the checkboxs to the Vbox
			}

			// ^^^^^^ 6. b), c), d) ^^^^^^

		}
	}

	private class CheckBoxHandler implements EventHandler<ActionEvent> {

		Hero hero;
		
		// When creating a new CheckBoxHandler, pass in a Hero object so it can be accessed later
		public CheckBoxHandler(Hero _hero) {
			this.hero = _hero;
		}

		@Override
		public void handle(ActionEvent event) {
			// DONE: 7. a) Use event.getSource() to get the CheckBox that triggered the event, cast it to CheckBox
			// vvvvvv 7. a) vvvvvv (1 line)
			CheckBox cb = (CheckBox)event.getSource();
			// ^^^^^^ 7. a) ^^^^^^
			
			// DONE: 7. b) If the CheckBox was selected, add the current hero scores to totalStrength, 
			// 	totalCharisma, and totalDamge. Otherwise, subtract the current hero scores
			// vvvvvv 7. b) vvvvvv (about 8-12 lines)
			if(cb.isSelected()){// if the box is checked add it's heros stats to the totals
				totalStrength += this.hero.getStrength();
				totalCharisma += this.hero.getCharisma();
				totalDamage += this.hero.getDamage();
			}else{// if not then subtract the heros stats
				totalStrength -= this.hero.getStrength();
				totalCharisma -= this.hero.getCharisma();
				totalDamage -= this.hero.getDamage();
			}

			// ^^^^^^ 7. b) ^^^^^^

			// DONE: 7. c) Set the Label to 
			// "Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma
			// vvvvvv 7. c) vvvvvv (1 line)
			armyInfo.setText("Total Damage: " + totalDamage + "\t\tTotal Strength: " + totalStrength + "\tTotal Charisma: " + totalCharisma);

			// ^^^^^^ 7. c) ^^^^^^

		}
	}

}
